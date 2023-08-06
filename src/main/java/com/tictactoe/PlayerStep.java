package com.tictactoe;

import java.util.Scanner;
import java.util.logging.Logger;

import static com.tictactoe.WinCombination.isWinning;

public class PlayerStep {

    private static final Scanner scan = new Scanner(System.in);
    private static final Logger logger = Logger.getLogger(PlayerStep.class.getName());
    static byte input;

    public static boolean playerSte(char[] box) {
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

    private PlayerStep() {
        throw new IllegalStateException("PlayerStep class");
    }
}
