package Application;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class App {
    static final Logger logger = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        char[] box = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
        boolean boxEmpty = false;
        boolean playing = true;
        while (playing) {

            printField(box);

            if (!boxEmpty) {
                resumeBox(box);
                boxEmpty = true;
            }

            userInput(box, scan);

            if (isUserWon(box)) {
                logger.info("You won the game!\nCreated by Shreyas Saha. Thanks for playing!");
                playing = false;
            }

            if (isDraw(box)) {
                logger.info("It's a draw!\nCreated by Shreyas Saha. Thanks for playing!");
                playing = false;
            }
            if (playing) {
                pcTurn(box);
            }

            if (isPCWon(box)) {
                logger.info("You lost the game!\nCreated by Shreyas Saha. Thanks for playing!");
                playing = false;
            }
        }

    }

    private static void printField(char[] box) {
        String format = " {} | {} | {}";
        logger.info(format, box[0], box[1], box[2]);
        logger.info("-----------");
        logger.info(format, box[3], box[4], box[5]);
        logger.info("-----------");
        logger.info(format, box[6], box[7], box[8]);
    }

    private static void userInput(char[] box, Scanner scan) {
        byte input;
        logger.info("Enter box number to select. Enjoy!\n");
        while (true) {
            input = scan.nextByte();
            if (input > 0 && input < 10) {
                if (box[input - 1] == 'X' || box[input - 1] == 'O')
                    logger.info("That one is already in use. Enter another.");
                else {
                    box[input - 1] = 'X';
                    break;
                }
            } else
                logger.info("Invalid input. Enter again.");
        }
    }

    private static void pcTurn(char[] box) {
        byte rand;
        while (true) {
            rand = (byte) (Math.random() * (9 - 1 + 1) + 1);
            if (box[rand - 1] != 'X' && box[rand - 1] != 'O') {
                box[rand - 1] = 'O';
                break;
            }
        }
    }

    private static boolean isUserWon(char[] box) {
        return isWin(box, 'X');
    }

    private static boolean isPCWon(char[] box) {
        return isWin(box, 'O');
    }

    private static boolean isDraw(char[] box) {
        boolean boxAvailable;
        boxAvailable = false;
        for (int i = 0; i < 9; i++) {
            if (box[i] != 'X' && box[i] != 'O') {
                boxAvailable = true;
                break;
            }
        }
        return !boxAvailable;
    }

    private static boolean isWin(char[] box, char symbol) {
        return ((box[0] == symbol && box[1] == symbol && box[2] == symbol) ||
                (box[3] == symbol && box[4] == symbol && box[5] == symbol) ||
                (box[6] == symbol && box[7] == symbol && box[8] == symbol) ||
                (box[0] == symbol && box[3] == symbol && box[6] == symbol) ||
                (box[1] == symbol && box[4] == symbol && box[7] == symbol) ||
                (box[2] == symbol && box[5] == symbol && box[8] == symbol) ||
                (box[0] == symbol && box[4] == symbol && box[8] == symbol) ||
                (box[2] == symbol && box[4] == symbol && box[6] == symbol));
    }
    private static void resumeBox(char[] box){
        for (int i = 0; i < 9; i++)
            box[i] = ' ';
    }
}