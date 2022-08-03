---
layout: post
title:  "Carbon language memory safety for secure memory management"
author: Pramod
categories: [Carbon]
tags: [red, yellow]
image: assets/images/carbon-memory-safety.png
description: "Memory management is critical to Carbon language to address memory safety issues from C++. Carbon language looks like it has great roadmap to achieve this"
hidden: true
suggestions: ['carbon-language-tutorial-syntax/']
beforetoc: "Memory management is critical to Carbon language to address memory safety issues from C++"
toc: true
featured: true
tableofcontents: true
promote: false
---

# Carbon language memory safety for secure memory management 

Google open sourced Carbon language with a goal become a successor of C++. In the previous post, we learnt about what carbon language is along with syntax and working examples. In case you 
missed it , here is the link for [carbon language tutorial](/carbon-language-tutorial-syntax)

One of the primary goals of Google carbon programming language is the memory safety as part of its memory management. 
Having a safer fundementals with incremental goals towards achieving robust memory safety is the key. 
In this tutorial we will learn about what is memory safety and how google carbon language provides memory safety as part of the memory management.

## What is memory safety ?
Memory safety is the property of programming languages to provide a secure mechanism to safeguard against software bugs 
and security vulnerabilities related to memory management. 

Memory safety bugs are very critical as they compromise the security of the application. 
Some of the common memory safety bugs involve 
* [Buffer Overflows](https://en.wikipedia.org/wiki/Buffer_overflow): When data is written to a buffer, in certain vulnerable situations, 
the data might be written to adjacent memory boundaries and overrides the existing data in those locations. This is a serious security concern. 
* [Dangling pointers](https://en.wikipedia.org/wiki/Dangling_pointer): Dangling pointers are the pointers that have invalid references to deleted/deallocated objects. 

When designing a programming language and writing applications, dealing with memory safety is important. Some of the programming languages like  
Java, Rust, C#, Swift, Pythin , JavaScript provide memory safety as part of the language design. 
Run-time error detection is a common technique(for example in Java) to perform array bounds and pointer dereferences that help in memory safety. 

Languages like C, C++ does not provide memory safety as they allow arbitrary pointer arithmetic. 

Carbon language has principles and design goals to achieve memory safety. 

## How carbon language achieves memory safety 
Carbon language has bunch of safety design principles to address "safety". As part of that, there are different ways memory safety is achieved in carbonlang.  
Let's look at each of them. 

### 1. Spatial Memory safety
Spatial memory safety is similar to buffer overflows. It's a way to protect access to address locations that are out of bounds for the source. 
This memory safety includes 
- Array boundary checks 
- Dereference invalid pointers for uninitialized pointers, handling `NULL` in C++.   

### 2. Temporal memory safety
Temporal memory safety involves avoiding access to addresses once they are deallocated. So if the address is deallocated, ideally it should be restricted to protect against these references. 
Checks that involve temporal memory safety in carbon are 
- use-after-free for heap 
- use-after-return for stack addresses. 

As part of address checks,  there are two other design principles for carbon language memory management. 
### 3. Type safety
If a valid memory location is accessed with an invalid type, it will be restricted. "Type Confusion" is what Carbon names it.

### 4. Date race safety
When multiple threads access same memory location involving reads and writes, that memory location needs to be properly protected against race conditions. 
Having a language level support for race conditions can be a great advantage when dealing with synchronization problems for multithreading.  

So these are some of the design principles and goals that carbon language plan to have as part of memory management. 

Memory safety is a critical part for programming languages but they are also tricky areas to handle. Let's look at how Carbon plan to achieve it.

## Memory safety roadmap
One of the key goals of Carbon language is to support interoperability (the ability to call C++ code from carbon language and viceversa). Dealing with the combination of Memory safety + interoperability 
can be very challenging as C++ is not a memory safe language. However being a successor language to C++ , carbon language is committed to memory safety in a phased approach. 
Based on the current status of carbon language, here is the roadmap for memory management. 

The primary priority for handling memory safety in Carbon is to address 
- Having a clean tracking for un-intialized states. Variable initialization enforcement and having a systematic solution to initialization bugs whereever possible 
- Provide dynamic boundary checks to debug and harden builds 
- Providing `debug` mode for builds which provide granular information for address references so that there errors can be detected at build time itself. This debug should 
also be available even when using Address Sanitizer. 
  - [Address Sanitizer](https://github.com/google/sanitizers/wiki/AddressSanitizer) is a memory error detector for C/C++. It 
  can find Dangling pointer references, Heap buffer overflow, Global buffer overflow, Use after scope, memory leaks and many more in a faster way.

Once the above goals are achieved then future goals like 'Safe Carbon Subset' will be addressed even though the intial 0.1 design doesn't handle this, there are definitely 
plans to address memory management with fundemental concepts around 'safety'
  



## Conclusion:

As we know , Carbon language is still in development phase, these goals might change rapidly as things evolve. Having a clear roadmap on how these problems needs to be addressed 
when building a new language is very important and Carbon looks like it's in a right direction to achieve these goals. 

Hope this tutorial helps you to understand some of the basic concepts of Carbon language memory management using memory safety and how Carbon plans to address this them at language level support. 

What's next?

- A real world project built on top of supported Carbon language features.
- We will cover Carbon language updates very closely with a free newsletter and detailed articles. If you are interested in learning more about Carbon, drop your email to our Newsletter to stay on top of Carbon and latest improvements.

{% include mailchimp-carbon.html %}

--- 
## Suggested Articles:
[Carbon language not working](https://tipseason.com/carbon-language-execvp-error/)

[Top 10 most loved programming languages of 2022 and which companies use them](https://tipseason.com/top-10-most-loved-programming-languages-2022/)

[PostgreSQL Vs MySQL Syntax - A beginners guide to use postgres and mysql with comparison and examples](https://tipseason.com/postgres-vs-mysql-syntax-comparision/)

--- 
## References:
[Carbon language official github](https://github.com/carbon-language/carbon-lang/)










