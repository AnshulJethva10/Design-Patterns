interface Toy
{
    public void material();
    public void cost();
}

class Truck implements Toy
{
    int wheels, door, carriage_capacity;
    String model;
    
    public Truck(int wheels, int door, String model, int carriage_capacity)
    {
        this.wheels = wheels;
        this.door = door;
        this.model = model;
        this.carriage_capacity = carriage_capacity;
    }
    
    public void material()
    {
        System.out.println("\nThis Truck is made out of wood");
    }

    public void cost()
    {
        System.out.println("Price : 750/-");
    }

    public void capacity()
    {
        System.out.println("This truck has " + carriage_capacity +" Liter carriage capacity");
    }
}

class Car implements Toy
{
    int wheels, door;
    String model;
    
    public Car(int wheels, int door, String model)
    {
        this.wheels = wheels;
        this.door = door;
        this.model = model;
    }
    
    public void material()
    {
        System.out.println("\nThis Car is made out of Plastic");
    }

    public void cost()
    {
        System.out.println("Price : 350/-");
    }
}

interface ToyDecorator
{
    public void decoration();
}

class TruckDecorator implements Toy, ToyDecorator
{
    Truck toy;
    String color;

    public TruckDecorator(Truck toy, String color)
    {
        this.toy = toy;
        this.color = color;
    }

    public void material()
    {
        System.out.println("\nThis Truck is made out of Wood");
    }

    public void cost()
    {
        System.out.println("Price : 850/-");
    }

    public void capacity()
    {
        System.out.println("This truck has " + getcarriage_capacity() +" Liter carriage capacity");
    }

    public void decoration()
    {
        System.out.println("The truck is painted with " + color + " color");
    }

    public int getWheels()
    {
        return toy.wheels;
    }

    public int getDoor()
    {
        return toy.door;
    }

    public int getcarriage_capacity()
    {
        return toy.carriage_capacity;
    }

    public String getModel()
    {
        return toy.model;
    }
}

class CarDecorator implements Toy, ToyDecorator
{
    Car toy;
    String color;

    public CarDecorator(Car toy, String color)
    {
        this.toy = toy;
        this.color = color;
    }

    public void material()
    {
        System.out.println("\nThis Car is made out of Plastic");
    }

    public void cost()
    {
        System.out.println("Price : 450/-");
    }

    public void decoration()
    {
        System.out.println("The car is painted with " + color + " color");
    }

    public int getWheels()
    {
        return toy.wheels;
    }

    public int getDoor()
    {
        return toy.door;
    }

    public String getModel()
    {
        return toy.model;
    }
}

class client
{
    public static void main(String[] args) 
    {
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
