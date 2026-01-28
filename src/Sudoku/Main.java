package Sudoku;

import Sudoku.ui.MenuFrame;

import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MenuFrame(args));
    }
}

