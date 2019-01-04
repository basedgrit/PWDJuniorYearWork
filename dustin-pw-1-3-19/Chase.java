import objectdraw.*;
import java.awt.*;

public class Chase extends WindowController
{
    private static final double TIME_LIMIT = 1.5;  // time available to click                                             
    
    private FunnyFace funFace;           // funny face to be chased
    
    private Timer stopWatch;             // Timer to see if click fast enough
    
    private Text infoText;               // Text item to be displayed during game
    
    private RandomIntGenerator randXGen, // generators to get new x and
                               randYGen; // y coords
    
    private boolean playing;             // Is player playing or waiting to start
    
    // Set up timer and funny face for game
    public void begin() {
        stopWatch = new Timer();
        randXGen = new RandomIntGenerator( 0, canvas.getWidth() );
        randYGen = new RandomIntGenerator( 0, canvas.getHeight() );
        funFace = new FunnyFace( canvas.getWidth()/2, canvas.getHeight()/3, canvas );
        infoText = new Text( "Click to start chasing the FunnyFace.", 
                             canvas.getWidth()/3, canvas.getHeight()/2, canvas);         
        playing = false;
    }
    
    // Determine if user won and move funny face if necessary
    public void onMouseClick(Location pt) {
        Location randLocation = new Location(randXGen.nextValue(),  randYGen.nextValue());
        if (!playing) {                           // Start playing
            playing = true;
            infoText.setText("Click quickly on the FunnyFace to win!");
            funFace.moveTo(randLocation );
            stopWatch.reset();
        }
        else if (!funFace.contains(pt)) {         // missed the funny face
            infoText.setText("You missed!");
            funFace.moveTo( randLocation );
            stopWatch.reset();
            funFace.setColorMiss();
            
        }
        else if (stopWatch.elapsedSeconds() <= TIME_LIMIT) {  // got it in time
            playing = false;
            
            funFace.setColorHit();
            infoText.setText("You got the face in time.  Click to restart.");
        }
        else {                                    // User was too slow
            infoText.setText("Too slow!");
            funFace.moveTo(randLocation );
            stopWatch.reset();
        }
    }
}    