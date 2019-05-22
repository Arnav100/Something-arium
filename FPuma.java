
/**
 * Write a description of class FPuma here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class FPuma extends Puma implements Female
{
    private static int totalLitters = 0;
    private static int totalBorn = 0;
    private final int MAX_LITTER_SIZE = 6;
    private final int LITTER_SIZE = 3;
    private final int WEANING_AGE = 730;
    private final int GESTATION_DURATION = 91;
    private final int INTERBIRTH_INTERVAL = 730;
    private int pregStartAge;
    private boolean isPregnant;
    
    /**
     * Constructor for objects of class FGoat
     */
    public FPuma()
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
    
    public void startPregnancy()
    {
        if(!isPregnant && isFertile() && getDaysAlive() > pregStartAge + getInterbirthInterval() + getGestationDuration()  )
        {
            pregStartAge = getDaysAlive();
            isPregnant = true;
        }
    }
    
    public boolean isFertile()
    {
        return getDaysAlive() > getFertileAge();
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
                litter[i] = new FPuma();
            else
                litter[i] = new Puma();
        return litter;
    }
}
