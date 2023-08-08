import java.util.logging.Logger;

/**
 * Class with app.
 */
public final class App {
    /**
     * Initialize player symbol.
     */
    private static final char PLAYER_S = 'X';
    /**
     * Initialize artificial intelligence symbol.
     */
    private static final char AI_S = 'O';
    /**
     * Initialize number of draw.
     */
    private static final int WIN_DRAW = 3;
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
        char[] box = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
        LOGGER.info("Enter box number to select. Enjoy!\n");
        boolean showNum = true;

        while (true) {
            Board.displayBoard(box, showNum);
            if (showNum) {
                showNum = false;
            }

            byte winner = AppLogic.checkWinner(box);
            if (winner != 0) {
                Board.printResult(winner);
                break;
            }

            byte input = AppLogic.getUserInput();
            if (input == -1) {
                LOGGER.info("Invalid input. Enter again.");
                continue;
            }

            if (Board.isBoxOccupied(box, input)) {
                LOGGER.info("That one is already in use. Enter another.");
                continue;
            }

            box[input - 1] = PLAYER_S;
            winner = AppLogic.checkWinner(box);
            if (winner != 0) {
                Board.printResult(winner);
                break;
            }

            if (!Board.isBoxAvailable(box)) {
                winner = WIN_DRAW;
                Board.printResult(winner);
                break;
            }

            byte rand = AppLogic.makeAIMove(box);
            box[rand - 1] = AI_S;
            winner = AppLogic.checkWinner(box);
            if (winner != 0) {
                Board.printResult(winner);
                break;
            }
        }
    }
}
