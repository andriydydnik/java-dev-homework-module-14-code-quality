package com.example.app;

import java.util.Arrays;
import java.util.Random;

import static com.example.app.AppConstants.*;

public class GameManager {
    private final Random random = new Random();
    private final char[] box = { '1', '2', '3', '4', '5', '6', '7', '8', '9' };
    private boolean boxCleared;
    private boolean gameOver;

    public void startGame() {
        System.out.println("Welcome to Tic-tac-toe! Enter box number to select. Enjoy ^_^\n");

        while (!gameOver) {
            Console.displayBox(box);
            if (!boxCleared) clearBox();

            System.out.print("\nEnter box number: ");
            Console.readBoxNumber(box);

            if (playerWon()) {
                finishGame("\nYou won the game!");
            }
            else if (drawDetected()) {
                finishGame("\nIt's a draw!");
            }
            else {
                makeOpponentMove();

                if (opponentWon())
                    finishGame("\nYou lost the game!");
            }
        }
    }

    private boolean playerWon() {
        return detectWinner(PLAYER_SYMBOL);
    }

    private boolean opponentWon() {
        return detectWinner(OPPONENT_SYMBOL);
    }

    private boolean detectWinner(char ch) {
        int[][] combinations = { {0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {0, 4, 8}, {2, 4, 6} };
        for (int[] comb : combinations)
            if (Arrays.stream(comb).allMatch(i -> box[i] == ch)) return true;
        return false;
    }

    private boolean drawDetected() {
        for (char ch : box)
            if (ch == EMPTY_SYMBOL) return false;
        return true;
    }

    private void makeOpponentMove() {
        while (true) {
            int index = random.nextInt(box.length);
            if (box[index] == EMPTY_SYMBOL) {
                box[index] = OPPONENT_SYMBOL;
                break;
            }
        }
    }

    private void clearBox() {
        Arrays.fill(box, EMPTY_SYMBOL);
        boxCleared = true;
    }

    private void finishGame(String message) {
        gameOver = true;
        Console.displayBox(box);
        System.out.println(message + "\nThanks for playing!");
    }
}
