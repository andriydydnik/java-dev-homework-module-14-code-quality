package org.example;

import java.util.Scanner;

import static org.example.Constants.*;

public class Game {
    private static int winner = 0;
    private Board board;

    public Game() {
        this.board = new Board();
    }

    public void startGame() {
        while (true) {
            board.printBoard();
            board.resetBoard();
            playerInput();
            checkAvailableMoves();
            checkGameResult();
            if (winner != 0) {
                displayGameResultMessage(winner);
                break;
            }
            makeComputerMove();
            checkAvailableMoves();
            checkGameResult();
            if (winner != 0) {
                displayGameResultMessage(winner);
                break;
            }
        }
    }
    private void checkGameResult() {
        if (checkWinner(PLAYER_X)) {
            board.printBoard();
            winner = 1;
        } else if (checkWinner(PLAYER_O)) {
            board.printBoard();
            winner = 2;
        } else {
            checkAvailableMoves();
        }
    }

    @SuppressWarnings("java:S106")
    private static void playerInput() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            byte input = scanner.nextByte();
            if (input > 0 && input < 10) {
                if (BOARD[input - 1] == PLAYER_X || BOARD[input - 1] == PLAYER_O)
                    System.out.println("That one is already in use. Enter another.");
                else {
                    BOARD[input - 1] = PLAYER_X;
                    break;
                }
            } else {
                System.out.println("Invalid input. Enter again.");
            }
        }
    }

    private static boolean checkWinner(int symbol) {
        for (int[] combination : WINNING_COMBINATIONS) {
            if (BOARD[combination[0]] == symbol && BOARD[combination[1]] == symbol && BOARD[combination[2]] == symbol) {
                return true;
            }
        }
        return false;
    }

    @SuppressWarnings("java:S106")
    private static void displayGameResultMessage(int winner) {
        switch (winner) {
            case 1 -> System.out.println("You won the game!\nCreated by Shreyas Saha. Thanks for playing!");
            case 2 -> System.out.println("You lost the game!\nCreated by Shreyas Saha. Thanks for playing!");
            case 3 -> System.out.println("It's a draw!\nCreated by Shreyas Saha. Thanks for playing!\"");
            default -> System.out.println("Opps, Exception");
        }
    }

    private static void makeComputerMove() {
        while (true) {
            byte rand = (byte) (Math.random() * (9 - 1 + 1) + 1);
            if (BOARD[rand - 1] != PLAYER_X && BOARD[rand - 1] != PLAYER_O) {
                BOARD[rand - 1] = PLAYER_O;
                break;
            }
        }
    }

    private static void checkAvailableMoves() {
        boolean boxAvailable = false;

        for (int i = 0; i < 9; i++) {
            if (BOARD[i] != PLAYER_X && BOARD[i] != PLAYER_O) {
                boxAvailable = true;
                break;
            }
        }
        if (!boxAvailable) {
            winner = 3;
        }
    }
}