
/**
 * Creates and analyzes Brush species objects
 *
 * @author Gabe Robare
 * @version May 20, 2019
 */
public class Brush extends Plant
{
    private static final double MAX_MASS = 317000;
    private static final double PLANT_DENSITY = 14.9;
    private static final double GROWTH_RATE = 8;
    
    /**
     * Creates Rose species objects of a certain area in acres
     * 
     * @param acres the amount of acres that the Rose object covers
     */
    public Brush( double acres )
    {
        super( MAX_MASS, PLANT_DENSITY, GROWTH_RATE, acres );
    }
    
    public void printMass()
    {
        super.printMass( "brush" );
    }
    
    public String getType()
    {
        return "brush";
    }
}
