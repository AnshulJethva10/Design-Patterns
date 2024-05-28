# Design Patterns in Java
Welcome to the Design Patterns repository. This repository contains examples of various design patterns implemented in Java. This document explains the Abstract Factory Design Pattern using the provided code.

## Table of Contents
1. Abstract Factory
2. Adaptor
3. Builder
4. Composite
5. Decorator
6. Facade
7. Factory
8. Flyweight
9. Iterator
10. MVC
11. Memento
12. Observer
13. Prototype
14. Singleton
15. State

## Abstract Factory Design Pattern
### Description 
The Abstract Factory pattern provides an interface for creating families of related or dependent objects without specifying their concrete classes. This pattern is particularly useful when you need to create objects that share a common theme or family.

### Problem
In some scenarios, you need to create a set of related objects. For instance, a career counseling application may need to suggest different educational paths based on user input, such as recommending different colleges for B.Tech and M.Tech degrees in various branches of study. The challenge is to ensure that the application can handle different educational paths without changing existing code whenever a new path is added.

### Solution
1. Declare Interfaces for Products:
    - Define an interface for the type of product you want to create. In this case, `Career` is the product interface.
```
interface Career {
    void degree();
}
```
