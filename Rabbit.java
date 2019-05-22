
/**
 * Write a description of class Rabbit here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Rabbit extends Animal implements Herbivore
{
    private static final int STARTING_MASS = 90; 
    private static final int MAX_MASS = 2260;
    private static final int MAX_AGE = 8;
    private static final int FERTILE_AGE = 243;
    private static final int WEANING_AGE = 18;
    
    /**
     *
     */
    public Rabbit()
    {
        super( STARTING_MASS, MAX_MASS, MAX_AGE, FERTILE_AGE, WEANING_AGE );
    }
    
    /**
     * 
     */
    public String getType()
    {
        return "rabbit";
    }
    
    /**
     * 
     */
    public String[] getFoodTypes()
    {
        return new String[]{ "brush" };
    }
}
