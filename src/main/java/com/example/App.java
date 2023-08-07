package com.example;
import java.util.Scanner;

/**
 * Class with app.
 */
public final class App {
    /**
     * Initialize board size.
     */
    private static final int BOARD_SIZE = 9;
    /**
     * Initialize player symbol.
     */
    private static final char PLAYER_S = 'X';
    /**
     * Initialize artificial intelligence symbol.
     */
    private static final char AI_S = 'O';
    /**
     * Index of top left margin.
     */
    private static final int T_LEFT = 0;
    /**
     * Index of top center margin.
     */
    private static final int T_CENTER = 1;
    /**
     * Index of top rigth margin.
     */
    private static final int T_RIGHT = 2;
    /**
     * Index of middle left margin.
     */
    private static final int M_LEFT = 3;
    /**
     * Index of middle center margin.
     */
    private static final int M_CENTER = 4;
    /**
     * Index of middle right margin.
     */
    private static final int M_RIGHT = 5;
    /**
     * Index of bottom left margin.
     */
    private static final int B_LEFT = 6;
    /**
     * Index of bottom center margin.
     */
    private static final int B_CENTER = 7;
    /**
     * Index of bottom right margin.
     */
    private static final int B_RIGHT = 8;
    /**
     * Initialize number of player win.
     */
    private static final int WIN_PLAYER = 1;
    /**
     * Initialize number of artificial intelligence win.
     */
    private static final int WIN_AI = 2;
    /**
     * Initialize number of draw.
     */
    private static final int WIN_DRAW = 3;

    private App() {
    }

    /**
     * Main method.
     *
     * @param args User arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        byte input;
        byte rand;
        byte i;
        boolean boxAvailable;
        byte winner = 0;
        char[] box = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
        System.out.println("Enter box number to select. Enjoy!\n");

        boolean boxEmpty = false;
        while (true) {
            System.out.println("\n\n " + box[T_LEFT] + " | " + box[T_CENTER]
                    + " | " + box[T_RIGHT] + " \n");
            System.out.println("-----------");
            System.out.println(" " + box[M_LEFT] + " | " + box[M_CENTER]
                    + " | " + box[M_RIGHT] + " \n");
            System.out.println("-----------");
            System.out.println(" " + box[B_LEFT] + " | " + box[B_CENTER]
                    + " | " + box[B_RIGHT] + " \n");
            if (!boxEmpty) {
                for (i = 0; i < BOARD_SIZE; i++) {
                    box[i] = ' ';
                }
                boxEmpty = true;
            }

            if (winner == WIN_PLAYER) {
                System.out.println("You won the game!");
                System.out.println("Created by Shreyas Saha. "
                        + "Thanks for playing!");
                break;
            } else if (winner == WIN_AI) {
                System.out.println("You lost the game!");
                System.out.println("Created by Shreyas Saha. "
                        + "Thanks for playing!");
                break;
            } else if (winner == WIN_DRAW) {
                System.out.println("It's a draw!");
                System.out.println("Created by Shreyas Saha. "
                        + "Thanks for playing!");
                break;
            }

            while (true) {
                input = scan.nextByte();
                if (input > 0 && input < BOARD_SIZE + 1) {
                    if (box[input - 1] == PLAYER_S || box[input - 1] == AI_S) {
                        System.out.println("That one is already in use. "
                                + "Enter another.");
                    } else {
                        box[input - 1] = PLAYER_S;
                        break;
                    }
                } else {
                    System.out.println("Invalid input. Enter again.");
                }
            }
            if ((box[T_LEFT] == PLAYER_S && box[T_CENTER]
                    == PLAYER_S && box[T_RIGHT] == PLAYER_S)
                    || (box[M_LEFT] == PLAYER_S && box[M_CENTER]
                    == PLAYER_S && box[M_RIGHT] == PLAYER_S)
                    || (box[B_LEFT] == PLAYER_S && box[B_CENTER]
                    == PLAYER_S && box[B_RIGHT] == PLAYER_S)
                    || (box[T_LEFT] == PLAYER_S && box[M_LEFT]
                    == PLAYER_S && box[B_LEFT] == PLAYER_S)
                    || (box[T_CENTER] == PLAYER_S && box[M_CENTER]
                    == PLAYER_S && box[B_CENTER] == PLAYER_S)
                    || (box[T_RIGHT] == PLAYER_S && box[M_RIGHT]
                    == PLAYER_S && box[B_RIGHT] == PLAYER_S)
                    || (box[T_LEFT] == PLAYER_S && box[M_CENTER]
                    == PLAYER_S && box[B_RIGHT] == PLAYER_S)
                    || (box[T_RIGHT] == PLAYER_S && box[M_CENTER]
                    == PLAYER_S && box[B_LEFT] == PLAYER_S)) {
                winner = WIN_PLAYER;
                continue;
            }

            boxAvailable = false;
            for (i = 0; i < BOARD_SIZE; i++) {
                if (box[i] != PLAYER_S && box[i] != AI_S) {
                    boxAvailable = true;
                    break;
                }
            }

            if (!boxAvailable) {
                winner = WIN_DRAW;
                continue;
            }

            while (true) {
                rand = (byte) (Math.random() * (BOARD_SIZE - 1 + 1) + 1);
                if (box[rand - 1] != PLAYER_S && box[rand - 1] != AI_S) {
                    box[rand - 1] = AI_S;
                    break;
                }
            }

            if ((box[T_LEFT] == AI_S && box[T_CENTER]
                    == AI_S && box[T_RIGHT] == AI_S)
                    || (box[M_LEFT] == AI_S && box[M_CENTER]
                    == AI_S && box[M_RIGHT] == AI_S)
                    || (box[B_LEFT] == AI_S && box[B_CENTER]
                    == AI_S && box[B_RIGHT] == AI_S)
                    || (box[T_LEFT] == AI_S && box[M_LEFT]
                    == AI_S && box[B_LEFT] == AI_S)
                    || (box[T_CENTER] == AI_S && box[M_CENTER]
                    == AI_S && box[B_CENTER] == AI_S)
                    || (box[T_RIGHT] == AI_S && box[M_RIGHT]
                    == AI_S && box[B_RIGHT] == AI_S)
                    || (box[T_LEFT] == AI_S && box[M_CENTER]
                    == AI_S && box[B_RIGHT] == AI_S)
                    || (box[T_RIGHT] == AI_S && box[M_CENTER]
                    == AI_S && box[B_LEFT] == AI_S)) {
                winner = WIN_AI;
            }
        }
    }
}
