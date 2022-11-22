package four;

import javax.swing.*;

import java.awt.*;
import java.util.Objects;

import static four.ConnectFour.*;

public class Cell extends JButton {

    public static String currentTurn = "O";
    public static Cell[][] board = new Cell[ROWS][COLUMNS];
    public Column column;
    public int col;
    public int row;


    Cell(int row, int col) {
        super(" ");
        setBackground(Color.white);
        setFocusPainted(false);
        setName("Button" + cellTextFrom(row, col));
        addActionListener(e -> {
            if (Objects.equals(checkWin(), " ")) {
                column.setColumnText(getCurrentTurn());
            }
            checkWin();
        });
        this.column = columnArray[col];
        this.col = col;
        this.row = row;
        board[row][col] = this;
    }

    public static String cellTextFrom(int row, int column) {
        char a = 'A';
        char letter = (char) (a + column);
        return String.valueOf(letter) + (row + 1);
    }

    private String getCurrentTurn(){
        currentTurn = currentTurn.equals("X") ? "O" : "X";
        return currentTurn;
    }

    public static String checkWin() {
        final int HEIGHT = ROWS;
        final int WIDTH = COLUMNS;
        final String EMPTY_SLOT = " ";
        for (int r = 0; r < HEIGHT; r++) {
            for (int c = 0; c < WIDTH; c++) {
                String player = board[r][c].getText();
                if (Objects.equals(player, EMPTY_SLOT))
                    continue;

                if (c + 3 < WIDTH &&
                        Objects.equals(player, board[r][c + 1].getText()) &&
                        Objects.equals(player, board[r][c + 2].getText()) &&
                        Objects.equals(player, board[r][c + 3].getText())) {
                    board[r][c].setBackground(Color.MAGENTA);
                    board[r][c + 1].setBackground(Color.MAGENTA);
                    board[r][c + 2].setBackground(Color.MAGENTA);
                    board[r][c + 3].setBackground(Color.MAGENTA);
                    return player;
                }
                if (r + 3 < HEIGHT) {
                    if (Objects.equals(player, board[r + 1][c].getText()) &&
                        Objects.equals(player, board[r + 2][c].getText()) &&
                        Objects.equals(player, board[r + 3][c].getText())) {
                        board[r][c].setBackground(Color.MAGENTA);
                        board[r + 1][c].setBackground(Color.MAGENTA);
                        board[r + 2][c].setBackground(Color.MAGENTA);
                        board[r + 3][c].setBackground(Color.MAGENTA);
                        return player;
                    }
                    if (c + 3 < WIDTH &&
                            Objects.equals(player, board[r + 1][c + 1].getText()) &&
                            Objects.equals(player, board[r + 2][c + 2].getText()) &&
                            Objects.equals(player, board[r + 3][c + 3].getText())) {
                        board[r][c].setBackground(Color.MAGENTA);
                        board[r + 1][c + 1].setBackground(Color.MAGENTA);
                        board[r + 2][c + 2].setBackground(Color.MAGENTA);
                        board[r + 3][c + 3].setBackground(Color.MAGENTA);
                        return player;
                    }
                    if (c - 3 >= 0 &&
                            Objects.equals(player, board[r + 1][c - 1].getText()) &&
                            Objects.equals(player, board[r + 2][c - 2].getText()) &&
                            Objects.equals(player, board[r + 3][c - 3].getText())) {
                        board[r][c].setBackground(Color.MAGENTA);
                        board[r + 1][c - 1].setBackground(Color.MAGENTA);
                        board[r + 2][c - 2].setBackground(Color.MAGENTA);
                        board[r + 3][c - 3].setBackground(Color.MAGENTA);
                        return player;
                    }
                }
            }
        }
        return EMPTY_SLOT;
    }

}