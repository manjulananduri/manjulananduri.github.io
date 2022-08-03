---
layout: post
title:  "[Solved] Carbon language not working execvp llvm-ar file not found error"
author: Pramod
categories: [Carbon]
tags: [red, yellow]
image: assets/images/carbon-language-tutorial.png
description: "Carbon language execvp llvm-ar file not found error"
featured: false
hidden: true
suggestions: ['dbt-tutorial-real-world-scenario-guide/']
beforetoc: "Google Carbon language is an open source Programming language that is successor to C++"
toc: true
tableofcontents: true
promote: true
---

Google introduced Carbon language as the next generation programming language with a goal to replace C++ as a successor. It is still in experimental phase and being actively developed by the open source community.

For detailed tutorial with syntax and examples and installation, you can follow this [carbon language examples tutorial](https://tipseason.com/carbon-language-tutorial-syntax/)

When installing Carbon language especially on a MacOS, you might receive llvm-ar no such file or directory error

Due to this error carbon language is not actually working for many people and the fix for this is very simple. 

If the error looks like this 

```
tipseason$ bazel run //explorer -- ./explorer/testdata/print/format_only.carbon

INFO: Invocation ID: 761f1638-be60-4f1a-8b40-46d85ab8a08e
WARNING: Download from https://mirror.bazel.build/ftp.gnu.org/gnu/m4/m4-1.4.18.tar.xz failed: class java.io.FileNotFoundException GET returned 404 Not Found
WARNING: Download from https://mirror.bazel.build/github.com/jmillikin/rules_m4/releases/download/v0.1/m4-gnulib-788db09a9f88abbef73c97e8d7291c40455336d8.tar.xz failed: class java.io.FileNotFoundException GET returned 404 Not Found
WARNING: Download from https://mirror.bazel.build/ftp.gnu.org/gnu/bison/bison-3.3.2.tar.xz failed: class java.io.FileNotFoundException GET returned 404 Not Found
WARNING: Download from https://mirror.bazel.build/github.com/jmillikin/rules_bison/releases/download/v0.1/bison-gnulib-788db09a9f88abbef73c97e8d7291c40455336d8.tar.xz failed: class java.io.FileNotFoundException GET returned 404 Not Found
INFO: Analyzed target //explorer:explorer (0 packages loaded, 0 targets configured).
INFO: Found 1 target...

ERROR: /private/var/tmp/_bazel_tipseason/d1e2eba114061da7a658f0a9641e4b19/external/m4_v1.4.18/BUILD.bazel:2:11: Linking external/m4_v1.4.18/libm4_lib.a [for host] failed: (Exit 1): llvm-ar failed: error executing command /usr/bin/llvm-ar @bazel-out/host/bin/external/m4_v1.4.18/libm4_lib.a-2.params

Use --sandbox_debug to see verbose messages from the sandbox
src/main/tools/process-wrapper-legacy.cc:80: "execvp(/usr/bin/llvm-ar, ...)": No such file or directory
Target //explorer:explorer failed to build
Use --verbose_failures to see the command lines of failed build steps.
INFO: Elapsed time: 2.498s, Critical Path: 2.20s
INFO: 43 processes: 11 internal, 32 darwin-sandbox.
FAILED: Build did NOT complete successfully
FAILED: Build did NOT complete successfully

```

## How to fix llvm-ar error:

The main reason for this error is the conflict installation of LLVM. MacOS by default comes with a default LLVM installed.

But when we do `brew install llvm` it installs the LLVM in the `/usr/local/opt/llvm/` directory. 
In addition you should see the warning message like: 

```
tipseason$ brew install llvm
==> Downloading https://ghcr.io/v2/homebrew/core/llvm/manifests/14.0.6_1
Already downloaded: /Users/tipseason/Library/Caches/Homebrew/downloads/cbaac22cb6f6e244c64563571c7d26a3e3ea4b1471e2bdc333593090506fd348--llvm-14.0.6_1.bottle_manifest.json
==> Downloading https://ghcr.io/v2/homebrew/core/llvm/blobs/sha256:c0a14a92f8b6a1476ed853ad53baa225e561100354f63ed7ee88e664f187d117
Already downloaded: /Users/tipseason/Library/Caches/Homebrew/downloads/6d094cf421785eec188be3e2f10f53012e620d4b19c4ad6d0e9a5992131ac662--llvm--14.0.6_1.monterey.bottle.tar.gz
==> Pouring llvm--14.0.6_1.monterey.bottle.tar.gz
==> Caveats
To use the bundled libc++ please add the following LDFLAGS:
  LDFLAGS="-L/usr/local/opt/llvm/lib -Wl,-rpath,/usr/local/opt/llvm/lib"

llvm is keg-only, which means it was not symlinked into /usr/local,
because macOS already provides this software and installing another version in
parallel can cause all kinds of trouble.

If you need to have llvm first in your PATH, run:
  echo 'export PATH="/usr/local/opt/llvm/bin:$PATH"' >> /Users/tipseason/.bash_profile

For compilers to find llvm you may need to set:
  export LDFLAGS="-L/usr/local/opt/llvm/lib"
  export CPPFLAGS="-I/usr/local/opt/llvm/include"
```

As you can see in the above warning, llvm installed by homebrew doesn't link the paths properly due to conflict with MacOS. 

So when we run `bazel` command, it expects the llvm to be present in `/usr/bin/llvm-ar` path. 
That is the reason in the error message you should see the error like
`"execvp(/usr/bin/llvm-ar, ...)": No such file or directory` . The path is not being resolved properly by bazel. 

### To fix this issue, 

1. Open `~/.bash_profile` file. In that enter the following commands and save the file.
```
export PATH="/usr/local/opt/llvm/bin:$PATH"
export LDFLAGS="-L/usr/local/opt/llvm/lib"
export CPPFLAGS="-I/usr/local/opt/llvm/include"
export CC=$(which clang)
```
2. Once you save the file, run below command to compile above changes. 
```
source ~/.bash_profile
```

`$CC` is the main variable that fixes this issue. 

Now try to rerun the bazel file and you should not see the error ideally. Try it in multiple tabs or wait for sometime and retry. 

This should fix the issue. 

If you are just getting started , check out this detailed Carbon programming syntax guide with examples here. [carbon-language-tutorial-syntax](https://tipseason.com/carbon-language-tutorial-syntax/)

--- 

Carbon language is still in development phase. So installation in some of the platforms like Windows, Linux are having some issues. We will share detailed posts for each of them. Subscribe to our letter to stay tuned. 


## Suggested Articles:

[Top 10 most loved programming languages of 2022 and which companies use them](https://tipseason.com/top-10-most-loved-programming-languages-2022/)

[dbt (data build tool) in a real world scenario, Beginner dbt tutorial](https://tipseason.com/dbt-tutorial-real-world-scenario-guide/)

[PostgreSQL Vs MySQL Syntax - A beginners guide to use postgres and mysql with comparison and examples](https://tipseason.com/postgres-vs-mysql-syntax-comparision/)
