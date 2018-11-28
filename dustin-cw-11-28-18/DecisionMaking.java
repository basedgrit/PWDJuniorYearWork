
/**
 * Write a description of class DecisionMaking here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import objectdraw.*;
import java.awt.*;
/**
 * A voting Program.
 */
public class DecisionMaking extends WindowController
{
   private double midX;
 private Text display;
 private FilledRect myRect;
 private boolean rectanglePressed = false;
 private Location prevPoint;
 
  public void begin()
 {
    midX = canvas.getWidth()/2;
   myRect = new FilledRect(100, 100, 30, 70, canvas);
   display = new Text ("Nothing clicked Yet", 50, 50, canvas);
 }
 
 public void onMousePress(Location point)
 {
    if(myRect.contains(point))
    {
      rectanglePressed = true;
      prevPoint = point;
      //Inside the Rectangle  
    }else {
    //Outside the Rectangle
    rectanglePressed = false;
    }
    
 }
 
 public void onMouseDrag(Location point)
 {
     double dx;
     double dy;
   
     if(rectanglePressed)
     {
         dx = point.getX() - prevPoint.getX();
         dy = point.getY() - prevPoint.getY();
         myRect.move(dx, dy);
         prevPoint = point;
     }
 }
    
}
