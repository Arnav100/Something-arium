import java.util.Scanner;
/**
 * Receives input data from the user
 *
 * @author Gabe Robare
 * @version May 3, 2019
 */
public class UI
{
    private Animal[][] animals;
    private Plant[] plants;
    private final int NUM_ANIMALS = 6;
    private final int NUM_PLANTS = 3;
    
    /**
     * Constructor for objects of class UI; prints an interface into which users enter
     * initial data
     */
    public UI()
    {
        Scanner in = new Scanner( System.in );
        System.out.println( "Please enter a starting population number for each of the " +
        "following:" + "\n\n" );
        String[] animalNames = { "Golden Jackal","Puma", "Great Horned Owl", "Wild Goat",
            "Red-Tailed Hawk", "Black Tailed Rabbit" };
            
        animals = new Animal[NUM_ANIMALS][];
        for( int i = 0; i < animals.length; i++ )
        {
            System.out.print( animalNames[ i ] + ": " );
            animals[i] = new Animal[in.nextInt()];
            for(int j = 0; j < animals[i].length; j ++)
            {
                animals[i][j] = makeAnimal(animalNames[i]);
                animals[i][j].becomeAdult();
            }
            
            System.out.print( "\n" );
        }
        
        System.out.println( "Please enter a starting acreage of coverage for each of " +
        "the following (note: 1 acre = 43,560 sqft):" + "\n\n" );
        plants = new Plant[NUM_PLANTS];
        String[] plantNames = { "Coyote Brush", "Blue Oak", "Mountain Mahogany" };
        for( int i = 0; i < plants.length; i++ )
        {
            System.out.print( plantNames[ i ] + ": " );
            plants[ i ] = makePlant(plantNames[i], in.nextInt());
            System.out.print( "\n" );

        }        

    }
    
    public Animal makeAnimal(String type)
    {
        boolean isFemale = Math.random() < 0.5;
        switch(type)
        {
            case "Wild Goat": 
               return isFemale ? new FGoat() : new Goat();
            case "Black Tailed Rabbit":
                return isFemale ? new FRabbit() : new Rabbit();
            case "Great Horned Owl":
                return isFemale ? new FOwl() : new Owl();
            case "Red-Tailed Hawk":
                return isFemale ? new FHawk() : new Hawk();
            case "Golden Jackal":
                return isFemale ? new FJackal() : new Jackal();
            case "Puma":
                return isFemale ? new FPuma() : new Puma();
        }
        System.out.println("ERROR: " + type + " NOT FOUND!");
        return null;
    }
    
    public Plant makePlant(String type, int acres)
    {
        switch(type)
        {
            case"Coyote Brush":
                return new Brush(acres);
            case "Blue Oak":
                return new Oak(acres);
            case "Mountain Mahogany":
                return new Rose(acres);
        }
        System.out.println("ERROR: " + type + " NOT FOUND!");
        return null;
    }
    
    public Animal[][] getAnimals()
    {
        return animals;
    }
    
    public Plant[] getPlants()
    {
        return plants;
    }
    
    public void printMass( Plant plant, String name )
    {
        System.out.println("The mass of the " + name + " are: " + plant.getMass() );

    }
}
