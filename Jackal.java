/**
 * Creates and analyzes Jackal species objects
 *
 * @author Gabe Robare, Arnav Parashar, and Dana Nigrin
 * @version May 27, 2019
 */
public class Jackal extends Animal implements Carnivore
{
    private static final int STARTING_MASS = 205; 
    private static final int MAX_MASS = 9525;
    private static final int MAX_AGE = 15;
    private static final int FERTILE_AGE = 334;
    private static final int WEANING_AGE = 56;
    
    /**
     * Creates Goat species objects based on its starting mass, maximum mass, 
     *  maximum age, fertile age, and weaning age
     */
    public Jackal()
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
        return "jackal";
    }
    
    /**
     * Returns the types of food eaten by the Jackal as an array of Strings
     * 
     * @return the food types as a String
     */
    public String[] getFoodTypes()
    {
        return new String[]{ "goat", "rabbit" };
    }
}