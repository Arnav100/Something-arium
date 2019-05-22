
/**
 * Write a description of interface Female here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public interface Female
{
    public int getGestationDuration();
    
    public int getInterbirthInterval();

    public boolean isPregnant();
    
    public void startPregnancy();
    
    public boolean isFertile();
    
    public Animal[] reproduce();
}
