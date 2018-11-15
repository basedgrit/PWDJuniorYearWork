
/**
 * Drawing Example
 * 
 * Dustin Bloom
 */
import objectdraw.*;
import java.awt.*;

public class DrawingExample extends WindowController
{
    private Location initialPoint;
    public void onMousePress(Location pressPoint)
    {
       //new Text ("Pressed", pressPoint , canvas);
       initialPoint = pressPoint; 
    }

    public void onMouseDrag(Location releasePoint)
    {
       //new Text ("Released", releasePoint , canvas);
       new Line(initialPoint, releasePoint, canvas);
        initialPoint = releasePoint;
    }
}
