/**
 * Creates and analyzes Goat species objects
 *
 * @author Gabe Robare, Arnav Parashar, and Dana Nigrin
 * @version May 27, 2019
 */
public class Goat extends Animal implements Herbivore
{
    private static final int STARTING_MASS = 2720; 
    private static final int MAX_MASS = 77110;
    private static final int MAX_AGE = 18;
    private static final int FERTILE_AGE = 912;
    private static final int WEANING_AGE = 105;
        
    /**
     * Creates Goat species objects based on its starting mass, maximum mass, 
     *  maximum age, fertile age, and weaning age
     */
    public Goat()
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
        return "goat";
    }
    
    /**
     * Returns the types of food eaten by the Goat as an array of Strings
     * 
     * @return the food types as a String
     */
    public String[] getFoodTypes()
    {
        return new String[]{ "brush" };
    }
}