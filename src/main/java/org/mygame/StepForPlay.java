package org.mygame;

import java.util.Scanner;
import java.util.logging.Logger;

import static org.mygame.Box.isWinning;

public class StepForPlay {
    static Scanner scan = new Scanner(System.in);
    static final char PLAYER_SYMBOL = 'X';
    static final char COMPUTER_SYMBOL = 'O';
    byte rand;
    byte input;

    public boolean playerStep(char[] box) {
        Logger logger = Logger.getLogger(StepForPlay.class.getName());
        while (true) {
            input = scan.nextByte();
            if (input > 0 && input < 10) {
                if (box[input - 1] == PLAYER_SYMBOL || box[input - 1] == COMPUTER_SYMBOL) {
                    logger.info("That one is already in use. Enter another.");
                } else {
                    box[input - 1] = PLAYER_SYMBOL;
                    break;
                }
            } else {
                logger.info("Invalid input. Enter again.");
            }
        }
        return isWinning(box, PLAYER_SYMBOL);
    }

    public boolean computerStep(char[] box) {
        while (true) {
            rand = (byte) ((Math.random() * 9) + 1);
            if (box[rand - 1] != PLAYER_SYMBOL && box[rand - 1] != COMPUTER_SYMBOL) {
                box[rand - 1] = COMPUTER_SYMBOL;
                break;
            }
        }
        return isWinning(box, COMPUTER_SYMBOL);
    }
}
