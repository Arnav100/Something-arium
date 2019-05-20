
/**
 * Write a description of class Oak here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Oak extends Plant
{

    public Oak(double acres)
    {
        super(18000, 30, 12, acres);
    }    
   
    public void printMass()
    {
        super.printMass("Oak");
    }
}
