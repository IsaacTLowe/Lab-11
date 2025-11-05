package org.example;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Controller class for Main, for this version just the start button
 * @author Amelia Harris and Isaac Lowe
 * @version 1.0
 */

public class MainController implements ActionListener {
    private Thread gameThread;
    private GameLogic logic;
    private boolean running = false;

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!running) {
            logic = new GameLogic();
            gameThread = new Thread(logic);
            running = true;
            gameThread.start();
            System.out.println("Simulation started...");
        } else {
            logic.stop();
            running = false;
            System.out.println("Simulation stopped.");
        }
    }
}
