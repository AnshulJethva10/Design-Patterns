# Design Patterns in Java
Welcome to the Design Patterns repository. This repository contains implementations of various design patterns in Java. Each pattern is implemented with clarity to help beginners understand the concepts easily. Below is a list of the design patterns included in this repository along with their descriptions and usage.
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

2. Concrete Product Classes: 
    - Implement the product interface in concrete classes that represent specific products. Here, we have various classes implementing the Career interface, such as CS_Btech, Mec_Btech, CS_Mtech, etc.
```
class CS_Btech implements Career {
    public void degree() {
        System.out.println("For B.Tech in Computer Science these colleges are good: ");
        System.out.println("IITs\nNITs\nIIITs");
    }
}

class Mec_Btech implements Career {
    public void degree() {
        System.out.println("For B.Tech in Mechanical these colleges are good: ");
        System.out.println("BITS\nMIT\nVIT");
    }
}

// Similarly, other classes are defined
```

3. Abstract Factory Interface:
    - Define an abstract class or interface that declares creation methods for each type of product. Here, Factory is the abstract class with a method FactoryPass.
```
abstract class Factory {
    abstract void FactoryPass(int x);
}
```

4. Concrete Factories:
    - Implement the abstract factory class in concrete factory classes that create specific products. Here, Btech_Factory and Mtech_Factory are concrete factory classes.
```
class Btech_Factory extends Factory {
    void FactoryPass(int x) {
        if (x == 1) {
            Career c = new CS_Btech();
            c.degree();
        } else if (x == 2) {
            Career c = new Mec_Btech();
            c.degree();
        } // similarly for other branches
    }
}

class Mtech_Factory extends Factory {
    void FactoryPass(int x) {
        if (x == 1) {
            Career c = new CS_Mtech();
            c.degree();
        } else if (x == 2) {
            Career c = new Mec_Mtech();
            c.degree();
        } // similarly for other branches
    }
}
```

5. Factory Producer:
    - Implement a factory producer that returns an instance of the appropriate factory based on the given input.
```
class FactoryProducer {
    public static Factory getFactory(int x) {
        if (x == 1) {
            return new Btech_Factory();
        } else if (x == 2) {
            return new Mtech_Factory();
        } else {
            return null;
        }
    }
}
```

6. Client Code
    - The client code demonstrates how to use the Abstract Factory pattern. It prompts the user to choose their educational path and branch, then uses the factories to suggest relevant colleges or fields of study.
```
public class Client {
    public static void main(String[] args) {
        System.out.println("Hello! Welcome to Career Counseling Center.");
        System.out.println("What do you want to do? : ");
        System.out.println("1.B.Tech\n2.M.Tech");

        Scanner sc = new Scanner(System.in);
        int y = sc.nextInt();

        System.out.println("Which branch do you want to pursue: ");
        System.out.println("1.Computer Science\n2.Mechanical\n3.Civil\n4.Electrical");
        int x = sc.nextInt();

        Factory f = FactoryProducer.getFactory(y);
        f.FactoryPass(x);

        sc.close();
    }
}
```

### Summary
The Abstract Factory pattern helps create families of related objects without specifying their concrete classes. In this example, the pattern is used to create different career paths for B.Tech and M.Tech students in various branches. By using abstract factories and concrete products, the code remains flexible and easy to extend with new educational paths without modifying existing code.

Link to the Complete Code
