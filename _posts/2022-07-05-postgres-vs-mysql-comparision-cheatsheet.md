---
layout: post 
title:  "PostgreSQL Vs MySQL differences in syntax - side by side comparison cheatsheet for show databases, tables, schemas and more"
author: Pramod 
categories: [Database, MySQL, PostgreSQL]
tags: [red, yellow]
image: assets/images/postgres-vs-mysql-cheatsheet.png 
description: "PostgreSQL Vs MySQL differences in syntax side by side comparison cheatsheet for show databases, tables, schemas and more"
hidden: true
suggestions: ['how-to-read-convert-an-inputstream-into-a-string-in-java/']
beforetoc: "PostgreSQL Vs MySQL Syntax Comparison - Cheatsheet for databases, tables, schemas"
toc: true
promote: true
---

In the previous post for [PostgreSQL Vs MySQL Syntax Comparison - Useful basic commands with examples](/postgres-vs-mysql-syntax-comparision/) , we compared the detailed differences between PostgreSQL
vs MySQL syntax. If you haven't read it already we strongly recommend to read that post before going through this cheatsheet as it has more detailed examples with basic command usage for postgres and mysql. 

As a handy reference, here is the cheatsheet for PostgreSQL vs MySQL syntax comparison highlighting the differences. 

<table style="width:100%; border-collapse:collapse; border:1px solid #69899F; text-align:center" border="1">
    <tr>
        <th>How to</th>
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

<br> 
<div class="alert alert-warning" role="alert">
If you need detailed examples on how to use these commands you can read this link: 
<br>
<a href="/postgres-vs-mysql-syntax-comparision/" class="text text-danger"><u>PostgreSQL Vs MySQL Syntax Comparison - Useful basic commands with examples </u></a>
</div>
