package org.example;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
/**
 * Handles mouse clicks for the squares
 * @author Amelia Harris and Isaac Lowe
 * @version 1.3
 */

public class GameBoardController implements MouseListener {
    @Override
    public void mouseClicked(MouseEvent e) {
        Blackboard.getInstance().boxClicked(e.getX(),e.getY(), true);
    }

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}
}
