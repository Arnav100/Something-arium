/**
 * Creates and analyzes Rose species objects
 *
 * @author Gabe Robare, Arnav Parashar, and Dana Nigrin
 * @version May 27, 2019
 */
public class Rose extends Plant
{
    private static final double MAX_MASS = 18000;
    private static final double PLANT_DENSITY = 30;
    private static final double GROWTH_RATE = 12;
    
    /**
     * Creates Rose species objects of a certain area in acres
     * 
     * @param acres the amount of acres that the Rose object covers
     */
    public Rose( double acres )
    {
        super( MAX_MASS, PLANT_DENSITY, GROWTH_RATE, acres);
    }
    
    /**
     * Returns the type as a String
     * 
     * @return the type as a String
     */
    public String getType()
    {
        return "rose";
    }
}