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

    public static boolean isWinning(char[] box, char symbol) {
        return (box[0] == symbol && box[1] == symbol && box[2] == symbol) ||
                (box[3] == symbol && box[4] == symbol && box[5] == symbol) ||
                (box[6] == symbol && box[7] == symbol && box[8] == symbol) ||
                (box[0] == symbol && box[3] == symbol && box[6] == symbol) ||
                (box[1] == symbol && box[4] == symbol && box[7] == symbol) ||
                (box[2] == symbol && box[5] == symbol && box[8] == symbol) ||
                (box[0] == symbol && box[4] == symbol && box[8] == symbol) ||
                (box[2] == symbol && box[4] == symbol && box[6] == symbol);
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
