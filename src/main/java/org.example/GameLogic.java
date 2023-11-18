package org.example;

import java.util.Scanner;
import java.util.logging.Logger;

import static org.example.Constants.*;

public class GameLogic {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final Logger LOGGER = Logger.getLogger(GameLogic.class.getName());
    private static int winner = 0;
    private static final Board board = new Board();

    private GameLogic() {
    }

    public static void startGame() {
        while (true) {
            board.printBoard();
            Board.resetBoard();
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


    private static void playerInput() {
        while (true) {
            byte input = SCANNER.nextByte();
            if (input > 0 && input < 10) {
                if (BOARD[input - 1] == PLAYER_X || BOARD[input - 1] == PLAYER_O)
                    LOGGER.info("That one is already in use. Enter another.");
                else {
                    BOARD[input - 1] = PLAYER_X;
                    break;
                }
            } else
                LOGGER.warning("Invalid input. Enter again.");
        }
    }

    private static void checkGameResult() {
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