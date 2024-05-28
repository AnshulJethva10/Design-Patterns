import java.util.*;

interface Career
{
    abstract void degree();
}

class CS_Btech implements Career
{
    public void degree()
    {
        System.out.println("For B.Tech in Computer Science these colleges are good: ");
        System.out.println("IITs\nNITs\nIIITs");
    }
}

class Mec_Btech implements Career
{
    public void degree()
    {
        System.out.println("For B.Tech in Mechnical these colleges are good: ");
        System.out.println("BITS\nMIT\nVIT");
    }
}

class Elec_Btech implements Career
{
    public void degree()
    {
        System.out.println("For B.Tech in Electrical these colleges are good: ");
        System.out.println("IISC\nBITS\nIIT");
    }
}

class Civil_Btech implements Career
{
    public void degree()
    {
        System.out.println("For B.Tech in Civil these colleges are good: ");
        System.out.println("IITs\nNITs\nDTU");
    }
}

class CS_Mtech implements Career
{
    public void degree()
    {
        System.out.println("For M.Tech in Computer Science you can either go abroad or stay in India and these are the fields in which you can do M.Tech: ");
        System.out.println("Artificial Intelligence\nCyber Security\nMachine Learning\nData Analysis\nInformation Security");
    }
}

class Mec_Mtech implements Career
{
    public void degree()
    {
        System.out.println("For M.Tech in Mechnical you can either go abroad or stay in India and these are the fields in which you can do M.Tech: ");
        System.out.println("Automobile\nThermal\nManufacturing\nAerospace\nRobotics\nMechatronics");
    }
}

class Elec_Mtech implements Career
{
    public void degree()
    {
        System.out.println("For M.Tech in Electrical you can either go abroad or stay in India and these are the fields in which you can do M.Tech: ");
        System.out.println("Control and Instrumentation\nPower Electronics\nEnergy Systems\nAdvanced Power System\nRenewable Energy");
    }
}

class Civil_Mtech implements Career
{
    public void degree()
    {
        System.out.println("For M.Tech in Civil you can either go abroad or stay in India and these are the fields in which you can do M.Tech: ");
        System.out.println("Structural\nEnviromental\nGeotechnical\nConstruction\nTransportation\nWater Resources");
    }
}

abstract class Factory
{
    abstract void FactoryPass(int x);
}

class Btech_Factory extends Factory
{
    void FactoryPass(int x)
    {
        if(x == 1)
        {
            Career c = new CS_Btech();
            c.degree();
        }
        else if(x == 2)
        {
            Career c = new Mec_Btech();
            c.degree();
        }
        else if(x == 3)
        {
            Career c = new Civil_Btech();
            c.degree();
        }

        else if(x == 4)
        {
            Career c = new Elec_Btech();
            c.degree();
        }
    }
}

class Mtech_Factory extends Factory
{
    void FactoryPass(int x)
    {
        if(x == 1)
        {
            Career c = new CS_Mtech();
            c.degree();
        }
        else if(x == 2)
        {
            Career c = new Mec_Mtech();
            c.degree();
        }
        else if(x == 3)
        {
            Career c = new Civil_Mtech();
            c.degree();
        }

        else if(x == 4)
        {
            Career c = new Elec_Mtech();
            c.degree();
        }
    }
}

class FactoryProducer 
{
    public static Factory getFactory(int x) 
    {
        if (x == 1) 
        {
            return new Btech_Factory();
        } 
        else if (x == 2) 
        {
            return new Mtech_Factory();
        } 
        else 
        {
            return null;
        }
    }
}

public class Client
{
    public static void main(String[] args) 
    {
        System.out.println("Hello! Welcome to Career Counciling Center.");
        System.out.println("What do you want to do? : ");
        System.out.println("1.B.Tech\n2.M.Tech");
        
        Scanner sc = new Scanner(System.in);
        int y = sc.nextInt();

        System.out.println("Which branch do you want to Persue: ");
        System.out.println("1.Computer Science\n2.Mechanical\n3.Civil\n4.Electrical");
        int x = sc.nextInt();

        Factory f = FactoryProducer.getFactory(y);
        f.FactoryPass(x);
    
        sc.close();
    }
}
