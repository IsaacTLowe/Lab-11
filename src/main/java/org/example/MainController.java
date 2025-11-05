package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Controller class for Main, for this version just the start button
 * @author Amelia Harris and Isaac Lowe
 * @version 1.3
 */

public class MainController implements ActionListener {
    private Thread gameThread;
    private GameLogic logic;
    private boolean running = false;
    private JButton button;


    public MainController(JButton button) {
        this.button = button;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!running) {
            logic = new GameLogic();
            gameThread = new Thread(logic);
            running = true;
            gameThread.start();
            System.out.println("Simulation started...");
            button.setText("Stop");
        } else {
            // Stop the loop gracefully
            logic.stop();
            running = false;
            System.out.println("Simulation stopped.");
            button.setText("Start");
        }
    }
}
