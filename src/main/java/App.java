import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Logger;

public class App {

    private static final Logger logger = Logger.getLogger(App.class.getName());
    private static final char[] box = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
    private static boolean boxEmpty = false;
    private static byte winner = 0;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        logger.info("Enter box number to select. Enjoy!\n");

        while (winner == 0) {
            displayBoard();

            if (!boxEmpty) {
                resetBoard();
                boxEmpty = true;
            }

            if (checkAndProcessUserMove(scan)) {
                continue;
            }

            checkAndProcessAIMove();
        }

        printResultMessage();
    }

    public static void displayBoard() {
        String boardString = "\n\n " + box[0] + " | " + box[1] + " | " + box[2] + " "
                + "\n-----------"
                + "\n " + box[3] + " | " + box[4] + " | " + box[5] + " "
                + "\n-----------"
                + "\n " + box[6] + " | " + box[7] + " | " + box[8] + " \n";

        logger.info(boardString);
    }


    private static void resetBoard() {
        Arrays.fill(box, ' ');
    }

    private static boolean checkAndProcessUserMove(Scanner scan) {
        userMove(scan);
        if (checkWin('X')) {
            winner = 1;
            return true;
        } else if (!checkAvailable()) {
            winner = 3;
            return true;
        }
        return false;
    }

    private static void checkAndProcessAIMove() {
        aiMove();
        if (checkWin('O')) {
            winner = 2;
        }
    }

    private static void printResultMessage() {
        if (winner == 1) {
            printWinnerMessage("You");
        } else if (winner == 2) {
            printWinnerMessage("AI");
        } else if (winner == 3) {
            printDrawMessage();
        }
    }

    private static void userMove(Scanner scan) {
        byte input;
        while (true) {
            input = scan.nextByte();
            if (input > 0 && input < 10) {
                if (box[input - 1] == 'X' || box[input - 1] == 'O') {
                    logger.info("That one is already in use. Enter another.");
                } else {
                    box[input - 1] = 'X';
                    break;
                }
            } else {
                logger.info("Invalid input. Enter again.");
            }
        }
    }

    private static boolean checkWin(char symbol) {
        return (box[0] == symbol && box[1] == symbol && box[2] == symbol) ||
                (box[3] == symbol && box[4] == symbol && box[5] == symbol) ||
                (box[6] == symbol && box[7] == symbol && box[8] == symbol) ||
                (box[0] == symbol && box[3] == symbol && box[6] == symbol) ||
                (box[1] == symbol && box[4] == symbol && box[7] == symbol) ||
                (box[2] == symbol && box[5] == symbol && box[8] == symbol) ||
                (box[0] == symbol && box[4] == symbol && box[8] == symbol) ||
                (box[2] == symbol && box[4] == symbol && box[6] == symbol);
    }

    private static boolean checkAvailable() {
        for (char c : box) {
            if (c != 'X' && c != 'O') {
                return true;
            }
        }
        return false;
    }

    private static void aiMove() {
        byte rand;
        while (true) {
            rand = (byte) (Math.random() * (9 - 1 + 1) + 1);
            if (box[rand - 1] != 'X' && box[rand - 1] != 'O') {
                box[rand - 1] = 'O';
                break;
            }
        }
    }

    private static void printWinnerMessage(String player) {
        logger.info(player + " won the game!\nCreated by Shreyas Saha. Thanks for playing!");
    }

    private static void printDrawMessage() {
        logger.info("It's a draw!\nCreated by Shreyas Saha. Thanks for playing!");
    }
}
