package com.tictactoe;

public class IsAvailableBoxes {

    boolean boxAvailable;
    static final byte NUMBEROFBOXES = 9;

    public boolean isAvailable(char[] box) {
        boxAvailable = false;

        for (byte i = 0; i < NUMBEROFBOXES; i++) {
            if (box[i] != 'X' && box[i] != 'O') {
                boxAvailable = true;
                break;
            }
        }

        return !boxAvailable;
    }

    IsAvailableBoxes() {
        throw new IllegalStateException("IsBoxAvailable class");
    }
}
