import java.util.Scanner;
/**
 * Receives input data from the user and creates arrays of Organisms
 *
 * @author Gabe Robare, Arnav Parashar, and Dana Nigrin
 * @version May 27, 2019
 */
public class UI
{
    private Animal[][] animals;
    private Plant[] plants;
    private final int NUM_ANIMALS = 6;
    private final int NUM_PLANTS = 3;
    
    /**
     * Constructor for objects of class UI. Prints an interface into which users 
     * enter initial data
     */
    public UI()
    {
        Scanner in = new Scanner( System.in );
        
        System.out.println( "Please enter a starting population number for each " 
            + "of the following:" + "\n\n" );
        animals = new Animal[ NUM_ANIMALS ][];
        String[] animalNames = { "Golden Jackal","Puma", "Great Horned Owl", 
            "Wild Goat", "Red-Tailed Hawk", "Black Tailed Rabbit" };
        for( int i = 0; i < animals.length; i++ )
        {
            System.out.print( animalNames[ i ] + ": " );
            animals[ i ] = new Animal[ in.nextInt() ];
            for(int j = 0; j < animals[ i ].length; j ++)
            {
                animals[ i ][ j ] = makeAnimal( animalNames[ i ] );
                animals[ i ][ j ].becomeAdult();
            }
            System.out.print( "\n" );
        }
        
        System.out.println( "Please enter a decimal starting acreage of coverage for each "
            + "of the following (note: 1 acre = 43,560 sqft, so start small):" + "\n\n" );
        plants = new Plant[ NUM_PLANTS ];
        String[] plantNames = { "Coyote Brush", "Blue Oak", "Mountain Mahogany" };
        for( int i = 0; i < plants.length; i++ )
        {
            System.out.print( plantNames[ i ] + ": " );
            plants[ i ] = makePlant( plantNames[ i ], in.nextDouble() );
            System.out.print( "\n" );
        }
        in.close();
    }
    private Animal makeAnimal( String type )
    {
        boolean isFemale = Math.random() < 0.5;
        switch( type )
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
        System.out.println( "ERROR: " + type + " NOT FOUND!" );
        return null;
    }
    private Plant makePlant( String type, double acres )
    {
        switch( type )
        {
            case "Coyote Brush":
                return new Brush( acres );
            case "Blue Oak":
                return new Oak( acres );
            case "Mountain Mahogany":
                return new Rose( acres );
        }
        System.out.println( "ERROR: " + type + " NOT FOUND!" );
        return null;
    }
    
    /**
     * Returns the array of species of Animals
     * 
     * @return the 2-D array of Animals, with each index containing an array 
     *  of the Animals of a certain species
     */
    public Animal[][] getAnimals()
    {
        return animals;
    }
    /**
     * Returns the array of Plant species objects
     * 
     * @return the array of Plants, with each index representing a species of 
     *  Plant
     */
    public Plant[] getPlants()
    {
        return plants;
    }
    
    /**
     * Prints the amount of living animals per population
     */
    public void printLiving()
    {
        for( Animal[] group : animals )
        {
            int aliveAmount = 0;
            int total = 0;
            String type = "";
            for( Animal a : group )
            {
                total++;
                type = a.getType();
                if( a.isAlive() )
                    aliveAmount++;
            }
            System.out.println( type + " has " + aliveAmount + " alive out of " 
                + total );
            System.out.println( "\n" );
        }
    }
    /**
     * Prints the mass of each plant species
     */
    public void printPlantMass()
    {
        for( Plant p : plants )
            System.out.println( p.getType() +" "+ p.getMass() );
    }
    /**
     * Prints the given string s
     * @param s the String to print
     */
    public void print(String s)
    {
        System.out.println(s);
    }
}
