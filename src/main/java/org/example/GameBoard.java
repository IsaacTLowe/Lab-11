package org.example;
import java.awt.*;
import javax.swing.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * A gridded game board that observes BlackBoard
 * @author Amelia Harris and Isaac Lowe
 * @version 1.3
 */

public class GameBoard extends JPanel implements PropertyChangeListener {

    // Grid dimensions
    private final int cols = 100;
    private final int rows = 80;
    private final int width = 1000;
    private final int height = 800;

    public GameBoard() {
        setBackground(Color.GRAY);
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int squareWidth = width / cols;
        int squareHeight = height / rows;

        // Compute offsets to center grid if panel size not perfectly divisible
        int startX = (width - (squareWidth * cols)) / 2;
        int startY = (height - (squareHeight * rows)) / 2;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int x =  col * squareWidth;
                int y =  row * squareHeight;

                Color color = Blackboard.getInstance().getGridAt(row, col).getColor();
                paintLifeSquare(x, y, color, g, squareWidth, squareHeight);
            }
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        repaint();
    }

    private void paintLifeSquare(int x, int y, Color color, Graphics g, int width, int height) {
        g.setColor(color);
        g.fillRect(x, y, width, height);

        g.setColor(Color.DARK_GRAY);
        g.drawRect(x, y, width, height);
    }
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(width, height);
}

}