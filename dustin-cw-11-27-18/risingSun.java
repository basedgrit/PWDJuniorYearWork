
/**
 * RisingSun
 * Dustin Bloom
 */
import objectdraw.*;
import java.awt.*;
public class risingSun extends WindowController
{
    private FilledOval sun; 
    private Text instructions;
    private Location initialLocation = new Location (150,350);
    
    private final double RADIUS  =  100;
    //The begin method is called when the program starts
    public void begin()
    {
        //Create a circle at location (150, 350) with radius 100
        sun = new FilledOval (initialLocation, RADIUS, RADIUS ,canvas);
        Color myColor = new Color (0, 200, 255);
        sun.setColor(myColor);
        instructions = new Text ( " Please click the mouse repeatedly", 20, 20, canvas );
    }
    
    public void onMouseClick(Location point)
    {   
        sun.moveTo(sun.getX(), point.getY() - RADIUS / 2);
        instructions.hide();
    }
    
    public void onMouseExit (Location point)
    {
        sun.moveTo(initialLocation);
        instructions.show();
    }
}