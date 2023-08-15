package org.mygame;

import java.util.logging.Logger;

import static org.mygame.StepForPlay.scan;

public class Game {
    private final char[] BOX = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
    private static final String MESSAGE_CREATE_GAME = "\nCreated by Shreyas Saha. Thanks for playing!";
    private static final String MESSAGE_ON_WON = "You won the game!";
    private static final String MESSAGE_ON_LOST = "You lost the game!";
    private static final String MESSAGE_ON_DRAW = "It's a draw!";


    public void playGame() {
        Logger logger = Logger.getLogger(Game.class.getName());
        logger.info("Enter box number to select. Enjoy!\n");
        Box box = new Box();
        StepForPlay stepForPlay = new StepForPlay();

        while (true) {
            box.printBoxInfo(this.BOX);

            if (stepForPlay.playerStep(this.BOX)) {
                logger.info(MESSAGE_ON_WON + MESSAGE_CREATE_GAME);
                scan.close();
                break;
            }

            if (new Box().isAvailable(this.BOX)) {
                logger.info(MESSAGE_ON_DRAW + MESSAGE_CREATE_GAME);
                scan.close();
                break;
            }

            if (stepForPlay.computerStep(this.BOX)) {
                logger.info(MESSAGE_ON_LOST + MESSAGE_CREATE_GAME);
                scan.close();
                break;
            }
        }
    }
}