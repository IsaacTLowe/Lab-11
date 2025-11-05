

/**
 * An object that keeps track of if it's alive or dead (boolean)
 * @author Amelia Harris and Isaac Lowe
 * @version 1.0
 */

package org.example;

public class LifeSquare {
    private boolean isAlive;
    public LifeSquare(){
        isAlive = false;
    }
    public void setAlive(boolean isAlive) {
        this.isAlive = isAlive;
    }
    public boolean getAlive(){
        return isAlive;
    }

}
