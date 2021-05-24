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

#### Print Integer in Binary or any Base
```java
int i = 20;
Integer.toBinaryString(i); //Prints in Binary 
Integer.toString(i, 2); //Prints in Base 2 i.e. Binary 
Integer.toString(i, n); //Prints in Base n

```

#### Java TreeMap. 
floorKey() : The floorKey method is used to return a keymapping associated with the greatest key less than or equal to the given key, or null if there is no such key.             
Map.Entry floorEntry(): The floorEntry(K key) method is used to return a key-value mapping associated with the greatest key less than or equal to the given key, or null if there is no such key.
ceilingKey() : The ceilingKey function of TreeMap Class returns the least key greater than or equal to the given key or null if the such a key is absent.


## Tips for Coding
1. In binary search, insert position of an element is nothing but the 'start' position (i.e. return start) in a iterative version of binary search.
2. Java Long range can be from -10^18 to 10^18 (precisely:  -9,223,372,036,854,775,808 to +9,223,372,036,854,775,807)
3. If the number of occurances of more than two characters is odd, you cannot form a palindrome with it.   
4. For palindromes, if the order doesn’t matter, may be go for a counting approach.
5. In a matrix, current diagonal can be identified with ```int currDiagonal = row - col; int currAntiDiagonal = row + col;``` 