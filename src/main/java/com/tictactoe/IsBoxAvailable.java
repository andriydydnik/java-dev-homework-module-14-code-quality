package com.tictactoe;

public class IsBoxAvailable {

    static boolean boxAvailable = false;

    public static boolean isBoxAvailable(char[] box) {
        boxAvailable = false;

        for (byte i = 0; i < 9; i++) {
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
