
/**
 * Write a description of class Hawk here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Hawk extends Animal implements Herbivore, Carnivore
{
    private static final int STARTING_MASS = 55; 
    private static final int MAX_MASS = 1020;
    private static final int MAX_AGE = 29;
    private static final int FERTILE_AGE = 1095;
    private static final int WEANING_AGE = 45;
    
    /**
     *
     */
    public Hawk()
    {
        super( STARTING_MASS, MAX_MASS, MAX_AGE, FERTILE_AGE, WEANING_AGE );
    }
    
    /**
     * 
     */
    public String getType()
    {
        return "hawk";
    }
    
    /**
     * 
     */
    public String[] getFoodTypes()
    {
        return new String[]{ "oak", "rose", "rabbit" };
    }
}
