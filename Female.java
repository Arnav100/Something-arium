
/**
 * Contains methods necessary only to Female Animals, being related to reproduction
 *
 * @author Gabe Robare, Arnav Parashar, and Dana Nigrin
 * @version May 27, 2019
 */
public interface Female
{
    /**
     * Returns the gestation duration
     * 
     * @return the gestation duration
     */
    public int getGestationDuration();
    
    /**
     * Returns the interbirth interval
     * 
     * @return the interbirth interval
     */
    public int getInterbirthInterval();
    
    /**
     * Returns whether the individual is past its fertile age
     * 
     * @return true if the animal is older than its fertile age, false otherwise
     */
    public boolean isFertile();
    
    /**
     * Returns whether the individual is pregnant
     * 
     * @return true if the individual is pregnant, false otherwise
     */
    public boolean isPregnant();
    
    /**
     * If the individual is not already pregnant, is fertile, and enough time has
     *  passed since its last pregnancy, makes the individual pregnant
     */
    public void startPregnancy();
    
    /**
     * Creates an array of new individuals as offspring to a pregnant individual
     * 
     * @return the array of new individuals, based on the average litter size
     */
    public Animal[] reproduce();
}
