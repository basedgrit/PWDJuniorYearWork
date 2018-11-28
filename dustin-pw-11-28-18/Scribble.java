
/**
 * Write a description of class hf here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import objectdraw.*;
import java.awt.*;

// This program allows its user to draw simple lines on the screen
// using the mouse as if it were a pencil.
public class Scribble extends WindowController {
    
    private Location previousPosition;   // Last known position of mouse
    private Boolean drawMode = true;
    private Text mode;
    
    
    public void begin()
    {
        mode = new Text ("",0,0,canvas);
        mode.sendToFront();
    }
    // When the mouse button is depressed, note its location
    public void onMousePress( Location pressPoint) {
        previousPosition = pressPoint;
        
    }   
    
    public void onMouseClick(Location point)
    {
        if( drawMode == true){
            drawMode = false;
            mode.setText("Erase Mode");
        }else{
            drawMode= true;
            mode.setText("Draw Mode");
        }
    
    }
    // Connect current and previous mouse positions with a line
    public void onMouseDrag( Location currentPosition) {
        mode.sendToFront();
        FilledOval myOval;
        double pointX = currentPosition.getX();
        double pointY = currentPosition.getY();
        if(drawMode == true){
            mode.sendToFront();
            new Line( previousPosition, currentPosition, canvas);
            previousPosition = currentPosition;
            
        }else{
            myOval = new FilledOval (pointX - 10, pointY - 10,20/2,20 , canvas);
            myOval.setColor(Color.WHITE);
             previousPosition = currentPosition;
        }
        
    }

}
