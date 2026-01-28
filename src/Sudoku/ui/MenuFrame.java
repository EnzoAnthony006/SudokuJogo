package Sudoku.ui;

import javax.swing.*;
import java.awt.*;

public class MenuFrame extends JFrame {

    private final String[] args;

    public MenuFrame(String[] args) {
        this.args = args;

        setTitle("Sudoku");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JButton startButton = new JButton("Iniciar Jogo");
        JButton exitButton = new JButton("Sair");

        startButton.addActionListener(e -> {
            dispose();
            new SudokuFrame(args);
        });

        exitButton.addActionListener(e -> System.exit(0));

        setLayout(new GridLayout(2, 1, 10, 10));
        add(startButton);
        add(exitButton);

        setVisible(true);
    }
}
