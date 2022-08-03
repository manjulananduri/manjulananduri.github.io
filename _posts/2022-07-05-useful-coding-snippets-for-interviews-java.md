---
layout: post
title:  "Java Programming Tips for interviews"
author: Pramod
categories: [ Interviews, Java ]
image: assets/images/java_tips.png
beforetoc: "Here are some of the most useful utilities in Java"
featured: true
toc: true
---


#### Print all the elements in a queue.
If the queue has objects then using `System.out.println(queue)` will print hashcodes. So instead you can use: 

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


#### Digit Parsing from string. 
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

#### Integer Parsing from string.
```java
You can use Integer.valueOf(s) 
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


## Additional tips for programming
1. In binary search, insert position of an element is nothing but the 'start' position (i.e. return start) in a iterative version of binary search. Using insert position problem, helps you solve many similar binary search problems. 
2. Java Long range can be from -10^18 to 10^18 (precisely:  -9,223,372,036,854,775,808 to +9,223,372,036,854,775,807)
3. If the number of occurances of more than two characters is odd, you cannot form a palindrome with it.   
4. For palindromes, if the order doesn’t matter, may be go for a counting approach.
5. In a matrix, current diagonal can be identified with ```int currDiagonal = row - col; int currAntiDiagonal = row + col;```
6. For the graph to be a valid tree, it must have exactly n - 1 edges. Any less, and it can't possibly be fully connected. 
Any more, and it has to contain cycles. Additionally, if the graph is fully connected and contains exactly n - 1 edges, 
it can't possibly contain a cycle, and therefore must be a tree! 
7. In some questions they ask for MOD (of 10^9 + 7) if the range is high. In that case you can define mod as int MOD = (1e9 + 7). The answer will be x % MOD.
8. Time complexity of a recursive function is : O(Number of Branches ^ depth of each branch). 