# Design Patterns in Java
Welcome to the Design Patterns repository. This repository contains implementations of various design patterns in Java. Each pattern is implemented with clarity to help beginners understand the concepts easily. Below is a list of the design patterns included in this repository along with their descriptions and usage.
1. [Abstract Factory](https://github.com/AnshulJethva10/Design-Patterns/blob/main/README.md#abstract-factory) 
2. [Adaptor](https://github.com/AnshulJethva10/Design-Patterns/blob/main/README.md#adapter)
3. [Builder](https://github.com/AnshulJethva10/Design-Patterns/blob/main/README.md#builder)
4. [Composite](https://github.com/AnshulJethva10/Design-Patterns/blob/main/README.md#composite)
5. [Decorator](https://github.com/AnshulJethva10/Design-Patterns/blob/main/README.md#decorator)
6. [Facade](https://github.com/AnshulJethva10/Design-Patterns/blob/main/README.md#facade)
7. [Factory](https://github.com/AnshulJethva10/Design-Patterns/blob/main/README.md#factory)
8. [Flyweight](https://github.com/AnshulJethva10/Design-Patterns/blob/main/README.md#flyweight)
9. [Iterator](https://github.com/AnshulJethva10/Design-Patterns/blob/main/README.md#iterator)
10. [MVC](https://github.com/AnshulJethva10/Design-Patterns/blob/main/README.md#mvc)
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

# Composite 
## Description
The DIY Electronics Kit Assembly project provides a Java implementation for creating and managing an electronics kit. This implementation defines various types of devices (sensors, modules, wires, and other components) that can be added to a kit, which can then calculate the total cost and display the list of devices.

## Problem
Managing a collection of various electronic components and calculating the total cost of the kit can be complex. This project aims to provide a flexible and reusable solution by defining a structured approach to add different devices to a kit, display the devices, and compute the total cost.

## Solution
1. Define the Device Interface:
    - The Device interface defines the structure for all devices that can be added to the kit.

```
interface Device {
    String name();
    float price();
}
```

2. Abstract Classes for Device Types:
    - Abstract classes for different device types (sensors, modules, wires, others) that implement the Device interface.

```
abstract class sensors implements Device {
    public abstract String name();
    public abstract float price();
}

abstract class Modules implements Device {
    public abstract String name();
    public abstract float price();
}

abstract class Wire implements Device {
    public abstract String name();
    public abstract float price();
}

abstract class Other implements Device {
    public abstract String name();
    public abstract float price();
}
```

3. Concrete Device Classes:
    - Concrete classes for specific devices extending their respective abstract classes.
```
class temp_sensor extends sensors {
    public String name() {
        return "Temperature Sensor";
    }

    public float price() {
        return 50f;
    }
}

class ir_sensor extends sensors {
    public String name() {
        return "Infrared Sensor";
    }

    public float price() {
        return 65f;
    }
}

// Other device classes (laser_sensor, dht_sensor, Uno, Nano, esp32, esp8266, m2m, f2m, f2f, led, bb, btn, resistor) follow the same pattern
```

4. Kit Class:
    - The Kit class manages a collection of devices, allowing to add devices, display them, and calculate the total cost.
```class kit {
    ArrayList<Device> items = new ArrayList<Device>();

    void addDevice(Device itm) {
        items.add(itm);
    }

    float getCost() {
        float cost = 0;
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

5. Client Code:
    - The client code demonstrates creating various devices, adding them to a kit, displaying the devices, and calculating the total cost.
```public class client {
    public static void main(String[] args) {
        kit new_kit = new kit();

        Device esp8266 = new esp8266();
        Device m2m = new m2m();
        Device f2m = new f2m();
        Device t_sensor = new temp_sensor();
        Device ir_sensor = new ir_sensor();
        Device dht_sensor = new dht_sensor();
        Device breadboard = new bb();
        Device btn = new btn();
        Device led = new led();
        Device resistor = new resistor();

        new_kit.addDevice(esp8266);
        new_kit.addDevice(m2m);
        new_kit.addDevice(f2m);
        new_kit.addDevice(t_sensor);
        new_kit.addDevice(dht_sensor);
        new_kit.addDevice(ir_sensor);
        new_kit.addDevice(breadboard);
        new_kit.addDevice(btn);
        new_kit.addDevice(led);
        new_kit.addDevice(resistor);

        System.out.println("Devices in the Kit are: ");
        new_kit.showDevices();

        float cost = new_kit.getCost();
        System.out.println("\nTotal cost of the kit is : " + cost);
    }
}
```

## Explanation of the Code
1. Device Interface:
    - The Device interface defines the basic functionalities of a device, such as name and price.
```
interface Device {
    String name();
    float price();
}
```

2. Abstract Classes for Device Types:
    - Abstract classes (sensors, Modules, Wire, Other) represent generic device types and implement the Device interface.
```abstract class sensors implements Device {
    public abstract String name();
    public abstract float price();
}

abstract class Modules implements Device {
    public abstract String name();
    public abstract float price();
}

abstract class Wire implements Device {
    public abstract String name();
    public abstract float price();
}

abstract class Other implements Device {
    public abstract String name();
    public abstract float price();
}
```

3. Concrete Device Classes:
    - Concrete classes for specific devices (e.g., temp_sensor, ir_sensor, Uno, Nano) extend their respective abstract classes and provide specific implementations for the name and price methods.
```
class temp_sensor extends sensors {
    public String name() {
        return "Temperature Sensor";
    }

    public float price() {
        return 50f;
    }
}

class ir_sensor extends sensors {
    public String name() {
        return "Infrared Sensor";
    }

    public float price() {
        return 65f;
    }
}

// Other device classes follow the same pattern
```

4. Kit Class:
    - The Kit class is used to manage a collection of devices. It provides methods to add devices, display the devices, and calculate the total cost of the kit.
```class kit {
    ArrayList<Device> items = new ArrayList<Device>();

    void addDevice(Device itm) {
        items.add(itm);
    }

    float getCost() {
        float cost = 0;
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

5. Client Code:
    - The client class demonstrates how to create various device objects, add them to a kit, display the devices, and calculate the total cost.
```
public class client {
    public static void main(String[] args) {
        kit new_kit = new kit();

        Device esp8266 = new esp8266();
        Device m2m = new m2m();
        Device f2m = new f2m();
        Device t_sensor = new temp_sensor();
        Device ir_sensor = new ir_sensor();
        Device dht_sensor = new dht_sensor();
        Device breadboard = new bb();
        Device btn = new btn();
        Device led = new led();
        Device resistor = new resistor();

        new_kit.addDevice(esp8266);
        new_kit.addDevice(m2m);
        new_kit.addDevice(f2m);
        new_kit.addDevice(t_sensor);
        new_kit.addDevice(dht_sensor);
        new_kit.addDevice(ir_sensor);
        new_kit.addDevice(breadboard);
        new_kit.addDevice(btn);
        new_kit.addDevice(led);
        new_kit.addDevice(resistor);

        System.out.println("Devices in the Kit are: ");
        new_kit.showDevices();

        float cost = new_kit.getCost();
        System.out.println("\nTotal cost of the kit is : " + cost);
    }
}
```
## UML Diagram
![Composite UML](https://lh3.googleusercontent.com/u/0/drive-viewer/AKGpihYqD83yIwjlZyvuD5G8TTVntOESuSY5HItqigJNNwY40TnFW-LM3WbDY4NrTINdqCUIlgGKrpR0M-zDhqZxu2h4Kw9Jh1V9hbY=w1920-h919-rw-v1)

## Summary
This project provides a structured approach to managing a collection of electronic components in a DIY electronics kit. The use of interfaces and abstract classes allows for flexibility and easy extension of new device types. The Kit class serves as a container for the devices and provides methods to manage them effectively. By running the client code, users can create a kit, add various devices, display the devices, and calculate the total cost.

[Link to the Complete Code](https://github.com/AnshulJethva10/Design-Patterns/blob/main/Composite.java)


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

[Link to the Complete Code](https://github.com/AnshulJethva10/Design-Patterns/blob/main/Decorator.java)


# Facade
## Description
The Facade Design Pattern provides a simplified interface to a complex subsystem. In this project, we use the Facade pattern to convert text into an image by encapsulating the entire process within a single class that interacts with various components responsible for different stages of the conversion.

## Problem
Converting text to an image involves multiple steps and interactions between various components. Managing these interactions directly can be complex and error-prone. The Facade Design Pattern simplifies this by providing a unified interface that makes the subsystem easier to use.

## Solution
1. Define the LLM Interface:
    - The LLM interface defines the structure for all components involved in the text to image conversion process.
```
interface LLM {
    public void identify();
}
```

2. Concrete Classes for Each Stage:
    - Concrete classes for each stage of the conversion process, implementing the LLM interface.
```
class Layout_Planning implements LLM {
    public void drawplan() {
        System.out.println("Creating layout...");
    }
    public void identify() {
        System.out.println("This is Layout Planning Section");
    }
}

class Tokenization implements LLM {
    public void generatetoken() {
        System.out.println("Converting text to tokens...");
    }
    public void identify() {
        System.out.println("This is Tokenization Section");
    }
}

class Embedding implements LLM {
    public void convertingtokens() {
        System.out.println("Tokens are being converted into numerical representation...");
    }
    public void identify() {
        System.out.println("This is Embedding Section");
    }
}

class Contextualization implements LLM {
    public void analyzing() {
        System.out.println("Model is analyzing embedding...");
    }
    public void identify() {
        System.out.println("This is Contextualization Section");
    }
}

class Image_Generation implements LLM {
    public void generatingimage() {
        System.out.println("Converting the contextualized embeddings into a grid of pixels, applying colors, shapes...");
    }
    public void identify() {
        System.out.println("This is Image Generation Section");
    }
}

class Save implements LLM {
    public void savingfile() {
        System.out.println("Saving the generated image...");
    }
    public void identify() {
        System.out.println("This is Save Section");
    }
}
```

3. TexttoImageConversion Class (Facade):
    - This class provides a simplified interface to the entire text to image conversion process by sequentially invoking methods from each stage.
```
class TexttoImageConversion {
    public String ImageGenerator(String text) {
        Tokenization t1 = new Tokenization();
        t1.generatetoken();
        Embedding e1 = new Embedding();
        e1.convertingtokens();
        Contextualization c1 = new Contextualization();
        c1.analyzing();
        Image_Generation i1 = new Image_Generation();
        i1.generatingimage();
        Save s1 = new Save();
        s1.savingfile();
        System.out.println("Text converted to Image successfully.");
        return text + ".png";
    }  
}
```

4. Client Code:
    - The client code takes user input and initiates the text to image conversion process using the Facade class.
```
class client {
    public static void main(String[] args) {
        System.out.println("Enter the Text that you want to convert to image: ");
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        System.out.println("Creating Image of '" + text + "'...");
        TexttoImageConversion converter = new TexttoImageConversion();
        converter.ImageGenerator(text);
        sc.close();
    }
}
```

## Explanation of the Code
1. LLM Interface:
    - The LLM interface defines a method identify for all stages of the conversion process.
```
interface LLM {
    public void identify();
}
```

2. Concrete Classes for Each Stage:
    - Classes (Layout_Planning, Tokenization, Embedding, Contextualization, Image_Generation, Save) implement the LLM interface and provide specific implementations for their respective stages.
```
class Layout_Planning implements LLM {
    public void drawplan() {
        System.out.println("Creating layout...");
    }
    public void identify() {
        System.out.println("This is Layout Planning Section");
    }
}

class Tokenization implements LLM {
    public void generatetoken() {
        System.out.println("Converting text to tokens...");
    }
    public void identify() {
        System.out.println("This is Tokenization Section");
    }

// Other stages follow the same pattern
```

3. TexttoImageConversion Class (Facade):
    - This class manages the entire text to image conversion process by calling methods from each stage in sequence.
```
class TexttoImageConversion {
    public String ImageGenerator(String text) {
        Tokenization t1 = new Tokenization();
        t1.generatetoken();
        Embedding e1 = new Embedding();
        e1.convertingtokens();
        Contextualization c1 = new Contextualization();
        c1.analyzing();
        Image_Generation i1 = new Image_Generation();
        i1.generatingimage();
        Save s1 = new Save();
        s1.savingfile();
        System.out.println("Text converted to Image successfully.");
        return text + ".png";
    }  
}
```

4. Client Code:
    - The client class takes input from the user, creates an instance of TexttoImageConversion, and initiates the conversion process.
```
class client {
    public static void main(String[] args) {
        System.out.println("Enter the Text that you want to convert to image: ");
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        System.out.println("Creating Image of '" + text + "'...");
        TexttoImageConversion converter = new TexttoImageConversion();
        converter.ImageGenerator(text);
        sc.close();
    }
}
```

## UML
![Facade UML](https://lh3.googleusercontent.com/u/0/drive-viewer/AKGpihbvP86-6_1niBM4J-bMz8Wn0_emCz_OGmo9F4-hRAlzzw1bAnOfbzx19C1xs5DP1PW6v2LEwPDO-8zZWyu9e-8lYC6XYexu6So=w1920-h919-rw-v1)

## Summary
The Facade Design Pattern simplifies interactions with complex subsystems by providing a unified interface. In this project, the TexttoImageConversion class acts as a facade, managing the entire text to image conversion process. This approach hides the complexities of the individual steps and provides a simple interface for the client to use. The project demonstrates how to use the Facade pattern to encapsulate the functionality of multiple components into a single class, making the system easier to use and maintain.

[Link to the Complete Code](https://github.com/AnshulJethva10/Design-Patterns/blob/main/Facade.java)


# Factory
## Description
The Factory Design Pattern is used to create objects without specifying the exact class of object that will be created. It provides a way to encapsulate the instantiation logic and enables the creation of different types of objects based on input parameters. In this project, we use the Factory pattern to generate specifications of different laptop models.

## Problem
When a client needs to create objects of different types based on input, directly instantiating these objects using new can lead to code that is hard to manage and extend. The Factory Design Pattern addresses this issue by encapsulating the object creation logic, making the code more maintainable and scalable.

## Solution
1. Define the Laptop Interface:
    - The Laptop interface defines the method for displaying laptop specifications.
```
interface Laptop {
    void specs();
}
```

2. Concrete Classes for Each Laptop Model:
    - Concrete classes implement the Laptop interface and provide specific implementations for displaying the specifications of different laptop models.
```
class HP implements Laptop {
    public void specs() {
        System.out.println("Name: Victus 15");
        System.out.println("Screen Resolution: 920 x 1080 pixels");
        System.out.println("Processor: AMD Ryzen 5 7535HS");
        System.out.println("RAM Size: 32 GB ");
        System.out.println("Hard Drive Size: 1 TB");
        System.out.println("Graphics Coprocessor: GeForce RTX 2050 4GB GDDR6 Graphic");
        System.out.println("Price: Rs.1,07,770");
    }
}

class Asus implements Laptop {
    public void specs() {
        System.out.println("Name: ROG Zephyrus M16");
        System.out.println("Screen Resolution: 2560 x 1600 pixels");
        System.out.println("Processor: Intel Core I9 12900H");
        System.out.println("RAM Size: 8 GB ");
        System.out.println("Hard Drive Size: 1 TB");
        System.out.println("Graphics Coprocessor: NVIDIA GeForce RTX 3070 Ti");
        System.out.println("Price: Rs.1,69,990");
    }
}

class Dell implements Laptop {
    public void specs() {
        System.out.println("Name: Dell G15-5525");
        System.out.println("Screen Resolution: 1920 x 1080 pixels");
        System.out.println("Processor: AMD Ryzen 7-6800H");
        System.out.println("RAM Size: 16 GB ");
        System.out.println("Hard Drive Size: 512 GB");
        System.out.println("Graphics Coprocessor: NVIDIA GeForce RTX 3060");
        System.out.println("Price: Rs.93,831");
    }
}

class Lenovo implements Laptop {
    public void specs() {
        System.out.println("Name: Lenovo Legion 5");
        System.out.println("Screen Resolution: 2560X1440 Pixels");
        System.out.println("Processor: AMD Ryzen 7 5800H");
        System.out.println("RAM Size: 16 GB ");
        System.out.println("Hard Drive Size: 512 GB");
        System.out.println("Graphics Coprocessor: NVIDIA GeForce RTX 3060");
        System.out.println("Price: Rs.1,18,900");
    }
}
```

3. Factory Class:
    - The Factory class contains the logic to create and return instances of different laptop models based on the input parameter.
```
class LaptopFactory {
    public Laptop getLaptop(int x) {
        switch (x) {
            case 1:
                return new HP();
            case 2:
                return new Asus();
            case 3:
                return new Dell();
            case 4:
                return new Lenovo();
            default:
                return null;
        }
    }
}
```

4. Client Code:
    - The client code prompts the user to select a laptop model and uses the factory to create and display the specifications of the selected model.
```
class Client {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Which Laptop do you want to buy?: ");
        System.out.println("1. HP\n2. Asus\n3. Dell\n4. Lenovo");
        int x = sc.nextInt();

        LaptopFactory factory = new LaptopFactory();
        Laptop laptop = factory.getLaptop(x);
        if (laptop != null) {
            laptop.specs();
        } else {
            System.out.println("Invalid selection");
        }
        sc.close();
    }
}
```

## Explanation of the Code
1. Laptop Interface:
    - The Laptop interface defines a method specs that will be implemented by all concrete laptop classes.
```
interface Laptop {
    void specs();
}
```

2. Concrete Classes for Each Laptop Model:
    - Classes (HP, Asus, Dell, Lenovo) implement the Laptop interface and provide specific details for each laptop model.
```
class HP implements Laptop {
    public void specs() {
        // Specifications of HP laptop
    }
}

class Asus implements Laptop {
    public void specs() {
        // Specifications of Asus laptop
    }
}
// Other laptop classes follow the same pattern
```

3. LaptopFactory Class:
    - The factory class has a method getLaptop that takes an integer as input and returns an instance of the corresponding laptop model.
```
class LaptopFactory {
    public Laptop getLaptop(int x) {
        switch (x) {
            case 1:
                return new HP();
            case 2:
                return new Asus();
            case 3:
                return new Dell();
            case 4:
                return new Lenovo();
            default:
                return null;
        }
    }
}
```

4. Client Code:
    - The client class prompts the user for input, uses the factory to create the appropriate laptop object, and displays its specifications.
```
class Client {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Which Laptop do you want to buy?: ");
        System.out.println("1. HP\n2. Asus\n3. Dell\n4. Lenovo");
        int x = sc.nextInt();

        LaptopFactory factory = new LaptopFactory();
        Laptop laptop = factory.getLaptop(x);
        if (laptop != null) {
            laptop.specs();
        } else {
            System.out.println("Invalid selection");
        }
        sc.close();
    }
}
```

## UML
![Factory UML](https://lh3.googleusercontent.com/u/0/drive-viewer/AKGpihbptvNTWbh4DR9tPz2oJJCGLMf-M67n0ajomV9uAS-wfhphDz_LZ8bmu1dx60Ibsb_T2QmkuYMxmjXG-q2V9pfojLAVrFzCCg8=w1920-h919-rw-v1)

## Summary
The Factory Design Pattern encapsulates the creation logic of objects, making the code easier to manage and extend. In this example, the LaptopFactory class provides a simple interface for creating different types of laptop objects based on user input. This approach hides the instantiation logic from the client, ensuring that the client code remains clean and easy to understand. The Factory pattern is particularly useful when the creation process is complex or when the exact types of objects to be created are determined at runtime.

[Link to the Complete Code](https://github.com/AnshulJethva10/Design-Patterns/blob/main/Factory.java)


# Flyweight
## Description
The Flyweight Design Pattern is used to minimize memory usage and improve performance by sharing as much data as possible with similar objects. It is particularly useful when a large number of similar objects are created, and their storage cost is high. This pattern provides a way to use objects in a more efficient manner.

## Problem
In scenarios where a large number of similar objects are created, memory usage can become a concern. Creating multiple instances of similar objects wastes memory and can degrade performance. The Flyweight Design Pattern helps reduce memory consumption by sharing common parts of the object state.

## Solution
1. Define the Character Interface:
    - The Character interface defines the methods that concrete characters will implement.
```
interface Character {
    void display();
    int getcost();
}
```

2. Concrete Character Class:
    - The ConcreteCharacter class implements the Character interface and represents a character with a specific symbol and cost.
```
class ConcreteCharacter implements Character {
    char symbol;
    int cost;

    public ConcreteCharacter(char symbol, int cost) {
        this.symbol = symbol;
        this.cost = cost;
    }

    public void display() {
        System.out.print(symbol);
    }

    public int getcost() {
        return cost; 
    }
}
```

3. Character Factory Class:
    - The CharacterFactory class manages the creation and reuse of ConcreteCharacter instances. It ensures that new characters are only created when they don't already exist.
```
class CharacterFactory {
    private List<ConcreteCharacter> characters = new ArrayList<>();

    public Character getCharacter(char symbol, int cost) {
        ConcreteCharacter character = getExistingCharacter(symbol);

        if (character == null) {
            character = new ConcreteCharacter(symbol, cost);
            characters.add(character);
        }

        return character;
    }

    private ConcreteCharacter getExistingCharacter(char symbol) {
        for (ConcreteCharacter character : characters) {
            if (character.symbol == symbol) {
                return character;
            }
        }
        return null;
    }
}
```

4. Client Code:
    - The client class demonstrates the use of the Flyweight pattern to print characters and calculate the total cost.
```
public class Client {
    static int fontcost = 5;
    static int sizecost = 4;
    int totalcost = 0;
    private CharacterFactory characterFactory = new CharacterFactory();

    public void printCharacters(String text) {
        for (char c : text.toCharArray()) {
            Character character = characterFactory.getCharacter(c, 1);
            character.display();
            totalcost += character.getcost();
        }
        totalcost += fontcost + sizecost;
    }

    public int getTotalcost() {
        return totalcost;
    }

    public static void main(String[] args) {
        Client editor = new Client();
        editor.printCharacters("Hello, World!");
        System.out.println("\nTotal Cost with Flyweight Design Pattern: " + editor.getTotalcost());

        int totalcostwithoutflyweight = "Hello, World!".length() * (sizecost + fontcost);
        System.out.println("Total Cost without Flyweight Design Pattern: " + totalcostwithoutflyweight);
    }
}
```

## Explanation of the Code
1. Character Interface:
    - The Character interface defines two methods, display and getcost, which are implemented by concrete character classes.
```
interface Character {
    void display();
    int getcost();
}
```

2. ConcreteCharacter Class:
    - The ConcreteCharacter class represents a character with a symbol and cost. It implements the Character interface.
```
class ConcreteCharacter implements Character {
    char symbol;
    int cost;

    public ConcreteCharacter(char symbol, int cost) {
        this.symbol = symbol;
        this.cost = cost;
    }

    public void display() {
        System.out.print(symbol);
    }

    public int getcost() {
        return cost; 
    }
}
```

3. CharacterFactory Class:
    - The CharacterFactory class is responsible for creating and managing ConcreteCharacter instances. It ensures that characters are reused when possible to save memory.
```
class CharacterFactory {
    private List<ConcreteCharacter> characters = new ArrayList<>();

    public Character getCharacter(char symbol, int cost) {
        ConcreteCharacter character = getExistingCharacter(symbol);

        if (character == null) {
            character = new ConcreteCharacter(symbol, cost);
            characters.add(character);
        }

        return character;
    }

    private ConcreteCharacter getExistingCharacter(char symbol) {
        for (ConcreteCharacter character : characters) {
            if (character.symbol == symbol) {
                return character;
            }
        }
        return null;
    }
}
```
4. Client Class:
    - The client class demonstrates how to use the Flyweight pattern to print characters and calculate the total cost with and without the Flyweight pattern.
```
public class Client {
    static int fontcost = 5;
    static int sizecost = 4;
    int totalcost = 0;
    private CharacterFactory characterFactory = new CharacterFactory();

    public void printCharacters(String text) {
        for (char c : text.toCharArray()) {
            Character character = characterFactory.getCharacter(c, 1);
            character.display();
            totalcost += character.getcost();
        }
        totalcost += fontcost + sizecost;
    }

    public int getTotalcost() {
        return totalcost;
    }

    public static void main(String[] args) {
        Client editor = new Client();
        editor.printCharacters("Hello, World!");
        System.out.println("\nTotal Cost with Flyweight Design Pattern: " + editor.getTotalcost());

        int totalcostwithoutflyweight = "Hello, World!".length() * (sizecost + fontcost);
        System.out.println("Total Cost without Flyweight Design Pattern: " + totalcostwithoutflyweight);
    }
}
```

## UML
![Flyweight UML](https://lh3.googleusercontent.com/u/0/drive-viewer/AKGpihYhuitHRIE4DfiKOzAIKqprx9YxIxkGkFQojTtIbNzu140cwg9qmEDd9G9Cmua5JX1VeELCoz8LbfgLaOa4ueQ_rXlmVureNno=w1920-h919)

## Summary
The Flyweight Design Pattern is a structural pattern that reduces memory usage by sharing as much data as possible with similar objects. In this example, we demonstrated how to use the Flyweight pattern to efficiently manage and display characters in a text editor. The pattern helps in minimizing memory consumption and improving performance, especially when dealing with a large number of similar objects.

[Link to the Complete Code](https://github.com/AnshulJethva10/Design-Patterns/blob/main/Flyweight.java)


# Iterator
## Description
The Iterator Design Pattern provides a way to access the elements of a collection sequentially without exposing the underlying representation. This pattern is particularly useful for traversing collections like lists or arrays in a uniform way.

## Problem
In scenarios where collections need to be traversed, it is important to provide a standardized way to iterate through the elements. Without a common iteration interface, each collection would require a different traversal mechanism, leading to inconsistent and error-prone code. The Iterator Design Pattern addresses this issue by defining a standard interface for traversal.

## Solution
1. Define the Students Class:
    - The Students class represents a student with attributes like name, branch, age, and roll number.
```
class Students {
    String name, branch;
    int age, rollno;

    Students(String name, String branch, int age, int rollno) {
        this.name = name;
        this.branch = branch;
        this.age = age;
        this.rollno = rollno;
    }

    void PrintDetails(Students s1) {
        System.out.println("Name: " + s1.name + "\t" +
                        "Roll Number: " + s1.rollno + "\t" + 
                        "Branch: " + s1.branch + "\t" + 
                        "Age: " + s1.age);
    }

    String getName() {
        return name;
    }

    int getRoll() {
        return rollno;
    }

    String getBranch() {
        return branch;
    }

    int getAge() {
        return age;
    }
}
```

2. Define the StudentIterator Class:
    - The StudentIterator class implements the Iterator interface for traversing the Students collection.
```
class StudentIterator implements Iterator<Students> {
    private ArrayList<Students> studentList;
    private int index;

    public StudentIterator(ArrayList<Students> studentList) {
        this.studentList = studentList;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        return index < studentList.size();
    }

    @Override
    public Students next() {
        return studentList.get(index++);
    }
}
```

3. Define Comparator Classes for Sorting:
    - The comparator classes (StudentAgeComparator, StudentRollNoComparator, StudentNameComparator, and StudentBranchComparator) are used to sort the student list based on different attributes.
```
class StudentAgeComparator implements Comparator<Students> {
    @Override
    public int compare(Students s1, Students s2) {
        return s1.getAge() - s2.getAge();
    }
}

class StudentRollNoComparator implements Comparator<Students> {
    @Override
    public int compare(Students s1, Students s2) {
        return s1.getRoll() - s2.getRoll();
    }
}

class StudentNameComparator implements Comparator<Students> {
    @Override
    public int compare(Students s1, Students s2) {
        return s1.getName().compareTo(s2.getName());
    }
}

class StudentBranchComparator implements Comparator<Students> {
    @Override
    public int compare(Students s1, Students s2) {
        return s1.getBranch().compareTo(s2.getBranch());
    }
}
```

4. Define the Iterators Class:
    - The Iterators class contains methods to iterate through the student list, sorted by different attributes.
```
class Iterators {
    void IteratebyName(ArrayList<Students> studentList) {
        Collections.sort(studentList, new StudentNameComparator());
        System.out.println("Sorted by Name:");
        StudentIterator iterator = new StudentIterator(studentList);
        while (iterator.hasNext()) {
            Students student = iterator.next();
            student.PrintDetails(student);
            System.out.println();
        }
    }

    void IteratebyAge(ArrayList<Students> studentList) {
        Collections.sort(studentList, new StudentAgeComparator());
        System.out.println("Sorted by Age:");
        StudentIterator iterator = new StudentIterator(studentList);
        while (iterator.hasNext()) {
            Students student = iterator.next();
            student.PrintDetails(student);
            System.out.println();
        }
    }

    void IteratebyRoll(ArrayList<Students> studentList) {
        Collections.sort(studentList, new StudentRollNoComparator());
        System.out.println("Sorted by Roll Number:");
        StudentIterator iterator = new StudentIterator(studentList);
        while (iterator.hasNext()) {
            Students student = iterator.next();
            student.PrintDetails(student);
            System.out.println();
        }
    }

    void IteratebyBranch(ArrayList<Students> studentList) {
        Collections.sort(studentList, new StudentBranchComparator());
        System.out.println("Sorted by Branch:");
        StudentIterator iterator = new StudentIterator(studentList);
        while (iterator.hasNext()) {
            Students student = iterator.next();
            student.PrintDetails(student);
            System.out.println();
        }
    }
}
```

5. Client Code:
    - The client class demonstrates the use of the Iterator pattern to iterate through a list of students sorted by different attributes.
```
public class Client {
    public static void main(String[] args) {
        ArrayList<Students> studentList = new ArrayList<>();
        studentList.add(new Students("Alice", "Computer", 20, 103));
        studentList.add(new Students("Bob", "Mechanical", 22, 101));
        studentList.add(new Students("Charlie", "Aerospace", 21, 102));

        Iterators i = new Iterators();
        i.IteratebyName(studentList);
        i.IteratebyAge(studentList);
        i.IteratebyBranch(studentList);
        i.IteratebyRoll(studentList);
    }
}
```

## Explanation of the Code
1. Students Class:
    - The Students class represents a student with attributes like name, branch, age, and roll number. It also includes methods to get these attributes and print the student's details.
```
class Students {
    String name, branch;
    int age, rollno;

    Students(String name, String branch, int age, int rollno) {
        this.name = name;
        this.branch = branch;
        this.age = age;
        this.rollno = rollno;
    }

    void PrintDetails(Students s1) {
        System.out.println("Name: " + s1.name + "\t" +
                        "Roll Number: " + s1.rollno + "\t" + 
                        "Branch: " + s1.branch + "\t" + 
                        "Age: " + s1.age);
    }

    String getName() {
        return name;
    }

    int getRoll() {
        return rollno;
    }

    String getBranch() {
        return branch;
    }

    int getAge() {
        return age;
    }
}
```

2. StudentIterator Class:
    - The StudentIterator class implements the Iterator interface to traverse the Students collection. It maintains an index to track the current position in the list.
```
class StudentIterator implements Iterator<Students> {
    private ArrayList<Students> studentList;
    private int index;

    public StudentIterator(ArrayList<Students> studentList) {
        this.studentList = studentList;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        return index < studentList.size();
    }

    @Override
    public Students next() {
        return studentList.get(index++);
    }
}
```

3. Comparator Classes:
    - These classes (StudentAgeComparator, StudentRollNoComparator, StudentNameComparator, and StudentBranchComparator) implement the Comparator interface to sort the student list based on different attributes.
```
class StudentAgeComparator implements Comparator<Students> {
    @Override
    public int compare(Students s1, Students s2) {
        return s1.getAge() - s2.getAge();
    }
}

class StudentRollNoComparator implements Comparator<Students> {
    @Override
    public int compare(Students s1, Students s2) {
        return s1.getRoll() - s2.getRoll();
    }
}

class StudentNameComparator implements Comparator<Students> {
    @Override
    public int compare(Students s1, Students s2) {
        return s1.getName().compareTo(s2.getName());
    }
}

class StudentBranchComparator implements Comparator<Students> {
    @Override
    public int compare(Students s1, Students s2) {
        return s1.getBranch().compareTo(s2.getBranch());
    }
}
```

3. Iterators Class:
    - The Iterators class contains methods to iterate through the student list sorted by different attributes. Each method sorts the list using the appropriate comparator and then iterates through it using the StudentIterator.
```
class Iterators {
    void IteratebyName(ArrayList<Students> studentList) {
        Collections.sort(studentList, new StudentNameComparator());
        System.out.println("Sorted by Name:");
        StudentIterator iterator = new StudentIterator(studentList);
        while (iterator.hasNext()) {
            Students student = iterator.next();
            student.PrintDetails(student);
            System.out.println();
        }
    }

    void IteratebyAge(ArrayList<Students> studentList) {
        Collections.sort(studentList, new StudentAgeComparator());
        System.out.println("Sorted by Age:");
        StudentIterator iterator = new StudentIterator(studentList);
        while (iterator.hasNext()) {
            Students student = iterator.next();
            student.PrintDetails(student);
            System.out.println();
        }
    }

    void IteratebyRoll(ArrayList<Students> studentList) {
        Collections.sort(studentList, new StudentRollNoComparator());
        System.out.println("Sorted by Roll Number:");
        StudentIterator iterator = new StudentIterator(studentList);
        while (iterator.hasNext()) {
            Students student = iterator.next();
            student.PrintDetails(student);
            System.out.println();
        }
    }

    void IteratebyBranch(ArrayList<Students> studentList) {
        Collections.sort(studentList, new StudentBranchComparator());
        System.out.println("Sorted by Branch:");
        StudentIterator iterator = new StudentIterator(studentList);
        while (iterator.hasNext()) {
            Students student = iterator.next();
            student.PrintDetails(student);
            System.out.println();
        }
    }
}
```

4. Client Code:
    - The client class demonstrates how to use the Iterators class to iterate through a list of students sorted by different attributes. It creates a list of students, sorts and iterates through them using the different methods in the Iterators class.
```
public class Client {
    public static void main(String[] args) {
        ArrayList<Students> studentList = new ArrayList<>();
        studentList.add(new Students("Alice", "Computer", 20, 103));
        studentList.add(new Students("Bob", "Mechanical", 22, 101));
        studentList.add(new Students("Charlie", "Aerospace", 21, 102));

        Iterators i = new Iterators();
        i.IteratebyName(studentList);
        i.IteratebyAge(studentList);
        i.IteratebyBranch(studentList);
        i.IteratebyRoll(studentList);
    }
}
```

## UML Diagram
![Iterator UML](https://lh3.googleusercontent.com/u/0/drive-viewer/AKGpihY6GyKArufMwAcp3z-TnCrfaHXpfv-3zXHvoE4xSVsLTyYVU4tBgkJ4TVMKLwTP3OopcHHvFxLYDY4dF9zobQEgM1w0qHFaUA=w1920-h919-rw-v1)

## Summary
The Iterator Design Pattern is a behavioral pattern that provides a standardized way to traverse elements in a collection without exposing the underlying representation. In this example, we demonstrated how to use the Iterator pattern to efficiently iterate through a list of students, sorted by different attributes. This pattern helps in achieving a clean separation of concerns and simplifies the traversal logic.

[Link to the Complete Code](https://github.com/AnshulJethva10/Design-Patterns/blob/main/Iterator.java)


# Model-View-Controller (MVC)
## Description
The Model-View-Controller (MVC) Design Pattern is used to separate the application's concerns. This separation helps manage complexity and promotes organized code. The MVC pattern divides an application into three interconnected components: Model, View, and Controller.

## Problem
In scenarios where the user interface and business logic are tightly coupled, the code becomes difficult to manage, extend, and test. Any change in the user interface might require changes in the business logic and vice versa. The MVC Design Pattern addresses this issue by separating the application into three components, each handling a specific aspect of the application's functionality.

## Solution
1. Define the FlightModel Class:
    - The FlightModel class represents the data and business logic of a flight.
    - The FlightModel class represents the data and business logic for a flight. It includes attributes for the flight name, model, and number of seats. The class also provides setter methods to update the flight's name and model.
```
class FlightModel {
    String Name, Model;
    int Seats;

    FlightModel(String Name, String Model, int Seats) {
        this.Name = Name;
        this.Model = Model;
        this.Seats = Seats;
    }

    void setName(String name) {
        this.Name = name;
    }

    void setModel(String model) {
        this.Model = model;
    }
}
```

2. Define the FlightView Class:
    - The FlightView class handles the display of flight information.
    - The FlightView class handles the presentation of the flight information. It includes a method to print the details of a flight.
```
class FlightView {
    void PrintFlightDetails(FlightModel fm) {
        System.out.println("\nFlight Name: " + fm.Name);
        System.out.println("Flight Model: " + fm.Model);
        System.out.println("Flight Seats: " + fm.Seats);
    }
}
```

3. Define the FlightController Class:
    - The FlightController class acts as an intermediary between the FlightModel and FlightView. It handles the user input and updates the model.
    - The FlightController class serves as an intermediary between the FlightModel and FlightView. It provides methods to update the model's data and refresh the view.
```
class FlightController {
    FlightModel fm;
    FlightView fv;

    FlightController(FlightModel fm, FlightView fv) {
        this.fm = fm;
        this.fv = fv;
    }

    void setName(String name) {
        fm.setName(name);
    }

    void setModel(String model) {
        fm.setModel(model);
    }

    void updateView() {
        fv.PrintFlightDetails(fm);
    }
}
```

4. Client Code:
    - The client class demonstrates the use of the MVC pattern by creating instances of the FlightModel, FlightView, and FlightController classes and updating the flight information.
    - The client class demonstrates how to use the MVC components. It creates instances of FlightModel, FlightView, and FlightController, updates the model through the controller, and displays the updated flight information.
```
public class Client {
    public static void main(String[] args) {
        FlightModel fm = new FlightModel("Flight 1", "Model 1", 100);
        FlightView fv = new FlightView();
        FlightController fc = new FlightController(fm, fv);
        fc.updateView();
        fc.setName("Flight 2");
        fc.setModel("Model 2");
        fc.updateView();
    }
}
```

## UML
![MVC UML](https://lh3.googleusercontent.com/u/0/drive-viewer/AKGpihYnRx4SJo1FqVsd_C-2ngJAeJf2nZLWnNUNQSvvCeM6Cej4WdTIrNS5OaYU8tGCfYIR55jEb7U_0wBhwcPoy4JAkgZTu2Wj2A=w1920-h919)

## Summary
The Model-View-Controller (MVC) Design Pattern is a structural pattern that separates the application into three interconnected components: Model, View, and Controller. This separation helps manage complexity, promotes organized code, and makes the application easier to maintain and extend. In this example, we demonstrated how to use the MVC pattern to manage and display flight information efficiently. The pattern helps in achieving a clear separation of concerns, leading to a more modular and scalable application.

[Link to the Complete Code](https://github.com/AnshulJethva10/Design-Patterns/blob/main/MVC.java)
