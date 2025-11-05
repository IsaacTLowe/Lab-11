package org.example;

import java.beans.PropertyChangeSupport;
import java.awt.*;
import javax.swing.*;
import java.util.*;
/**
 * Acts as the database for the game; keeps track of LifeSquares status and sends updates to any observers
 * @author Amelia Harris and Isaac Lowe
 * @version 1.0
 */
public class Blackboard extends PropertyChangeSupport {

    private static Blackboard instance;
    private Vector<Vector<LifeSquare>> grid;

    private Blackboard() {
        super(new Object());
        initializeGrid();
    }
    private void initializeGrid() {
        grid = new Vector<>(100);
        for (int row = 0; row < 80; row++) {
            Vector<LifeSquare> rowVector = new Vector<>(100);
            for (int col = 0; col < 100; col++) {
                rowVector.add(new LifeSquare()); 
            }
            grid.add(rowVector);
        }
    }

    public static Blackboard getInstance(){
        if(instance == null){
            instance = new Blackboard();
        }
        return instance;
    }
    public void boxClikced(int x, int y, boolean status){
        GameLogic boxClicked = new GameLogic();
        boxClicked.boxStatus(x,y, status);
    }
    public Vector<Vector<LifeSquare>> getGrid(){
        return grid;
    }
    
    public LifeSquare getGridAt(int row, int col){
        return grid.get(row).get(col);
    }

    public void setLifeSquare(int row, int col, boolean status){
        grid.get(row).get(col).setAlive(status);
        Object[] changeInfo = {row, col};
        firePropertyChange("Box Status Changed", null, changeInfo);
    }

}
