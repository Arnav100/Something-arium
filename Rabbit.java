
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
    
    /**
     * 
     */
    public Rabbit()
    {
        super( STARTING_MASS, MAX_MASS, MAX_AGE );
    }
}
