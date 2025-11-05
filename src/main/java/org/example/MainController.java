package org.example;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
            // Stop the loop gracefully
            logic.stop();
            running = false;
            System.out.println("Simulation stopped.");
        }
    }
}
