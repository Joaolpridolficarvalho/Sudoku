package Data;
import javax.management.OperationsException;
import java.util.List;

public class Board {
    private final int[][] board;
    private final List<Element> elements;

    public Board(List<Element> elements) {
        this.elements = elements;
        this.board = new int[9][9];
        for (Element element : elements)
            insertNumber(element);
    }

    public int[][] getBoard() {
        return board;
    }

    public void insertNumber(Element element) {
        board[element.row()][element.column()] = element.number();
    }

    public void deleteNumber(Element element) {
        if (!this.elements.contains(element)) {
            board[element.row()][element.column()] = 0;
        } else
            System.out.println("You cannot delete this number, it is part of the initial board.");
    }

    public boolean isComplete() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }
public void showBoard() {
    int boardSize = board.length;
    int boxSize = (int) Math.sqrt(boardSize);
    String thickHorizontalBorder = "=".repeat(boardSize * 4 + boxSize + 2); // Adjusted for coordinates
    String thinHorizontalBorder = "-".repeat(boardSize * 4 + boxSize + 2); // Adjusted for coordinates

    // Print column indices
    System.out.print("    "); // Offset for row indices
    for (int col = 0; col < boardSize; col++) {
        System.out.print(" " + col + "  ");
    }
    System.out.println();

    System.out.println(thickHorizontalBorder); // Top border
    for (int i = 0; i < boardSize; i++) {
        if (i % boxSize == 0 && i != 0) {
            System.out.println(thickHorizontalBorder); // Thicker horizontal divider between boxes
        } else if (i != 0) {
            System.out.println(thinHorizontalBorder); // Thinner horizontal divider between rows
        }

        // Print row index
        System.out.print(i + " | "); // Row index with left border
        for (int j = 0; j < boardSize; j++) {
            if (j % boxSize == 0 && j != 0) {
                System.out.print("| "); // Thicker vertical divider between boxes
            } else {
                System.out.print("|"); // Thinner vertical divider between numbers
            }
            System.out.print(board[i][j] == 0 ? "   " : " " + board[i][j] + " ");
        }
        System.out.println("|"); // Right border
    }
    System.out.println(thickHorizontalBorder); // Bottom border
}
}