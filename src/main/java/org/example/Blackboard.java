package org.example;

import java.beans.PropertyChangeSupport;
import java.util.*;
/**
 * Acts as the database for the game; keeps track of LifeSquares status and sends updates to any observers
 * @author Amelia Harris and Isaac Lowe
 * @version 1.3
 */
public class Blackboard extends PropertyChangeSupport{

    private static Blackboard instance;
    private Vector<Vector<LifeSquare>> grid;

    private GameLogic logic;
    private Thread logicThread;

    private Blackboard() {
        super(new Object());
        initializeGrid();
    }

    public static Blackboard getInstance() {
        if (instance == null) instance = new Blackboard();
        return instance;
    }

    public void startSimulation() {
        if (logicThread == null || !logicThread.isAlive()) {
            logic = new GameLogic();
            logicThread = new Thread(logic);
            logicThread.start();
        }
    }

    public void stopSimulation() {
        if (logic != null) {
            logic.stop();
        }
    }

    public boolean toggleSimulation() {
        if (logicThread != null && logicThread.isAlive()) {
            stopSimulation();
            return false;
        } else {
            startSimulation();
            return true;
        }
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

    public void boxClicked(int x, int y, boolean status){
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
        getGridAt(row, col).setAlive(status);
        Object[] changeInfo = {row, col};
        firePropertyChange("Box Status Changed", null, changeInfo);
    }

}
