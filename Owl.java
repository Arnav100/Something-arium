/**
 * Creates and analyzes Owl species objects
 *
 * @author Gabe Robare, Arnav Parashar, and Dana Nigrin
 * @version May 27, 2019
 */
public class Owl extends Animal implements Herbivore, Carnivore
{
    private static final int STARTING_MASS = 60; 
    private static final int MAX_MASS = 1450;
    private static final int MAX_AGE = 32;
    private static final int FERTILE_AGE = 730;
    private static final int WEANING_AGE = 50;
    
    /**
     * Creates Goat species objects based on its starting mass, maximum mass, 
     *  maximum age, fertile age, and weaning age
     */
    public Owl()
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
        return "owl";
    }
    
    /**
     * Returns the types of food eaten by the Owl as an array of Strings
     * 
     * @return the food types as a String
     */
    public String[] getFoodTypes()
    {
        return new String[]{ "oak", "rose", "rabbit" };
    }
}