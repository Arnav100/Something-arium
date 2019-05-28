/**
 * Creates and tracks the sizes of Plant species objects as time passes
 *
 * @author Gabe Robare, Arnav Parashar, and Dana Nigrin
 * @version May 27, 2019
 */
public abstract class Plant implements Organism
{
    private double maxIndiviualMass;
    private double plantDensity;
    private double relativeGrowthRate;
    
    private double maxSpeciesMass;
    private double speciesMass; 
    private boolean isAlive;
    
    /**
     * Constructs Plant species objects based on their parameters and sets their
     *  size
     * 
     * @param maxIndividualMass the maximum mass of an individual Plant as a double
     * @param plantDensity the amount of Plants per acre as a double
     * @param relativeGrowthRate the rate of increase of mass of the Plant in 
     *  mg / g / day, as a double
     * @param acres the area that the Plant species object covers
     */
    public Plant( double maxIndiviualMass, double plantDensity, 
    double relativeGrowthRate, double acres )
    {
        this.plantDensity = plantDensity;
        this.relativeGrowthRate = relativeGrowthRate;
        this.maxIndiviualMass = maxIndiviualMass;
        
        this.maxSpeciesMass = acres * plantDensity * maxIndiviualMass;
        this.speciesMass = maxSpeciesMass;
        this.isAlive = true;
    }
    
    /**
     * Returns the mass of the Plant species object
     * 
     * @return the mass of the Plant species object
     */
    public double getMass()
    {
        return speciesMass;
    }
    /**
     * Returns whether the Plant species object is not entirely dead
     * 
     * @return true if the Plant species is non-extinct, false otherwise
     */
    public boolean isAlive()
    {
        return isAlive;
    }
    
    /**
     * Increases the mass of the Plant species object over one day, unless it 
     *  reaches the maximum mass, in which case the mass is set to the mass is set
     *  to the maxiumum mass
     */
    public void grow()
    {
        speciesMass += relativeGrowthRate;
        if( speciesMass > maxSpeciesMass )
            speciesMass = maxSpeciesMass;
    }
    /**
     * When a plant is eaten, reduces its mass by the amount eaten. If the amount
     *  eaten is more than the total mass of the Plant species object, kills the
     *  plant
     *  
     *  @param amountEaten the mass of the Plant eaten
     */
    public void reduce( double amountEaten )
    {
        speciesMass -= amountEaten;
        if( speciesMass < 0 )
            isAlive = false;
    }
    
    /**
     * Returns the type of the Plant species as a String
     * 
     * @return the type of Plant species
     */
    public abstract String getType();
}
