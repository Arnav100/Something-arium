import java.util.Scanner;
/**
 * Receives input data from the user
 *
 * @author Gabe Robare
 * @version May 3, 2019
 */
public class UI
{
    private int[] animalPops;
    private int[] plantCovs;
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
        animalPops = new int[ NUM_ANIMALS ];
        String[] animalNames = { "Wild Goat", "Black Tailed Rabbit", "Great Horned Owl",
            "Red-Tailed Hawk", "Golden Jackal", "Puma" };
        for( int i = 0; i < animalPops.length; i++ )
        {
            System.out.print( animalNames[ i ] + ": " );
            animalPops[ i ] = in.nextInt();
            System.out.print( "\n" );
        }
        
        System.out.println( "Please enter a starting acreage of coverage for each of " +
        "the following (note: 1 acre = 43,560 sqft):" + "\n\n" );
        plantCovs = new int[ NUM_PLANTS ];
        String[] plantNames = { "Coyote Brush", "Blue Oak", "Mountain Mahogany" };
        for( int i = 0; i < plantNames.length; i++ )
        {
            System.out.print( plantNames[ i ] + ": " );
            plantCovs[ i ] = in.nextInt();
            System.out.print( "\n" );
        }
    }
    
    public void printMass( Plant plant, String name )
    {
        System.out.println("The mass of the " + name + " are: " + plant.getMass() );
    }
}
