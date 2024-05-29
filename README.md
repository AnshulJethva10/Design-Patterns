# Design Patterns in Java
Welcome to the Design Patterns repository. This repository contains implementations of various design patterns in Java. Each pattern is implemented with clarity to help beginners understand the concepts easily. Below is a list of the design patterns included in this repository along with their descriptions and usage.
1. [Abstract Factory](https://github.com/AnshulJethva10/Design-Patterns/blob/main/README.md#abstract-factory) 
2. [Adaptor](https://github.com/AnshulJethva10/Design-Patterns/blob/main/README.md#adapter)
3. [Builder](https://github.com/AnshulJethva10/Design-Patterns/blob/main/README.md#builder)
4. Composite
5. [Decorator](https://github.com/AnshulJethva10/Design-Patterns/blob/main/README.md#decorator)
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


# Abstract Factory
## Description 
The Abstract Factory pattern provides an interface for creating families of related or dependent objects without specifying their concrete classes. This pattern is particularly useful when you need to create objects that share a common theme or family.

## Problem
In some scenarios, you need to create a set of related objects. For instance, a career counseling application may need to suggest different educational paths based on user input, such as recommending different colleges for B.Tech and M.Tech degrees in various branches of study. The challenge is to ensure that the application can handle different educational paths without changing existing code whenever a new path is added.

## Solution
1. Declare Interfaces for Products:

- Define an interface for the type of product you want to create. In this case, `Career` is the product interface.
```
interface Career {
    void degree();
}
```

2. Concrete Product Classes: 
    - Implement the product interface in concrete classes that represent specific products. Here, we have various classes implementing the `Career` interface, such as `CS_Btech`, `Mec_Btech`, `CS_Mtech`, etc.
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
    - Define an abstract class or interface that declares creation methods for each type of product. Here, `Factory` is the abstract class with a method `FactoryPass`.
```
abstract class Factory {
    abstract void FactoryPass(int x);
}
```

4. Concrete Factories:
    - Implement the abstract factory class in concrete factory classes that create specific products. Here, `Btech_Factory` and `Mtech_Factory` are concrete factory classes.
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

## UML Diagram
![Abstract-Factory UML](https://lh3.googleusercontent.com/u/0/drive-viewer/AKGpihbAgueAFphwQkmMKhi0WpKrVJ3e66ql2RgNecuAQyRay2V8O3xLIm7boVzSuhh2PRCiZefTnEPmjZNjIfoT74qCwmD88vNOOxg=w1920-h919-rw-v1)

## Summary
The Abstract Factory pattern helps create families of related objects without specifying their concrete classes. In this example, the pattern is used to create different career paths for B.Tech and M.Tech students in various branches. By using abstract factories and concrete products, the code remains flexible and easy to extend with new educational paths without modifying existing code.

[Link to the Complete Code](https://github.com/AnshulJethva10/Design-Patterns/blob/main/AbstractFactory.java)


# Adapter
### Description
The Adapter pattern allows incompatible interfaces to work together. It acts as a bridge between two incompatible interfaces by converting the interface of a class into another interface that a client expects.

## Problem
Sometimes, there are classes with incompatible interfaces, and you want to use these classes together. The Adapter Design Pattern allows you to create an intermediary that adapts the interface of one class to be compatible with another.

## Solution
1. Define the Target Interface:
    - This is the interface that the client expects to work with. In this example, `PaymentGateway` is the target interface.
```
interface PaymentGateway {
    public void pay();
}
```

2. Implement Concrete Classes:
    - These classes implement the target interface. Here, `Paytm` and `GPay` are concrete implementations of the `PaymentGateway` interface.
```
class Paytm implements PaymentGateway {
    public void pay() {
        System.out.println("Current Payment Gateway is PayTM");
    }
}

class GPay implements PaymentGateway {
    public void pay() {
        System.out.println("Current Payment Gateway is GPay");
    }
}
```
3. Create the Adapter Class:
    - The adapter class implements the target interface and holds an instance of the class it adapts. Here, `PaymentGatewayAdapter` adapts the `Paytm` class to the `PaymentGateway` interface.
```
class PaymentGatewayAdapter implements PaymentGateway {
    private Paytm paytm;

    public PaymentGatewayAdapter(Paytm paytm) {
        this.paytm = paytm;
    }

    @Override
    public void pay() {
        paytm.pay();
        System.out.println("Changing the Payment Gateway from PayTM to GPay...");
        // Additional logic to adapt Paytm to GPay could go here
    }
}
```

4. Client Code:
    - The client code demonstrates how to use the adapter pattern to switch between payment gateways. It allows the user to choose between `Paytm` and `GPay`. If `GPay` is chosen, the adapter is used to adapt the `Paytm` interface to the `GPay` interface.
```
public class Client {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Paytm paytm = new Paytm();
        System.out.println("Select A Payment Gateway: ");
        System.out.println("a) PayTM \nb) GPay");
        String choice = sc.nextLine();

        PaymentGateway paymentGateway;
        if (choice.equals("a")) {
            paymentGateway = paytm;
        } else if (choice.equals("b")) {
            paymentGateway = new PaymentGatewayAdapter(paytm);
        } else {
            System.out.println("Invalid choice");
            sc.close();
            return;
        }

        paymentGateway.pay();
        sc.close();
    }
}
```
## UML Diagram
![Abstract-Factory UML](https://lh3.googleusercontent.com/u/0/drive-viewer/AKGpihag2wuDNMOTOwGJws5wy09X8JHmYX6zyDASserHU4AsqU5bo0QuxOcfeSMOscE5ebvBSsZflPE4fhR9A3F_cYyZKCfpqNtH57E=w1920-h919-rw-v1)

## Summary
The Adapter Design Pattern is a structural pattern that enables classes with incompatible interfaces to work together. In this example, we demonstrated how to use an adapter to switch between different payment gateways (`Paytm` and `GPay`). The adapter allows `Paytm` to be used where a `GPay` interface is expected, illustrating how the pattern helps integrate different interfaces seamlessly.

[Link to the Complete Code](https://github.com/AnshulJethva10/Design-Patterns/blob/main/Adapter.java)


# Builder
## Description
The Builder Design Pattern is used to construct complex objects step by step. It allows the creation of different representations of an object using the same construction process. This pattern is useful when the creation process of an object is complex and requires several steps.

## Problem
In scenarios where an object needs to be constructed through a series of steps, the Builder Design Pattern helps in separating the construction logic from the representation of the object. This separation allows the same construction process to create different representations of the object.

## Solution
1. Define the Product:
    - The product is the complex object that needs to be constructed. Here, `kit` represents the IoT kit with various components.

```
class kit {
    ArrayList<Device> items = new ArrayList<Device>();

    void addDevice(Device itm) {
        items.add(itm);
    }

    float getCost() {
        int cost = 0;
        for (Device itm : items) {
            cost += itm.price();
        }
        return cost;
    }

    void showDevices() {
        for (Device itm : items) {
            System.out.println(itm.name());
        }
    }
}
```

2. Define the Builder Interface:
    - The builder interface specifies methods for creating the parts of the product. In this example, `IoT_Kit_Builder` provides methods to build different types of kits.

```
class IoT_Kit_Builder {
    public kit NodeMCU_Kit_Builder() {
        // Implementation for building NodeMCU kit
    }

    public kit Ardunio_Kit_Builder() {
        // Implementation for building Arduino kit
    }
}
```

3. Concrete Builder Classes:
    - Concrete builder classes implement the builder interface and provide specific implementations for building parts of the product. Here, the methods `NodeMCU_Kit_Builder` and `Ardunio_Kit_Builder` build IoT kits with different components.

```
public kit NodeMCU_Kit_Builder() {
    kit k = new kit();
    // Logic to add components to the NodeMCU kit
    return k;
}

public kit Ardunio_Kit_Builder() {
    kit k = new kit();
    // Logic to add components to the Arduino kit
    return k;
}
```

4. Director:
    - The director is responsible for managing the correct sequence of building steps. In this example, `Customer` class acts as the director, orchestrating the construction process.

```public class Customer {
    public static void main(String[] args) {
        System.out.println("Hello! Welcome to the IoT Kit Builder");
        System.out.println("Which type of kit do you want to build? :");
        System.out.println("a) Arduino Kit\nb) NodeMCU Kit");
        Scanner sc = new Scanner(System.in);
        String x = sc.next();
        IoT_Kit_Builder iot = new IoT_Kit_Builder();
        if (x.equals("a")) {
            iot.Ardunio_Kit_Builder();
        } else if (x.equals("b")) {
            iot.NodeMCU_Kit_Builder();
        }
        sc.close();
    }
}
```

## Explanation of the Code

1. Product and Components:
    - The `kit` class represents the IoT kit that contains various devices (`Device`). These devices can be sensors, modules, wires, and other components like LEDs, breadboards, buttons, and resistors.

```
abstract class sensors implements Device { /* ... */ }
class temp_sensor extends sensors { /* ... */ }
class ir_sensor extends sensors { /* ... */ }
class laser_sensor extends sensors { /* ... */ }

abstract class Modules implements Device { /* ... */ }
class Uno extends Modules { /* ... */ }
class Nano extends Modules { /* ... */ }
class esp32 extends Modules { /* ... */ }
class esp8266 extends Modules { /* ... */ }

abstract class Wire implements Device { /* ... */ }
class m2m extends Wire { /* ... */ }
class f2m extends Wire { /* ... */ }
class f2f extends Wire { /* ... */ }

abstract class Other implements Device { /* ... */ }
class led extends Other { /* ... */ }
class bb extends Other { /* ... */ }
class btn extends Other { /* ... */ }
class resistor extends Other { /* ... */ }
```

2. Builder Implementation:
    - The `IoT_Kit_Builder` class contains methods for building different types of IoT kits. It asks the user to select components and adds them to the kit.

```
class IoT_Kit_Builder {
    public kit NodeMCU_Kit_Builder() {
        kit k = new kit();
        // Logic for NodeMCU kit
        return k;
    }

    public kit Ardunio_Kit_Builder() {
        kit k = new kit();
        // Logic for Arduino kit
        return k;
    }
}
```

3. Director:
    - The `Customer` class acts as the director, managing the construction process based on user input.

```public class Customer {
    public static void main(String[] args) {
        System.out.println("Hello! Welcome to the IoT Kit Builder");
        System.out.println("Which type of kit do you want to build? :");
        System.out.println("a) Arduino Kit\nb) NodeMCU Kit");
        Scanner sc = new Scanner(System.in);
        String x = sc.next();
        IoT_Kit_Builder iot = new IoT_Kit_Builder();
        if (x.equals("a")) {
            iot.Ardunio_Kit_Builder();
        } else if (x.equals("b")) {
            iot.NodeMCU_Kit_Builder();
        }
        sc.close();
    }
}
```

## UML Diagram
![Builder UML](https://lh3.googleusercontent.com/u/0/drive-viewer/AKGpihaBCZM6uMJ5kB6P2cEk7ylDVJ_rIOkK1ciYguVqXu8jJwpVGiURfV6vD6Q9ZZDka73Qf8FV-FaFIkAOg_toIgXADrGpo7dSxg=w1920-h919-rw-v1)

## Summary
The Builder Design Pattern is a creational pattern that helps in constructing complex objects step by step. In this example, we demonstrated how to use the builder pattern to create customized IoT kits with different components. The pattern ensures that the construction process is flexible and allows for different representations of the object.

[Link to the Complete Code](https://github.com/AnshulJethva10/Design-Patterns/blob/main/Builder.java)

# Decorator
## Description
The Decorator Design Pattern is used to extend the functionalities of objects in a flexible and reusable way. It allows behavior to be added to individual objects, either statically or dynamically, without affecting the behavior of other objects from the same class.

## Problem
Sometimes, we need to add functionalities to objects without altering their structure. The Decorator Design Pattern provides a way to attach additional responsibilities to an object dynamically. This pattern creates a decorator class which wraps the original class and provides additional functionality while keeping the class methods' signature intact.

## Solution
1. Define the Component Interface:
    - The component interface defines the interface for objects that can have responsibilities added to them dynamically.

```
interface Toy {
    public void material();
    public void cost();
}
```

2. Concrete Component Classes:
    - These classes implement the Toy interface and represent objects to which additional functionalities can be added.

```
class Truck implements Toy {
    int wheels, door, carriage_capacity;
    String model;

    public Truck(int wheels, int door, String model, int carriage_capacity) {
        this.wheels = wheels;
        this.door = door;
        this.model = model;
        this.carriage_capacity = carriage_capacity;
    }

    public void material() {
        System.out.println("\nThis Truck is made out of wood");
    }

    public void cost() {
        System.out.println("Price : 750/-");
    }

    public void capacity() {
        System.out.println("This truck has " + carriage_capacity + " Liter carriage capacity");
    }
}

class Car implements Toy {
    int wheels, door;
    String model;

    public Car(int wheels, int door, String model) {
        this.wheels = wheels;
        this.door = door;
        this.model = model;
    }

    public void material() {
        System.out.println("\nThis Car is made out of Plastic");
    }

    public void cost() {
        System.out.println("Price : 350/-");
    }
}
```

3. Decorator Interface:
    - The decorator interface extends the Toy interface and provides a method for decoration.

```
interface ToyDecorator {
    public void decoration();
}
```

4. Concrete Decorator Classes:
    - These classes implement the Toy and ToyDecorator interfaces and add additional functionalities to the toy objects.

```
class TruckDecorator implements Toy, ToyDecorator {
    Truck toy;
    String color;

    public TruckDecorator(Truck toy, String color) {
        this.toy = toy;
        this.color = color;
    }

    public void material() {
        System.out.println("\nThis Truck is made out of Wood");
    }

    public void cost() {
        System.out.println("Price : 850/-");
    }

    public void capacity() {
        System.out.println("This truck has " + getcarriage_capacity() + " Liter carriage capacity");
    }

    public void decoration() {
        System.out.println("The truck is painted with " + color + " color");
    }

    public int getWheels() {
        return toy.wheels;
    }

    public int getDoor() {
        return toy.door;
    }

    public int getcarriage_capacity() {
        return toy.carriage_capacity;
    }

    public String getModel() {
        return toy.model;
    }
}

class CarDecorator implements Toy, ToyDecorator {
    Car toy;
    String color;

    public CarDecorator(Car toy, String color) {
        this.toy = toy;
        this.color = color;
    }

    public void material() {
        System.out.println("\nThis Car is made out of Plastic");
    }

    public void cost() {
        System.out.println("Price : 450/-");
    }

    public void decoration() {
        System.out.println("The car is painted with " + color + " color");
    }

    public int getWheels() {
        return toy.wheels;
    }

    public int getDoor() {
        return toy.door;
    }

    public String getModel() {
        return toy.model;
    }
}
```

5. Client Code:
    - The client code demonstrates the creation of Truck and Car objects and their decoration using the decorator classes.

```
class client {
    public static void main(String[] args) {
        Truck t = new Truck(12, 2, "TATA", 250);
        t.material();
        t.cost();
        t.capacity();

        Car c = new Car(4, 4, "Honda");
        c.material();
        c.cost();

        TruckDecorator t1 = new TruckDecorator(t, "red");
        t1.material();
        t1.cost();
        t1.capacity();
        t1.decoration();

        CarDecorator c1 = new CarDecorator(c, "blue");
        c1.material();
        c1.cost();
        c1.decoration();
    }
}
```

## Explanation of the Code
1. Component Interface:
    - The Toy interface defines the basic functionalities of a toy, such as material and cost.

```interface Toy {
    public void material();
    public void cost();
}
```

2. Concrete Components:
    - Truck and Car classes implement the Toy interface and provide specific implementations for the material and cost methods. Additionally, the Truck class has a capacity method to display its carriage capacity.

```class Truck implements Toy {
    // Truck implementation
}

class Car implements Toy {
    // Car implementation
}
```

3. Decorator Interface:
    - The ToyDecorator interface provides an additional method for decoration.

```
interface ToyDecorator {
    public void decoration();
}
```

4. Concrete Decorators:
    - TruckDecorator and CarDecorator classes implement the Toy and ToyDecorator interfaces. They add additional functionality, such as decoration, to the original Truck and Car objects.

```
class TruckDecorator implements Toy, ToyDecorator {
    // TruckDecorator implementation
}

class CarDecorator implements Toy, ToyDecorator {
    // CarDecorator implementation
}
```

5. Client Code:
    - The client class demonstrates the creation of Truck and Car objects and their decoration using the decorator classes.

```
class client {
    public static void main(String[] args) {
        // Client code implementation
    }
}
```

## UML Diagram
![Decorator UML](https://lh3.googleusercontent.com/u/0/drive-viewer/AKGpihYpxEvuvv9yHG5jYPOfCKMGN6_7ICDeQKydGaWsdY0eLgBtq6QW8znm259h2dbEX1uTg0hxTwO8sTCg2UaEvpdJyxxIynSLK8g=w1920-h919-rw-v1)

## Summary
The Decorator Design Pattern is a structural pattern that allows behavior to be added to individual objects dynamically. In this example, we demonstrated how to use the decorator pattern to add decoration functionality to Truck and Car objects without modifying their class definitions. The pattern provides a flexible alternative to subclassing for extending functionality.

[Link to the Complete Code](https://github.com/AnshulJethva10/Design-Patterns/blob/main/Builder.java)
