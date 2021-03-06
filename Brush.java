/**
 * Creates and analyzes Brush species objects
 *
 * @author Gabe Robare, Arnav Parashar, and Dana Nigrin
 * @version May 27, 2019
 */
public class Brush extends Plant
{
    private static final double MAX_MASS = 317000;
    private static final double PLANT_DENSITY = 14.9;
    private static final double GROWTH_RATE = 8;
    
    /**
     * Creates Brush species objects of a certain area in acres
     * 
     * @param acres the amount of acres that the Brush object covers
     */
    public Brush( double acres )
    {
        super( MAX_MASS, PLANT_DENSITY, GROWTH_RATE, acres );
    }
    
    /**
     * Returns the type as a String
     * 
     * @return the type as a String
     */
    public String getType()
    {
        return "brush";
    }
}