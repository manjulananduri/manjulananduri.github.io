---
layout: post
title: "Golang get map keys - 3 simple ways"
author: Pramod
categories: [Interviews, Golang]
image: assets/images/golang.jpg
beforetoc: "3 simple ways to get the map keys using Golang"
toc: true
promote: true
---

Maps are a data structure powerhouse in Golang, allowing you to store key-value pairs in an efficient and organized manner. But sometimes, you need to unlock those treasures – the keys themselves. So, how do you get your hands on them?

This blog post dives into 3 simple methods to get keys from your maps in Golang, catering to different versions and preferences. Buckle up, and let's unlock the secrets of map keys!

In case you missed it check out other Golang articles here

[3 simple ways to get the first character of a string in Golang](/how-to-get-first-character-in-string-golang/)

[Golang read file line by line - 3 Simple ways](/how-to-read-file-line-by-line-golang/)

[Golang enums implementation with examples](/golang-enums/)

[Golang sets implementation in 2 simple ways](/golang-sets-implementation/)

[Golang for loops: 5 basic ways with examples using range, arrays, maps iteration](/golang-for-loop/)

So, let's dive in and explore the 3 simple ways to get the first character of a string in Golang.

## 1. The Built-in Key Master with maps package (Go 1.18+):

Starting with Go 1.18, the maps package introduces a dedicated key-extraction champion: the Keys function. It's straightforward and elegant:
This one-liner grabs all the keys from your myMap and stores them in a slice named keys. The keys are returned in an unordered list, but that's often all you need. Simple, efficient, and perfect for those who appreciate conciseness.

```
keys := maps.Keys(myMap)
```

This one-liner grabs all the keys from your myMap and stores them in a slice named keys. The keys are returned in an unordered list, but that's often all you need. 
Simple, efficient, and perfect for those who appreciate conciseness.

### Example:

```
package main

import "golang.org/x/exp/maps"

func main() {
  myMap := map[string]int{"apple": 1, "banana": 2, "cherry": 3}
  keys := maps.Keys(myMap) // Main code to get keys

  fmt.Println("Map keys:", keys) // Output: [apple banana cherry]
}
```

### Output: 
```
Map keys: [apple banana cherry]
```

## 2. Range Loop iteration:
Traverse the map using a range loop, extracting and storing the keys in a separate slice:

Main Code:

```
var keys []string
for k := range myMap {
  keys = append(keys, k)
}
```
While it doesn't directly return the keys, it achieves the same goal. This approach might be preferable for beginners due to its familiarity and readability.

### Example:

```
package main

func main() {
  myMap := map[string]int{"apple": 1, "banana": 2, "cherry": 3}
  var keys []string

  for k := range myMap { // Main code to get keys
    keys = append(keys, k)
  }

  fmt.Println("Map keys:", keys) // Output: [apple banana cherry]
}
```

### Output: 
```
Map keys: [cherry apple banana]
```

## 3. Reflection (Golang Versions prior to 1.18):
Before Go `1.18`, the reflect package was the key master for generic key extraction. This approach is slightly more complex but unlocks some hidden potential:

```
valueOfMap := reflect.ValueOf(myMap)
mapKeys := valueOfMap.MapKeys()

var keys []string
for _, key := range mapKeys {
  keys = append(keys, key.Interface().(string))
}
```
Here, we use reflection to access the map's internal structure and obtain its keys. This method works for maps with any value type, not just strings. However, it comes with slightly higher complexity and less readability compared to the previous methods.


### Example:

```
package main

import "reflect"

func main() {
  myMap := map[string]int{"apple": 1, "banana": 2, "cherry": 3}
  valueOfMap := reflect.ValueOf(myMap) // Main code using reflection
  mapKeys := valueOfMap.MapKeys()

  var keys []string
  for _, key := range mapKeys {
    keys = append(keys, key.Interface().(string))
  }

  fmt.Println("Map keys:", keys) // Output: [apple banana cherry]
}
```

### Output: 
```
Map keys: [apple banana cherry]
```

Choosing the right method:

Now that you have met the three key-extraction methods, which one should you choose? Here's a quick guide:

* Go 1.18+: Embrace the maps.Keys function for its simplicity and efficiency.
* Pre-Go 1.8: Reach for the range loop for clear and familiar key extraction.
* Generic Key Extraction: Utilize the reflection magic for maps with any value type.

Choose the one that resonates with your Golang version, coding style, and specific needs.

### Conclusion
We have explored three simple ways to get the keys from a map using Golang. 

Each method has its advantages and disadvantages, and the best method to use will depend on the specific requirements of
your programming scenario.

We hope this article has been informative and helpful in your Golang programming endeavors. If you enjoyed this article
and want to learn more about Golang or programming in general, be sure to subscribe to our blog for more great content
like this. Thank you for reading!
