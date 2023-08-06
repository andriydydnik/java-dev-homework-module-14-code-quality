package com.tictactoe;

import java.util.logging.Logger;

import static com.tictactoe.Board.printFieldAll;
import static com.tictactoe.ComputerStep.computerSte;
import static com.tictactoe.IsBoxAvailable.isBoxAvailable;
import static com.tictactoe.PlayerStep.playerSte;

public class TicTacToe {

    private static final Logger logger = Logger.getLogger(TicTacToe.class.getName());
    private static final char[] box = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};

    public void startGame() {
        logger.info("Enter box number to select. Enjoy!\n");

        while (true) {
            printFieldAll(box);

            if (playerSte(box)) {
                logger.info("You won the game!\nCreated by Shreyas Saha. Thanks for playing!");
                break;
            }

            if (isBoxAvailable(box)) {
                logger.info("It's a draw!\nCreated by Shreyas Saha. Thanks for playing!");
                break;
            }

            if (computerSte(box)) {
                logger.info("You lost the game!\nCreated by Shreyas Saha. Thanks for playing!");
                break;
            }
        }
    }
}