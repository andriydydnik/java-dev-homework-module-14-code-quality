package Application;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Game {
    static final Logger logger = LoggerFactory.getLogger(Game.class);
    char[] box;
    UserInput userInput = new UserInput();

    public Game() {
        box = new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9'};
    }

    public void play() {
        boolean boxEmpty = false;
        boolean playing = true;
        while (playing) {
            printField();
            if (!boxEmpty) {
                resumeBox();
                boxEmpty = true;
            }
            userTurn();
            if (isUserWon()) {
                logger.info("You won the game!\nCreated by Shreyas Saha. Thanks for playing!");
                playing = false;
                userInput.closeInput();
            }
            if (isDraw()) {
                logger.info("It's a draw!\nCreated by Shreyas Saha. Thanks for playing!");
                playing = false;
                userInput.closeInput();
            }
            if (playing) {
                pcTurn();
            }
            if (isPCWon()) {
                logger.info("You lost the game!\nCreated by Shreyas Saha. Thanks for playing!");
                playing = false;
                userInput.closeInput();
            }
        }
    }

    private void printField() {
        String format = " {} | {} | {}";
        logger.info(format, box[0], box[1], box[2]);
        logger.info("-----------");
        logger.info(format, box[3], box[4], box[5]);
        logger.info("-----------");
        logger.info(format, box[6], box[7], box[8]);
    }

    private void userTurn() {
        byte input;
        boolean inputCorrect = false;
        input = userInput.userChoice();
        while (!inputCorrect) {
            if (box[input - 1] == 'X' || box[input - 1] == 'O') {
                logger.info("That one is already in use. Enter another.");
                input = userInput.userChoice();
            } else {
                box[input - 1] = 'X';
                inputCorrect = true;
            }
        }

    }

    private void pcTurn() {
        byte rand;
        while (true) {
            rand = (byte) (Math.random() * (9 - 1 + 1) + 1);
            if (box[rand - 1] != 'X' && box[rand - 1] != 'O') {
                box[rand - 1] = 'O';
                break;
            }
        }
    }

    private boolean isUserWon() {
        return isWin('X');
    }

    private boolean isPCWon() {
        return isWin('O');
    }

    private boolean isDraw() {
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

    private boolean isWin(char symbol) {
        return ((box[0] == symbol && box[1] == symbol && box[2] == symbol) ||
                (box[3] == symbol && box[4] == symbol && box[5] == symbol) ||
                (box[6] == symbol && box[7] == symbol && box[8] == symbol) ||
                (box[0] == symbol && box[3] == symbol && box[6] == symbol) ||
                (box[1] == symbol && box[4] == symbol && box[7] == symbol) ||
                (box[2] == symbol && box[5] == symbol && box[8] == symbol) ||
                (box[0] == symbol && box[4] == symbol && box[8] == symbol) ||
                (box[2] == symbol && box[4] == symbol && box[6] == symbol));
    }

    private void resumeBox() {
        for (int i = 0; i < 9; i++)
            box[i] = ' ';
    }
}