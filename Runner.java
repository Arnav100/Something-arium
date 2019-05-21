
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
    public static void main()
    {
        UI ui = new UI();
        animals = ui.getAnimals();
        plants = ui.getPlants();
        printHunger();
        for(int i = 0; i< 3; i ++)
        {
            feedingTime();
            printHunger();
            newDay();
        }
        /*
         * Things to ask:
         * 1. Are we allowed to have array of ArrayLists
         * 2. If an object is used outside of the array, will the reference inside the array be changed?
         * 
         * Add how well hunters are, each one their own level of goodness
         */
    }

    private static void newDay()
    {
         for(Animal[] group : animals)
            for(Animal a : group)
                a.hungerReset();
    }
    
    private static void printHunger()
    {
        for(Animal[] group : animals)
        {
            for(Animal a : group)
            {
                String message = (!a.isAlive() ? " is dead " : " is " + (a.isHungry() ? "" : " not ") + " hungry and has a mass of " 
                + a.getMass());
                System.out.println(a.getType() + " " + a.name + message);
            }
            System.out.println("\n");
         }
    }

    
    private static void feedingTime()
    {
            //idea of using leftOvers by keeping a variable set in outer loop
        for(int i = 0; i < animals.length; i ++)
        {
            inner: for(int j = 0; j < animals[i].length; j++)
            {
                if(!animals[i][j].isAlive())
                    continue;
                while(animals[i][j].isHungry())
                {
                    String[] foodChoices = animals[i][j].getFoodTypes();
                    int choice = (int)(Math.random() * foodChoices.length);
                    int[] mealLocation = findFood(foodChoices[choice], animals[i][j].getType());

                    if(mealLocation == null)
                        animals[i][j].eat(null);
                    else if(mealLocation.length == 1) //If it is a plant, eat it, and register how much you ate
                    {
                        double massEaten = animals[i][j].eat(plants[mealLocation[0]]);
                        plants[mealLocation[0]].reduce(massEaten);
                    }
                    else if(mealLocation.length == 2) //If it is an animal, eat it and kill it
                    {
                        animals[i][j].eat(animals[ mealLocation[0] ][ mealLocation[1] ]);
                        animals[ mealLocation[0] ][ mealLocation[1] ].die();
                    }
                }
            }   
        }
    }
    private static int[] findFood(String food, String animalSearching)
    {
        for(int i = 0; i < plants.length; i ++)
            if(plants[i].getType().equals(food))
                return new int[]{i};
        for(int i = 0; i < animals.length; i ++)
            for(int j = 0; j < animals[i].length; j++)
                if(animals[i][j].isAlive() && animals[i][j].getType().equals(food))
                    return new int[]{i, j};
        System.out.println("ERROR: " + food + " NOT FOUND AS FOOD FOR " + animalSearching);  //Or all creatures are dead
        return null;
    }

}
