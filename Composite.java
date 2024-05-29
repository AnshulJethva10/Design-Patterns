import java.util.ArrayList;

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

class dht_sensor extends sensors
{
    public String name()
    {
        return "DHT Sensor";
    }

    public float price()
    {
        return 60f;
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

public class client
{
    public static void main(String[] args) 
    {
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
