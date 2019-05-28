/**
 * Simulates the ecosystem based on the initial conditions from the user, until
 *  all Animals die
 *
 * @author Gabe Robare, Arnav Parashar, and Dana Nigrin
 * @version May 27, 2019
 */
public class Runner
{
    private static Animal[][] animals;
    private static Plant[] plants;
    private static boolean[] extincts;
    private static boolean allExtinct;
    /**
     * Runs methods to simulate the ecosystem until all Animals are extinct
     */
    public static void main()
    {
        UI ui = new UI();
        animals = ui.getAnimals();
        plants = ui.getPlants();
        extincts = new boolean[ animals.length ];
        allExtinct = false;

        for( int i = 0; !allExtinct; i++ )
        {
            feedingTime();
            reproduce();
            checkExtincts();
            if( allExtinct )
            {
                System.out.println( "All died at day " + i );
                break;
            }
            if( i % 50 == 0 )
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
        for( int i = 0; i < animals.length; i++ )
        {
            if( extincts[ i ] )
                continue;

            boolean allDead = true;
            for( Animal a : animals[ i ] )
                if( a.isAlive() )
                    allDead = false;
            extincts[ i ] = allDead;

            if( !allDead )
                allPopsDead = false;
        }
        allExtinct = allPopsDead;
    }
    private static void newDay()
    {
        for( Animal[] group : animals )
            for( Animal a : group )
                a.newDay();
    }
    private static void printPlantMass()
    {
        for( Plant p : plants )
            System.out.println( p.getMass() );
    }
    private static void printHunger()
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
    private static void fertilityTest()
    {
        for( Animal[] group : animals )
        {
            int total = 0;
            int females = 0;
            String type = "";
            for( Animal a : group )
            {
                type = a.getType();
                if( a instanceof Female )
                {
                    if( ( (Female) a ).isFertile() )
                        total++;
                    females++;
                }
            }
            System.out.println( "There are " + total +" Fertile females out of " 
                + females + " for " + type );
        }
    }

    private static void reproduce()
    {
        for( int i = 0; i < animals.length; i++ )
        {
            int length = animals[ i ].length;
            if( extincts[ i ] )
                continue;
            for( int j = 0; j < length; j++ )
                if(animals[ i ][ j ].isAlive() && 
                animals[ i ][ j ] instanceof Female)
                    animals[ i ] = 
                    adjustArray( ( (Female) animals[ i ][ j ] ).reproduce(), 
                        animals[i]);  
        }
    }
    private static Animal[] adjustArray( Animal[] babies, Animal[] population )
    {
        if( babies == null )
            return population;
        Animal[] newPop = new Animal[ babies.length + population.length ];
        for( int i = 0; i < newPop.length; i++ )
            if( i < population.length )
                newPop[ i ] = population[ i ];
            else 
                newPop[ i ] = babies[ i - population.length ];
        return newPop;
    }

    private static void feedingTime()
    {
        for( int i = 0; i < animals.length; i++ )
        {
            if( extincts[ i ] )
                continue;   
            for( int j = 0; j < animals[ i ].length; j++ )
            {
                if( !animals[ i ][ j ].isAlive() )
                    continue;
                while( animals[ i ][ j ].isHungry() )
                {
                    String[] foodChoices = animals[ i ][ j ].getFoodTypes();
                    int choice = (int)( Math.random() * foodChoices.length );
                    Organism meal = findFood( foodChoices[ choice ] );
                    animals[ i ][ j ].eat( meal );
                }
            }   
        }
    }
    private static Organism findFood( String food )
    {
        for( int i = 0; i < plants.length; i++ )
            if( plants[ i ].isAlive() && plants[ i ].getType().equals( food ) )
                return plants[ i ];
        for(int i = 0; i < animals.length; i ++)
            for(int j = 0; j < animals[ i ].length; j++)
                if( animals[ i ][ j ].isAlive() && 
                    animals[ i ][ j ].getType().equals( food ) )
                    return animals[ i ][ j ];
        return null;
    }
}