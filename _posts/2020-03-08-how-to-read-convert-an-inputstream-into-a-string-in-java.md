---
layout: post
title:  "How to read or convert an inputstream into a string in java"
author: Pramod
categories: [Java]
tags: [red, yellow]
image: assets/images/javastream.jpeg
description: "How to read or convert an inputstream into a string in java"
featured: false
hidden: true
rating: 5
suggestions: ['how-to-read-file-as-string-in-java/']
---

In many development projects, we might need to convert an InputStream into a String in java. 
In this tutorial we will discuss simple and handpicked ways to read or convert an InputStream into a String in Java.
Depending upon your project configuration, you can use any of the following methods.   

For the purpose of this tutorial, lets assume "inputStream" is a variable of type InputStream.
``` Java
InputStream inputStream; 
```
Check the ways below. 

##### 1. Using Java 1.8+ inbuilt Streams package: 
```java
String result = new BufferedReader(new InputStreamReader(inputStream))
                    .lines().collect(Collectors.joining("\n"));
```
This method works with Java 1.8+ 

##### 2. Native Java Scanner way:  
```java
try (Scanner scanner = new Scanner(inputStream).useDelimiter("\\A")) {
    String result = scanner.hasNext() ? scanner.next() : "";
}
```
Note that "\\A" represents regex pattern for useDelimiter scanner method. 
"\A" stands for :start of a string! . So when this pattern is supplied, whole stream is ready into the scanner object.  

##### 3. Apache commons-io IOUtils way: 
```java
String result = IOUtils.toString(inputStream);
```
For this method, Apache commons-io library should be included into your project. You can include it with the below maven link: 
<a href="https://mvnrepository.com/artifact/commons-io/commons-io/2.6" target="_blank">https://mvnrepository.com/artifact/commons-io/commons-io/2.6</a>

##### 4. Using Google Guava library:
```java
String result = CharStreams.toString(new InputStreamReader(inputStream));
```
For this method, Guava library should be included into your project. You can include it with the below maven link: 
<a href="https://mvnrepository.com/artifact/com.google.guava/guava/r09" target="_blank">https://mvnrepository.com/artifact/com.google.guava/guava/r09</a>

#### 5. Spring Boot style: 
```java
String content = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);
```
If you are using spring boot framework for your project you can use this. To include spring boot, you can use the below maven repo: 
<a href="https://mvnrepository.com/artifact/org.springframework/spring-core/5.2.4.RELEASE" target="_blank">https://mvnrepository.com/artifact/org.springframework/spring-core/5.2.4.RELEASE</a>

#### 6. Plain old ByteArrayOutputStream way: 
```java
ByteArrayOutputStream baos = new ByteArrayOutputStream();
byte[] buffer = new byte[1024];
int length;
while ((length = inputStream.read(buffer)) != -1) {
    baos.write(buffer, 0, length);
}
String result = baos.toString();
```
If you want to play around with actual InputStreams without any utility methods you can use the above style. 


If you feel there are any other better ways to convert the streams or if you have any questions please comment below.

