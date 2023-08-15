package com.andriiiiiko.tictactoe.game;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {

    private final GameBox gameBox = new GameBox();
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String PLAYER_WON_MESSAGE = "\nYou won the game!";
    private static final String COMPUTER_WON_MESSAGE = "\nYou lost the game!";
    private static final String DRAW_MESSAGE = "\nIt's a draw!";
    public static final String GAME_CREDITS_MESSAGE = "\nCreated by andriiiiiko. Thanks for playing!";
    private boolean gameInProgress = true;

    private byte getInput() {
        while (true) {
            System.out.print("Enter box number: ");
            byte input = readInput();

            if (isValidInput(input)) {
                if (gameBox.isBoxEmpty((byte) (input - 1))) {
                    return input;
                } else {
                    System.out.println("That one is already in use. Enter another.");
                }
            } else {
                System.out.println("Invalid input. Enter again.");
            }
        }
    }

    private byte readInput() {
        try {
            return SCANNER.nextByte();
        } catch (InputMismatchException e) {
            SCANNER.nextLine();
            return -1;
        }
    }

    private boolean isValidInput(byte input) {
        return input > 0 && input < 10;
    }

    private boolean playerMoveAndCheckForWin() {
        byte input = getInput();
        gameBox.fillBox((byte) (input - 1), 'X');

        return gameBox.checkFinalCombination('X');
    }

    private byte generateComputerMove() {
        while (true) {
            final byte rand = (byte) (Math.random() * 9 + 1);
            if (gameBox.isBoxEmpty(((byte) (rand - 1)))) {
                return rand;
            }
        }
    }

    private boolean computerMoveAndCheckForWin() {
        byte rnd = generateComputerMove();
        gameBox.fillBox((byte) (rnd - 1), 'O');

        return gameBox.checkFinalCombination('O');
    }

    private boolean checkDraw() {
        for (byte i = 0; i < 9; i++) {
            if (gameBox.isBoxFull(i)) {
                return true;
            }
        }

        return false;
    }

    private GameState playStrategy() {
        if (playerMoveAndCheckForWin()) {
            gameInProgress = false;
            return GameState.PLAYER_WON;
        } else if (computerMoveAndCheckForWin()) {
            gameInProgress = false;
            return GameState.COMPUTER_WON;
        } else if (checkDraw()) {
            gameInProgress = false;
            return GameState.DRAW;
        } else {
            return GameState.GOING;
        }
    }

    public void play() {
        boolean isFirstPrintOfBoxInfo = true;

        do {
            if (!isFirstPrintOfBoxInfo) {
                gameBox.printBoxInfo();
            }

            final GameState result = playStrategy();

            if (!gameInProgress) {
                writeWinningMessage(result);
            }

            isFirstPrintOfBoxInfo = false;
        } while (gameInProgress);
    }

    private void writeWinningMessage(final GameState variant) {
        if (GameState.PLAYER_WON.equals(variant)) {
            System.out.println(PLAYER_WON_MESSAGE + GAME_CREDITS_MESSAGE);
        } else if (GameState.COMPUTER_WON.equals(variant)) {
            System.out.println(COMPUTER_WON_MESSAGE + GAME_CREDITS_MESSAGE);
        } else if (GameState.DRAW.equals(variant)) {
            System.out.println(DRAW_MESSAGE + GAME_CREDITS_MESSAGE);
        }
    }
}
