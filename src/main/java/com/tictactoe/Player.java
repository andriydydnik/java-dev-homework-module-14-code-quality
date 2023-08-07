package com.tictactoe;

import java.util.logging.Logger;

import static com.tictactoe.TicTacToe.scan;
import static com.tictactoe.WinCombination.isWinning;

public class Player {

    private static final Logger logger = Logger.getLogger(Player.class.getName());
    byte input;

    public boolean playerStep(char[] box) {
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

        return isWinning(box, 'X');
    }

    public Player() {
        throw new IllegalStateException("PlayerStep class");
    }
}
