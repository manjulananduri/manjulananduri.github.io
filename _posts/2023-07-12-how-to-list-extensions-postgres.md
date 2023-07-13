---
layout: post
title:  "Query list of extensions in PostgreSQL - 3 Simple ways"
author: Pramod
categories: [ PostgreSQL, SQL ]
image: assets/images/interviews.png
beforetoc: "Query list of extensions in PostgreSQL - 3 Simple ways"
featured: true
toc: true
promote: true
---

## Introduction:
PostgreSQL, often referred to as Postgres, is a powerful and versatile open-source relational database management system (RDBMS). 
One of its standout features is the ability to extend its functionality using extensions. 
Extensions are modular components that provide additional features, data types, functions, and more to enhance the capabilities of PostgreSQL. 
In this article, we will explore 3 different methods to get the list of extensions in PostgreSQL using psql, pg_extension and 2 other easy 

## 1. Using the psql Command-Line Utility with \dx:

The psql command-line utility provides an interactive shell for working with PostgreSQL. To list extensions using psql, follow these steps:
a. Open the command prompt or terminal and run the following command to access the PostgreSQL shell:
   ```
   psql -U your_username -d your_database
   ```
b. Once connected, execute the following SQL command to list all installed extensions:
   ```
   \dx
   ```
Tip: You can also get detailed Extension Information in PostgreSQL using `\dx extname` command


## 2. Querying the pg_extension Catalog Table:
PostgreSQL stores information about installed extensions in the `pg_extension` system catalog table. You can use SQL queries to extract the desired information. Follow these steps:
a. Connect to the PostgreSQL database using a client application or psql.
b. Execute the following SQL query to list all installed extensions:
   ```
   SELECT extname, extversion, extschema, extowner FROM pg_extension;
   ```

## 3. Utilizing the pg_available_extensions View:
PostgreSQL provides the `pg_available_extensions` system view, which lists all available extensions that can be installed. To retrieve this information, follow these steps:
a. Connect to the PostgreSQL database using psql or a client application.
b. Run the following SQL query to display all available extensions:
   ```
   SELECT * FROM pg_available_extensions;
   ```

## Conclusion:
Listing extensions in PostgreSQL allows users to explore the wide range of additional features available to extend the database's functionality. By utilizing the psql command-line utility, querying system catalog tables, and leveraging system views, you can easily access information about installed extensions, available extensions, and their update paths. Understanding how to list extensions in PostgreSQL empowers users to make informed decisions when selecting and managing extensions for their database environment, enabling them to maximize the potential of their PostgreSQL deployments.