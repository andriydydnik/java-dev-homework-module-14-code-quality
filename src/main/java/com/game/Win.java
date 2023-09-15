package com.game;

public class Win {
    public static boolean result(char[] box, char value) {
        return ((box[0] == value && box[1] == value && box[2] == value) || (box[3] == value && box[4] == value && box[5] == value) || (box[6] == value && box[7] == value && box[8] == value) ||
                (box[0] == value && box[3] == value && box[6] == value) || (box[1] == value && box[4] == value && box[7] == value) || (box[2] == value && box[5] == value && box[8] == value) ||
                (box[0] == value && box[4] == value && box[8] == value) || (box[2] == value && box[4] == value && box[6] == value));
    }
}
