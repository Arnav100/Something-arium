
/**
 * Write a description of class Brush here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Brush extends Plant
{
    private final static int MAX_INDIVIDUAL_MASS = 18000;
    private final static int PLANT_DENSITY = 30;
    private final static int RELATIVE_GROWTH_RATE = 12; //fix
    
    public Brush( double acres )
    {
        super( MAX_INDIVIDUAL_MASS, PLANT_DENSITY, RELATIVE_GROWTH_RATE, acres);
    }   
}
