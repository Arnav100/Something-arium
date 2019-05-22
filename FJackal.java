
/**
 * Write a description of class FJackal here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class FJackal extends Jackal implements Female
{
    private static int totalLitters = 0;
    private static int totalBorn = 0;
    private final int MAX_LITTER_SIZE = 8;
    private final int LITTER_SIZE = 4;
    private final int WEANING_AGE = 56;
    private final int GESTATION_DURATION = 63;
    private final int INTERBIRTH_INTERVAL = 365;
    private boolean isPregnant;
    
    /**
     * Constructor for objects of class FGoat
     */
    public FJackal()
    {
        super();
    }

    public int getWeaningAge()
    {
        return WEANING_AGE;
    }
    
    public int getGestationDuration()
    {
        return GESTATION_DURATION;
    }
    
    public int getInterbirthInterval()
    {
        return INTERBIRTH_INTERVAL;
    }
    
    public boolean isPregnant()
    {
        return isPregnant;
    }
    
    /**
     * 
     */
    public Animal[] reproduce()
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
                litter[i] = new FJackal();
            else
                litter[i] = new Jackal();
        return litter;
    }
}
