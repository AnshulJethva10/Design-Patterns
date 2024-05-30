import java.util.*;

interface laptop
{
    abstract void specs();
}

class HP implements laptop
{
    public void specs()
    {
        System.out.println("Name: Victus 15");
        System.out.println("Screen Resolution: 920 x 1080 pixels");
        System.out.println("Processor: AMD Ryzen 5 7535HS");
        System.out.println("RAM Size: 32 GB ");
        System.out.println("Hard Drive Size: 1 TB");
        System.out.println("Graphics Coprocessor: GeForce RTX 2050 4GB GDDR6 Graphic");
        System.out.println("Price: Rs.1,07,770");
    }
}

class Asus implements laptop
{
    public void specs()
    {
        System.out.println("Name: ROG Zephyrus M16");
        System.out.println("Screen Resolution: 2560 x 1600 pixels");
        System.out.println("Processor: Intel Core I9 12900H");
        System.out.println("RAM Size: 8 GB ");
        System.out.println("Hard Drive Size: 1 TB");
        System.out.println("Graphics Coprocessor: NVIDIA GeForce RTX 3070 Ti");
        System.out.println("Price: Rs.1,69,990");
    }
}

class Dell implements laptop
{
    public void specs()
    {
        System.out.println("Name: Dell G15-5525");
        System.out.println("Screen Resolution: 1920 x 1080 pixels");
        System.out.println("Processor: AMD Ryzen 7-6800H");
        System.out.println("RAM Size: 16 GB ");
        System.out.println("Hard Drive Size: 512 GB");
        System.out.println("Graphics Coprocessor: NVIDIA GeForce RTX 3060");
        System.out.println("Price: Rs.93,831");
    }
}

class Lenovo implements laptop
{
    public void specs()
    {
        System.out.println("Name: Lenovo Legion 5");
        System.out.println("Screen Resolution: 2560X1440 Pixels");
        System.out.println("Processor: AMD Ryzen 7 5800H");
        System.out.println("RAM Size: 16 GB ");
        System.out.println("Hard Drive Size: 512 GB");
        System.out.println("Graphics Coprocessor: NVIDIA GeForce RTX 3060");
        System.out.println("Price: Rs.1,18,900");
    }
}

class Factory
{
    void FactoryPass(int x)
    {
        if (x == 1)
        {
            laptop l = new HP();
            l.specs();
        }
        else if (x == 2)
        {
            laptop l = new Asus();
            l.specs();
        }
        else if (x == 3)
        {
            laptop l = new Dell();
            l.specs();
        }
        else if (x == 4)
        {
            laptop l = new Lenovo();
            l.specs();
        }
    }
}

class Client
{
    public static void main(String[] args) 
    {
        System.out.println("Which Laptop do you want to Buy?: ");
        System.out.println("1.HP\n2.Asus\n3.Dell\n4.Lenovo");
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();

        Factory f = new Factory();
        f.FactoryPass(x);
        sc.close();
    }
}
