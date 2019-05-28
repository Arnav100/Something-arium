/**
 * Creates and analyzes Hawk species objects
 *
 * @author Gabe Robare, Arnav Parashar, and Dana Nigrin
 * @version May 27, 2019
 */
public class Hawk extends Animal implements Herbivore, Carnivore
{
    private static final int STARTING_MASS = 55; 
    private static final int MAX_MASS = 1020;
    private static final int MAX_AGE = 29;
    private static final int FERTILE_AGE = 1095;
    private static final int WEANING_AGE = 45;
    
    /**
     * Creates Goat species objects based on its starting mass, maximum mass, 
     *  maximum age, fertile age, and weaning age
     */
    public Hawk()
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
        return "hawk";
    }
    
    /**
     * Returns the types of food eaten by the Hawk as an array of Strings
     * 
     * @return the food types as a String
     */
    public String[] getFoodTypes()
    {
        return new String[]{ "oak", "rose", "rabbit" };
    }
}