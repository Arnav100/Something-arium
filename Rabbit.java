/**
 * Creates and analyzes Rabbit species objects
 *
 * @author Gabe Robare, Arnav Parashar, and Dana Nigrin
 * @version May 27, 2019
 */
public class Rabbit extends Animal implements Herbivore
{
    private static final int STARTING_MASS = 90; 
    private static final int MAX_MASS = 2260;
    private static final int MAX_AGE = 8;
    private static final int FERTILE_AGE = 243;
    private static final int WEANING_AGE = 18;
    
    /**
     * Creates Goat species objects based on its starting mass, maximum mass, 
     *  maximum age, fertile age, and weaning age
     */
    public Rabbit()
    {
        super( STARTING_MASS, MAX_MASS, MAX_AGE, FERTILE_AGE, WEANING_AGE );
    }
    
    /**
     * Returns the type as a String
     * 
     * @return the type as a String
     */
    public String getType()
    {
        return "rabbit";
    }
    
    /**
     * Returns the types of food eaten by the Rabbit as an array of Strings
     * 
     * @return the food types as a String
     */
    public String[] getFoodTypes()
    {
        return new String[]{ "brush" };
    }
}