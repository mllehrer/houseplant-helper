# Houseplant-helper
## A companion project to *The Beginner's Guide to Programming (in Clojure!)*

Got a lot of houseplants? Generate a watering schedule--in Clojure!
By the end of writing this program, you will be able to:
- Set up Clojure project with dependencies
- Call an API
- Turn api data into something useful
- Output a file onto your machine

## Commands:
- clj -m --help ;; lists commands
- clj -m --houseplants ;; lists houseplants the program knows about
- clj -m --schedule [array of houseplants] ;; produces your houseplant watering schedule

## Further reading:
(How tools.deps works)[https://clojure.org/reference/deps_and_cli]
(The little API this project is calling)[]

## Contents
Every Clojure project has the following:
1. (src directory)[]: contains all the "business logic*" namespaces
2. (test directory)[]: contains one test for each namespace
3. (dependencies file)[]: we are using tools.deps. There is another dependency manager called leiningen that uses a file called project.clj instead of deps.clj. You can read more about it in the dependencies section of the *Beginner's Guide*.

This project has four namespaces:
1. `client`: communicates with the api to retrieve data
2. `scheduler`: uses the data retrieved by `client` to build your houseplant schedule
3. `printer`: formats your houseplant schedule and prints it to a file on your computer
4. `main`: listens to command line arguments and runs the program based on the arguments it receives. Most Clojure programs have a `main` namespace.

To understand why the project is organized this way, please refer to the `Separation of concerns` section in the *Beginner's Guide*

This project also has a seed data file to use for tests and can be run in the REPL in case there is no API available. See the `REPL` section in the *Beginner's Guide*.
