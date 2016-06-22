# r2pipe.clj

`"Know only Clojure and want to work with r2? I got you fam."`

r2pipe.clj is a Clojure library to interact with [radare2](https://github.com/radare/radare2). This requires you to have r2 installed on your system. It spawns a new process and communicates with it over pipes.

## Installation

In Leiningen:

[![Clojars Project](https://img.shields.io/clojars/v/org.clojars.chinmay_dd/r2pipe.svg)](https://clojars.org/org.clojars.chinmay_dd/r2pipe)

## Usage

```clojure
;; Start up the REPL and include r2 pipe lib
user=> (require '[r2pipe.core :refer :all])

;; Load the file into r2
user=> (r2-load "binary")
#'r2pipe.lib/pipe

;; Execute a command in r2
user=> (r2-write "pi 5")
nil

;; Print the output to the console
user=> (r2-print)
xor ebp, ebp
pop esi
mov ecx, esp
and esp, 0xfffffff0
push eax
nil

;; You can also ask for the output in the form of a string for further parsing
user=> (r2-write "pi 5")
nil
user=> (r2-string)
"xor ebp, ebp\npop esi\nmov ecx, esp\nand esp, 0xfffffff0\npush eax\n"
```

### Todo

A lot of things!

## Contributions

This is still a work in progress. If you have anything to add please raise a pull request!

This project is licensed under the MIT license.