package Sudoku.ui;

import Sudoku.Model.Board;
import Sudoku.Model.Space;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.util.Objects.isNull;

public class SudokuFrame extends JFrame {

    private Board board;
    private final JTextField[][] fields = new JTextField[9][9];
    private final JLabel statusLabel = new JLabel("Não iniciado");
    private final JLabel timerLabel = new JLabel("00:00");
    private javax.swing.Timer gameTimer;
    private int elapsedSeconds = 0;
    private boolean gameStarted = false;

    private final String[] args;

    public SudokuFrame(String[] args) {
        this.args = args;
        setTitle("Sudoku");
        setSize(1000, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        add(createGrid(), BorderLayout.CENTER);
        add(createMenu(), BorderLayout.WEST);
        setVisible(true);
    }

    private void initBoard() {
        List<List<Space>> spaces = new ArrayList<>();

        int[][] baseBoard = {
                {5,3,4,6,7,8,9,1,2},
                {6,7,2,1,9,5,3,4,8},
                {1,9,8,3,4,2,5,6,7},
                {8,5,9,7,6,1,4,2,3},
                {4,2,6,8,5,3,7,9,1},
                {7,1,3,9,2,4,8,5,6},
                {9,6,1,5,3,7,2,8,4},
                {2,8,7,4,1,9,6,3,5},
                {3,4,5,2,8,6,1,7,9}
        };

        Random random = new Random();

        for (int row = 0; row < 9; row++) {
            spaces.add(new ArrayList<>());
            for (int col = 0; col < 9; col++) {
                boolean fixed = random.nextInt(100) < 40;
                spaces.get(row).add(new Space(baseBoard[row][col], fixed));
            }
        }

        board = new Board(spaces);
        gameStarted = true;
        elapsedSeconds = 0;
        startTimer();
        refreshUI();
    }





    private JPanel createGrid() {
        JPanel mainPanel = new JPanel(new GridLayout(3, 3));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        for (int blockRow = 0; blockRow < 3; blockRow++) {
            for (int blockCol = 0; blockCol < 3; blockCol++) {

                JPanel block = new JPanel(new GridLayout(3, 3));
                block.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));

                for (int row = 0; row < 3; row++) {
                    for (int col = 0; col < 3; col++) {
                        int r = blockRow * 3 + row;
                        int c = blockCol * 3 + col;

                        JTextField field = new JTextField();
                        field.setHorizontalAlignment(JTextField.CENTER);
                        field.setFont(new Font("Monospaced", Font.BOLD, 28));
                        field.setPreferredSize(new Dimension(60, 60));
                        field.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));

                        fields[r][c] = field;
                        block.add(field);
                    }
                }
                mainPanel.add(block);
            }
        }
        return mainPanel;
    }

    private JPanel createMenu() {
        JPanel menu = new JPanel();
        menu.setLayout(new BoxLayout(menu, BoxLayout.Y_AXIS));
        menu.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JButton startButton = new JButton("Iniciar Jogo");
        JButton insertButton = new JButton("Inserir número");
        JButton removeButton = new JButton("Remover número");
        JButton clearButton = new JButton("Limpar jogo");
        JButton finishButton = new JButton("Finalizar");
        JButton exitButton = new JButton("Sair");

        startButton.addActionListener(e -> initBoard());
        insertButton.addActionListener(e -> insertNumber());
        removeButton.addActionListener(e -> removeNumber());
        clearButton.addActionListener(e -> clearGame());
        finishButton.addActionListener(e -> finishGame());
        exitButton.addActionListener(e -> System.exit(0));

        menu.add(startButton);
        menu.add(Box.createVerticalStrut(10));
        menu.add(insertButton);
        menu.add(Box.createVerticalStrut(10));
        menu.add(removeButton);
        menu.add(Box.createVerticalStrut(10));
        menu.add(clearButton);
        menu.add(Box.createVerticalStrut(10));
        menu.add(finishButton);
        menu.add(Box.createVerticalStrut(10));
        menu.add(exitButton);
        menu.add(Box.createVerticalStrut(20));
        menu.add(statusLabel);
        menu.add(Box.createVerticalStrut(10));
        menu.add(timerLabel);

        return menu;
    }

    private void insertNumber() {
        if (!gameStarted) {
            JOptionPane.showMessageDialog(this, "Inicie o jogo primeiro!");
            return;
        }

        int col = askIndex("Coluna (0-8)");
        int row = askIndex("Linha (0-8)");
        int value = askValue("Valor (1-9)");

        if (!board.changeValue(col, row, value)) {
            JOptionPane.showMessageDialog(this, "Valor fixo!");
        }
        refreshUI();
    }

    private void removeNumber() {
        if (!gameStarted) {
            JOptionPane.showMessageDialog(this, "Inicie o jogo primeiro!");
            return;
        }

        int col = askIndex("Coluna (0-8)");
        int row = askIndex("Linha (0-8)");

        if (!board.clearvalue(col, row)) {
            JOptionPane.showMessageDialog(this, "Valor fixo!");
        }
        refreshUI();
    }

    private void clearGame() {
        if (!gameStarted) return;

        board.reset();
        elapsedSeconds = 0;
        refreshUI();
        statusLabel.setText("Não iniciado");
    }

    private void finishGame() {
        if (!gameStarted) return;

        if (board.gameisFinished()) {
            JOptionPane.showMessageDialog(this, "Parabéns!");
            stopTimer();
        } else {
            JOptionPane.showMessageDialog(this, "Jogo incompleto ou com erros");
        }
    }

    private void refreshUI() {
        if (!gameStarted) return;

        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                Space space = board.getSpaces().get(row).get(col);

                fields[row][col].setText(
                        space.getActual() == null ? "" : space.getActual().toString()
                );

                fields[row][col].setEditable(!space.isFixed());
                fields[row][col].setBackground(space.isFixed() ? Color.LIGHT_GRAY : Color.WHITE);
            }
        }

        statusLabel.setText(board.getStatus().getLabel());
    }




    private int askIndex(String msg) {
        int value = -1;
        do {
            try {
                String input = JOptionPane.showInputDialog(msg);
                if (input == null || input.isBlank()) {
                    JOptionPane.showMessageDialog(this, "Valor obrigatório!");
                    continue;
                }
                value = Integer.parseInt(input);
            } catch (Exception e) {
                value = -1;
            }
        } while (value < 0 || value > 8);
        return value;
    }

    private int askValue(String msg) {
        int value = -1;
        do {
            try {
                String input = JOptionPane.showInputDialog(msg);
                if (input == null || input.isBlank()) {
                    JOptionPane.showMessageDialog(this, "Valor obrigatório!");
                    continue;
                }
                value = Integer.parseInt(input);
            } catch (Exception e) {
                value = -1;
            }
        } while (value < 1 || value > 9);
        return value;
    }

    private void startTimer() {
        if (gameTimer != null) gameTimer.stop();

        gameTimer = new javax.swing.Timer(1000, e -> {
            elapsedSeconds++;
            int minutes = elapsedSeconds / 60;
            int seconds = elapsedSeconds % 60;
            timerLabel.setText(String.format("%02d:%02d", minutes, seconds));
        });
        gameTimer.start();
    }

    private void stopTimer() {
        if (gameTimer != null) gameTimer.stop();
    }
}
