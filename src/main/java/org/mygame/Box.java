package org.mygame;

import java.util.logging.Logger;

import static org.mygame.StepForPlay.*;

public class Box {
    boolean boxEmpty;
    static final byte BOX_SIZE = 9;
    boolean boxAvailable;

    public void printBoxInfo(char[] box) {
        String message = """
         
        %c | %c | %c
        -----------
         %c | %c | %c
        -----------
         %c | %c | %c
        """.formatted(
                box[0], box[1], box[2],
                box[3], box[4], box[5],
                box[6], box[7], box[8]
        );

        Logger logger = Logger.getLogger(Box.class.getName());
        logger.info(message);

        if (!boxEmpty) {
            clearBoard(box);
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

    public void clearBoard(char[] box) {
        for (byte i = 0; i < BOX_SIZE; i++) {
            box[i] = ' ';
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
