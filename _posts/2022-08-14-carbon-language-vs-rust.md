---
layout: post
title:  "Carbon language vs Rust comparison - A detailed guide"
author: Pramod
categories: [Carbon]
tags: [red, yellow]
image: assets/images/carbon-vs-rust-compare.jpg
description: "In this tutorial we will compare Carbon Language vs Rust with various properties including side by side table comparison"
featured: true
hidden: true
suggestions: ['carbon-language-tutorial-syntax/']
beforetoc: "Carbon language with Rust comparison simplified"
toc: true
tableofcontents: true
promote: true
---
The moment Google open-sourced [Carbon programming language](https://tipseason.com/carbon-language-tutorial-syntax/) with a goal to become a successor to C++, it brought a huge attention among Rust language communities with some of the questions like

* What's the comparison between Carbon language vs Rust ?
* Why Carbon language when we have Rust already as potential C++ successor?
* Will Carbon language fully replace C++ ?

Well, answering these questions may not be straight forward unless we do a detailed analysis between [Rust](https://www.rust-lang.org/) and [Carbon language](https://github.com/carbon-language/carbon-lang/).

In this article, we will go through the comparison between Carbon language vs Rust and get some insights on above questions towards the end of this post. As we go through the post, we will also have a side by side comparison for Carbon to Rust for the listed properties.

Please note that Carbon vs Rust Syntax level detailed comparison will be coming soon. So stay tuned!  

Let's get started.

## Carbon language vs Rust Comparison
Here is the comparison across various properties for each of these languages.

## 1. Purpose and history
#### Rust Lang

* Rust (or Rust-lang) was originally developed by former Mozilla employee [Graydon Hoare](https://github.com/graydon) as a personal project which got sponsorship form Mozilla in 2009 and was announced in 2010. Rust 1.0 was release on May 15, 2015.
* The primary purpose / goals of Rust are to provide Performance, Reliability with high safety, concurrency. 
* It's used in many production systems in various backend applications, cross-platform command-line tools,  embedded systems, WebAssembly etc.

#### Carbon Language

* Carbon language (or Carbon-lang) was announced publicly on 19 July 2022 at CPP North conference by [Chandler Carruth](https://twitter.com/chandlerc1024) along with his team. Carbon is still in development phase and there is no working compiler yet and only has demo interpreter which you can play around with this [Carbon language tutorial](https://tipseason.com/carbon-language-tutorial-syntax/).
* Primary purpose of Carbon language is to have faster performance (similar to C++), Bi-directional Interoperability and migration from C++ (ranging from inheritance to templates), modern syntax.
* While it is still early to predict exact applications using Carbon, it can be inferred to have applications in various backend systems, embedded systems etc. One of the main areas Carbon wants to excel is in codebases that are heavy on C++ code and would require easy migration to C++ successors.

If you are new to Carbon, you can get started with video tutorials on this [Carbon language youtube channel](https://www.youtube.com/channel/UCq7dd8PEBNyROge2Hm_jWnQ/?sub_confirmation=1)

## 2. Interoperability
Language Interoperability ( in short `interop` ) is the ability of one programming language to be able to **interact** with a different programming language as part of the same system. So code written in one language should be compatible with code written in another language.
As new languages evolve, having interoperability is a key element which can make new language adoption easy.

Comparing Carbon vs Rust interoperability with C++,

#### Interoperability in Rust
* Rust doesn't have native language level support for interoperability with C++. Rust supports interop with C. However C++ interop is still not in place and an ongoing work, although it has large gap to support C++. So the common pattern is to rewrite the code in Rust instead of doing an interop with C++.
* However there are external libraries like [cxx](https://cxx.rs/index.html) and [autocxx](https://google.github.io/autocxx/) which try to solve this problem out of the box for interoperability in Rust-lang.

#### Interoperability in Carbon
* Carbon supports bidirectional interoperability with C++. So code written in Carbon can be called in C++ using subset of library wrappers and code written in C++ can be called in Carbon easily.
* This is one of the primary selling points of Carbon as they want to make migration from C++ code relatively seamless

## 3. Garbage collection
At a very high level, garbage collection is **an automatic** process to clean up unused variables/references from program memory especially the heap memory. 
As the programs execute, variables or objects that are no longer referenced in the code accumulate space on the heap. 
So cleaning up these resources is important for efficient memory management. 
Some languages (Eg: Java, python, golang ) perform garbage collection at run time using periodic background threads to deallocate space. 
Few other languages (Eg: Rust) achieve this by adding relevant cleanup code at compile time.

Garbage collection differences between Carbon and Rust are as follows:

#### GC in Rust
- Rust is a GC free language. It manages memory cleanup using ownership mechanism. When a variable goes out of scope and is not reachable, 2 things can happen.
    1. Ownership of that variable can be transferred to some other variable or
    2. The memory associated with the out of scope variable is freed up.

All of this happens at compile time by adding relevant cleanup code. So there is no real garbage collection that happens at run time in Rust.

#### GC in Carbon language
- Carbon language does not have GC either. Just like C++, carbon-lang provides methods to manually manage memory. In C++ we need to use `new` and `delete` to allocate and deallocate the memory.
- Similar to that Carbon language has `heap.New` and `heap.Delete` to allocate and deallocate memory. 

Although this can have some cons in terms of unwanted memory errors this is a general usage pattern for low level languages. Some of the common errors are addressed using [memory safety](https://tipseason.com/carbon-language-memory-safety/) goals of carbon-lang.

## 4. Safety in Carbon vs Rust
Safety of a programming language involves secure mechanisms to safeguard against software bugs and security vulnerabilities. Some common safety mechanisms include Spatial Memory safety, Temporal memory safety, Type safety, Date race safety. You can read more about them [here](https://tipseason.com/carbon-language-memory-safety/)

#### Rust Safety
- Safety is the first citizen in Rust. Rust supports safety at compile time. To avoid Garbage collection at runtime , Rust automatically adds relevant code based on variable scopes.  This helps avoiding manual memory allocation thereby enhancing overall language safety.
- Rust is memory-safe, type-safe, null-safe and thread-safe by design. If the compiler detects the code is unsafe, it throws compilation errors. Unless you specifiy `unsafe` keyword Rust doesn't allow you to perform [unsafe](https://doc.rust-lang.org/rust-by-example/unsafe.html) code.

#### Safety in Carbon Language
- Carbon language has high priority to performance over [Safety](https://github.com/carbon-language/carbon-lang/blob/3276903cee2c18b05f14a03a87fd21ec7d8f4642/docs/design/README.md). It has tight goals to achieve performance similar to C++. This means some of the options like Garbage collection etc., should be manually managed (at-least initially with incremental feature addition).
- Carbon main focus is the ability to perform migration from C++ with interop.

As per Carbon docs,
>The only well understood mechanism of achieving safety without giving up performance is compile-time safety. The leading example of how to achieve this is Rust.

So as the language evolves, compile time safety similar to Rust could be an option for Carbon.


## 5. Borrow checker
Borrow checker is a mechanism that validates and helps you manage ownership rules in the code.

* Rust has borrow checker. Borrow checker is the key sauce of sauce. It helps Rust manage ownership at compile time.
* Carbon language does not have borrow checker as it offers manual memory allocation mechanisms.

## 6. Package manager
Package manager is a program / tool that can automate common development workflows like creating builds, download and install libraries or dependencies required for the codebase etc. They can interact with language specific compiler to perform builds. With package managers you can publish your own packages to a central repositories, which in-turn can be packaged into other projects easily.
Some of the most frequently used package managers are maven, gradle, pip, cargo etc.

#### Package manager in Rust
[Cargo](https://doc.rust-lang.org/cargo/guide/why-cargo-exists.html) is the package manager for Rust. Every executable program or library in Rust is called a [Crate](https://doc.rust-lang.org/cargo/appendix/glossary.html#crate).
The central repository for Rust packages is [crates.io](https://crates.io) . With Cargo you can download dependencies, compile, distribute packages with Crates package registry.

#### Package manager in Carbon Lang
Looking at Carbon language goals, it is projected to include package manager as part of Carbon tools and ecosystem.

> Infrastructure to enable package management and other library ecosystem support:  The goal is to support what the ecosystem needs, regardless of the exact form this ends up taking.
Source: [Carbon language goals](https://github.com/carbon-language/carbon-lang/blob/075b3aba1bdbcb26488529fe35778981d219e5ca/docs/project/goals.md)

While the exact timelines and details are not clear, keeping the current goals in mind, carbon language can include package manager as an improvement compared to C++.

Alright, keeping these differences in mind, let's try to answer the questions that we had in the beginning of this post.

As a quick recap to this article, here is the quick comparison between carbon language vs Rust.

## Carbon language vs Rust side by side comparison
Here is a quick side by side comparison of Carbon vs Rust.

<table class="table table-striped">
    <thead>
    <tr>
        <th>Property</th>
        <th>Carbon Language</th>
        <th>Rust</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td>Goals</td>
        <td>Performance, Interoperability, Migration from C++,</td>
        <td>Concurrency, Reliability, Speed</td>
    </tr>
    <tr>
        <td>Interoperability with C++</td>
        <td>Bidirectional interop supported</td>
        <td>Not currently supported natively</td>
    </tr>
    <tr>
        <td>Garbage collection</td>
        <td>No GC. Manual memory allocation</td>
        <td>No GC. Compile time memory safety</td>
    </tr>
    <tr>
        <td>Safety</td>
        <td>Performance is high priority compared to Safety</td>
        <td>Safety is first citizen</td>
    </tr>
    <tr>
        <td>Borrow checker</td>
        <td>No borrow checker. Manual memory management</td>
        <td>Borrow checker is the main secret sauce in Rust</td>
    </tr>
    <tr>
        <td>Package manager</td>
        <td>Plans to support package manager</td>
        <td>Cargo is the packager manger for Rust</td>
    </tr>
    <tr>
        <td>Embedded systems support</td>
        <td>Yes. Plans to support it in future</td>
        <td>Yes. Currently supported</td>
    </tr>
    <tr>
        <td>Modern syntax</td>
        <td>Yes</td>
        <td>Yes</td>
    </tr>

    </tbody>
</table>


## Why Carbon language when we have Rust already to become C++ successor ?
To address C++ evolution needs, Rust is considered a decent language to be its successor. In fact Carbon language suggests using Rust if you can in the [Why not Rust](https://github.com/carbon-language/carbon-lang/blob/5d12c25bbe4fa7be7a059d878ce96e74b5ed755c/docs/project/faq.md#why-not-rust) section.

> If you want to use Rust, and it is technically and economically viable for your project, you should use Rust.

But Rust has its own advantages and disadvantages especially in terms of interoperability with C++. If the codebase is heavy on C++ , it's difficult to migrate to Rust as it is. The code might have to be re-written in Rust. But Carbon wants to excel in this area

## Will Carbon language fully replace C++ ?
Since Carbon is too early in its development we cannot exactly predict this. Based on a tiny survey (https://twitter.com/thetipseason/status/1553811165280477186) of this question "Do you think Carbon language will fully replace C++ in the future?"

53.3% voted No, 13.3% voted Yes , while 33.3% are neutral on this.

<blockquote class="twitter-tweet"><p lang="en" dir="ltr">Do you thing Carbon language will fully replace C++ in the future ? <a href="https://twitter.com/hashtag/CarbonLang?src=hash&amp;ref_src=twsrc%5Etfw">#CarbonLang</a> <a href="https://twitter.com/hashtag/cplusplus?src=hash&amp;ref_src=twsrc%5Etfw">#cplusplus</a> <a href="https://twitter.com/hashtag/programming?src=hash&amp;ref_src=twsrc%5Etfw">#programming</a> <a href="https://twitter.com/hashtag/languages?src=hash&amp;ref_src=twsrc%5Etfw">#languages</a> <a href="https://twitter.com/hashtag/code?src=hash&amp;ref_src=twsrc%5Etfw">#code</a></p>&mdash; TipSeason (@thetipseason) <a href="https://twitter.com/thetipseason/status/1553811165280477186?ref_src=twsrc%5Etfw">July 31, 2022</a></blockquote> <script async src="https://platform.twitter.com/widgets.js" charset="utf-8"></script>


Things can change a lot while the language is still growing. We will cover this closely as things evolve, so make sure to subscribe to our Carbon language newsletter.
What do you think the future of Carbon is ? Drop your thoughts in the comments.

## Conclusion

Every language has its own pros and cons. But each language is designed with specific goals in mind. Both Carbon and Rust have a great scope and applications for each of them can vary as things progress.

Learning new things are always fun. So give a try with each of these languages and explore around.

Hope this tutorial helps you get some idea about fundamental differences between Carbon and Rust. If you have any other thoughts in mind or if you have any other questions, drop your comment below. Also subscribe to our Carbon language newsletter here to get latest language updates.

{% include mailchimp-carbon.html %}

--- 
### Learn Carbon language from scratch with these resources:

[Carbon language tutorial](https://tipseason.com/carbon-language-tutorial-syntax)

[Carbon language memory safety](https://tipseason.com/carbon-language-memory-safety)

[Fibonacci series example in Carbon](https://tipseason.com/carbon-language-fibonacci-sequence)

[Carbon language documentation](https://tipseason.com/carbon-language.html)


#### Other interesting articles.

[What is dbt (data build tool) in a real world scenario - Beginner dbt tutorial](https://tipseason.com/dbt-tutorial-real-world-scenario-guide/)

[PostgreSQL Vs MySQL Syntax - A beginners guide to use postgres and mysql with comparison and examples](https://tipseason.com/postgres-vs-mysql-syntax-comparision/)





