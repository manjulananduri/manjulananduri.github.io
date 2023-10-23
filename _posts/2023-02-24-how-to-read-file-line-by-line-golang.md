---
layout: post
title:  "Golang read file line by line - 3 Simple ways"
author: Pramod
categories: [Interviews, Golang]
image: assets/images/golang.jpg
beforetoc: "3 simple ways to read file line by line in Golang"
toc: true
promote: true
---

Welcome back to our Golang tutorial series! 

In our previous post, we covered about

[3 simple ways to get the first character of a string in Golang](/how-to-get-first-character-in-string-golang/)

[Golang for loops: 5 basic ways with examples using range, arrays, maps iteration](/2023-10-22-golang-for-loop/)

In this post, we'll be discussing another important topic - how to read a file line by line in Golang. Reading a file
line by line is a common task in programming, and Golang provides several ways to accomplish this. We'll be exploring 3
simple methods using the "bufio", "ioutil", and "os" packages. 

Let's dive in!

## 1: Using ioutil ReadFile

Here's an example code snippet that demonstrates how to read a file line by line using the "ioutil" package:

The second method uses the "ioutil" package to read a file line by line. This method reads the entire contents of a file
into memory using the "ioutil.ReadFile" function. The contents of the file are returned as a byte slice, which can be
converted to a string using the "string" function. The string can then be split into lines using the "strings.Split"
function with the "\n" delimiter. This method is simple and straightforward, but it may not be suitable for large files
that cannot be read entirely into memory.

```
package main

import (
    "fmt"
    "io/ioutil"
    "log"
    "strings"
)

func main() {
    data, err := ioutil.ReadFile("example.txt")
    if err != nil {
        log.Fatal(err)
    }

    lines := strings.Split(string(data), "\n")
    for _, line := range lines {
        fmt.Println(line)
    }
}

```

In this example, we first read the entire file "example.txt" into memory using the "ioutil.ReadFile" function. We then
split the byte slice into lines using the "strings.Split" function with the "\n" delimiter and print each line using
the "fmt.Println" function.


## 2: Using bufio Scanner

The first method uses the "bufio" package to read a file line by line. This method creates a new scanner using the "
bufio.NewScanner" function, which takes a file as an argument. The scanner provides a convenient way to read the
contents of a file line by line using the "scanner.Scan" method. This method returns a boolean value indicating whether
a line was successfully scanned or not, and the line itself can be obtained using the "scanner.Text" method. If an error
occurs during scanning, the "scanner.Err" method can be used to retrieve it.

Here's an example code snippet that demonstrates how to read a file line by line using the "bufio" package:

```
package main

import (
    "bufio"
    "fmt"
    "log"
    "os"
)

func main() {
    file, err := os.Open("example.txt")
    if err != nil {
        log.Fatal(err)
    }
    defer file.Close()

    scanner := bufio.NewScanner(file)
    for scanner.Scan() {
        line := scanner.Text()
        fmt.Println(line)
    }

    if err := scanner.Err(); err != nil {
        log.Fatal(err)
    }
}

```

In this example, we first open the file "example.txt" using the "os.Open" function and create a new scanner using the "
bufio.NewScanner" function. We then use a for loop to read each line of the file using the "scanner.Scan" method and
print it using the "fmt.Println" function. Finally, we check for any errors using the "scanner.Err" method.


## 3: Using os Open and bufio NewReader

The third method uses the "os" and "bufio" packages to read a file line by line. This method opens the file using the 
"os.Open" function and creates a new buffered reader using the "bufio.NewReader" function. The reader provides a
convenient way to read the contents of a file line by line using the "reader.ReadString" method. This method reads a
string up to the specified delimiter, which in this case is the newline character '\n'. If an error occurs during
reading, the loop can be exited. This method is also simple and straightforward, and it is suitable for reading large
files since it reads the file contents in chunks rather than reading the entire file into memory.

Here's an example code snippet that demonstrates how to read a file line by line using the "os" and "bufio" packages:
```
package main

import (
    "bufio"
    "fmt"
    "log"
    "os"
)

func main() {
    file, err := os.Open("example.txt")
    if err != nil {
        log.Fatal(err)
    }
    defer file.Close()

    reader := bufio.NewReader(file)
    for {
        line, err := reader.ReadString('\n')
        if err != nil {
            break
        }
        fmt.Print(line)
    }
}

```

In this example, we first open the file "example.txt" using the "os.Open" function and create a new buffered reader
using the "bufio.NewReader" function. We then use a for loop to read each line of the file using the "reader.ReadString"
method and print it using the "fmt.Print" function. Finally, we check for any errors and break out of the loop if the
end of the file is reached.

### Conclusion

In conclusion, reading a file line by line is an essential task in Golang programming, and there are several ways to
accomplish this. In this post, we discussed 3 simple methods using the "bufio", "ioutil", and "os" packages. Depending
on the specific requirements of your project, one method may be more suitable than the others.

We hope you found this post informative and useful. If you'd like to receive more Golang tutorials and tips like this
one, be sure to subscribe to our blog. Thanks for reading!

