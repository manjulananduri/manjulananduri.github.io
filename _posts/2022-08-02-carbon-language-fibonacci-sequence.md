---
layout: post
title:  "Carbon language fibonacci series, print nth fibonacci number"
author: Pramod
categories: [Carbon]
tags: [red, yellow]
image: assets/images/carbon-fibonacci-series.png
description: "Simplest way to print fibonacci series in carbon programming language. Working without errors to print the full series"
featured: true
hidden: true
suggestions: ['carbon-language-tutorial-syntax/']
beforetoc: "Google Carbon language is an open source Programming language that is successor to C++"
toc: true
tableofcontents: true
promote: true
last_modified_at: 2022-08-01T23:02:00+00:00
---

Google introduced [Carbon programming language](https://tipseason.com/carbon-language-tutorial-syntax/) with a modern language syntax to become a successor to C++.

One of the challenges many beginner developers are facing is to run basic examples since the language is in a very early stage without even having a compiler. So here is a working example to print fibonacci series using Carbon language.

## How to print fibonacci series in carbon lang
To recollect Fibonacci series, here the following sequence that we want to print.

`0, 1, 1, 2, 3, 5, 8, 13, 21 ....`

Currently, there is no support `<` symbol yet in Carbon language. Also `for` loop is not yet supported in carbon language. So we will use different approach.

To print fibonacci series in carbon, we will use combination of recursion + iteration to print fibonacci sequence. Here are 2 steps we follow.

1. Print nth fibonacci number in Carbon programming language
2. Print fibonacci sequence using While loop in carbonlang

Let's dive in

## Step 1: Print nth fibonacci number in Carbon language
We use a recursive code to calculate nth fibonacci number using the follow recursive formula.
```
fib(n) = fib(n-1) + fib(n-2); 
if n <= 1 we can just print n. 
```

Let's write code in carbon language.

```
fn Square(x: i32) -> i32 {
  return x * x;
}

fn fib(n: i32) -> i32 {
    if(n == 0) {
        return 0;
    }
    if(n == 1) {
        return 1;
    }

    return fib(n - 1) + fib(n - 2);
}
```


## Step 2: Print fibonacci sequence using While loop in carbonlang
The next step is the call fib(n) for n times. This can be achieved using while loop.
Observe fib(i) inside `Print` method.

```
fn fibSeries(count: i32) {
    var i: i32 = count;
    while(not (i == 0)) {
        Print("{0}", fib(i));
        i = i - 1;
    }

}
```

## Print fibonacci sequence in carbonlang
Connecting two pieces together, we can have

```
package sample api;

fn Square(x: i32) -> i32 {
  return x * x;
}

fn fib(n: i32) -> i32 {
    if(n == 0) {
        return 0;
    }
    if(n == 1) {
        return 1;
    }
    return fib(n - 1) + fib(n - 2);
}


fn fibonacciSeries(count: i32) {
    var i: i32 = count;
    while(not (i == 0)) {
        Print("{0}", fib(i));
        i = i - 1;
    }

}

fn Main() -> i32 {
    var n: i32 = 6;
    Print("Input n: {0}", n);
    Print("nth fibonacci number result: {0}", fib(n));
    Print("-----------", n); 
    Print("Fibonacci series for n = {0}", n);
    fibonacciSeries(10);
    return 0;
}
```

The output for this would be
```
Input n: 6
nth fibonacci number result: 8
-----------
Fibonacci series for n = 6
55
34
21
13
8
5
3
2
1
1
```

You can try this by yourself using carbon language compiler explorer online:
[Compiler explorer](https://carbon.godbolt.org/)

Additional Reading in Carbon language:

Carbon language memory safety for secure memory management:
[Carbon language memory management](https://tipseason.com/carbon-language-memory-safety/)

This is a part of carbon language series for beginners. Will share carbon language tips and working examples regularly. You can view full carbon language tutorial video here.

## Carbon language short course 
If you are getting started with Carbon, you can watch carbon language tutorial here 

<iframe width="560" height="315" src="https://www.youtube.com/embed/vff1BRrQr_w" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>

If you find other better ways to print fibonacci series in carbon, share your thoughts in the comments.


### What's next?

- A real world project built on top of supported Carbon language features.
- We will cover Carbon language updates very closely with a free newsletter and detailed articles. If you are interested in learning more about Carbon, drop your email to our Newsletter to stay on top of Carbon and latest improvements.

{% include mailchimp-carbon.html %}
