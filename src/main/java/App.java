import java.util.Scanner;
import java.util.logging.Logger;

/**
 * Class with app.
 */
public final class App {
    /**
     * Initialize board size.
     */
    private static final int BOARD_SIZE = 9;
    /**
     * Initialize player symbol.
     */
    private static final char PLAYER_S = 'X';
    /**
     * Initialize artificial intelligence symbol.
     */
    private static final char AI_S = 'O';
    /**
     * Index of top left margin.
     */
    private static final int T_LEFT = 0;
    /**
     * Index of top center margin.
     */
    private static final int T_CENTER = 1;
    /**
     * Index of top rigth margin.
     */
    private static final int T_RIGHT = 2;
    /**
     * Index of middle left margin.
     */
    private static final int M_LEFT = 3;
    /**
     * Index of middle center margin.
     */
    private static final int M_CENTER = 4;
    /**
     * Index of middle right margin.
     */
    private static final int M_RIGHT = 5;
    /**
     * Index of bottom left margin.
     */
    private static final int B_LEFT = 6;
    /**
     * Index of bottom center margin.
     */
    private static final int B_CENTER = 7;
    /**
     * Index of bottom right margin.
     */
    private static final int B_RIGHT = 8;
    /**
     * Initialize number of player win.
     */
    private static final int WIN_PLAYER = 1;
    /**
     * Initialize number of artificial intelligence win.
     */
    private static final int WIN_AI = 2;
    /**
     * Initialize number of draw.
     */
    private static final int WIN_DRAW = 3;
    /**
     * String with creator text.
     */
    private static final String CREATED_BY = "Created by Saha. ";
    /**
     * String with thanks text.
     */
    private static final String THANKS_FOR = "Thanks for playing!";
    /**
     * Initialize logger.
     */
    private static final Logger LOGGER = Logger.getLogger(App.class.getName());

    private App() {
    }

    /**
     * Main method.
     *
     * @param args User arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        char[] box = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
        LOGGER.info("Enter box number to select. Enjoy!\n");
        boolean showNum = true;

        while (true) {
            displayBoard(box, showNum);
            if (showNum) {
                showNum = false;
            }

            byte winner = checkWinner(box);
            if (winner != 0) {
                printResult(winner);
                break;
            }

            byte input = getUserInput(scan);
            if (input == -1) {
                LOGGER.info("Invalid input. Enter again.");
                continue;
            }

            if (isBoxOccupied(box, input)) {
                LOGGER.info("That one is already in use. Enter another.");
                continue;
            }

            box[input - 1] = PLAYER_S;
            winner = checkWinner(box);
            if (winner != 0) {
                printResult(winner);
                break;
            }

            if (!isBoxAvailable(box)) {
                winner = WIN_DRAW;
                printResult(winner);
                break;
            }

            byte rand = makeAIMove(box);
            box[rand - 1] = AI_S;
            winner = checkWinner(box);
            if (winner != 0) {
                printResult(winner);
                break;
            }
        }
    }

    private static boolean isBoxOccupied(final char[] box, final byte input) {
        return box[input - 1] == PLAYER_S || box[input - 1] == AI_S;
    }

    private static void displayBoard(final char[] box, final boolean showNum) {
        String board = "\n" + " "
                + getBoxValue(box[T_LEFT], showNum) + " | "
                + getBoxValue(box[T_CENTER], showNum) + " | "
                + getBoxValue(box[T_RIGHT], showNum) + " \n"
                + "-----------\n" + " " + getBoxValue(box[M_LEFT], showNum)
                + " | " + getBoxValue(box[M_CENTER], showNum) + " | "
                + getBoxValue(box[M_RIGHT], showNum) + " \n" + "-----------\n"
                + " " + getBoxValue(box[B_LEFT], showNum) + " | "
                + getBoxValue(box[B_CENTER], showNum) + " | "
                + getBoxValue(box[B_RIGHT], showNum) + " \n";

        LOGGER.info(board);
    }

    private static char getBoxValue(final char value, final boolean showNum) {
        if (showNum) {
            return value;
        }
        return (value == PLAYER_S || value == AI_S) ? value : ' ';
    }

    private static void printResult(final byte winner) {
        switch (winner) {
            case WIN_PLAYER -> LOGGER.info("You won the game!");
            case WIN_AI -> LOGGER.info("You lost the game!");
            case WIN_DRAW -> LOGGER.info("It's a draw!");
            default -> LOGGER.info("ERROR");
        }
        LOGGER.info(CREATED_BY + THANKS_FOR);
    }

    private static byte checkWinner(final char[] box) {
        if (isAnyFullLine(box, PLAYER_S)) {
            return WIN_PLAYER;
        } else if (isAnyFullLine(box, AI_S)) {
            return WIN_AI;
        }

        return isBoxAvailable(box) ? (byte) 0 : WIN_DRAW;
    }

    private static boolean isAnyFullLine(final char[] box, final char symbol) {
        return isFullLine(box, T_LEFT, T_CENTER, T_RIGHT, symbol)
                || isFullLine(box, M_LEFT, M_CENTER, M_RIGHT, symbol)
                || isFullLine(box, B_LEFT, B_CENTER, B_RIGHT, symbol)
                || isFullLine(box, T_LEFT, M_LEFT, B_LEFT, symbol)
                || isFullLine(box, T_CENTER, M_CENTER, B_CENTER, symbol)
                || isFullLine(box, T_RIGHT, M_RIGHT, B_RIGHT, symbol)
                || isFullLine(box, T_LEFT, M_CENTER, B_RIGHT, symbol)
                || isFullLine(box, T_RIGHT, M_CENTER, B_LEFT, symbol);
    }

    private static boolean isFullLine(final char[] box, final int a,
                                      final int b, final int c,
                                      final char symbol) {
        return (box[a] == symbol && box[b] == symbol && box[c] == symbol);
    }

    private static boolean isBoxAvailable(final char[] box) {
        for (char c : box) {
            if (c != PLAYER_S && c != AI_S) {
                return true;
            }
        }
        return false;
    }

    private static byte getUserInput(final Scanner scan) {
        byte input;
        try {
            input = scan.nextByte();
            if (input > 0 && input < BOARD_SIZE + 1) {
                return input;
            } else {
                return -1;
            }
        } catch (Exception e) {
            return -1;
        }
    }

    private static byte makeAIMove(final char[] box) {
        byte rand = (byte) (Math.random() * (BOARD_SIZE - 1 + 1) + 1);
        while (box[rand - 1] == PLAYER_S || box[rand - 1] == AI_S) {
            rand = (byte) (Math.random() * (BOARD_SIZE - 1 + 1) + 1);
        }
        return rand;
    }
}
