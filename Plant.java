
/**
 * Abstract class Plant - write a description of the class here
 *
 * @author (your name here)
 * @version (version number or date here)
 */
public abstract class Plant 
{
    private double plantDensity;
    private double speciesMass; 
    private double relativeGrowthRate;
    private double maxSpeciesMass;
    private double maxIndiviualMass;
    public Plant(int maxIndiviualMass, double plantDensity, double relativeGrowthRate, double acres)
    {
        this.plantDensity = plantDensity;
        this.relativeGrowthRate = relativeGrowthRate;
        this.maxIndiviualMass = maxIndiviualMass;
        this.maxSpeciesMass = acres * plantDensity * maxIndiviualMass;
        this.speciesMass = maxSpeciesMass;
    }

    public void grow()
    {
        speciesMass += relativeGrowthRate;
        if(speciesMass > maxSpeciesMass)
         speciesMass = maxSpeciesMass;
    }
    
    public void reduce(double amountEaten)
    {
        speciesMass -= amountEaten;
    }
   
    public double getMass()
    {
        return speciesMass;
    }
    
    public void printMass(String name)
    {
        System.out.println("The mass of the "+name+" are: " + getMass());
    }
}
