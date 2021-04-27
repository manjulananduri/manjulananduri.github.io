---
layout: post
title:  "Useful snippets for coding interviews - Java"
author: Pramod
categories: [ Jekyll, tutorial ]
image: 
beforetoc: "Here are some of the most useful utilities in Java"
featured: false
toc: true
---

#### Print all the elements in a queue.
 
```java
for(Integer x : queue) { 
    System.out.print(x + ","); 
}
System.out.println();
```

#### Array Custom Sort using Lambda
```java 
//Sort based on First element in 2D array. 
int[][] intervals;
Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
Arrays.sort(intervals, (a,b) -> {return (a[0] - b[0]);}); 

//Sort Based on Month Length. 
String[] months = {"January","February","March","April","May","June","July","August","September","October","December"};
Arrays.sort(months, (a, b) -> a.length() - b.length());
Arrays.sort(months, 
    (String a, String b) -> { return Integer.signum(a.length() - b.length()) }; 
);
Arrays.sort(months, Comparator.comparingInt(String::length));


```