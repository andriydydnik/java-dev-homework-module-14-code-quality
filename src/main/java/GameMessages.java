import java.util.logging.Logger;

public class GameMessages {
    private static final Logger logger = Logger.getLogger(GameMessages.class.getName());

    public void displayMessage(String message) {
        logger.info(message);
    }

    public void displayStartMessage() {
        logger.info("Enter box number to select. Enjoy!\n");
    }

    public void printResultMessage(byte winner) {
        if (winner == 1) {
            logger.info("You won the game!\nCreated by Shreyas Saha. Thanks for playing!");
        } else if (winner == 2) {
            logger.info("AI won the game!\nCreated by Shreyas Saha. Thanks for playing!");
        } else if (winner == 3) {
            logger.info("It's a draw!\nCreated by Shreyas Saha. Thanks for playing!");
        }
    }
}
