package com.example.app;

import java.util.Arrays;
import java.util.Random;

import static com.example.app.AppConstants.*;

public class GameManager {
    private final char[] box = { '1', '2', '3', '4', '5', '6', '7', '8', '9' };
    private boolean boxCleared;
    private boolean gameOver;

    public void startGame() {
        System.out.println("Enter box number to select. Enjoy!\n");

        while (!gameOver) {
            displayBox();
            if (!boxCleared) clearBox();

            System.out.print("\nYour turn: ");
            UserInput.readBoxNumber(box);

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
        return horizontalRowFilled(ch) || verticalRowFilled(ch) || diagonalRowFilled(ch);
    }

    private boolean horizontalRowFilled(char ch) {
        return (box[0] == ch && box[1] == ch && box[2] == ch) || (box[3] == ch && box[4] == ch && box[5] == ch) || (box[6] == ch && box[7] == ch && box[8] == ch);
    }

    private boolean verticalRowFilled(char ch) {
        return (box[0] == ch && box[3] == ch && box[6] == ch) || (box[1] == ch && box[4] == ch && box[7] == ch) || (box[2] == ch && box[5] == ch && box[8] == ch);
    }

    private boolean diagonalRowFilled(char ch) {
        return (box[0] == ch && box[4] == ch && box[8] == ch) || (box[2] == ch && box[4] == ch && box[6] == ch);
    }

    private boolean drawDetected() {
        for (char ch : box)
            if (ch == ' ') return false;
        return true;
    }

    private void makeOpponentMove() {
        Random random = new Random();
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
        displayBox();
        System.out.println(message + "\nThanks for playing!");
    }

    private void displayBox() {
        for (int i = 0; i < box.length; i++) {
            System.out.println(" " + box[i] + " | " + box[++i] + " | " + box[++i] + " ");
            if (i != box.length - 1)
                System.out.println("-----------");
        }
    }
}
