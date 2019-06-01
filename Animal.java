/**
 * Creates and tracks the sizes and ages of Animal objects as time passes
 *
 * @author Gabe Robare, Arnav Parashar, and Dana Nigrin
 * @version May 27, 2019
 */
public abstract class Animal implements Organism
{
    private double mass;
    private double startingMass;
    private double maxMass;
    
    private int maxAge;
    private boolean isAlive;
    private int daysAlive;
    private int fertileAge;
    private int weaningAge;
    
    private final int DAYS_FOR_STARVATION = 30;
    private final double STARVATION_DECREASE = 0.95;
    private final int TROPHIC_EFFICIENCY_DOWN = 10;
    private final double TROPHIC_EFFICIENCY_UP = 0.1;
    private final double EDIBLE_CARCASS_MASS = 0.5;
    private final int DAYS_IN_YEAR = 365;
    private double hunger; 
    private int starvingDays;
    
    private static int nameLength = 1;
    private String name;

    /**
     * Constructs Animal objects based on their parameters and names them
     * 
     * @param startingMass the infant mass as a double
     * @param maxMass the full-grown mass as a double
     * @param maxAge the age at which the Animal will naturally die, in years, as
     *  an int
     * @param fertileAge the age at which the Animal can reproduce, in days, as an
     *  int
     * @param weaningAge the age at which the Animal must start eating, in days, as
     *  an int
     */
    public Animal( double startingMass, double maxMass, int maxAge, int fertileAge,
    int weaningAge )
    {
        this.mass = startingMass;
        this.startingMass = startingMass;
        this.maxMass = maxMass;
        
        this.maxAge = maxAge;
        this.isAlive = true;
        this.daysAlive = -1;
        this.fertileAge = fertileAge;
        this.weaningAge = weaningAge;

        starvingDays = 0;

        newDay();
        giveName();
    }
    private void giveName()
    {
        name = "" + nameLength++;
    }
    /**
     * Returns the name of the animal
     * @return the name of the animal
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * Returns whether the Animal is hungry
     * 
     * @return true if the Animal's hunger is non-zero, false otherwise
     */
    public boolean isHungry()
    {
        return hunger > 0;
    }
    /**
     * Returns the mass of the Animal
     * 
     * @return the mass of the Animal
     */
    public double getMass()
    {
        return mass;
    }
    /**
     * Returns whether the Animal is alive
     * 
     * @return true if the Animal is alive, false otherwise
     */
    public boolean isAlive()
    {
        return isAlive;
    }
    /**
     * Returns the fertile age of the Animal
     * 
     * @return the fertile age of the Animal
     */
    public int getFertileAge()
    {
        return fertileAge;
    }

    /**
     * Returns the age of the Animal in days
     * 
     * @return the age of the Animal in days
     */
    public int getDaysAlive()
    {
        return daysAlive;
    }
    /**
     * Sets the Animal to adult age and adult size
     */
    public void becomeAdult()
    {
        daysAlive = fertileAge;
        mass = maxMass;
    }
    /**
     * Adds a day to the Animal's age, resets its hunger, and kills it if it is 
     *  starving or too old
     */
    public void newDay()
    {
        daysAlive++;  
        hunger = ( ( maxMass - startingMass ) / fertileAge )
                 * TROPHIC_EFFICIENCY_DOWN;
        
        if( starvingDays >= DAYS_FOR_STARVATION )
            die();
        if( daysAlive / DAYS_IN_YEAR >= maxAge )
            die();
    }
    /**
     * Kills the animal
     */
    public void die()
    {
        isAlive = false;
    }

    /**
     * Simulates an Animal object "eating" by adding mass to the Animal and 
     *  reducing the mass of the food or killing the food
     *  
     * @param food the Organism being eaten
     */
    public void eat( Organism food )
    {
        if( daysAlive < weaningAge )
        {
            feed( hunger );
            return;
        }
        
        if( food == null )
        {
            this.mass *= STARVATION_DECREASE;
            hunger = 0;
            starvingDays++;
            return;
        }
        
        double mass = food.getMass();
        if( food instanceof Plant )
        {
            Plant plantFood = (Plant) food;
            if( hunger < mass )
            {
                plantFood.reduce( hunger );
                feed( hunger );
            }
            else
            {
                plantFood.reduce( mass );
                feed( mass );
            }
            return;
        }
        feed( EDIBLE_CARCASS_MASS * mass);
        ( (Animal) food ).die();
    }
    private void feed( double m )
    {
        if( !isHungry() )
            return;
        
        if( m > hunger )
        {
            this.mass += hunger * TROPHIC_EFFICIENCY_UP;
            hunger = 0;
        }
        else
        {
            this.mass += m * TROPHIC_EFFICIENCY_UP;
            hunger -= m;
        }
       
        if( this.mass > maxMass )
            this.mass = maxMass;
    }

    /**
     * Returns the type of Animal as a String
     * 
     * @return the type of Animal
     */
    public abstract String getType();
    /**
     * Returns the types of Organisms that the Animal eats as an array of Strings
     * 
     * @return the Animal's prey types
     */
    public abstract String[] getFoodTypes();
}
