package com.tictactoe;

public class IsBoxAvailable {

    static boolean boxAvailable = false;
    private static final byte NUMBEROFBOXES = 9;

    public static boolean isBoxAvailable(char[] box) {
        boxAvailable = false;

        for (byte i = 0; i < NUMBEROFBOXES; i++) {
            if (box[i] != 'X' && box[i] != 'O') {
                boxAvailable = true;
                break;
            }
        }

        return !boxAvailable;
    }

    private IsBoxAvailable() {
        throw new IllegalStateException("IsBoxAvailable class");
    }
}
