/**
 * Contains methods necessary for both Plants and Animals
 * 
 * @author Gabe Robare, Arnav Parashar, and Dana Nigrin
 * @version May 27, 2019
 */
public interface Organism
{
    /**
     * Returns the mass of the Organism
     * 
     * @return the mass of the Organism
     */
    public double getMass();
    
    /**
     * Returns whether the Organism is alive
     * 
     * @return true if the Organism is alive, false otherwise
     */
    public boolean isAlive();
    
    /**
     * Returns the type of Organism as a String
     * 
     * @return the type of Organism
     */
    public abstract String getType();
}