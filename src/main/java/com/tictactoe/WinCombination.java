package com.tictactoe;

public class WinCombination {

    public static boolean isWinning(char[] box, char value) {
        return (box[0] == value && box[1] == value && box[2] == value) || (box[3] == value && box[4] == value && box[5] == value) || (box[6] == value && box[7] == value && box[8] == value ||
                box[0] == value && box[3] == value && box[6] == value) || (box[1] == value && box[4] == value && box[7] == value) || (box[2] == value && box[5] == value && box[8] == value ||
                box[0] == value && box[4] == value && box[8] == value) || (box[2] == value && box[4] == value && box[6] == value);
    }

    private WinCombination() {
        throw new IllegalStateException("WinCombination class");
    }
}
