import java.util.ArrayList;
import java.util.List;

interface Character 
{
    void display();
    int getcost();
}

class ConcreteCharacter implements Character 
{
    char symbol;
    int cost;

    public ConcreteCharacter(char symbol, int cost) 
    {
        this.symbol = symbol;
        this.cost = cost;
    }

    public void display() 
    {
        System.out.print(symbol);
    }

    public int getcost()
    {
        return cost; 
    }
}

class CharacterFactory {
    private List<ConcreteCharacter> characters = new ArrayList<>();

    public Character getCharacter(char symbol, int cost) 
    {
        ConcreteCharacter character = getExistingCharacter(symbol);

        if (character == null) 
        {
            character = new ConcreteCharacter(symbol, cost);
            characters.add(character);
        }

        return character;
    }

    private ConcreteCharacter getExistingCharacter(char symbol) 
    {
        for (ConcreteCharacter character : characters) 
        {
            if (character.symbol == symbol) 
            {
                return character;
            }
        }
        return null;
    }
}

public class client 
{
    static int fontcost = 5;
    static int sizecost = 4;
    int totalcost = 0;
    private CharacterFactory characterFactory = new CharacterFactory();

    public void printCharacters(String text) 
    {
        for (char c : text.toCharArray()) 
        {
            Character character = characterFactory.getCharacter(c, 1);
            character.display();
            totalcost += character.getcost();
        }
        totalcost += fontcost + sizecost;
    }

    public int getTotalcost()
    {
        return totalcost;
    }

    public static void main(String[] args) 
    {
        client editor = new client();
        editor.printCharacters("Hello, World!");
        System.out.println("\nTotal Cost with Flyweight Design Pattern: " + editor.getTotalcost());

        int totalcostwithoutflyweight = "Hello, World!".length() * (sizecost+fontcost);
        System.out.println("\nTotal Cost with Flyweight Design Pattern: " + totalcostwithoutflyweight);
    }
}
