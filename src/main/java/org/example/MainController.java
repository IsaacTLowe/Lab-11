package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Controller class for Main, for this version just the start button
 * @author Amelia Harris and Isaac Lowe
 * @version 1.0
 */

public class MainController implements ActionListener {

    private JButton button;

    public MainController(JButton button) {
        this.button = button;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        boolean running = Blackboard.getInstance().toggleSimulation();
        button.setText(running ? "Stop" : "Start");
    }
}
