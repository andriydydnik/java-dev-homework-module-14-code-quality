package sergey.goit;

import java.text.MessageFormat;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class App {
    private static final char[] BOX = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
    private static final int[][] WINNING_COMBINATIONS = {
            {0, 1, 2}, {3, 4, 5}, {6, 7, 8},
            {0, 3, 6}, {1, 4, 7}, {2, 5, 8},
            {0, 4, 8}, {2, 4, 6}
    };
    private static byte winner = 0;
    private static byte i;
    private static Scanner scan;
    private static boolean game = true;
    private static byte count = 1;
    private static final Logger logger = LogManager.getLogger(App.class.getName());


    public static void main(String[] args) {
        scan = new Scanner(System.in);
        logger.info("Enter box number to select. Enjoy!\n");
        startGame();
    }

    private static void startGame() {
        boolean boxEmpty = false;
        while (game) {
            logger.info(MessageFormat.format("\n  {0} | {1} | {2} ", box[0], box[1], box[2]));
            logger.info("-----------");
            logger.info(MessageFormat.format(" {0} | {1} | {2} ", box[3], box[4], box[5]));
            logger.info("-----------");
            logger.info(MessageFormat.format(" {0} | {1} | {2} \n", box[6], box[7], box[8]));
            if (!boxEmpty) {
                for (i = 0; i < 9; i++)
                    box[i] = ' ';
                boxEmpty = true;
            }
            hwoIsWinner(winner);
            playerTurn();
            checkGameOver();
            checkBoxEmpty();
            computerTurn();
            checkGameOver();
        }
    }

    private static void hwoIsWinner(byte winner) {
        switch (winner) {
            case 1 -> {
                logger.info("You won the game!\n Thanks for playing!");
                game = false;
            }
            case 2 -> {
                logger.info("You lost the game!\n Thanks for playing!");
                game = false;
            }
            case 3 -> {
                logger.info("It's a draw!\n Thanks for playing!");
                game = false;
            }
        }
    }

    private static void playerTurn() {
        while (true) {
            byte input = scan.nextByte();
            if (input > 0 && input < 10) {
                if (BOX[input - 1] == 'X' || BOX[input - 1] == 'O')
                    logger.info("That one is already in use. Enter another.");
                else {
                    BOX[input - 1] = 'X';
                    break;
                }
            } else
                logger.info("Invalid input. Enter again.");
        }
    }

    private static void checkBoxEmpty() {
        boolean boxAvailable = false;
        int numberOfMoves = 9;
        for (i = 0; i < numberOfMoves; i++) {
            if (BOX[i] != 'X' && BOX[i] != 'O') {
                boxAvailable = true;
                break;
            }
        }
        if (!boxAvailable) {
            winner = 3;
            hwoIsWinner(winner);
        }
    }

    private static void computerTurn() {
        boolean rt = true;
        while (rt) {
            byte rand = (byte) (Math.random() * (9 - 1 + 1) + 1);
            if (BOX[rand - 1] != 'X' && BOX[rand - 1] != 'O') {
                BOX[rand - 1] = 'O';
                rt = false;
            }
        }
    }

    private static void checkGameOver() {
        count++;
        char symbol = (count % 2 == 0) ? 'X' : 'O';
        if (checkLine(symbol)) {
            winner = (byte) ((symbol == 'X') ? 1 : 2);
            startGame();
        }
    }

    public static boolean checkLine(char symbol) {
        for (int[] combination : WINNING_COMBINATIONS) {
            if (BOX[combination[0]] == symbol &&
                    BOX[combination[1]] == symbol &&
                    BOX[combination[2]] == symbol) {
                return true;
            }
        }
        return false;
    }
}
