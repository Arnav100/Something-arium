
/**
 * Write a description of class FOwl here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class FOwl extends Owl implements Female
{
    private static int totalLitters = 0;
    private static int totalBorn = 0;
    private final int MAX_LITTER_SIZE = 6;
    private final int LITTER_SIZE = 3;
    private final int GESTATION_DURATION = 35;
    private final int INTERBIRTH_INTERVAL = 91;
    private int pregStartAge;
    private boolean isPregnant;
    
    /**
     * Constructor for objects of class FGoat
     */
    public FOwl()
    {
        super();
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
        if(!isPregnant)
            startPregnancy(); 
        else if(getDaysAlive() > getGestationDuration() + pregStartAge)
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
                    litter[i] = new FOwl();
                else
                    litter[i] = new Owl();
            return litter;
        }   
        return null;
    }
}
