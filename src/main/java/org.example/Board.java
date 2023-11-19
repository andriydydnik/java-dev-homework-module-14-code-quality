package org.example;

import static org.example.Constants.BOARD;
import static org.example.Constants.EMPTY_CELL;

public class Board {
    private boolean isBoardEmpty = false;
    @SuppressWarnings("java:S106")
    public void printBoard() {
        System.out.println("|---|---|---|");
        System.out.println("| " + BOARD[0] + " | " + BOARD[1] + " | " + BOARD[2] + " |");
        System.out.println("|-----------|");
        System.out.println("| " + BOARD[3] + " | " + BOARD[4] + " | " + BOARD[5] + " |");
        System.out.println("|-----------|");
        System.out.println("| " + BOARD[6] + " | " + BOARD[7] + " | " + BOARD[8] + " |");
        System.out.println("|---|---|---|");
    }

    public void resetBoard() {
        if (!isBoardEmpty) {
            for (byte i = 0; i < 9; i++) {
                BOARD[i] = EMPTY_CELL;
            }
            isBoardEmpty = true;
        }
    }
}
