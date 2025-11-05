

/**
 * An object that keeps track of if it's alive or dead (boolean)
 * @author Amelia Harris and Isaac Lowe
 * @version 1.0
 */

package org.example;
import java.awt.*;

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
