package com.tictactoe;

import java.util.Scanner;
import java.util.logging.Logger;

public class TicTacToe {

    static Scanner scan = new Scanner(System.in);
    Logger logger = Logger.getLogger(TicTacToe.class.getName());
    char[] box = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};


    public void startGame() {
        logger.info("Enter box number to select. Enjoy!\n");
        Board board = new Board();
        Player player = new Player();

        while (true) {
            board.printBoard(box);

            if (player.playerStep(box)) {
                logger.info("You won the game!\nCreated by Shreyas Saha. Thanks for playing!");
                scan.close();
                break;
            }


            if (new IsAvailableBoxes().isAvailable(box)) {
                logger.info("It's a draw!\nCreated by Shreyas Saha. Thanks for playing!");
                scan.close();
                break;
            }

            if (new Computer().computerStep(box)) {
                logger.info("You lost the game!\nCreated by Shreyas Saha. Thanks for playing!");
                scan.close();
                break;
            }
        }
    }
}