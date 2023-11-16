package com.example.game_resources;

import java.util.Arrays;

public class Box {
    /**
     * All possible victory lines in 3*3 game
     */
    private static final int[][] directions =
            {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {0, 4, 8}, {2, 4, 7}};
    private static final char ERROR_RETURN_VALUE = '=';
    public static final char ZERO = '0';
    public static final char X = 'X';
    private final char[] boxState = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
    private GameStates gameState = GameStates.ONGOING;

    public char[] getBoxState() {
        return boxState;
    }

    public GameStates getGameState() {
        return gameState;
    }

    /**
     * Expects an index from 1 to 9, this is why it subtracts 1 when getting a value
     */
    public char getSquare(int naturalNumber) {
        if (naturalNumber > 0 && naturalNumber <= boxState.length) {
            return boxState[naturalNumber - 1];
        }
        return ERROR_RETURN_VALUE;
    }

    public void setSquare(int naturalNumber, char newValue) {
        if (naturalNumber > 0 && naturalNumber <= boxState.length) {
            boxState[naturalNumber - 1] = newValue;
        } else {
            throw new IllegalArgumentException("1 to " + boxState.length + " values are ok only");
        }
    }

    public boolean isBoxEmpty() {
        for (char square : boxState) {
            if (square == X || square == ZERO) {
                return false;
            }
        }
        return true;
    }

    public void updateGameState() {
        if (anyRowWithSameChar(X)) {
            gameState = GameStates.VICTORY;
        } else if (anyRowWithSameChar(ZERO)) {
            gameState = GameStates.DEFEAT;
        } else if (isDraw()) {
            gameState = GameStates.DRAW;
        } else {
            gameState = GameStates.ONGOING;
        }
    }

    public void printBoxState() {
        System.out.println("\n\n " + boxState[0] + " | " + boxState[1] + " | " + boxState[2] + " ");
        System.out.println("-----------");
        System.out.println(" " + boxState[3] + " | " + boxState[4] + " | " + boxState[5] + " ");
        System.out.println("-----------");
        System.out.println(" " + boxState[6] + " | " + boxState[7] + " | " + boxState[8] + " \n");
    }

    public void cleanBox() {
        Arrays.fill(boxState, ' ');
    }

    private boolean isDraw() {
        for (char square : boxState) {
            if (square != X && square != ZERO) {
                return false;
            }
        }
        return true;
    }

    private boolean anyRowWithSameChar(char character) {
        for (int[] direction : directions) {
            boolean allAreSame = true;
            for (int square : direction) {
                if (boxState[square] != character) {
                    allAreSame = false;
                    break;
                }
            }
            if (allAreSame) {
                return true;
            }
        }
        return false;
    }
}
