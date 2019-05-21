
/**
 * Creates and analyzes Oak species objects
 *
 * @author Gabe Robare
 * @version May 6, 2019
 */
public class Oak extends Plant
{
    private static final double MAX_MASS = 18000;
    private static final double PLANT_DENSITY = 30;
    private static final double GROWTH_RATE = 12;
    
    /**
     * Creates Oak species objects of a certain area in acres
     * 
     * @param acres the amount of acres that the Oak object covers
     */
    public Oak(double acres)
    {
        super( MAX_MASS, PLANT_DENSITY, GROWTH_RATE, acres);
    }
    
    public void printMass()
    {
        super.printMass( "Oak" );
    }
    
    public String getType()
    {
        return "oak";
    }
}
