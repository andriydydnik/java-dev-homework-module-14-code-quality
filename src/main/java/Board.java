import java.util.logging.Logger;

public final class Board {
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
     * Index of top right margin.
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
    private static final Logger LOG = Logger.getLogger(Board.class.getName());
    private Board() {
    }

    /**
     * Method that check if a specific box on the board is occupied.
     *
     * @param input The index of the box to check
     * @param box   The game board
     * @return True if the box is occupied, False otherwise
     */
    public static boolean isBoxOccupied(final char[] box, final byte input) {
        return box[input - 1] == PLAYER_S || box[input - 1] == AI_S;
    }

    /**
     * Method that display the current game board on the console.
     *
     * @param box     The game board
     * @param showNum Whether to display numbers of position on the board
     */
    public static void displayBoard(final char[] box, final boolean showNum) {
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

        LOG.info(board);
    }

    /**
     * Method that return the value of a specific box on the board.
     *
     * @param value   The value of the box to return
     * @param showNum Whether to show the box numbers of position
     * @return The value of the box
     */
    public static char getBoxValue(final char value, final boolean showNum) {
        if (showNum) {
            return value;
        }
        return (value == PLAYER_S || value == AI_S) ? value : ' ';
    }

    /**
     * Method that print result of the game on the console.
     *
     * @param winner The result of the game
     */
    public static void printResult(final byte winner) {
        switch (winner) {
            case WIN_PLAYER -> LOG.info("You won the game!");
            case WIN_AI -> LOG.info("You lost the game!");
            case WIN_DRAW -> LOG.info("It's a draw!");
            default -> LOG.info("ERROR");
        }
        LOG.info(CREATED_BY + THANKS_FOR);
    }

    /**
     * Method that check is any available boxes left on the board.
     *
     * @param box The game board
     * @return True if there are available boxes, False otherwise
     */
    public static boolean isBoxAvailable(final char[] box) {
        for (char c : box) {
            if (c != PLAYER_S && c != AI_S) {
                return true;
            }
        }
        return false;
    }
}
