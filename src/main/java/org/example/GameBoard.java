package org.example;
import java.awt.*;
import javax.swing.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * A gridded game board that observes BlackBoard
 * @author Amelia Harris and Isaac Lowe
 * @version 1.0
 */

public class GameBoard extends JPanel implements PropertyChangeListener {

    public GameBoard(){
        GridLayout gridLayout = new GridLayout(10, 10);
        setLayout(gridLayout);
        setBackground(Color.GRAY);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        
    }
     @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawBoard(g);
    }
    private void drawBoard(Graphics g) {

        int panelWidth = 1000;
        int panelHeight = 800;
        int cols = 100;
        int rows = 80;
        int squareWidth = panelWidth / cols;
        int squareHeight = panelHeight / rows;

        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                int x =  i * squareWidth;
                int y =  j * squareHeight;

                paintLifeSquare(x,y, Color.GRAY, g, squareWidth, squareHeight);
            }
        }
    }

    private void paintLifeSquare(int x,int y, Color color, Graphics g, int width, int height ){

                g.setColor(color);
                g.fillRect(x, y, width, height);
            
                g.setColor(Color.DARK_GRAY);
                g.drawRect(x, y, width, height);
    }
}
    
