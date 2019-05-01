import java.util.Scanner;
/**
 * Write a description of class UI here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class UI
{
    private int[] animalPops;
    /**
     * Constructor for objects of class UI
     */
    public UI()
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter a starting population number" +
        "for each of the following:\n");
        animalPops = new int[3];
        String[] animalNames = {"Harlequin Duck", "Lemmings", "Musk Oxen"};
        for(int i = 0; i < animalPops.length; i++)
        {
            System.out.print(animalNames[i]+":");
            
        }
    }
    
    
}
