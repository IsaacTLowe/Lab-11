package org.example;

import java.util.Vector;

/**
 * Enacts Game logic onto the game (e.i x,y to grid conversion and game rules)
 * @author Amelia Harris and Isaac Lowe
 * @version 1.3
 */
public class GameLogic implements Runnable{
    private final int cols = 100;
    private final int rows = 80;
    private final int width = 1000;
    private final int height = 800;
    private volatile boolean running = true;


    @Override
    public void run() {
        while (running) {
            step();
            try {
                Thread.sleep(300); // control speed of generations
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public void stop() {
        running = false;
    }

    public void step() {
        Vector<Vector<LifeSquare>> grid = Blackboard.getInstance().getGrid();

        boolean[][] nextGen = new boolean[rows][cols];

        for(int r = 0; r < rows; r++) {
            for(int c = 0; c < cols; c++) {
                int neighbors = countAliveNeighbors(grid, r, c);
                boolean alive = grid.get(r).get(c).getAlive();

                if(alive) {
                    nextGen[r][c] = (neighbors == 2 || neighbors == 3);
                } else {
                    nextGen[r][c] = (neighbors == 3);
                }
            }
        }

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                Blackboard.getInstance().setLifeSquare(r, c, nextGen[r][c]);
            }
        }
    }

    private int countAliveNeighbors(Vector<Vector<LifeSquare>> grid, int row, int col) {
        int count = 0;
        for (int dr = -1; dr <= 1; dr++) {
            for (int dc = -1; dc <= 1; dc++) {
                if (dr == 0 && dc == 0) continue; // skip self
                int nr = row + dr;
                int nc = col + dc;
                if (nr >= 0 && nr < rows && nc >= 0 && nc < cols) {
                    if (grid.get(nr).get(nc).getAlive()) count++;
                }
            }
        }
        return count;
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
        int startX = (width - (squareWidth * cols)) / 2;
        
        int col = (x - 0) / squareWidth; // use same startX as GameBoard
        if (col < 0 || col >= cols) return -1;
        return col;
    }

    public int getRow(int y) {
        int squareHeight = height / rows;
        int startY = (height - (squareHeight * rows)) / 2;
        int row = (y - 0) / squareHeight; // use same startY as GameBoard
        if (row < 0 || row >= rows) return -1;
        return row;
    }
}


