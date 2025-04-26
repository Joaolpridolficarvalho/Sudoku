import Controller.ValidateBoard;
import Data.Board;
    import Data.Element;

import java.util.*;
import java.util.function.Function;

import static java.lang.System.exit;

public class Main {
    private static Board board;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Element> elements = new ArrayList<>();
        Map<Integer, Runnable> menuOptions = new HashMap<>();
        menuOptions.put(1, () -> System.out.println("Backing to board..."));
        menuOptions.put(2, () -> {
            System.out.println("Enter row, column, and number (comma-separated):");
            String input = scanner.nextLine();
            board.deleteNumber(parseInput(input));
        });
        menuOptions.put(3, () -> {
            System.out.println("Validating board...");
            ValidateBoard validateBoard = new ValidateBoard();
            validateBoard.isValidBoard(board);
        });
        menuOptions.put(4, () -> exit(0));

        for (String arg : args) {
            elements.add(parseInput(arg));
        }

        board = new Board(elements);
        board.showBoard();

        while (!board.isComplete()) {
            System.out.println("Enter row, column, and number (comma-separated):");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("menu")) {
                showMenu();
                int option = scanner.nextInt();
                scanner.nextLine();
                Runnable action = menuOptions.get(option);
                if (action != null) {
                    action.run();
                } else {
                    System.out.println("Invalid option. Please try again.");
                    continue;
                }
            }
            try {
                Element element = parseInput(input);
                board.insertNumber(element);

            } catch (IllegalArgumentException e) {
                System.out.println("Invalid element values. Please try again.");
            }

            board.showBoard();
        }
        ValidateBoard validateBoard = new ValidateBoard();
        validateBoard.isValidBoard(board);
    }

    private static Element parseInput(String input) {
        String[] parts = input.split(",");
        int row = Integer.parseInt(parts[0]);
        int column = Integer.parseInt(parts[1]);
        int number = Integer.parseInt(parts[2]);
        return new Element(row, column, number);
    }

    private static void showMenu() {
        System.out.println("Menu:");
        System.out.println("1. Continue");
        System.out.println("2. Delete number");
        System.out.println("3. Validate board");
        System.out.println("4. Exit");
    }
}

