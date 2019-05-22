
/**
 * Abstract class Animal - write a description of the class here
 *
 * @author (your name here)
 * @version (version number or date here)
 */
public abstract class Animal implements Organism
{
    private int age;
    private int maxAge;
    private double mass;
    private double maxMass;
    private boolean isAlive;
    private int daysAlive;
    private int fertileAge;
    private final double STARVATION_DECREASE = 0.05;
    private double hunger; 
    
    private final int DAYS_FOR_STARVATION = 2;
    
    private static char nameChar = 'a';
    public String name;
    public Animal(double startingMass, double maxMass, int maxAge)
    {
        this.mass = startingMass;
        this.maxMass = maxMass;
        this.maxAge = maxAge;
        this.isAlive = true;
        daysAlive = -1;
        hungerReset();
        name = "" + nameChar;
        nameChar++;
    }
    
    public void birthday()
    {
        age++;
    }
    
    public int getAge(int age)
    {
        return age;
    }
    
    public void eat(Organism food)
    {
        if(food == null)
        {
            this.mass -= STARVATION_DECREASE * mass;
            hunger = 0;
        }
        double mass = food.getMass();
        if(food instanceof Plant)
        {
            Plant plantFood = (Plant) food;
            if(hunger < mass*0.1)   //If the plant has more mass than the animal can eat, just eat how much it needs
            {
                feed(hunger);
                plantFood.reduce(hunger*10);
            }
            else //If the plant isn't more than it can eat, eat it all
            {
                feed(mass);
                plantFood.reduce(mass);
            }
        }
        //If it is an animal, just eat it
        feed(mass);
    }
    
    private void feed(double mass)
    {
        if(!isHungry())
            return;
        this.mass += mass*0.1; //Incorporate the 10% trophic efficiency into the code for eating plant above
        hunger -= mass;
        if(mass > maxMass)
            mass = maxMass;
    }
    
    public void hungerReset()
    {
        daysAlive ++;
        if(daysAlive < fertileAge)
           hunger = maxMass/fertileAge;
        
        hunger = 0.1 * mass;
        
    }
    
    public boolean isHungry()
    {
        return hunger > 0;
    }
    
    public double getMass()
    {
        return mass;
    }
    
    public void die()
    {
        isAlive = false;
    }
    
    public boolean isAlive()
    {
        return isAlive;
    }
    
    public abstract String getType();
    
    public abstract String[] getFoodTypes();
}
