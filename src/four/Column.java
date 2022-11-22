package four;

import static four.ConnectFour.COLUMNS;
import static four.ConnectFour.ROWS;

public class Column {

        protected Cell[] cells = new Cell[ROWS];
        protected int row;

        protected void setCells(int row, Cell cell) {
            cells[row] = cell;
        }

        protected void setColumnText(String currentPlayer) {
                for (int i = 0; i < ROWS; i++) {
                     if (cells[i].getText().equals(" ")) {
                             cells[i].setText(currentPlayer);
                             break;
                     }
                }
                Cell.checkWin();
        }



//    need to create an array for each column containing the state of each Cell
//    thinking I need to use the instances of the cells I created to do so
//    the Cell object already holds the state of each cell in its text value
//    need to create an if statement/loop that checks for the next available (empty string) cell in order from down to up
//    want a new column instance containing all the rows for that column.
//    thinking to create an if statement to check the Cell's column number and add it to the array if it matches
//    have to change the click event listener to be on a column instead of an individual cell
//    the column should then check for the next available cell
}
