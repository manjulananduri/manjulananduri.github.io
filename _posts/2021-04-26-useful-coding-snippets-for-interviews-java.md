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


#### Integer Parsing from string. 
```java
public static void main(String[] args) {
        String s = "2";
        int a = s.charAt(0) - '0';
        System.out.println(a);
        //result = 2
        int b = s.charAt(0);
        System.out.println(b);
        //result = 50
    }
```


## Tips for Coding
1. In binary search, insert position of an element is nothing but the 'start' position (i.e. return start) in a iterative version of binary search.  