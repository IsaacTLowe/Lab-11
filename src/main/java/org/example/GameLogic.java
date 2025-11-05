package org.example;

public class GameLogic implements Runnable{
    private final int cols = 80;
    private final int rows = 100;
    private final int width = 1000;
    private final int height = 800;
  

    @Override
    public void run() {

    }
    
    public void boxStatus(int x, int y, Boolean status){
        int col = getCol(x);
        int row = getRow(y);
        if (row >= 0 && col >= 0) {
            Blackboard.getInstance().setLifeSquare(row, col, status);
        }
    }
    public int getCol(int x) {
        int squareWidth = width / cols;
        int col = (x - 0) / squareWidth; // use same startX as GameBoard
        if (col < 0 || col >= cols) return -1;
        return col;
    }

    public int getRow(int y) {
        int squareHeight = height / rows;
        int row = (y - 0) / squareHeight; // use same startY as GameBoard
        if (row < 0 || row >= rows) return -1;
        return row;
    }
}


