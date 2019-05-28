/**
 * Creates and analyzes Puma species objects
 *
 * @author Gabe Robare, Arnav Parashar, and Dana Nigrin
 * @version May 27, 2019
 */
public class Puma extends Animal implements Carnivore
{
    private static final int STARTING_MASS = 450; 
    private static final int MAX_MASS = 63500;
    private static final int MAX_AGE = 13;
    private static final int FERTILE_AGE = 912;
    private static final int WEANING_AGE = 730;
    
    /**
     * Creates Goat species objects based on its starting mass, maximum mass, 
     *  maximum age, fertile age, and weaning age
     */
    public Puma()
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
        return "puma";
    }
    
    /**
     * Returns the types of food eaten by the Puma as an array of Strings
     * 
     * @return the food types as a String
     */
    public String[] getFoodTypes()
    {
        return new String[]{ "jackal" };
    }
}