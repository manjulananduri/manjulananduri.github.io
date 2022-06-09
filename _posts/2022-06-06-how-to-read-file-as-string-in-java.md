---
layout: post
title:  "How to read and write to file as a string in java in simple way"
author: Pramod
categories: [ Java]
tags: [red, yellow]
image: assets/images/FileToString.jpg
description: "How to read and write to a file as string in java in simple way"
featured: true
hidden: true
rating: 5
suggestions: ['how-to-read-convert-an-inputstream-into-a-string-in-java/']
---

In many programming projects, converting a file into a String is one of the most common use cases for development.  
In this tutorial we will discuss simple and handpicked ways to read or convert a file into a String in Java.
Depending upon your project configuration, you can use any of the following methods.   

For the purpose of this tutorial, lets assume "inputStream" is a variable of type InputStream.
``` Java
InputStream inputStream; 
```
Check the ways below. 

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

