---
layout: post
title:  "Golang for loops: 5 basic ways with examples using range, arrays, maps iteration"
author: Pramod
categories: [Interviews, Golang]
image: assets/images/golang.jpg
beforetoc: "5 basic ways to use Golang for loops that includes syntax, examples with various datastructures like arrays, maps iteration"
toc: true
promote: true
---

Loops are an essential part of any programming language. They allow us to execute a single task multiple times. In this post, we will be diving deeper with the for loops in Go.
The for loop is one of the most common loops in programming. 

There are multiple variations for using Golang for-loops. In this tutorial we will discuss 5 unique ways to use for-loops. 
We will also discuss various ways to iterate arrays, maps using range keyword with for loop combination. 

In case you missed it check out other Golang articles here

[3 simple ways to get the first character of a string in Golang](/how-to-get-first-character-in-string-golang/)

[Golang read file line by line - 3 Simple ways](/how-to-read-file-line-by-line-golang/)

[Golang enums implementation with examples](/golang-enums/)

[Golang sets implementation in 2 simple ways](/golang-sets-implementation/)

Let's dive in.

## Golang for loop Syntax
The for loop in Go works just like other languages. The loop starts with the keyword `for`.
Then it initializes the looping variable, checks for condition, and then does the postcondition.
Below is the syntax of for-loop in Golang:

```go
for initialization; condition; postcondition {
    // code to be executed
}
```

Now, let's see how to declare and use a for loop. Here is an example showing the for-loop in action:

## 1. Basic for-loop example

```go
package main

import (
	"fmt"
)

func main() {
	for i := 0; i < 3; i++ {
		fmt.Printf("TipSeason %d \n", i)
	}
}
```

Output of above code: 
```
TipSeason 0 
TipSeason 1 
TipSeason 2
```


In the code above, the variable `i` is initialized and then matched with the condition. After that, there is a postcondition which is to increment by 1. Now, the postcondition can be anything. 
The incrementation is a stepping mechanism which takes the loop forward.

## 2. Infinite for loop in Golang
We can create an infinite for-loop by simply removing the conditional clauses. Here is an example of an infinite for-construct:
```go
for {
    // code to be executed
}
```

To stop the infinite execution after certain conditions match, Go has a keyword called `break`, which can be used to break out of the loop.

## 3. Simple For loop with limit 
We can also create another kind of for-loop which is the conditional for-loop by simply excluding the initialization and postcondition. It only checks the condition and runs if it matches. An example would be as follows:

```go
package main

import (
    "fmt"
)

func main() {
    i := 0
    for i<5 {
        fmt.Println(i)
        i += 2
    }
}
```

## 4. Golang for loop range iteration
Sometimes we need to iterate over a slice or array of items. In that case, using the range function along with for is the way to go. It makes the code much simpler. Here is an example showing the range-for loop in action:

```go
package main

import (
    "fmt"
)

func main() {
    var items []int = []int{1, 2, 3, 4, 5}
    for i, v := range items {
        fmt.Println(i, v)
    }
}
```

The range-for gives two things to work with: one is the current index and the other is the current value. If the current value is the only thing needed then we can ignore the index using the blank identifier.

```go
package main

import (
    "fmt"
)

func main() {
    var items []int = []int{1, 2, 3, 4, 5}
    for _, v := range items {
        fmt.Println(v)
    }
}
```

Range-for can also be used with maps as well. Which will provide us with both key and value at the same time. With the key being the index.


## 5. Golang iterate Map with range for loop 

In Go, we can iterate over a map using the `for` loop and the `range` keyword. The `range` keyword returns both the key and value of each element in the map. Here is an example of how to iterate over a map:

```go
package main

import "fmt"

func main() {
    m := map[string]int{"one": 1, "two": 2, "three": 3}

    for key, value := range m {
        fmt.Println(key, value)
    }
}
```

The output of the above code will be:

```
one 1
two 2
three 3
```

We can also iterate over only the keys or values of a map by using the blank identifier `_`. Here is an example of how to iterate over only the keys of a map:

```go
package main

import "fmt"

func main() {
    m := map[string]int{"one": 1, "two": 2, "three": 3}

    for key := range m {
        fmt.Println(key)
    }
}
```

The output of the above code will be:

```
one
two
three
```

## Conclusion

Golang for loops are a powerful tool that can be used to automate repetitive tasks and write more efficient and maintainable code. In this article, we have learned about the five basic ways to use Golang for loops, and we have seen some examples of how to use them to solve real-world problems.
If you want to learn more about Golang for loops, or if you want to stay up-to-date on the latest Golang news and tutorials, subscribe to our newsletter today!
Thank you for reading!
