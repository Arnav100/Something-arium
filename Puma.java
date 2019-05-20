
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
    
    /**
     *
     */
    public Puma()
    {
        super( STARTING_MASS, MAX_MASS, MAX_AGE );
    }
}
