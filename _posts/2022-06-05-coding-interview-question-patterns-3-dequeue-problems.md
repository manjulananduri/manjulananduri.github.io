---
layout: post
title:  "Coding Interview Questions - Pattern 3 - Dequeue Problems"
author: Pramod
categories: [ Interviews ]
image: assets/images/dequeue.png
beforetoc: "DEQueue as it stands for double-ended queue (pronouned as 'deck') is one of the hidden data structures that helps solving bunch of coding interview questions. "
toc: true
---

Dequeue is a data structure similar to queue with one modification. Normal queue allows us to enqueue elements at the tail of the queue and deque elements
from the head of the queue. But in case of a Dequeue, we can perform enqueue or dequeue from both head or tail. All the operations are similar 
to queue but just that it allows them on both ends of the queue. 

Top interview problems that can be solved with this pattern include: 

<a target="_blank" href="https://leetcode.com/problems/sliding-window-maximum/">Sliding Window Maximum</a> <br> 
<a target="_blank" href="https://leetcode.com/problems/largest-rectangle-in-histogram/">Largest rectangle in a histogram</a>

### Different Ways to declare Deque in java. 
```java
Deque deque = new LinkedList();

Deque deque = new ArrayDeque();

ArrayDeque<Integer> queue = new ArrayDeque<>();
```

### Dequeue methods ( cheatsheet ) quick reference: 
  
```java
add(Element e) : The method inserts particular element at the end of the deque.
addFirst(Element e) : The method inserts particular element at the start of the deque.
addLast(Element e) : The method inserts particular element at the end of the deque. It is similiar to add() method
clear() : The method removes all deque elements.
size() : The method returns the no. of elements in deque.
contains(Obj) : The method checks whether a deque contains the element or not
Iterator() : The method returns an iterator over the deque.
descendingIterator() : The method returns a reverse order iterator over the deque
element() : The method returns element at the head of the deque
getFirst(): The method returns first element of the deque
getLast(): The method returns last element of the deque
isEmpty(): The method checks whether the deque is empty or not.
toArray(): The method returns array having the elements of deque.
offer(Element e) : The method inserts element at the end of deque.
offerFirst(Element e) : The method inserts element at the front of deque.
offerLast(Element e) : The method inserts element at the end of deque.
peek() : The method returns head element without removing it.
peekFirst() : The method returns first element without removing it.
peekLast() : The method returns last element without removing it.
poll() : The method returns head element and also removes it
pollFirst() : The method returns first element and also removes it
pollLast() : The method returns last element and also removes it
pop() : The method pops out an element for stack repesented by deque
push(Element e) : The method pushes an element onto stack repesented by deque
remove() : The method returns head element and also removes it
removeFirst() : The method returns first element and also removes it
removeLast() : The method returns last element and also removes it
removeFirstOccurrence(Obj) : The method removes the element where it first occur in the deque.
removeLastOccurrence(Obj) : The method removes the element where it last occur in the deque.
```