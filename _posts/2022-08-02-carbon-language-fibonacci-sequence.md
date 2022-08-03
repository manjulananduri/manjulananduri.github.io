Carbon language beginner series:

Google introduced [Carbon programming language](https://tipseason.com/carbon-language-tutorial-syntax/) recently.

One of the challenges many beginner users are facing is to run basic examples since the language is in a very early stage without even having a compiler. So here is a working example to print fibonacci series using Carbon language.


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

fn fibSeries(count: i32) {
    var i: i32 = count;
    while(not (i == 0)) {
        Print("{0}", fib(i));
        i = i - 1;
    }

}

fn Main() -> i32 {
    Print("Fib result: {0}", fib(6));
    fibSeries(10);
    return Square(12);
}
```

Understanding the code:

```
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

We use a recursive code to calculate nth fibonacci number .
`fib(n) = fib(n-1) + fib(n-2)`

To print the sequence, since `for` loops doesn't work in carbon yet, we will use `while` loop.
```
fn fibSeries(count: i32) {
    var i: i32 = count;
    while(not (i == 0)) {
        Print("{0}", fib(i));
        i = i - 1;
    }

}
```

Additional Reading:

[Carbon language memory management](https://tipseason.com/carbon-language-memory-safety/)

This is a part of carbon language series for beginners. Feel free to ask any questions regarding Carbon. 