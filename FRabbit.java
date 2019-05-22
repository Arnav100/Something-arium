
/**
 * Write a description of class FRabbit here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class FRabbit extends Rabbit implements Female
{
    private static int totalLitters = 0;
    private static int totalBorn = 0;
    private static final int MAX_LITTER_SIZE = 7;
    private static final int LITTER_SIZE = 4;
    private final int WEANING_AGE = 18;
    private final int GESTATION_DURATION = 43;
    private final int INTERBIRTH_INTERVAL = 25;
    private boolean isPregnant;
    
    /**
     * Constructor for objects of class FGoat
     */
    public FRabbit()
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
                litter[i] = new FRabbit();
            else
                litter[i] = new Rabbit();
        return litter;
    }
}
