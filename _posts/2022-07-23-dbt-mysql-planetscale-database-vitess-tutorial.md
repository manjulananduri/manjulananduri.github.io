---
layout: post
title:  "Connecting dbt mysql with PlanetScale database (Vitess) - A case study"
author: Pramod
categories: [DataScience, MySQL, PostgreSQL]
tags: [red, yellow]
image: assets/images/dbt-mysql-planetscale.jpg
description: "An ultimate case study to combine dbt (data build tool) data transformation at scale using dbt mysql + Vitess from Planetscale database"
featured: true
hidden: false
suggestions: ['dbt-tutorial-real-world-scenario-guide/']
beforetoc: "PlanetScale and dbt (data build tool) have become two major platforms for databases + analytics engineers. What if we connect both of them?"
toc: true
tableofcontents: false
promote: true
---

When I first started playing around with dbt (data build tool), being a traditional MySQL developer, the first thing that came to my mind is **Can we connect dbt with mysql** ? After some research on getdbt site, I found that there is a dbt-mysql adapter which can connect dbt with mysql. But then as I digged deeper to understand [dbt in a real world scenario](https://tipseason.com/dbt-tutorial-real-world-scenario-guide/), the immediate question that popped up is **what if I have to do the data processing at scale using MySQL** ? MySQL is scalable however it's still single master node. Well that's when Vitess came to a rescue. Since we are in cloud era and that I don't want to manage Vitess on my own, went ahead and saw who provides Vitess as a managed service and thats when PlanetScale came into picture and is a perfect fit for our use case.

**What if we combine the power of dbt data transformations with mysql compatible Vitess at scale?**

Thats exactly what this case study is all about. In this post, we will connect dbt with Vitess using dbt-mysql adapter on PlanetScale Vitess database Cloud.

For beginners,

**[Vitess](https://vitess.io/)** is a MySQL compatible database clustering system for horizontal scaling of MySQL. Since MySQL works with single master, Vitess helps you partition your data into multiple partitions with a unique key ( called as sharding key). It's a proven technology at scale originally developed at Youtube.

**[PlanetScale](https://planetscale.com/)** is a managed MySQL compatible serverless database platform. They provide database as a service with Vitess as a backend.

So there we go. We have a perfect combination of

- dbt ( data build tool)
- MySQL with [dbt-mysql](https://github.com/dbeatty10/dbt-mysql)
- Managed Vitess hosted on PlanetScale

Let's jump into connecting each of them. The flow goes like this.

- Vitess is a "MySQL compatible" database. MySQL compatible database indicates that it can support MySQL syntax for all the query needs even though the underlying technology of how data is stored is different from how MySQL natively stores the data.
- To connect dbt with Vitess, we will use [dbt-mysql adapter](https://github.com/dbeatty10/dbt-mysql) which is a plugin to connect dbt with mysql or mariadb.
- dbt-mysql adapter is not supported by dbt cloud (which is a dbt cloud based online ide). So for this tutorial, we will use [dbt cli](https://docs.getdbt.com/dbt-cli/cli-overview) for working with dbt. dbt cli is a client based tool which can be used to manage the entire dbt workflows.
- [PlanetScale](https://planetscale.com/) is a fully managed Vitess based service (The MySQL-compatible serverless database platform) .

Let's dive into the actual workflows.

## Step 1: Create PlanetScale database
First thing we will do is to signup an account with PlanetScale. This is a straight forward step like any other account signup. Here is the planetscale [signup link](https://auth.planetscale.com/sign-up)

<iframe width="560" height="315" src="https://www.youtube.com/embed/dkLOS95PJrA" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>

Once you create an account using above steps, you can configure a `pscale` planetscale client (which is a shell based tool) to connect to your db. To do that, for MacOS you use below steps. For other operating systems you can follow [this guide](https://github.com/planetscale/cli#installation)

```
#Install Planetscale Client i.e. pscale 
brew install planetscale/tap/pscale

#Install MySQL client that pscale can connect. 
brew install mysql-client

#Login to planetscale account for cli
pscale auth login

#Create database named `demo`
pscale database create demo

#Connect to demo database. 
pscale connect demo

```

You can access PlanetScale `demo` database using `pscale` shell using
``` 
pscale shell demo 
```
This is just like a mysql shell.

## Step 2: Setup dbt client with dbt-mysql adapter
We will connect dbt-mysql adapter for using dbt client. Setting up dbt cli depends on the type of machine that you use. For the purpose of this tutorial , we will use `pip` to setup dbt cli with dbt-mysql adapter.

If you have pip installed already you can skip this step.
#### Step 2.1:  Setup pip:

pip (package installer for Python) is a simple package management system written in python that can be used install and manage software packages/libraries written in Python.
If you don't have pip installed already you can use run below commands in your terminal.

```
curl https://bootstrap.pypa.io/get-pip.py -o get-pip.py
python3 get-pip.py
```
Depending on the operating system this process might be a bit different and can be installed using these [pip instructions](https://pip.pypa.io/en/stable/installation/)

- If you are using python3 , this might be more like pip3.


#### Step 2.2: Setup dbt mysql adapter
Once you have pip installed , you can install dbt-mysql using the below command in your terminal.

```
pip install dbt-mysql

```
To verify if dbt installed fine, you can use
```
dbt --version
```
which should give results similar to this
```
tipseason$ dbt --version
installed version: 1.0.8
   latest version: 1.1.1

Your version of dbt is out of date! You can find instructions for upgrading here:
https://docs.getdbt.com/docs/installation

Plugins:
  - mysql5: 1.0.0 - No PYPI version available
  - mariadb: 1.0.0 - No PYPI version available
  - mysql: 1.0.0 - Up to date!
```

Once you have dbt-cli installed, you can create a sample dbt project using this.

```
dbt init demoproject
```

Now that we have dbt project ready along with planetscale database , let's connect the two pieces.

## Step 3: Connect dbt-mysql with planetscale database
Inorder to connect dbt with mysql adapter, we need to modify profiles.yml file which serves as the configuration file to database connections.
For mac users the location of this file is in the home folder under `.dbt` subfolder. In this if you don't have a `profiles.yml` file, you can create one using

`vi ~/.dbt/profiles.yml`

This file should have the following configuration information.
```
demoproject:
  target: dev
  outputs:
    dev:
      type: mysql5
      server: [planetscale_servername]
      port: 3306  # optional
      database: [demo] # optional, should be same as schema
      schema: [planetscale_schema]
      username: [planetscale_username]
      password: [planetscale_password]
      driver: MySQL ODBC 8.0 ANSI Driver
    prod:
      type: mysql5
      server: [server/host]
      port: [port]  # optional
      database: [schema] # optional, should be same as schema
      schema: [schema]
      username: [username]
      password: [password]
      driver: MySQL ODBC 8.0 ANSI Driver                                                                                                                                                                                   
```
Make sure you input the data without square brackets (no `[` or `]`).

That's it. We have all the required configurations ready.

#### Perform sample queries with dbt-mysql and pscale:
In Step 2.2, we created `demoproject` for dbt. dbt comes with sample models(my_first_dbt_model, my_second_dbt_model, my_third_dbt_model) when we initiate a project.
So let's go ahead and run our models from dbt. In terminal,

```
dbt run
```
This will create 3 tables in planetscale vitess database. You can check it in your pscale shell using.

```
tipseason$ cd demoproject  
tipseason$ dbt run

tipseason$ pscale shell demo
demo/main> show tables;
+---------------------+
| Tables_in_demo      |
+---------------------+
| my_first_dbt_model  |
| my_second_dbt_model |
| my_third_dbt_model  |
+---------------------+
demo/main> select * from my_first_dbt_model;
+------+
| id   |
+------+
|    1 |
| NULL |
+------+
demo/main> select * from my_second_dbt_model;
+------+
| id   |
+------+
|    1 |
+------+
demo/main> 

```

As you can see the three models are properly being populated using PlanetScale Vitess MySQL database with dbt-mysql adapter.

## Some Caveats:
Note that dbt-mysql is still in a testing phase and its only a community supported project. So if you plan to use this in production make sure you evaluate in more detail.

Hope this article finds it helpful. Let me know if any specific insights are needed in this integration in the comments. Happy to help.

--- 
Did you know?

Data Analytics + Data Engineers = Analytics Engineers

dbt (data build tool) helps you in becoming Analytics Engineers. If you don’t know what these roles are or you just started playing around data, [dbt course](https://tipseason.com/dbt-data-build-tool-course-beginner/) towards dbt certification here.

<div class="alert alert-warning" role="alert">
     <span class="text">We are launching a dbt course for beginners with practical hands on project. <br>
       First 20 people to signup for the course, will get course for free and next 30 people will get a 50% discount. Make sure to signup here.
    </span>
</div>

{% include mailchimp.html %}

* Tip: dbt is never spelled in capital letters.

Hope this post make things clear about dbt. In the next tutorial, we will talk about

- dbt Cloud and Step by step tutorial to setup your first dbt cloud project.

Make sure you subscribe to our website by subscribing to our mailing list and by following us on Twitter (<a target="_blank" href="https://twitter.com/thetipseason">@thetipseason</a>)

## Suggested Articles:

[Google Carbon Programming language tutorial](https://tipseason.com/carbon-language-tutorial-syntax/)

[PostgreSQL Vs MySQL Syntax - A beginners guide to use postgres and mysql with comparison and examples](https://tipseason.com/postgres-vs-mysql-syntax-comparision/)

[dbt (data build tool) in a real world scenario, Beginner dbt tutorial](https://tipseason.com/dbt-tutorial-real-world-scenario-guide/)

[Top 10 most loved programming languages of 2022 and which companies use them](https://tipseason.com/top-10-most-loved-programming-languages-2022/)





