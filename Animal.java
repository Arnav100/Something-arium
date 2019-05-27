
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
    private double startingMass;
    private double maxMass;
    private boolean isAlive;
    private int daysAlive;
    private int fertileAge;
    private int weaningAge;
    private final double STARVATION_DECREASE = 0.05;
    private double hunger; 
    
    private final int DAYS_FOR_STARVATION = 30;
    private int starvingDays;
    private static char nameChar = 'a';
    private static int nameLength = 1;
    public String name;
    
    public Animal(double startingMass, double maxMass, int maxAge, int fertileAge, 
    int weaningAge)
    {
        this.mass = startingMass;
        this.startingMass = startingMass;
        this.maxMass = maxMass;
        this.maxAge = maxAge;
        this.fertileAge = fertileAge;
        this.weaningAge = weaningAge;
        this.isAlive = true;
        starvingDays = 0;
        daysAlive = -1;
        newDay();
        giveName();
    }
    
    private void giveName()
    {
        // name = "";
        // for(int i = 0; i < nameLength; i++)
            // name += nameChar;
        // nameChar++;
        // if(nameChar > 'z')
        // {
            // nameChar = 'a';
            // nameLength++;
        // }
        name = "" + nameLength++;
    }
    public void birthday()
    {
        age++;
    }
    
    public int getAge(int age)
    {
        return age;
    }
    
    public int getDaysAlive()
    {
        return daysAlive;
    }
    
    public void eat(Organism food)
    {
        if(daysAlive < weaningAge)
        {
            feed(hunger);
            return;
        }
        if(food == null)
        {
            this.mass -= STARVATION_DECREASE * mass;
            hunger = 0;
            starvingDays++;
            return;
        }
        double mass = food.getMass();
        if(food instanceof Plant)
        {
            
            Plant plantFood = (Plant) food;
            if(hunger < mass)   //If the plant has more mass than the animal can eat, just eat how much it needs
            {
                
             //   System.out.println("mass is " +mass+ " A. About to Eat " + hunger + " of plant " + plantFood.getType() + " for " + getType());
         //    System.out.println("a");   
             plantFood.reduce(hunger*10);
                feed(hunger);
            }
            else //If the plant isn't more than it can eat, eat it all
            {
            //   System.out.println("b");  
            //    System.out.println("B. About to Eat " + mass + " of plant " + plantFood.getType());
                plantFood.reduce(mass);
                 feed(mass);
            }
            return;
        }
        //If it is an animal, just eat it
        feed(mass);
        ((Animal) food).die();
    }
    
    private void feed(double mass)
    {
        if(!isHungry())
            return;
      //  System.out.println(getType() + " is about to eat " + mass);
        if(mass > hunger)
            this.mass += hunger*0.1;
        else
            this.mass += mass*0.1; //Incorporate the 10% trophic efficiency into the code for eating plant above
        hunger -= mass;
        if(mass > maxMass)
            mass = maxMass;
    }
    
    public void newDay()
    {
        
        daysAlive ++;  
        hunger = ((maxMass-startingMass)/fertileAge)*10; //has to eat 10 times the slope, in order to increase in mass by the slope
        if(starvingDays >= DAYS_FOR_STARVATION)
            die();
        if(daysAlive / 365 >= maxAge)
            die();
    }
    
    public boolean isHungry()
    {
       // System.out.println("Checking hunger: " + hunger + " for " + getType());
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
    
    public void becomeAdult()
    {
        daysAlive = fertileAge;
        mass += ((maxMass-startingMass)/fertileAge) * fertileAge;
    }
    
    public int getFertileAge()
    {
        return fertileAge;
    }
    
    public abstract String getType();
    
    public abstract String[] getFoodTypes();
}
