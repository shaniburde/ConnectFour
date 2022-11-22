package four;

import javax.swing.*;
import java.awt.*;



public class ConnectFour extends JFrame {
    public static final int ROWS = 6;
    public static final int COLUMNS = 7;
    public static Column[] columnArray = new Column[COLUMNS];

    public ConnectFour() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 550);
        setLayout(new BorderLayout());
        setTitle("Connect Four");

        JPanel gridPanel = new JPanel();
        gridPanel.setLayout(new GridLayout(ROWS , COLUMNS));
        gridPanel.setSize(500, 500);
        add(gridPanel, BorderLayout.CENTER);

        for (int j = 0; j < COLUMNS; j++) {
            columnArray[j] = new Column();
        }
        for (int i = (ROWS - 1); i >= 0; i--) {
            for (int j = 0; j < COLUMNS; j++) {
                Cell cell = new Cell(i, j);
                gridPanel.add(cell);
                columnArray[j].setCells(i, cell);
            }
        }
        addResetButton();
        setVisible(true);
    }

    private void addResetButton() {
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BorderLayout());
        bottomPanel.setSize(500, 50);
        add(bottomPanel, BorderLayout.SOUTH);
        JButton resetButton = new JButton("Reset");
        resetButton.setName("ButtonReset");
        resetButton.addActionListener(e -> {
            for (Column column : columnArray) {
                for (int i = 0; i < column.cells.length; i++) {
                    column.cells[i].setText(" ");
                    column.cells[i].setBackground(Color.WHITE);
                    Cell.currentTurn = "O";
                }
            }
        });
        bottomPanel.add(resetButton, BorderLayout.EAST);
    }





}