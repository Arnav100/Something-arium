
/**
 * Write a description of class Goat here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Goat extends Animal implements Herbivore
{
    private static final int STARTING_MASS = 2720; 
    private static final int MAX_MASS = 77110;
    private static final int MAX_AGE = 18;
    private static final int FERTILE_AGE = 912;
    private static final int WEANING_AGE = 105;
        
    /**
     *
     */
    public Goat()
    {
        super( STARTING_MASS, MAX_MASS, MAX_AGE, FERTILE_AGE, WEANING_AGE );
    }
    
    /**
     * 
     */
    public String getType()
    {
        return "goat";
    }
    
    /**
     * 
     */
    public String[] getFoodTypes()
    {
        return new String[]{ "brush" };
    }
}
