---
layout: post
title:  "Carbon language tutorial with syntax, examples - A beginner guide"
author: Pramod
categories: [Carbon]
tags: [red, yellow]
image: assets/images/carbon-language-tutorial.png
description: "Google introduced Carbon language as the next generation programming language with a goal to replace C++ as a successor"
featured: true
hidden: true
suggestions: ['carbon-language-memory-safety/']
beforetoc: "Google Carbon language is an open source Programming language that is successor to C++"
toc: true
tableofcontents: true
promote: true
---

Google introduced Carbon language as the next generation programming language with a goal to replace C++ as a successor. It's an open source project still in experimental phase. Originally demonstrated by Chandler Carruth in [CppNorth](https://cppnorth.ca/) conference, Carbon language looks like a great alternative to C++.

In this tutorial we will learn about various aspects of Carbon language and jump into carbon language basic syntax along with examples code that you can use to try the language after reading through the end of this documentation.

Let's dive in.

## What and Why Carbon Language ?

Carbon language can replace C++ as things evolve. C++ is already a great language to work with. It can give high performance and widely used in many production systems. It can run with multiple platforms, hardware architecture and many operating systems. However some of the problems with C++ are

- Accumulated technical debt (eg: Integer promotion rules) across various functionalities. Backward compatibility with C makes it even more hard to fix tech debt and make code changes hard to implement.
- Evolution process to add new functionalities to C++ is very difficult as it needs to adhere to ISO process overhead, preventing from experimentation etc.

So C++ is falling short of some of it's goals like Performance critical software; Software and language evolution; Code that is easy to understand and write; Fast and scalable development and so on.

Since solving these problems with C++ is really hard, after a deep research and evaluation across multiple languages by Google engineers, **Carbon programming language** is introduced. So it is like a successor to C++ similar to

- C -> C++
- JavaScript -> TypeScript
- Objective-C -> Swift
- Java -> Kotlin
- C++ -> Carbon Language

where the left part of arrow is the original language and right part is the replacing language.

Some of the key aspects of successor languages include - Building on top of existing ecosystem, Bi-directional interoperability, Optimize learning curve , Modern tooling systems like package manager etc.

Carbon language is not inherited from legacy C or C++. It's built from scratch with modern  language fundamentals such as Generics, Modular code, Consistent, Simple syntax.

## Key features of Carbon language

1. **Fast performance** matching C++ using LLVM (low level virtual machine), having low level access to bits and addresses.
2. **Bi-directional Interoperability** indicates that you can call C++ language code from Carbon language and Carbon language code from C++.
3. **Migration** Provides support to migrate code from C++.
4. **Modern and evolving** features like fast and scalable builds that can work with existing C++ builds, easier to learn.
5. **Built with Open Source** with clear goals and priorities having batteries included approach such as compilers, libraries, documentation, package manager etc.

### Carbon language VS Rust comparison

As part of the Carbon language evolution, lot of factors are considered. Some of them include taking a look at garbage collected languages (like Java), more modern language such as Rust , swift , Kotlin and so on.

[Rust](https://www.rust-lang.org/) is thoroughly evaluated as a replacement to C++. Infact Carbon language insists to use Rust and ignore Carbon if possible as Rust is technically and economically more viable language.

However for organizations that are already using C++ , it's very difficult to migrate to Rust. Software written in Rust has properties and modules that non of the languages like C++ or Carbon has. Adapting to Rust for large C++ codebases is almost not practical given that there is no inter-operability. We will talk in depth about this in a separate article soon. If you are still curious, you can learn more about it [here](https://github.com/carbon-language/carbon-lang/blob/trunk/docs/project/faq.md#why-not-rust) on why Rust is not a replacement for C++.

Now that we know what Carbon language is and why we need to use it, let's dive into the actual setup/installation, syntax, examples.

Alright! Let's jump into carbon language. 

## How to setup and install Carbon language:
Getting started with Carbon language involves installation of
- `Homebrew`: is a package installation tool. If you don't have homebrew installed you can follow these [instructions](https://brew.sh/) . In MacOs you can install homebrew using `/bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/HEAD/install.sh)"`
- `Bazel` : Bazel is an open-source build and test tool which can support multiple languages, platforms.
- `LLVM`: LLVM is a low level virtual machine that Carbon language uses to run. You may not need to have full knowledge of LLVM to follow this tutorial. 
- `Carbon Explorer`: Carbon explorer is like an implementation tool to Carbon language. To run all the programs of Carbon lang, we will use carbon explorer.

For the purpose of this tutorial, we will use MacOS to install. However instructions for other operating systems like linux or windows can be similar. If you have any questions on installation or if carbon language is not working for any reason, 
you can drop a comment on this post. Will try to solve the issue. 

To install carbon lang, run these commands in your terminal.

#### Step 1: Install Bazel
To install Bazel you can run
```
$ brew install bazelisk
```
This should automatically install and setup Bazel that is ready to use. If you have any errors related to permissions, the error message from Bazel will have useful command to run. Try to run that command using `sudo`

#### Step 2: Install LLVM
LLVM is the core virtual machine on which carbon language is run on. To install it
```
$ brew install llvm
$ export PATH="$(brew --prefix llvm)/bin:${PATH}"
```
One thing to note is MacOS has a default llvm . So using `brew install llvm may` give message like `llvm is keg-only, which means it was not symlinked ...`. To solve this problem go to <a href="#troubleshooting">Carbon language Installation errors troubleshooting </a> section at the end of this article to solve this problem.


#### Step 3: Setup Carbon language code
This step is to download carbon lang code which also has some examples.

```
$ git clone https://github.com/carbon-language/carbon-lang
$ cd carbon-lang
```

#### Step 4: Hello world with Carbon language
Now that we have setup Carbon language, let's do a quick run for Hello world. To do that we will use Carbon explorer to run. To run your first code in Carbon, make sure you are in the `carbon-lang` directory that you cloned from git and then run below command.

```
$ bazel run //explorer -- ./explorer/testdata/print/format_only.carbon
```
What this line is doing is to invoke Bazel build tool to trigger explorer code that in turns runs the actual code present in the `./explorer/testdata/print/format_only.carbon` file.

Once you run this you should see a Hello world in Carbon output like this

```
tipseason$ bazel run //explorer -- ./explorer/testdata/print/format_only.carbon
INFO: Invocation ID: aa36a266-cb55-4433-9bed-907e393c0605
WARNING: ..... 
.
.
INFO: Build completed successfully, 390 total actions
.
.
Hello world!
result: 0
```
As you can see "Hello World!" is printed and return type of main is int32 resulting to 0.
The code that is behind this hello world program is

File path: `./explorer/testdata/print/format_only.carbon`
```
package ExplorerTest api;

fn Main() -> i32 {
  var s: auto = "Hello world!";
  Print(s);
  return 0;
}
```

The file extension for Carbon language code is `.carbon` . So if you write new carbon language file you need to have a file which ends with extension of `.carbon`. Example: `demo.carbon` .

Now that we have carbon language setup, let's look at the some of the basic syntax that can be used in day to day basis for Carbon language.

## Video tutorial
If you prefer to watch video version of this tutorial including live demos + walkthrough installation and working examples, you can follow this youtube video too.

<iframe width="560" height="315" src="https://www.youtube.com/embed/vff1BRrQr_w" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>

Let's jump into Carbon language basic syntax. 

## Carbon Language Basic Syntax with examples:

Carbon language is still in experimental phases. While most of the design choices are made already, some of the syntax and usage might change as things evolve. So keep that in mind while working with Carbon-lang. One great thing about Carbon is that the syntax should be C/C++ developer friendly and easy to understand.

For the best use of this tutorial, to follow along with each of these examples, You can run the below examples using Carbon language explorer that you installed in the previous step. 
If you are running in your own machine, you can create new files each time you run a program or modify 
`./explorer/testdata/print/format_only.carbon` file to check the examples. 

Each time you modify the code , run `bazel run //explorer -- ./explorer/testdata/print/format_only.carbon` to see the output.

Note: `format_only.carbon` is just a sample file. Change it to whichever filename you created. 

Alternatively, you can also use Carbon online explorer IDE to run through the below examples.
<br>
Just copy paste below examples in the online IDE and you can see live results.
<br>
Link for online carbon explorer IDE is at [Carbon Godbolt](https://carbon.godbolt.org/) or [Carbon online explorer](http://carbon.compiler-explorer.com/)

Let's get started on how to use carbon language.

### Declarations in carbon lang:
- Methods/Functions are declared using `fn` keyword.
- Variables are declared using `var` keyword.
- Variable names should end with `:` followed by space eg: `var x:`
- Constants can be declared using `let` keyword.
- Packages are declared using `package` keyword.
- Comments in Carbon language can be declared using two slashes `//`
- `auto` can be used to automatically infer the variable type. It can be used in combination of `let` or `var` or as function return types.

**Example/ Demo code:**
```
package ExplorerTest api;

//fn is function declaration
//return type is i32 i.e. int.
fn Main() -> i32 {
  //I am a comment. 

  var s: auto = "Hello world!"; // Auto Variable 
  let x: i32 = 20; // Constant
  var y: i32 = 3; // Integer variable 
  Print(s); // Print 
  return 0; //Return value 
}
```

### Functions/Methods in Carbon

Functions can be declared using `fn` keyword. The syntax is `fn MethodName(var param: type ... ) -> return type` . For void or empty return types , you can ignore the part after `->`

**Example:**
```
package ExplorerTest api;

//Integer return type 
fn Sum(var a: i32, var b: i32) -> i32 {
    return a + b;
}

//Empty or void return type. 
fn PrintCount(var count: i32) {
    Print("The count is {0}", count);
}

fn Main() -> i32 {
    Print("Sum is {0}", Sum(4, 6));
    PrintCount(10);
    return 0;
}
```


### Numeric Variables in carbon lang:

Variables in carbon language can be
- `bool` for boolean `true` or `false`
- `i8`, `i16`, `i32`, `i64`, `i128`, `i256` for integer types.
- `u8`, `u16`, `u32`, `u128`, `u256`  for unsigned integer types.
- `f16`, `f32`, `f64`, and `f128` for float types.
- `_` can be used for digit separators. Eg: 1_000_000 is still an integer if declared without quotes.

**Example:**
```
package ExplorerTest api;

fn Main() -> i32 {
  var a: i32 = 1;
  var b: i32 = 2;
  Print(a + b);
  return 0;
}
```  

### Strings in carbon language:

Strings can be declared using
- `String` for byte sequence
- `StringView` as a read only reference for utf-8 byte sequence.

Strings literals can be declared in two ways.

1. Single Line: Use double quotation mark(`"`) for single line.
2. Multi line string: For multi line string declaration use (`"""`)

**Example:**
```
package ExplorerTest api;

fn Main() -> i32 {
  var singleLine: String = "Hello world!";
  var multiLine: String = """hello line 1
            TipSeason demo line 2
            TipSeason demo line 3    
        """; //End of multi block
  return 0;
}
```  

### [Tuples](https://github.com/carbon-language/carbon-lang/blob/trunk/docs/design/tuples.md) in carbon lang:
Tuples represent values with multiple coordinates. They can be declared using parenthesis `( )`

**Example / Sample code **
```
package ExplorerTest api;

fn Main() -> i32 {
  var x: auto = (0, 1);
  Print("{0}", x[1]);
  return x[0];
}

```
Here `(x,y,z)` is a tuple with multiple coordinates. They can be accessed using the index.

### Pointers in Carbon lang:
There are no null pointers in Carbon. To represent a pointer that may not refer to a valid object, use the type Optional(T*) where `T` is the type.

`*` represents value.
`&` represents address.

**Example: **
```
package ExplorerTest api;

fn Main() -> i32 {
  var x: i32 = 5;
  // changes x to 10
  x = 10;
  Print("---");
  Print("x = {0}", x);
  var y: i32* = &x;
  // changes x to 7
  *y = 7;
  Print("---");
  Print("x = {0}", x);
  Print("y = {0}", *y);
  var z: i32* = &*y;
  // changes x to 0
  *z = 0;
  Print("---");
  Print("x = {0}", x);
  Print("y = {0}", *y);
  Print("z = {0}", *z);
  var w: i32 = *y;

  return w;
}

```

### Arrays in Carbon:
Arrays are declared using array type and the size. Syntax is `[type; size]`
Eg: `var xarray: [i32; 4] = (1,2,3,4);`

**Example**
```
package ExplorerTest api;

fn Main() -> i32 {
  var xarray: [i32; 4] = (0, 1, 5, 6); // Integer array 
  var index: i32 = 1;
  xarray[index] = 0;
  Print("{0}", xarray[0]);
  Print("{1}", xarray[0]);
  return xarray[0] + xarray[1];
}
```

### Conditional control flow with carbon
Combination of `if` , `else` can be used to control the conditional flow in Carbon.

**if-else: **

```
if(condition) {
 //doSomething
} else {
 //doSomething
}
```

**if-else-if**
```
if(condition) {
 //doSomething
} else if (condition) {
 //doSomething
} else {
  //doSomething
}
 
``` 

**Example:**
```
package ExplorerTest api;

fn Main() -> i32 {
  var x: i32 = 5;
  if(x == 5) {
    Print("{0} to word is FIVE", x);
  } else {
    Print("{0} is not known ", x);
  }
  return 0;
}

```


### Loops in Carbon language

Standards looping statements are supported.

#### While loop
While loop can be declared using `while(condition){ }`

**Example:**
```
package ExplorerTest api;

fn Main() -> i32 {
  var x: auto = 5;
  while (not (x == 0)) {
    x = x - 1;
    Print("{0}  ", x);
  }
  return x;
}
```


#### For Loop
For loop can be declared using `for (loop conditions) { }` . At the time of writing this article didn't get full working example. But here is the proposed [syntax](https://github.com/carbon-language/carbon-lang/tree/trunk/docs/design#for).

```
package ExplorerTest api;

fn Main() -> i32 {

  var names: [String; 4] = ("a", "b");
  for (var name: String in names) {
   Console.Print(name);
  }

  return x;
}
```


### Match multiple conditions similar to Switch
Carbon has `match` keyword which is similar to `switch` in C/C++. Syntax for match is
```
match(condition) {
  case (condition) => {
    //doSomething;
  }
  default => {
    //doSomething;
  }
}
```

<b>Example: </b>

```
package ExplorerTest api;

fn Matcher(var num: i32) -> i32 {
  var number: auto = 10;
  match (number) {
    case 5 => {
      Print("Got 5");
      return number;
    }
    case 10 => {
      Print("Got 10");
      return number;
    }
    default => {
      Print("Default");
      return number;
    }
  }
}

fn Main() -> i32 {
    Matcher(5);
    Matcher(10);
    Matcher(2);
    return 0;
}
```

### Classes in Carbon Lang:
Class in carbon language can be declared using `class` keyword.
Class can have members and methods. Here is an example class implementation.

```
package ExplorerTest api;

class Sum {
  var a: i32;

  fn Add[me: Self](var num: i32) -> i32 {
      var total: i32 = me.a + num;
      return total;
  }
}

fn Main() -> i32 {
  var p1: Sum = {.a = 5};
  var total: i32 = p1.Add(5);
  Print("Total sum {0}" , total);
  return 0;
}
```


### Structs in Google carbon language:
Structural types help you identify members using the name instead of their index/position. They are declared within curly braces `var name: auto = {.name1 = value1, .name2 = value2, ... }` and can be accessed using `name.name1` etc.

**Example:**
```
package ExplorerTest api;

fn Main() -> i32 {
  var point: auto = {.x_axis = 0, .y_axis = 1};
  point = {.x_axis = 5, .y_axis = -5};
  var result: i32 = point.x_axis * point.x_axis + point.y_axis * point.y_axis;
  Print("Result : {0}", result);
  return 0;
}
```


### Generics in Carbon programming language:
Generics can be seen in many modern languages. They define a way to induce compile time type checks and helps define cleaner type variables. They can be declared using `T` paramter types are shown below.

<b>Example: </b>

```
package ExplorerTest api;

fn GenericExample[T:! Type](x: T) -> T {
  return x;
}

fn Main() -> i32 {
  Print("Integer generic type {0}", GenericExample(0));
  Print(GenericExample("This is a string generic"));
  return 0;
}
```

### Memory safety in Carbon language: 
Carbon language has a heavy focus on memory management especially when it comes to memory safety. At a very high level carbon language plans to achieve memory 
safety using 
- Spatial Memory safety
- Temporal memory safety
Here is a detailed tutorial on how  memory safety is achieved in carbon along with goals and basics. 
Check [Carbon language memory safety for secure memory management](/carbon-language-memory-safety)


### <span id="troubleshooting"> Carbon language Installation errors troubleshooting </span>

[Carbon llvm-ar error fix](https://tipseason.com/carbon-language-execvp-error/): 

```
llvm is keg-only, which means it was not symlinked into /usr/local,
because macOS already provides this software and installing another version in
parallel can cause all kinds of trouble.

If you need to have llvm first in your PATH, run:
  echo 'export PATH="/usr/local/opt/llvm/bin:$PATH"' >> /Users/pramodnanduri/.bash_profile

For compilers to find llvm you may need to set:
  export LDFLAGS="-L/usr/local/opt/llvm/lib"
  export CPPFLAGS="-I/usr/local/opt/llvm/include"

```

To solve this problem configure your  `~/.bash_profile` file to have following variables
```
export PATH="/usr/local/opt/llvm/bin:$PATH"
export LDFLAGS="-L/usr/local/opt/llvm/lib"
export CPPFLAGS="-I/usr/local/opt/llvm/include"
export CC=$(which clang)
```
Once you save it make sure to run
```source ~/.bash_profile```

If you have other errors , drop a comment below . Will check and respond back.

## Carbon language release date:
While carbon language is still experimental phase , it is still unclear when it will be available for public usage. Lot of basic usage examples are still not supported. Hope to have this coming soon to get started.

## Conclusion:
Hope this tutorial helps you to play around and understand the basic concepts, syntax examples with google carbon language . While this is not the full list of supported syntax, while we experiment more with features of Carbon, we will cover it as part of the future articles. For any kind of questions or comments drop a note below.

What's next?

- A real world project built on top of supported Carbon language features.
- We will cover Carbon language updates very closely with a free newsletter and detailed articles. If you are interested in learning more about Carbon, drop your email to our Newsletter to stay on top of Carbon and latest improvements.

{% include mailchimp-carbon.html %}

--- 
## Suggested Articles:

[Top 10 most loved programming languages of 2022 and which companies use them](https://tipseason.com/top-10-most-loved-programming-languages-2022/)

[dbt (data build tool) in a real world scenario, Beginner dbt tutorial](https://tipseason.com/dbt-tutorial-real-world-scenario-guide/)

[PostgreSQL Vs MySQL Syntax - A beginners guide to use postgres and mysql with comparison and examples](https://tipseason.com/postgres-vs-mysql-syntax-comparision/)

--- 
## References:
[Carbon language official github](https://github.com/carbon-language/carbon-lang/)

[Carbon language launch at CppNorth Video](https://www.youtube.com/watch?v=omrY53kbVoA)










