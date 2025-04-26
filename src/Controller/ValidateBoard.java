package Controller;

import Data.Board;

import java.util.HashSet;
import java.util.Set;

public class ValidateBoard {
    private final int REQUIRED_SUM_COMPLETE_BOARD = 45;
    private final int QUANTITY_OF_ROWS_COLUMNS = 9;
    public void isValidRow(int row ) {
        Set<Integer> rowSet = new HashSet<>();
        rowSet.add(row);
        if (rowSet.stream().mapToInt(i -> i).sum() == REQUIRED_SUM_COMPLETE_BOARD) {
            System.out.println("Row  is valid.");
        } else {
            System.out.println("Row " + row + " is invalid.");
        }
    }
    public void isValidColumn(int column) {
        Set<Integer> columnSet = new HashSet<>();
        columnSet.add(column);
        if (columnSet.stream().mapToInt(i -> i).sum() == REQUIRED_SUM_COMPLETE_BOARD) {
            System.out.println("Column  is valid.");
        } else {
            System.out.println("Column " + column + " is invalid.");
        }
    }
    public void isValidBoard(Board board) {
        int[][] boardArray = board.getBoard();
        int column, row;
        for (column = 0; column < QUANTITY_OF_ROWS_COLUMNS; column++) {
            for (row = 0; row < QUANTITY_OF_ROWS_COLUMNS; row++) {
                isValidRow(boardArray[row][column]);
            }
            isValidColumn(boardArray[row][column]);
        }
    }
}