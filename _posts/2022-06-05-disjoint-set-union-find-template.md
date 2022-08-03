---
layout: post
title:  "Template for Disjoint set - Union Find - Java"
author: Pramod
categories: [ Interviews ]
image: 
beforetoc: "Template for Disjoint set - Union Find - Java"
featured: false
toc: true
---

#### Disjoint Sets with Arrays. 
 
```java
class DSU {
    int[] parent;
    public DSU() {
        parent = new int[10001];
        for (int i = 0; i <= 10000; ++i)
            parent[i] = i;
    }
    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
    public void union(int x, int y) {
        parent[find(x)] = find(y);
    }
}

``` 

##### Reference: 

https://leetcode.com/problems/accounts-merge/solution/
https://leetcode.com/problems/most-stones-removed-with-same-row-or-column/solution/
