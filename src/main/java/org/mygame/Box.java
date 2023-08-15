package org.mygame;

import java.util.logging.Logger;

import static org.mygame.StepForPlay.*;

public class Box {

    boolean boxEmpty;
    static final byte BOX_SIZE = 9;
    boolean boxAvailable;
    Logger logger = Logger.getLogger(Box.class.getName());

    public void printBoard(char[] arrayOfCells) {
        logger.info("\n " + arrayOfCells[0] + " | " + arrayOfCells[1] + " | " + arrayOfCells[2] + " " +
                "\n-----------" +
                "\n " + arrayOfCells[3] + " | " + arrayOfCells[4] + " | " + arrayOfCells[5] + " " +
                "\n-----------" +
                "\n " + arrayOfCells[6] + " | " + arrayOfCells[7] + " | " + arrayOfCells[8] + " \n");

        if (!boxEmpty) {
            clearBoard(arrayOfCells);
        }
    }

    public static boolean isWinning(char[] box, char value) {
        return (box[0] == value && box[1] == value && box[2] == value) ||
                (box[3] == value && box[4] == value && box[5] == value) ||
                (box[6] == value && box[7] == value && box[8] == value) ||
                (box[0] == value && box[3] == value && box[6] == value) ||
                (box[1] == value && box[4] == value && box[7] == value) ||
                (box[2] == value && box[5] == value && box[8] == value) ||
                (box[0] == value && box[4] == value && box[8] == value) ||
                (box[2] == value && box[4] == value && box[6] == value);
    }

    public void clearBoard(char[] arrayOfCells) {
        for (byte i = 0; i < BOX_SIZE; i++) {
            arrayOfCells[i] = ' ';
            boxEmpty = true;
        }
    }

    public boolean isAvailable(char[] box) {
        boxAvailable = false;
        for (byte i = 0; i < BOX_SIZE; i++) {
            if (box[i] != PLAYER_SYMBOL && box[i] != COMPUTER_SYMBOL) {
                boxAvailable = true;
                break;
            }
        }
        return !boxAvailable;
    }
}
