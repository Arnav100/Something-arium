
/**
 * Write a description of class Jackal here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Jackal extends Animal implements Carnivore
{
    private static final int STARTING_MASS = 205; 
    private static final int MAX_MASS = 9525;
    private static final int MAX_AGE = 15;
    
    /**
     *
     */
    public Jackal()
    {
        super( STARTING_MASS, MAX_MASS, MAX_AGE );
    }
    
    /**
     * 
     */
    public String getType()
    {
        return "jackal";
    }
    
    /**
     * 
     */
    public String[] getFoodTypes()
    {
        return new String[]{ "goat", "rabbit" };
    }
}
