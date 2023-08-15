package org.mygame;

import java.util.logging.Logger;

import static org.mygame.StepForPlay.scan;

public class Game {
    Logger logger = Logger.getLogger(Game.class.getName());
    char[] box = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
    private static final String MESAGE_CREATE_GAME = "\nCreated by Shreyas Saha. Thanks for playing!";
    private static final String MESAGE_ON_WON = "You won the game!";
    private static final String MESAGE_ON_LOST = "You lost the game!";
    private static final String MESAGE_ON_DRAW = "It's a draw!";


    public void playGame() {
        logger.info("Enter box number to select. Enjoy!\n");
        Box box = new Box();
        StepForPlay stepForPlay = new StepForPlay();

        while (true) {
            box.printBoard(this.box);

            if (stepForPlay.playerStep(this.box)) {
                logger.info(MESAGE_ON_WON + MESAGE_CREATE_GAME);
                scan.close();
                break;
            }

            if (new Box().isAvailable(this.box)) {
                logger.info(MESAGE_ON_DRAW + MESAGE_CREATE_GAME);
                scan.close();
                break;
            }

            if (stepForPlay.computerStep(this.box)) {
                logger.info(MESAGE_ON_LOST + MESAGE_CREATE_GAME);
                scan.close();
                break;
            }
        }
    }
}