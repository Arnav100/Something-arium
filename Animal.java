
/**
 * Abstract class Animal - write a description of the class here
 *
 * @author (your name here)
 * @version (version number or date here)
 */
public abstract class Animal
{
    private int age;
    private int maxAge;
    private double mass;
    private double maxMass;
    private boolean isAlive;
    
    public Animal(double startingMass, double maxMass, int maxAge)
    {
        this.mass = startingMass;
        this.maxMass = maxMass;
        this.maxAge = maxAge;
        this.isAlive = true;
    }
    
    public void birthday()
    {
        age++;
    }
    
    public int getAge(int age)
    {
        return age;
    }
    
    public void eat(double mass)
    {
        this.mass += mass;
        if(mass > maxMass)
            mass = maxMass;
    }
    
    public void die()
    {
        isAlive = false;
    }
    
    public abstract String getType();
    
    public abstract String[] getFoodTypes();
}
