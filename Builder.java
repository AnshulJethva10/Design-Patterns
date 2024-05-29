import java.util.ArrayList;
import java.util.Scanner;

interface Technology
{
    public void uses();
}

class blth implements Technology
{
    public void uses()
    {
        System.out.println("Needs external Bluetooth");
    }
}

class wifi implements Technology
{
    public void uses()
    {
        System.out.println("Needs external Wi-Fi");
    }
}

interface Device
{
    // +name() return:string
    // +price() retrun:float
    String name();
    float price();
}

abstract class sensors implements Device
{
    public abstract String name();
    public abstract float price();
}

class temp_sensor extends sensors
{
    public String name()
    {
        return "Temperature Sensor";
    }

    public float price()
    {
        return 50f;
    }
}

class ir_sensor extends sensors
{
    public String name()
    {
        return "Infrared Sensor";
    }

    public float price()
    {
        return 65f;
    }
}

class laser_sensor extends sensors
{
    public String name()
    {
        return "Laser Sensor";
    }

    public float price()
    {
        return 40f;
    }
}

abstract class Modules implements Device
{
    public abstract String name();
    public abstract float price();
}

class Uno extends Modules
{
    public String name()
    {
        return "Ardunio Uno";
    }

    public float price()
    {
        return 300f;
    }

    public Technology technology1()
    {
        return new blth();
    }

    public Technology technology2()
    {
        return new wifi();
    }

}

class Nano extends Modules
{
    public String name()
    {
        return "Ardunio Nano";
    }

    public float price()
    {
        return 450f;
    }

    public Technology technology1()
    {
        return new blth();
    }

    public Technology technology2()
    {
        return new wifi();
    }
}

class esp32 extends Modules
{
    public String name()
    {
        return "NodeMCU ESP32";
    }

    public float price()
    {
        return 550f;
    }

    public void technology1()
    {
        System.out.println("It already has Buletooth module");
    }

    public void technology2()
    {
        System.out.println("It already has Wi-Fi module");
    }
}

class esp8266 extends Modules
{
    public String name()
    {
        return "NodeMCU ESP8266";
    }

    public float price()
    {
        return 500;
    }

    public Technology technology1()
    {
        return new blth();
    }

    public void technology2()
    {
        System.out.println("It already has Wi-Fi module");
    }
}

abstract class Wire implements Device
{
    public abstract String name();
    public abstract float price();
}

class m2m extends Wire
{
    public String name()
    {
        return "Male to Male Wire x 10";
    }

    public float price()
    {
        return 40f;
    }
}

class f2m extends Wire
{
    public String name()
    {
        return "Female to Male Wire x 10";
    }

    public float price()
    {
        return 40f;
    }
}

class f2f extends Wire
{
    public String name()
    {
        return "Female to Female Wire x 10";
    }

    public float price()
    {
        return 40f;
    }
}

abstract class Other implements Device
{
    public abstract String name();
    public abstract float price();
}

class led extends Other
{
    public String name()
    {
        return "LED x 10";
    }

    public float price()
    {
        return 50f;
    }
}

class bb extends Other
{
    public String name()
    {
        return "BreadBoard";
    }

    public float price()
    {
        return 80f;
    }
}

class btn extends Other
{
    public String name()
    {
        return "Button x 5";
    }

    public float price()
    {
        return 70f;
    }
}

class resistor extends Other
{
    public String name()
    {
        return "Resistor(1k) x 10";
    }

    public float price()
    {
        return 60f;
    }
}

class kit
{
    // +addDevice() retrun:void
    // +getCost() retrun:float
    // +showDevice() retrun:void
    ArrayList<Device> items = new ArrayList<Device>();

    void addDevice(Device itm)
    {
        items.add(itm);
    }

    float getCost()
    {
        int cost=0;
        for(Device itm : items)
        {
            cost += itm.price();
        }
        return cost;
    }

    void showDevices()
    {
        for(Device itm : items)
        {
            System.out.println(itm.name());
        }
    }
}

class IoT_Kit_Builder
{
    // NodeMUC_Kit_Builder retrun:kit
    // Ardunio_Kit_Builder return:kit
    public kit NodeMCU_Kit_Builder()
    {
        kit k = new kit();
        System.out.println("Which NodeMCU you want to add? : ");
        System.out.println("a) ESP32\nb) ESP8266");
        Scanner sc = new Scanner(System.in);
        String x = sc.next();
        if(x.equals("a"))
        {
            esp32 Esp32 = new esp32();
            Esp32.technology1();
            Esp32.technology2();
            k.addDevice(Esp32);
        }
        else if(x.equals("b"))
        {
            esp8266 Esp8266 = new esp8266();
            Esp8266.technology1().uses();
            Esp8266.technology2();
            k.addDevice(Esp8266);
        }
        System.out.println("How many Sensors do you want? : ");
        int y = sc.nextInt();
        for(int i=0; i<y; i++)
        {
            System.out.println("Which Sensor you want to add? : ");
            System.out.println("a) Temperature Sensor\nb) IR Sensor\nc) Laser Sensor");
            String z = sc.next();
            if(z.equals("a"))
            {
                Device tem = new temp_sensor();
                k.addDevice(tem);
            }
            else if(z.equals("b"))
            {
                Device ir = new ir_sensor();
                k.addDevice(ir);
            }
            else if(z.equals("c"))
            {
                Device laser = new laser_sensor();
                k.addDevice(laser);
            }
        }
        System.out.println("Which type of wire do you want? : ");
        System.out.println("a) Male to Male\nb) Male to Female\nc) Female to Female");
        String w = sc.next();
        if(w.equals("a"))
        {
            Device m2ms = new m2m();
            k.addDevice(m2ms);
        }
        else if(w.equals("b"))
        {
            Device f2ms = new f2m();
            k.addDevice(f2ms);
        }
        else if(w.equals("c"))
        {
            Device f2fs = new f2f();
            k.addDevice(f2fs);
        }
        Device bb1 = new bb();
        k.addDevice(bb1);
        Device led1 = new led();
        k.addDevice(led1);
        Device res = new resistor();
        k.addDevice(res);
        Device btn1 = new btn();
        k.addDevice(btn1);

        System.out.println("\nThis many items are there in your kit :");
        k.showDevices();
        float cost = k.getCost();
        System.out.println("\nTotal cost of your kit is : " + cost);
        sc.close();
        return k;
    }
    public kit Ardunio_Kit_Builder()
    {
        kit k = new kit();
        System.out.println("Which Ardunio you want to add? : ");
        System.out.println("a) Uno\nb) Nano");
        Scanner sc = new Scanner(System.in);
        String x = sc.next();
        if(x.equals("a"))
        {
            Uno uno = new Uno();
            uno.technology1().uses();
            uno.technology2().uses();
            k.addDevice(uno);
        }
        else if(x.equals("b"))
        {
            Nano nano = new Nano();
            nano.technology1().uses();
            nano.technology2().uses();
            k.addDevice(nano);
        }
        System.out.println("How many Sensors do you want? : ");
        int y = sc.nextInt();
        for(int i=0; i<y; i++)
        {
            System.out.println("Which Sensor you want to add? : ");
            System.out.println("a) Temperature Sensor\nb) IR Sensor\nc) Laser Sensor");
            String z = sc.next();
            if(z.equals("a"))
            {
                Device tem = new temp_sensor();
                k.addDevice(tem);
            }
            else if(z.equals("b"))
            {
                Device ir = new ir_sensor();
                k.addDevice(ir);
            }
            else if(z.equals("c"))
            {
                Device laser = new laser_sensor();
                k.addDevice(laser);
            }
        }
        System.out.println("Which type of wire do you want? : ");
        System.out.println("a) Male to Male\nb) Male to Female\nc) Female to Female");
        String w = sc.next();
        if(w.equals("a"))
        {
            Device m2ms = new m2m();
            k.addDevice(m2ms);
        }
        else if(w.equals("b"))
        {
            Device f2ms = new f2m();
            k.addDevice(f2ms);
        }
        else if(w.equals("c"))
        {
            Device f2fs = new f2f();
            k.addDevice(f2fs);
        }
        Device bb1 = new bb();
        k.addDevice(bb1);
        Device led1 = new led();
        k.addDevice(led1);
        Device res = new resistor();
        k.addDevice(res);

        System.out.println("\nThis many items are there in your kit :");
        k.showDevices();
        float cost = k.getCost();
        System.out.println("\nTotal cost of your kit is : " + cost);
        sc.close();
        return k;
    }
}

public class Customer
{
    public static void main(String[] args) 
    {
        System.out.println("Hello! Welcome to the IoT Kit Builder");
        System.out.println("Which type of kit do you want to build? :");
        System.out.println("a)Ardunio Kit\nb)NodeMCU Kit");
        Scanner sc = new Scanner(System.in);
        String x = sc.next();
        if(x.equals("a"))
        {
            IoT_Kit_Builder iot = new IoT_Kit_Builder();
            iot.Ardunio_Kit_Builder();
        }
        else if(x.equals("b"))
        {
            IoT_Kit_Builder iot = new IoT_Kit_Builder();
            iot.NodeMCU_Kit_Builder();
        }
        sc.close();
    }
}
