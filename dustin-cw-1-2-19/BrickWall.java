/**
 * A demonstration of using repetition (while loops) in drawing.
 */

import objectdraw.*;
import java.awt.*;

public class BrickWall extends WindowController
{
    // Define sizes and spacing for the bricks
    private final static int BRICK_WIDTH = 30;
    private final static int BRICK_HEIGHT = 15;
    private final static int BRICK_SPACING = 3;
    private final static int BRICKS_PER_ROW = 10;
    private final static int MAX_ROWS = 5;

    // Keep track of where the next brick should go
    //private int nextBrickX = 25;
    //private int nextBrickY = 25;
    //private int numBricks = 0;
    //private int numRows = 0;

    // When the mouse is clicked, draw the next brick
    public void onMouseClick(Location point) {
        FilledRect currentBrick;
        int nextBrickX = 25;
        //int numBricks = 0;
       //int numRows = 0;
        int nextBrickY = 25;
        for(int numRows = 0; numRows < MAX_ROWS; numRows++) {
            
             //numBricks = 0;
             nextBrickX = 25;
            //Draw one row of bricks
            for(int numBricks = 0; numBricks < BRICKS_PER_ROW; numBricks++) {
    
                // draw a single red brick
                currentBrick = new FilledRect(nextBrickX, nextBrickY, BRICK_WIDTH, BRICK_HEIGHT, canvas);        
                currentBrick.setColor(Color.RED);
    
                // Update the next brick's coordinates
                // nextBrickX = nextBrickX + BRICK_WIDTH + BRICK_SPACING;
                nextBrickX += BRICK_WIDTH + BRICK_SPACING;
                
                // Increment brick counter
                //numBricks++;
            }
               
                nextBrickY += BRICK_HEIGHT + BRICK_SPACING;
               //numRows++;
    }
    
}
}