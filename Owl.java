
/**
 * Write a description of class Owl here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Owl extends Animal implements Herbivore, Carnivore
{
    private static final int STARTING_MASS = 60; 
    private static final int MAX_MASS = 1450;
    private static final int MAX_AGE = 32;
    private static final int FERTILE_AGE = 730;
    private static final int WEANING_AGE = 50;
    /**
     *
     */
    public Owl()
    {
        super( STARTING_MASS, MAX_MASS, MAX_AGE, FERTILE_AGE, WEANING_AGE );
    }
    
    /**
     * 
     */
    public String getType()
    {
        return "owl";
    }
    
    /**
     * 
     */
    public String[] getFoodTypes()
    {
        return new String[]{ "oak", "rose", "rabbit" };
    }
}
