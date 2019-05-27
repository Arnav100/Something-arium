import java.util.concurrent.TimeUnit;
/**
 * Write a description of class Runner here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Runner
{
    private static Animal[][] animals;
    private static Plant[] plants;
    private static boolean[] extincts;
    private static boolean allExtinct;
    public static void main()
    {
        UI ui = new UI();
        animals = ui.getAnimals();
        plants = ui.getPlants();
        extincts = new boolean[animals.length];
        allExtinct = false;
       // printHunger();
     //   fertilityTest();
        for(int i = 0; !allExtinct; i ++)
        {
    
            feedingTime();
            reproduce();
         
            checkExtincts();
            if(allExtinct)
            {
                System.out.println("All died at day " + i);
                break;
            }
            if(i % 50 == 0)
            {
                printHunger();
                printPlantMass();
            }
            newDay();
        }
         printHunger();
        printPlantMass();

    }
    private static void checkExtincts()
    {
        boolean allPopsDead = true;
        for(int i = 0; i < animals.length; i++)
        {
            if(extincts[i])
                continue;
            boolean allDead = true;
            for(Animal a : animals[i])
                if(a.isAlive())
                    allDead = false;
            extincts[i] = allDead;
            if(!allDead)
                allPopsDead = false;
        }
        allExtinct = allPopsDead;
    }
    
    //Can delete this later
    private static void printAges()
    {
         System.out.println("\n");
         for(Animal[] group : animals)
            for(Animal a : group)
                if(a instanceof Female)
                System.out.println(a.getType() + " " + a.name + " is female and is " + a.getDaysAlive());
    }
    
    private static void newDay()
    {
         for(Animal[] group : animals)
            for(Animal a : group)
                a.newDay();
    }
    
    private static void printPlantMass()
    {
        for(Plant p : plants)
            System.out.println(p.getMass());
    }
    
    private static void printHunger()
    {
        for(Animal[] group : animals)
        {
            int aliveAmount = 0;
            int total = 0;
            String type = "";
            for(Animal a : group)
            {
                // String message = (!a.isAlive() ? " is dead " : " is " + (a.isHungry() ? "" : " not ") + " hungry and has a mass of " 
                // + String.format(" %.2f", a.getMass()));
                // System.out.println(a.getType() + " " + a.name + message);
                total++;
                type = a.getType();
                if(a.isAlive())
                    aliveAmount ++;
            }
            System.out.println(type +" has " + aliveAmount + " alive out of " + total);
            System.out.println("\n");
         }
    }

    private static void fertilityTest()
    {
         for(Animal[] group : animals)
         {
            int total = 0;
            int females = 0;
            String type = "";
            for(Animal a : group)
            {
                type = a.getType();
                if(a instanceof Female)
                {
                    if(((Female) a ).isFertile())
                        total++;
                    females++;
                }
            }
            System.out.println("There are " + total +" Fertile females out of " + females + " for " + type);
          }
    }
    
    private static void reproduce()
    {
      
        for(int i = 0; i < animals.length; i ++)
        {
            int length = animals[i].length;
            if(extincts[i])
                continue;
            for(int j = 0; j < length; j++)
                if(animals[i][j].isAlive() && animals[i][j] instanceof Female)
                    animals[i] = adjustArray(((Female) animals[i][j]).reproduce(), animals[i]);
         
                
         }
    }
    
    private static Animal[] adjustArray(Animal[] babies, Animal[] population)
    {
        if(babies == null)
            return population;
        Animal[] newPop = new Animal[babies.length + population.length];
        for(int i = 0; i < newPop.length; i ++)
            if(i < population.length)
                newPop[i] = population[i];
            else 
                newPop[i] = babies[i - population.length];
        
        return newPop;
                
    }
    private static void feedingTime()
    {
            //idea of using leftOvers by keeping a variable set in outer loop
        for(int i = 0; i < animals.length; i ++)
        {
            if(extincts[i])
                continue;
            inner: for(int j = 0; j < animals[i].length; j++)
            {
                if(!animals[i][j].isAlive())
                    continue;
                while(animals[i][j].isHungry())
                {
                    String[] foodChoices = animals[i][j].getFoodTypes();
                    int choice = (int)(Math.random() * foodChoices.length);
                    Organism meal = findFood(foodChoices[choice], animals[i][j].getType());
                    animals[i][j].eat(meal);
                    // if(meal != null)
                    // System.out.println(meal.getType() + " Meal is " + meal.isAlive());
                }
            }   
        }
    }
    private static Organism findFood(String food, String animalSearching)
    {
        for(int i = 0; i < plants.length; i ++)
            if(plants[i].isAlive() && plants[i].getType().equals(food) )
                return plants[i];
        for(int i = 0; i < animals.length; i ++)
            for(int j = 0; j < animals[i].length; j++)
                if(animals[i][j].isAlive() && animals[i][j].getType().equals(food))
                    return animals[i][j];
       // System.out.println("ERROR: " + food + " NOT FOUND AS FOOD FOR " + animalSearching);  //Or all creatures are dead
        return null;
    }

}
