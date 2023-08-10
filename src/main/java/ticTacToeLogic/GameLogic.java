package ticTacToeLogic;

import board.TicTacToeBoard;
import moveLogic.AIMove;
import moveLogic.UserMove;

import java.util.Scanner;

public class GameLogic {
    private final TicTacToeBoard ticTacToeBoard;
    private static final char[] BOX = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
    private static byte winner = 0;

    public GameLogic(TicTacToeBoard ticTacToeBoard) {
        this.ticTacToeBoard = ticTacToeBoard;
    }

    public char[] getBox() {
        return BOX;
    }

    public void startGame() {
        Scanner scan = new Scanner(System.in);
        GameMessages gameMessages = new GameMessages();
        gameMessages.displayStartMessage();

        boolean boxEmpty = false;
        while (winner == 0) {
            ticTacToeBoard.displayBoard(getBox());

            if (!boxEmpty) {
                ticTacToeBoard.resetBoard(BOX);
                boxEmpty = true;
            }

            if (checkAndProcessUserMove()) {
                continue;
            }
            userMove(scan);
            checkAndProcessAIMove();
        }

        gameMessages.printResultMessage(winner);

        scan.close();
    }

    private static boolean checkAndProcessUserMove() {
        UserMove userMove = new UserMove(BOX);
        if (userMove.checkWin('X')) {
            winner = 1;
            return true;
        } else if (!userMove.checkAvailable()) {
            winner = 3;
            return true;
        }
        return false;
    }

    private static void checkAndProcessAIMove() {
        AIMove aiMove = new AIMove(BOX);
        aiMove.aiMove();
        if (aiMove.checkWin('O')) {
            winner = 2;
        }
    }

    private void userMove(Scanner scan) {
        UserMove userMove = new UserMove(BOX);
        userMove.userMove(scan);
    }
}
