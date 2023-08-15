package com.andriiiiiko.tictactoe.game;

public class GameBox {

    private final char[] box = new char[9];
    private static final char EMPTY_CELL = ' ';
    private static final char PLAYER_SYMBOL = 'X';
    private static final char COMPUTER_SYMBOL = 'O';

    public GameBox() {
        initBox();
    }

    private void initBox() {
        for (int i = 0; i < 9; i++) {
            box[i] = EMPTY_CELL;
        }
    }

    void printBoxInfo() {
        System.out.printf("""
                         
                         
                         %c | %c | %c
                        -----------
                         %c | %c | %c
                        -----------
                         %c | %c | %c
                         
                        """,
                box[0], box[1], box[2],
                box[3], box[4], box[5],
                box[6], box[7], box[8]
        );
    }

    boolean checkFinalCombination(final char symbol) {
        int[][] winningCombinations = {
                {0, 1, 2}, {3, 4, 5}, {6, 7, 8},
                {0, 3, 6}, {1, 4, 7}, {2, 5, 8},
                {0, 4, 8}, {2, 4, 6}
        };

        for (int[] combination : winningCombinations) {
            if (box[combination[0]] == symbol && box[combination[1]] == symbol && box[combination[2]] == symbol) {
                return true;
            }
        }

        return false;
    }

    boolean isBoxEmpty(byte i) {
        return box[i] != PLAYER_SYMBOL && box[i] != COMPUTER_SYMBOL;
    }

    boolean isBoxFull(byte i) {
        return box[i] == PLAYER_SYMBOL && box[i] == COMPUTER_SYMBOL;
    }

    void fillBox(final byte i, final char symbol) {
        box[i] = symbol;
    }
}
