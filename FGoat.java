
/**
 * Write a description of class FGoat here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class FGoat extends Goat implements Female
{
    private static int totalLitters = 0;
    private static int totalBorn = 0;
    private static final int MAX_LITTER_SIZE = 3;
    private static final int LITTER_SIZE = 1;
    
    /**
     * Constructor for objects of class FGoat
     */
    public FGoat()
    {
        super();
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
                litter[i] = new FGoat();
            else
                litter[i] = new Goat();
        return litter;
    }
}
