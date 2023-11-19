package org.example;

public class Constants {
    protected static final char[] BOARD = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
    protected static final int[][] WINNING_COMBINATIONS = {
            {0, 1, 2}, {3, 4, 5}, {6, 7, 8},
            {0, 3, 6}, {1, 4, 7}, {2, 5, 8},
            {0, 4, 8}, {2, 4, 6}
    };

    public static final char PLAYER_X = 'X';
    public static final char PLAYER_O = 'O';
    public static final char EMPTY_CELL = ' ';

    private Constants() {
    }
}
