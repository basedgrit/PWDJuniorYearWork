
/**
 * Write a description of class RecScarf here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import objectdraw.*;
import java.awt.*;

public class RecScarf extends WindowController
{
    private final static int CIRCLE_WIDTH = 12;
    private final static int CIRCLE_HEIGHT = 12;
    private final static int CIRCLE_SPACING = -4;
    private final static int CIRCLES_PER_ROW = 12;
    private final static int MAX_ROWS = 40;
    boolean doubleClick = false; 
    //private final static int ROW_NUMBER = 0;
    public void onMouseClick(Location Point) {
        if(doubleClick == false){
            drawScarf();
            
        } else {
            drawPyramid();
        }
    }
    public void drawScarf (){
        canvas.clear();
            FramedOval currentCircle;
            int nextCircleX = 25;
            int nextCircleY = 25;
            for(int numRows = 0; numRows <MAX_ROWS; numRows++) {
                nextCircleX = 50;
                for(int numCircles = 0; numCircles < CIRCLES_PER_ROW; numCircles++){
                    currentCircle = new FramedOval(nextCircleX, nextCircleY, CIRCLE_WIDTH, CIRCLE_HEIGHT, canvas);
                    nextCircleX += CIRCLE_WIDTH + CIRCLE_SPACING;

                }
                nextCircleY += CIRCLE_HEIGHT + CIRCLE_SPACING;
            } 
            doubleClick = true;
    }
    public void drawPyramid(){
        canvas.clear();
            FramedOval currentCircle;
            int nextCircleX = 25;
            int nextCircleY = 25;
            int ROWS = 8;
            int Circles_In_Row = 1;
            int MAX = 15;
            for(int numRows = 1; numRows <= ROWS; numRows++){
                nextCircleX = 50;

                for(int numCircles = 0; numCircles < numRows ; numCircles++){
                    currentCircle = new FramedOval (nextCircleX, nextCircleY,  CIRCLE_WIDTH, CIRCLE_HEIGHT, canvas);
                    nextCircleX += CIRCLE_WIDTH + CIRCLE_SPACING;
                  
                }
                doubleClick = false;
                nextCircleY += CIRCLE_HEIGHT + CIRCLE_SPACING;
            }
           for(int numRows = 8; numRows >= 0; numRows--){
                nextCircleX = 50;

                for(int numCircles = 0; numCircles <= numRows ; numCircles++){
                    currentCircle = new FramedOval (nextCircleX, nextCircleY,  CIRCLE_WIDTH, CIRCLE_HEIGHT, canvas);
                    nextCircleX += CIRCLE_WIDTH + CIRCLE_SPACING;
                  
                }
                doubleClick = false;
                
                nextCircleY += CIRCLE_HEIGHT + CIRCLE_SPACING;
            } 
    }
}

