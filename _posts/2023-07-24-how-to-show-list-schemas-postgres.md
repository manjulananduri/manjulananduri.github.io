---
layout: post
title:  "Show list of schemas in PostgreSQL - 3 Simple ways"
author: Pramod
categories: [ PostgreSQL, SQL ]
image: assets/images/interviews.png
beforetoc: "Query list of extensions in PostgreSQL - 3 Simple ways"
featured: true
toc: true
promote: true
---

## Introduction:

In the world of PostgreSQL, schemas are invaluable organizational tools that help users manage database objects
efficiently. They provide a logical separation of data, allowing multiple users or applications to coexist within the
same database without conflicts. In this comprehensive blog post, we will explore the significance of schemas in
PostgreSQL and demonstrate various methods to obtain a list of schemas in your database.

In addition check this blog post on [How to list all the extensions in PostgreSQL](/how-to-list-extensions-postgres/)

### Understanding PostgreSQL Schemas:
A schema in PostgreSQL is a named container that holds database objects like tables, views, functions, and more. It acts
as a namespace for these objects, providing a way to group them logically. By using schemas, you can organize your data
and avoid naming collisions, making your database more maintainable and scalable.

## How to show schemas list of all schemas in PostgreSQL
Here are 3 different ways to show schemas list in PostgreSQL

## 1. PSQL Command:

If you are using the PostgreSQL interactive terminal, PSQL, you can retrieve the list of schemas using the following
backslash command:
```
\dn
```
When you run this command in the PSQL terminal, you will see a formatted list of all schemas with their names and
associated owners.

## 2. Using SQL Query:
You can use a simple SQL query to fetch a list of all schemas present in your PostgreSQL database:
```
SELECT schema_name FROM information_schema.schemata;
```
Executing this SQL query will provide you with a tabular output containing the names of all the schemas in the database.

## 3. Direct Query to pg_namespace Catalog Table:
An alternative approach to acquiring the list of schemas involves directly querying the pg_namespace catalog table:
```
SELECT nspname AS schema_name, nspowner AS schema_ownerFROM pg_namespace;
```

This query provides additional information, including the owners of each schema, offering a more comprehensive
understanding of your database's organization.

## Conclusion:

PostgreSQL schemas hold the key to establishing a well-organized and streamlined database management system. In this
comprehensive blog post, we explored diverse methods to retrieve an exhaustive list of schemas within a PostgreSQL
database. By leveraging SQL queries on the information_schema, employing PSQL's convenient backslash command, and
querying the pg_namespace catalog table, you now possess a versatile toolkit to access schema information effectively.




    
