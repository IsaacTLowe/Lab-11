package org.example;

import javax.swing.*;
import java.awt.*;

/**
 * Displays a game board, Title, and start button
 * @author Amelia Harris and Isaac Lowe
 * @version 1.0
 */

public class Main extends JFrame {

    public Main() {
        JTextArea gameTitle = new JTextArea("Life Game");
        JPanel gameBoard = new GameBoard();
        JButton startButton = new JButton("Start");
        GameBoardController gameBoardController = new GameBoardController();

        setLayout(new BorderLayout());
        add(gameTitle, BorderLayout.NORTH);
        add(gameBoard, BorderLayout.CENTER);
        add(startButton, BorderLayout.SOUTH);

        gameBoard.addMouseListener(gameBoardController);

    }

    static void main(String[] args) {
        Main main = new Main();
        main.setTitle("Lab 11");
        main.setSize(1000,800);
        main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        main.setVisible(true);
    }
}
