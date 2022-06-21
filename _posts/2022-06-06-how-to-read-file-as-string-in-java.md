---
layout: post
title:  "How to read and write to file as a string in java in simple way"
author: Pramod
categories: [ Java]
tags: [red, yellow]
image: assets/images/FileToString.jpg
description: "5 simple ways to convert file to a string in java"
beforetoc: "5 simple ways to convert file to a string in java"
featured: true
hidden: true
rating: 5
promote: true
suggestions: ['how-to-read-convert-an-inputstream-into-a-string-in-java/']
---


Writing real world application code in java involves file and string processing. Some of the common use cases to convert a file to string are as follows.

1. Read a JSON file and parse content from it.
2. Read a CSV file for machine learning input data.

There are numerous other use cases for this. So given the huge number of applications,  in this tutorial we will discuss 5 simple and handpicked ways to read or convert a file into a String in Java.
Depending upon your project configuration, you can use any of the following methods.

##### 1. Using Java 1.11+ inbuilt Files package: 
```java
import java.nio.file.Files;
import java.nio.file.Path;

String result = Files.readString(Path.of("filePath"));

//To Write string to a file you can use 
String content = "Demo Content";
Files.writeString(filePath, content);
```
This method works with Java 1.11+ 

##### 2. Using Java 1.8+ inbuilt Streams package: 
```java
String result = new String(Files.readAllBytes(Paths.get(filePath)), StandardCharsets.UTF_8);
```
This method works with Java 1.8+ 

##### 3. Native Java Scanner way:  
```java
try (Scanner scanner = new Scanner(Paths.get(fileName), StandardCharsets.UTF_8.name())) {
    String result = scanner.useDelimiter("\\A").next();   
} 
```
Note that "\\A" represents regex pattern for useDelimiter scanner method. 
"\A" stands for :start of a string! . So when this pattern is supplied, whole stream is ready into the scanner object.  

##### 4. Apache commons-io IOUtils way: 
```java
File file = new File("data.txt");
String result = FileUtils.readFileToString(file, StandardCharsets.UTF_8);
```
For this method, Apache commons-io library should be included into your project. You can include it with the below maven link: 
<a href="https://mvnrepository.com/artifact/commons-io/commons-io/2.6" target="_blank">https://mvnrepository.com/artifact/commons-io/commons-io/2.6</a>

##### 5. Using Google Guava library:
```java
String result = Files.toString(new File(path), Charsets.UTF_8);
```
For this method, Guava library should be included into your project. You can include it with the below maven link: 
<a href="https://mvnrepository.com/artifact/com.google.guava/guava/r09" target="_blank">https://mvnrepository.com/artifact/com.google.guava/guava/r09</a>

If you want to play around with actual InputStreams without any utility methods you can use the above style. 


If you feel there are any other better ways to convert the streams or if you have any questions please comment below.
