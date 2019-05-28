/**
 * Creates Female Animal objects of type Jackal
 *
 * @author Gabe Robare, Arnav Parashar, and Dana Nigrin
 * @version May 27, 2019
 */
public class FJackal extends Jackal implements Female
{
    private static int totalLitters = 0;
    private static int totalBorn = 0;
    private final int MAX_LITTER_SIZE = 8;
    private final int LITTER_SIZE = 4;
    private final int GESTATION_DURATION = 63;
    private final int INTERBIRTH_INTERVAL = 365;
    private int pregStartAge;
    private boolean isPregnant;

    /**
     * Creates Female Jackal objects by calling the Jackal constructor
     */
    public FJackal()
    {
        super();
    }

    /**
     * Returns the gestation duration
     * 
     * @return the gestation duration
     */
    public int getGestationDuration()
    {
        return GESTATION_DURATION;
    }

    /**
     * Returns the interbirth interval
     * 
     * @return the interbirth interval
     */
    public int getInterbirthInterval()
    {
        return INTERBIRTH_INTERVAL;
    }

    /**
     * Returns whether the individual is past its fertile age
     * 
     * @return true if the animal is older than its fertile age, false otherwise
     */
    public boolean isFertile()
    {
        return getDaysAlive() >= getFertileAge();
    }

    /**
     * Returns whether the individual is pregnant
     * 
     * @return true if the individual is pregnant, false otherwise
     */
    public boolean isPregnant()
    {
        return isPregnant;
    }

    /**
     * If the individual is not already pregnant, is fertile, and enough time has
     *  passed since its last pregnancy, makes the individual pregnant
     */
    public void startPregnancy()
    {
        if( !isPregnant && isFertile() && 
        getDaysAlive() > pregStartAge + getInterbirthInterval() + 
        getGestationDuration() )
        {
            pregStartAge = getDaysAlive();
            isPregnant = true;
        }
    }

    /**
     * Creates an array of new individuals as offspring to a pregnant individual
     * 
     * @return the array of new individuals, based on the average litter size
     */
    public Animal[] reproduce()
    {
        if( !isPregnant )
            startPregnancy(); 
        else if( getDaysAlive() > getGestationDuration() + pregStartAge )
        {
            int size;
            if( totalLitters == 0 )
                size = (int)( ( MAX_LITTER_SIZE + 1 ) * Math.random() );
            else if( 1.0 * totalBorn / totalLitters < LITTER_SIZE )
                size = (int)( ( MAX_LITTER_SIZE - LITTER_SIZE ) * Math.random() +
                                LITTER_SIZE + 1 );
            else
                size = (int)( LITTER_SIZE * Math.random() );
            Animal[] litter = new Animal[ size ];
            for( int i = 0; i < size; i++ )
                if( Math.random() < .5 )
                    litter[ i ] = new FJackal();
                else
                    litter[ i ] = new Jackal();
            isPregnant = false;
            return litter;
        }
        return null;
    }
}