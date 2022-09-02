---
layout: post 
title:  "PostgreSQL Vs MySQL differences in syntax - A developer guide"
author: Pramod 
categories: [Database, MySQL, PostgreSQL]
tags: [red, yellow]
image: assets/images/postgres-vs-mysql.png 
description: "PostgreSQL Vs MySQL Syntax Comparison - Basic differences in usage and cheatsheet for PostgreSQL and MySQL"
featured: true
hidden: true 
suggestions: ['markdown-basics-cheat-sheet-one-page/']
beforetoc: "PostgreSQL Vs MySQL Syntax Comparison - A beginners guide to use postgres and mysql by comparision"
toc: true
tableofcontents: true
promote: true
---

## Introduction

PostgreSQL and MySQL are widely used databases by major companies across multiple projects, given the amount of scale and
performance these databases can handle. Many developers work on these two important databases when transitioning to
different projects or different companies. When we get used to one database for example MySQL and then transition to
another database say PostgresSQL or viceversa, then we tend to use the same commands across each other. However, syntax
for postgres and mysql is slightly different. In this tutorial we will compare and understand the differences between 
PostgreSQL and MySQL in terms of syntax for various operations or queries that are frequently used in 
production systems. 

For the purpose of this tutorial we use `psql` and `mysql` clients for showcasing examples. As a quick recap,<br>
`psql` is a terminal based client for PostgreSQL. We can connect to PostgreSQL server with `psql` and perform different operations.<br>
`mysql` is a terminal based client for MySQL. We can connect to MySQL server with `mysql` and perform different operations.<br>
So let's get started.

## 1. Show a list of all databases

As part of setup, we have created a database named `demo` (using `create database demo`) upfront in both PostgreSQL and
MySQL. To show a list of all databases present in PostgreSQL or MySQL, we can use the below commands:

##### List or show databases in Postgres or psql:

Default databases in most PostgreSQL servers are `template0` , `template0`, `postgres`.
<blockquote class="code-block-singleline-fullwidth">To list all the databases in Postgres i.e. psql we can use : <span class="code-highlight-focus">\l</span></blockquote>

Example in psql client: For our tutorial, you can see database `demo` is listed in the below example.

```
postgres=# \l
                                    List of databases
   Name    |     Owner     | Encoding |   Collate   |    Ctype    |   Access privileges   
-----------+---------------+----------+-------------+-------------+-----------------------
 demo      | demouser      | UTF8     | en_US.UTF-8 | en_US.UTF-8 | 
 postgres  | postgres      | UTF8     | en_US.UTF-8 | en_US.UTF-8 | 
 template0 | postgres      | UTF8     | en_US.UTF-8 | en_US.UTF-8 | =c/postgres          +
           |               |          |             |             | postgres=CTc/postgres
 template1 | postgres      | UTF8     | en_US.UTF-8 | en_US.UTF-8 | =c/postgres          +
           |               |          |             |             | postgres=CTc/postgres
(4 rows)
```

##### List or show databases in MySQL: 

Default databases in most MySQL servers are `information_schema` , `performance_schema`, `mysql`, `sys`

<blockquote class="code-block-singleline-fullwidth">In MySQL to show list of all databases we can use: <span class="code-highlight-focus">show databases</span></blockquote>

Example in mysql client: For our tutorial, you can see database `demo` is listed in the below example.

```
mysql> show databases;
+--------------------+
| Database           |
+--------------------+
| demo               |
| information_schema |
| mysql              |
| performance_schema |
| sys                |
+--------------------+
5 rows in set (0.01 sec)
```

MySQL `show databases` is equivalent to PostgreSQL list (`\l`) databases.

---
## 2. Use or Change database

If you have multiple databases on your DB server, we often need to switch between multiple databases to perform
various DDL or DML operations or to read data. In order to change or use a different database than the currently selected database, we
can use the below queries.

##### Change or Use database in PostgreSQL:

To change the database in PostgreSQL we can use : `\c {dbname}`

<blockquote class="code-block-singleline-fullwidth">
    <div><span class="code-highlight-focus">\c {dbname} :</span> Switches the current database to the specified database in PostgreSQL</div>
</blockquote>

Note: Text in curly braces can to be replaced with your own data. Don't forget to remove the braces. See example below. 

```
postgres-# \c demo
You are now connected to database "demo" as user "demouser".
```

##### Use or Change database in MySQL:

To change the database in MySQL we can use : `use {dbname}`

<blockquote class="code-block-singleline-fullwidth">
    <div><span class="code-highlight-focus">use {dbname} :</span> Switches the current database to the specified database in MySQL</div>
</blockquote>

Example: 
```
mysql> use demo;
Database changed
mysql> 
```
---
## 3. Show schemas
Schema is like a namespace of database objects such as tables, views, indexes etc. Depending on the type of DB server, 
a database can contain multiple schemas, but a schema belongs to only one database. In some DB servers, schema and database 
are used synonymously. 

##### Show schemas in PostgreSQL: 
PostgreSQL supports having multiple schemas in a single database so that you can specify different namespace for
different features. 

<blockquote class="code-block-singleline-fullwidth">
    <div><span class="code-highlight-focus">\dn :</span> Shows list of schemas in PostgreSQL</div>
</blockquote>

Example: 
```
postgres=# \dn
  List of schemas
  Name  |  Owner   
--------+----------
 public | postgres
(1 row)
```

##### Show schemas in MySQL:
In MySQL a schema is similar or synonymous with a database. You can substitute the keyword `SCHEMA` 
instead of `DATABASE` in MySQL SQL syntax, for example using `CREATE SCHEMA` instead of `CREATE DATABASE`.

<blockquote class="code-block-singleline-fullwidth">
    <div><span class="code-highlight-focus">show schemas :</span> Shows list of schemas in MySQL</div>
</blockquote>

Example:
```
mysql> show schemas;
+--------------------+
| Database           |
+--------------------+
| demo               |
| information_schema |
| mysql              |
| performance_schema |
| sys                |
+--------------------+
5 rows in set (0.02 sec)
```
---
## 4. Show a list of all tables
Once we change to the desired database, one of the most frequently used operations is to list all the 
tables that are present in the current database. 

##### List or show tables PostgreSQL:
To show the list of tables in PostgreSQL, we can use `\dt` or `\dt+` or `\d` or `\d+` 

<blockquote class="code-block-singleline-fullwidth">
    <div><span class="code-highlight-focus">\dt or \d :</span> Gives list of tables in current database</div>  
    <div><span class="code-highlight-focus">\dt+ or \d+:</span> Gives list of tables in current database with additional information like Size, description etc. </div>
</blockquote>

<span class="text text-info"><i class="material-icons">star</i> Pro Tip:</span> In postgres/psql, many commands support `+` as part of the syntax. Eg: Try `\dt+` instead of `\dt` . If we 
use `+` , we can see additional information for that specific command. 

Example: For this example two tables `demo_table_primarykey` (with primary key) and `demo_table` (without primary key) 
are already created for demo purposes. 
```
demo-# \dt
                   List of relations
 Schema |         Name          | Type  |     Owner     
--------+-----------------------+-------+---------------
 public | demo_table            | table | demouser
 public | demo_table_primarykey | table | demouser
(2 rows)

demo-# \dt+
                                              List of relations
 Schema |         Name          | Type  |     Owner     | Persistence | Access method |  Size   | Description 
--------+-----------------------+-------+---------------+-------------+---------------+---------+-------------
 public | demo_table            | table | demouser | permanent   | heap          | 0 bytes | 
 public | demo_table_primarykey | table | demouser | permanent   | heap          | 0 bytes | 
(2 rows)

```

##### List or show tables MySQL:
Once we select current database with `use demo` , to show the list of tables in MySQL, we can use `show tables`
<blockquote class="code-block-singleline-fullwidth">
    <div><span class="code-highlight-focus">show tables </span> Gives list of tables in current database for mysql</div>
</blockquote>

```
mysql> show tables;
+-----------------------+
| Tables_in_demo        |
+-----------------------+
| demo_table            |
| demo_table_primarykey |
+-----------------------+
2 rows in set (0.00 sec)

```
---

## 5. Describe table
Now that we know how to list all the tables, let's focus on specific table. If we have to describe the table 
fields, index etc, we can use the below queries. 

##### Describe table in PostgreSQL:
To describe a table in PostgreSQL, we can use : `\dt {table_name}` or `\dt+ {table_name}`
Alternatively `\d {table_name}` or `\d+ {table_name}` can also be used with each of the queries resulting in slightly different columns. 

<blockquote class="code-block-singleline-fullwidth">
    <div><span class="code-highlight-focus">\dt {table_name} </span> Gives basic information about specific table</div>
    <div><span class="code-highlight-focus">\dt+ {table_name} </span> Gives additional information about specific table</div>
    <div><span class="code-highlight-focus">\d+ {table_name} </span> Gives index level details too for more specific information. (Preferred way) </div>
</blockquote> 

Example: 
```
demo=# \d+ demo_table_primarykey;
                                  Table "public.demo_table_primarykey"
 Column |  Type   | Collation | Nullable | Default | Storage | Compression | Stats target | Description 
--------+---------+-----------+----------+---------+---------+-------------+--------------+-------------
 id     | integer |           | not null |         | plain   |             |              | 
Indexes:
    "demo_table_primarykey_pkey" PRIMARY KEY, btree (id)
Access method: heap

demo=# \dt demo_table_primarykey;
                   List of relations
 Schema |         Name          | Type  |     Owner     
--------+-----------------------+-------+---------------
 public | demo_table_primarykey | table | demouser
(1 row)

demo=# \dt+ demo_table_primarykey;
                                              List of relations
 Schema |         Name          | Type  |     Owner     | Persistence | Access method |  Size   | Description 
--------+-----------------------+-------+---------------+-------------+---------------+---------+-------------
 public | demo_table_primarykey | table | demouser | permanent   | heap          | 0 bytes | 
(1 row)

```

##### Describe table in MySQL:
In MySQL, to describe a table we can use `desc {table_name}` or `describe {table_name}` for detailed table information.  
<blockquote class="code-block-singleline-fullwidth">
    <div><span class="code-highlight-focus">describe {table_name}</span> Gives full information about specific table</div>
</blockquote> 

Example below: 
```
mysql> describe table demo_table_primarykey;
+----+-------------+-----------------------+------------+-------+---------------+---------+---------+------+------+----------+-------------+
| id | select_type | table                 | partitions | type  | possible_keys | key     | key_len | ref  | rows | filtered | Extra       |
+----+-------------+-----------------------+------------+-------+---------------+---------+---------+------+------+----------+-------------+
|  1 | SIMPLE      | demo_table_primarykey | NULL       | index | NULL          | PRIMARY | 4       | NULL |    1 |   100.00 | Using index |
+----+-------------+-----------------------+------------+-------+---------------+---------+---------+------+------+----------+-------------+
1 row in set, 1 warning (0.00 sec)
```

---
## 6. Show create table
If we want to see how the table is created or detailed indexes etc, MySQL has a convenient way to show the exact table structure. 
But in PostgreSQL there is no straight forward way to see it. But here are some alternatives. 

##### Show create table in PostgreSQL:
Since there is no inbuilt query to show how table is created, we can use `\d+ {table_name}` like we discussed in the 
list table section to view the detailed table info. 
If we want the exact table structure we can rely on `pg_dump` utility which is originally an export schema/data utility of postgres. 
We can leverage the schema dump mechanism from that. 

<blockquote class="code-block-singleline-fullwidth">
    <div><span class="code-highlight-focus">pg_dump -st {table_name} {dbname}</span> Dumps the exact table DDL </div>
</blockquote>

##### Show create table in MySQL: 
In MySQL, in order to see how the table is created, we can use 

<blockquote class="code-block-singleline-fullwidth">
    <div><span class="code-highlight-focus">show create table {table_name} </span> Shows the exact DDL that is used to create the table</div>
</blockquote>

```
mysql> show create table demo_table_primarykey;
+-----------------------+-----------------------------------------------------------------------------------------------------------------------------------------------------+
| Table                 | Create Table                                                                                                                                        |
+-----------------------+-----------------------------------------------------------------------------------------------------------------------------------------------------+
| demo_table_primarykey | CREATE TABLE `demo_table_primarykey` (
  `id` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci |
+-----------------------+-----------------------------------------------------------------------------------------------------------------------------------------------------+
1 row in set (0.01 sec)

```
---
## 7. Show list of users or roles
To view the list of users or roles in PostgreSQL vs MySQL we can use the below syntax. 
##### List users or roles in PostgreSQL:
Detailed of information of users and roles can be obtained from `\du`

<blockquote class="code-block-singleline-fullwidth">
    <div><span class="code-highlight-focus">\du </span> Shows the list of roles and their attributes in PostgreSQL</div>
</blockquote>

```
demo=# \du
                                     List of roles
   Role name   |                         Attributes                         | Member of 
---------------+------------------------------------------------------------+-----------
 postgres      | Superuser, Create role, Create DB, Replication, Bypass RLS | {}
 demouser | Superuser, Create role, Create DB                          | {}
```

##### Show all users or roles in MySQL:
In MySQL `mysql.user` table gives detailed information about various users, roles and their properties. 
To get user and their host you can use below query. Optionally try `DESCRIBE mysql.user` to see full list of supported attributes. 
<blockquote class="code-block-singleline-fullwidth">
    <div><span class="code-highlight-focus">SELECT User, Host from mysql.user; </span> Shows the list of roles and their attributes in MySQL</div>
</blockquote>

```
mysql> SELECT User, Host from mysql.user;
+------------------+-----------+
| User             | Host      |
+------------------+-----------+
| mysql.infoschema | localhost |
| mysql.session    | localhost |
| mysql.sys        | localhost |
| demouser             | localhost |
+------------------+-----------+
4 rows in set (0.00 sec)

```
---
## 8. Show process list
If you have a slow query or you want to view the list of current running process list, we can use the below queries.
##### Show process list in PostgreSQL:
To show process list in PostgreSQL, we can rely on `pg_stat_activity` table. This table has very useful information about 
currently running activities on the database. 

<blockquote class="code-block-singleline-fullwidth">
    <div><span class="code-highlight-focus">select * from pg_stat_activity</span> Gives the detailed list of processes in PostgreSQL</div>
</blockquote>


Example: 
```
postgres=# select * from pg_stat_activity;
 datid | datname  |  pid  | leader_pid | usesysid |    usename    | application_name | client_addr | client_hostname | client_port |         backend_start         |          xact_start           |          query_start          |         state_change          | wait_event_type |     wait_event      | state  | backend_xid | backend_xmin | query_id |              query              |         backend_type         
-------+----------+-------+------------+----------+---------------+------------------+-------------+-----------------+-------------+-------------------------------+-------------------------------+-------------------------------+-------------------------------+-----------------+---------------------+--------+-------------+--------------+----------+---------------------------------+------------------------------
       |          |  1855 |            |          |               |                  |             |                 |             | 2022-06-17 17:30:34.569684-07 |                               |                               |                               | Activity        | AutoVacuumMain      |        |             |              |          |                                 | autovacuum launcher
       |          |  1857 |            |       10 | postgres      |                  |             |                 |             | 2022-06-17 17:30:34.574222-07 |                               |                               |                               | Activity        | LogicalLauncherMain |        |             |              |          |                                 | logical replication launcher
only some datashown for example purposes
```
##### Show process list in MySQL:
To show process list in MySQL you can use : `show processlist`
<blockquote class="code-block-singleline-fullwidth">
    <div><span class="code-highlight-focus">show processlist</span> Gives the detailed list of processes in MySQL</div>
</blockquote>

Example: 
```
mysql> show processlist;
+----+-----------------+-----------+------+---------+-------+------------------------+------------------+
| Id | User            | Host      | db   | Command | Time  | State                  | Info             |
+----+-----------------+-----------+------+---------+-------+------------------------+------------------+
|  5 | event_scheduler | localhost | NULL | Daemon  | 65151 | Waiting on empty queue | NULL             |
|  8 | demouser            | localhost | demo | Query   |     0 | init                   | show processlist |
+----+-----------------+-
```

As you can see from the above comparison, each database is different and the way you can get information from these
databases change a bit. So bookmark and share this post to ease your day-to-day development.

## 9. Comments, Quotes, Case sensitivty
There are some basic differences between PostgreSQL VS MySQL in terms of comments, quotes, case sensitivity. Lets check them here. 

##### Comments:
- Single line comments in PostgreSQL can be added using: `--`
- Single line comments in MySQL can be added using: `#`

##### Handling Quotes: 
- PosgreSQL support only single quote (`'`) character for strings. Example: `WHERE site = 'tipseason.com'`
- MySQL supports both single quote (`'`) and double quote (`"`) characters for strings. Example: `WHERE site = 'tipseason.com'` or `WHERE site = "tipseason.com"`

##### Case sensitivity: 
- PosgreSQL is case-sensitive. Example: `WHERE site = 'tipseason.com'` might give different results than `WHERE site = 'TipSeason.com'` . We can use case conversion like (lower , upper etc.) and compare the objects. 
- MySQL is case-insensitive. So in above example both queries gives same results. 


## PostgreSQL vs MySQL differences side by side 
Here is a quick side by side comparison between PostgreSQL vs MySQL in syntax.

<table class="table table-striped">
    <tr>
        <th>Property</th>
        <th>PostgreSQL</th>
        <th>MySQL</th>
    </tr>
    <tr>
        <td>Show list of databases</td>
        <td class="text text-danger">\l</td>
        <td class="text text-primary">show databases</td>
    </tr>
    <tr>
        <td>Use database</td>
        <td class="text text-danger">\c {db_name}</td>
        <td class="text text-primary">use {db_name}</td>
    </tr>
    <tr>
        <td>Show list of schemas</td>
        <td class="text text-danger">\dn</td>
        <td class="text text-primary">show schemas</td>
    </tr>
    <tr>
        <td>Show list of tables</td>
        <td class="text text-danger">\d or \d+ or \dt or \dt+</td>
        <td class="text text-primary">show tables</td>
    </tr>
    <tr>
        <td>Describe table</td>
        <td class="text text-danger">\dt {table_name} or \d+ {table_name}</td>
        <td class="text text-primary">describe {table_name}</td>
    </tr>
    <tr>
        <td>Show create table</td>
        <td class="text text-danger">pg_dump -st {table_name} {dbname}</td>
        <td class="text text-primary">show create table {table_name} </td>
    </tr>
    <tr>
        <td>Show list of users or roles</td>
        <td class="text text-danger">\du</td>
        <td class="text text-primary">SELECT User, Host from mysql.user; </td>
    </tr>
    <tr>
        <td>Show process list</td>
        <td class="text text-danger">select * from pg_stat_activity</td>
        <td class="text text-primary">show processlist</td>
    </tr>
    <tr>
        <td>Comment single line</td>
        <td class="text text-danger">--  (double dash)</td>
        <td class="text text-primary"># (hash) </td>
    </tr>
    <tr>
        <td>String quotes</td>
        <td class="text text-danger">Only supports single quote (') eg:`where name = 'TipSeason'` </td>
        <td class="text text-primary">Supports both single(') and double quotes (") eg: `where name = "TipSeason"` </td>
    </tr>
    <tr>
        <td>Case sensitivity</td>
        <td class="text text-danger">Postgres is case sensitive eg: `WHERE name = 'TipSeason'` gives different results than `WHERE name = 'tipseason'` </td>
        <td class="text text-primary">MySQL is case insensitive. </td>
    </tr>

</table>



<div class="alert alert-warning" role="alert">
It's always easier to compare things in a table form side by side. 
You can get the full cheatsheet here. 
<br>
<a href="/postgres-vs-mysql-comparision-cheatsheet/" class="text text-danger">MySQL vs PostgreSQL syntax comparision cheatsheet </a>
</div>
