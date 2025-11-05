package org.example;
import java.awt.*;

/**
 * Updates whether a square is alive (yellow) or dead (gray)
 * @author Amelia Harris and Isaac Lowe
 * @version 1.3
 */

public class LifeSquare {
    private boolean isAlive;
    private Color lifeColor;

    public LifeSquare(){
        isAlive = false;
        lifeColor = Color.GRAY;
    }
    public void setAlive(boolean isAlive) {
        this.isAlive = isAlive;
        if(isAlive){
            lifeColor = Color.YELLOW;
        }
        else{
            lifeColor = Color.GRAY;
        }
        
    }
    public Color getColor(){
        return lifeColor;
    }
    public boolean getAlive(){
        return isAlive;
    }

}
