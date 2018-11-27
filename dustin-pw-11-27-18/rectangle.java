import objectdraw.*;
import java.awt.*;

// A program that displays the words "Pressed" and "Released"
// where the mouse button is pressed and released while connecting
// each such pair of points with a line.
public class rectangle extends WindowController{
    private FramedRect rectFrame; 
    private Location firstPoint; 
    private FilledRect rectFilled;
    private Text dimText;
    private Text coordsText;
    // The location where button was pressed
   //DrawingCanvas canvas;
        
    // Display "Pressed" when the button is pressed.
    public void begin(){
        //rectFrame = new FramedRect(0,0, hidden);
        dimText = new Text("",0,0,canvas);
        coordsText = new Text("(X,Y)",0,0,canvas);
        rectFrame = new FramedRect(0,0,0,0,canvas); 
        double coordsX = canvas.getWidth()/2 - coordsText.getWidth()/2;
        double coordsY = canvas.getHeight() - coordsText.getHeight();
        coordsText.moveTo(coordsX,coordsY);
       
    }
    
    public void onMouseMove (Location p)
    {
      double coordsX = canvas.getWidth()/2 - coordsText.getWidth()/2;
      double coordsY = canvas.getHeight() - coordsText.getHeight();
      coordsText.moveTo(coordsX,coordsY);
        
      double mouseCoordX = p.getX();
      double mouseCoordY = p.getY();
      coordsText.setText("( " + mouseCoordX + " , " + mouseCoordY + " )");
        
    }
    public void onMousePress(Location pressPoint){
        //new Text("Pressed", pressPoint, canvas);
        firstPoint = pressPoint;
        coordsText.setText("( " + pressPoint.getX() + " , " + pressPoint.getY() +" )");
        
        
        double mouseCoordX = pressPoint.getX();
        double mouseCoordY = pressPoint.getY();
        coordsText.setText("( " + mouseCoordX + " , " + mouseCoordY + " )");
        
    }
    
    public void onMouseDrag(Location dragPoint)
    { 
       canvas.clear();
       rectFrame = new FramedRect (firstPoint, dragPoint,  canvas);
       rectFrame.setColor(Color.BLUE);
       
       
        Text dimText = new Text("w " + rectFrame.getWidth() + " h " + rectFrame.getHeight(),0,0,canvas);
        
        double x = rectFrame.getX() + rectFrame.getWidth()/2 - dimText.getWidth()/2;
        double y = rectFrame.getY() + rectFrame.getHeight()/2 - dimText.getHeight()/2;
        dimText.moveTo(x,y);
        
         double mouseCoordX = dragPoint.getX();
        double mouseCoordY = dragPoint.getY();
        coordsText.setText("( " + mouseCoordX + " , " + mouseCoordY + " )");
        
        coordsText.addToCanvas(canvas);
    }
    
    public void onMouseExit(Location p)
    {
        canvas.clear();
        //coordsText.addToCanvas(canvas);
        begin();
        
    }
    // Display "Released" and draw a line from where the mouse
    // was last pressed.
    //public void onMouseRelease(Location releasePoint){
        //new Text("Released", releasePoint, canvas);
        //new Line(firstPoint, releasePoint, canvas);
      //  rectFilled = new FilledRect(firstPoint, releasePoint, canvas);
       // rectFilled.setColor(Color.BLUE);
    }
    
    
