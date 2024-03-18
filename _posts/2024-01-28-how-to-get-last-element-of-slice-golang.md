---
layout: post
title: "Golang get last element of slice / array / list - Simple and fast"
author: Pramod
categories: [Interviews, Golang]
image: assets/images/golang.jpg
beforetoc: "Simple ways to get the last element of a slice or an array or list"
toc: true
promote: true
---

When working with production code in Golang, efficiently accessing the last element of a slice or an array or a list is a common requirement. 
In this blog post, we'll explore simple and fast ways to achieve this task, ensuring both readability and performance in your Golang code.

In case you missed it check out other Golang articles here

[3 simple ways to get the first character of a string in Golang](/how-to-get-first-character-in-string-golang/)

[Golang read file line by line - 3 Simple ways](/how-to-read-file-line-by-line-golang/)

[Golang enums implementation with examples](/golang-enums/)

[Golang sets implementation in 2 simple ways](/golang-sets-implementation/)

[Golang get map keys - 3 Simple ways](/how-to-get-keys-in-map-golang/)

[Golang for loops: 5 basic ways with examples using range, arrays, maps iteration](/golang-for-loop/)

So, let's dive in and explore the 3 simple ways to get the first character of a string in Golang.

## 1. Get last element in a slice or array in golang: 
One straightforward approach to obtaining the last element of a Golang slice is by using indexing. In Go, slices are zero-indexed, and you can leverage this property to access the last element conveniently.
```
lastElement := mySlice[len(mySlice)-1]
```

### Example: 

```
package main

import "fmt"

func main() {
    mySlice := []int{1, 2, 3, 4, 5}
    
    lastElement := mySlice[len(mySlice)-1]
    
    fmt.Println("Last Element:", lastElement)
}
```

### Output: 
```
Last Element: 5
```

## 2. Get last element in a list using Go: 
The `Back()` method is used to access the last element of a list in Golang.
It returns a pointer to the last element, which you can then use to access the Value field and type-assert it to the appropriate type.
Remember that this method is only available in Go 1.18+.

```
list.Back().Value
```

### Example: 

```
package main

import (
    "container/list"
    "fmt"
)

func main() {
    // Sample slice of integers
    numbers := []int{1, 2, 3, 4, 5}

    // Convert slice to list
    tempList := list.New()
    for _, num := range numbers {
        tempList.PushBack(num)
    }

    // Get the last element using the Back() method
    lastElement := tempList.Back().Value.(int) // Note: Using Back() method

    // Print the last element
    fmt.Println("Last element:", lastElement) // Output: 5
}

```

### Output: 
```
Last element: 5
```


### Conclusion
We have explored easy ways to get the last elemtn in a list or a slice in Go. 

We hope this article has been informative and helpful in your Golang programming endeavors. If you enjoyed this article
and want to learn more about Golang or programming in general, be sure to subscribe to our blog for more great content
like this. Thank you for reading!
