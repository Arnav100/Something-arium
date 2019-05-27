
/**
 * Abstract class Plant - write a description of the class here
 *
 * @author (your name here)
 * @version (version number or date here)
 */
public abstract class Plant implements Organism
{
    private double plantDensity;
    private double speciesMass; 
    private double relativeGrowthRate;
    private double maxSpeciesMass;
    private double maxIndiviualMass;
    private boolean isAlive;
    
    public Plant( double maxIndiviualMass, double plantDensity, double relativeGrowthRate,
    double acres )
    {
        this.plantDensity = plantDensity;
        this.relativeGrowthRate = relativeGrowthRate;
        this.maxIndiviualMass = maxIndiviualMass;
        this.maxSpeciesMass = acres * plantDensity * maxIndiviualMass;
        this.speciesMass = maxSpeciesMass;
        isAlive = true;
    }

    public void grow()
    {
        speciesMass += relativeGrowthRate;
        if(speciesMass > maxSpeciesMass)
         speciesMass = maxSpeciesMass;
    }
    
    public void reduce( double amountEaten )
    {
        speciesMass -= amountEaten;
      //  System.out.println("Amount eaten: " + amountEaten + "New Species mass " + speciesMass + "for " + getType());
        if(speciesMass < 0)
            isAlive = false;
    }
   
    public double getMass()
    {
        return speciesMass;
    }
    
    public boolean isAlive()
    {
        return isAlive;
    }
    
    public void printMass(String name)
    {
        System.out.println("Mass of " + name + " is " + speciesMass);
    }
    
    public abstract String getType();
    
}
