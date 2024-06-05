class FlightModel 
{
    String Name, Model;
    int Seats;

    FlightModel(String Name, String Model, int Seats) 
    {
        this.Name = Name;
        this.Model = Model;
        this.Seats = Seats;
    }

    void setName(String name) 
    {
        this.Name = name;
    }

    void setModel(String model) 
    {
        this.Model = model;
    }
}

class FlightController 
{
    FlightModel fm;
    FlightView fv;

    FlightController(FlightModel fm, FlightView fv) 
    {
        this.fm = fm;
        this.fv = fv;
    }

    void setName(String name) 
    {
        fm.setName(name);
    }

    void setModel(String model) 
    {
        fm.setModel(model);
    }

    void updateView() 
    {
        fv.PrintFlightDetails(fm);
    }
}

class FlightView 
{
    void PrintFlightDetails(FlightModel fm) 
    {
        System.out.println("\nFlight Name: " + fm.Name);
        System.out.println("Flight Model: " + fm.Model);
        System.out.println("Flight Seats: " + fm.Seats);
    }
}

class client 
{
    public static void main(String[] args) 
    {
        FlightModel fm = new FlightModel("Flight 1", "Model 1", 100);
        FlightView fv = new FlightView();
        FlightController fc = new FlightController(fm, fv);
        fc.updateView();
        fc.setName("Flight 2");
        fc.setModel("Model 2");
        fc.updateView();
    }
}
