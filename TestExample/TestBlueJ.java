 // Always include this line
import objectdraw.*;

/**
 * Write a description of class TestBlueJ here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
//For now all of your classes will extend WindowController
public class TestBlueJ extends WindowController
{
    // instance variables - also known as an object property
    private int x;
    private Text label;

    /**
     * Constructor for objects of class TestBlueJ
     * Alice didn't allow you to create objects except in scene setup
     * Java lets you create objects whenever you want to.
     */
    
    
    //This is an event method that basically is equivalent to myFirstMethod
    // It runs after WindowController creates the window but before any other events.    
    public void begin()
    {
        
        label = new Text("This is a text box",0,0,canvas);
        //This resizes the window, you can also change the settings on 
        //    Invoker under preferences-> extensions  
        resize(800,400);
    }
    
    //This is another event method among others.
    public void onMousePress(Location p)
    {
        label.setText("You Pressed at ("+p.getX()+" , "+p.getY()+")");
    }
    
    public void onMouseDrag(Location p)
    {
        label.setText("You Dragged at ("+ p.getX()+" , "+p.getY()+")");   
    }
    
    public void onMouseRelease(Location p)
    {
        label.setText("You Released at ("+p.getX()+" , "+p.getY()+")");
    }
    
    public void onMouseExit(Location p)
    {
        label.setText("You Exited at ("+p.getX()+" , "+p.getY()+")");
    }
    
    public void onMouseEnter(Location p)
    {
        label.setText("You Enter at ("+p.getX()+" , "+p.getY()+")");
    }
    
    public void onMouseMove(Location p)
    {
        label.setText("You moved to ("+p.getX()+" , "+p.getY()+")");
    }
    
    public void onMouseClick(Location p)
    {
        label.setText("You Clicked at ("+p.getX()+" , "+p.getY()+")");
    }
    
}
