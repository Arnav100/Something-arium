
/**
 * Write a description of class Puma here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Puma extends Animal implements Carnivore
{
    private static final int STARTING_MASS = 450; 
    private static final int MAX_MASS = 63500;
    private static final int MAX_AGE = 13;
    private static final int FERTILE_AGE = 912;
    private static final int WEANING_AGE = 730;
    
    /**
     *
     */
    public Puma()
    {
        super( STARTING_MASS, MAX_MASS, MAX_AGE, FERTILE_AGE, WEANING_AGE );
    }
    
    /**
     * 
     */
    public String getType()
    {
        return "puma";
    }
    
    /**
     * 
     */
    public String[] getFoodTypes()
    {
        return new String[]{ "jackal" };
    }
}
