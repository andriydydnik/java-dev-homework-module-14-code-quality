import java.util.Scanner;

public final class AppLogic {
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

    private AppLogic() {

    }

    /**
     * Method that find the winner.
     *
     * @param box The game board
     * @return byte The winner number
     */
    public static byte checkWinner(final char[] box) {
        if (AppLogic.isAnyFullLine(box, PLAYER_S)) {
            return WIN_PLAYER;
        } else if (AppLogic.isAnyFullLine(box, AI_S)) {
            return WIN_AI;
        }

        return Board.isBoxAvailable(box) ? (byte) 0 : WIN_DRAW;
    }

    /**
     * Method that check is any full line in the game.
     *
     * @param box    The game board
     * @param symbol The symbol to check (either 'X' or 'O'
     * @return True if there is any full line, False otherwise
     */
    public static boolean isAnyFullLine(final char[] box, final char symbol) {
        return isFullLine(box, T_LEFT, T_CENTER, T_RIGHT, symbol)
                || isFullLine(box, M_LEFT, M_CENTER, M_RIGHT, symbol)
                || isFullLine(box, B_LEFT, B_CENTER, B_RIGHT, symbol)
                || isFullLine(box, T_LEFT, M_LEFT, B_LEFT, symbol)
                || isFullLine(box, T_CENTER, M_CENTER, B_CENTER, symbol)
                || isFullLine(box, T_RIGHT, M_RIGHT, B_RIGHT, symbol)
                || isFullLine(box, T_LEFT, M_CENTER, B_RIGHT, symbol)
                || isFullLine(box, T_RIGHT, M_CENTER, B_LEFT, symbol);
    }

    /**
     * Method.
     *
     * @param box    The game board
     * @param a      Index of the first box in line
     * @param b      Index of the second box in line
     * @param c      Index of the third box in line
     * @param symbol The symbol to check (either 'X' or 'O'
     * @return True if there is a full line, False otherwise
     */
    public static boolean isFullLine(final char[] box, final int a,
                                     final int b, final int c,
                                     final char symbol) {
        return (box[a] == symbol && box[b] == symbol && box[c] == symbol);
    }

    /**
     * Method that get what symbol user input from the console.
     *
     * @return byte The user input number
     */
    public static byte getUserInput() {
        Scanner scan = new Scanner(System.in);
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

    /**
     * Method that make random move for AI.
     *
     * @param box The game board
     * @return byte The AI's move number
     */
    public static byte makeAIMove(final char[] box) {
        byte rand = (byte) (Math.random() * (BOARD_SIZE - 1 + 1) + 1);
        while (box[rand - 1] == PLAYER_S || box[rand - 1] == AI_S) {
            rand = (byte) (Math.random() * (BOARD_SIZE - 1 + 1) + 1);
        }
        return rand;
    }
}
