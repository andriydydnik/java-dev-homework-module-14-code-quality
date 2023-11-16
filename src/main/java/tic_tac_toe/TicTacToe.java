package tic_tac_toe;

import java.util.*;

public class TicTacToe {

    private static final String ENTER_BOX_NUMBER_TO_SELECT_ENJOY = "Enter box number to select. Enjoy!\n";
    private static final String YOU_WON_THE_GAME = "You won the game!";
    private static final String CREATED_BY_SHREYAS_SAHA_THANKS_FOR_PLAYING = "Created by Shreyas Saha. Thanks for playing!";
    private static final String YOU_LOST_THE_GAME = "You lost the game!";
    private static final String IT_S_A_DRAW = "It's a draw!";
    private static final String THAT_ONE_IS_ALREADY_IN_USE_ENTER_ANOTHER = "That one is already in use. Enter another.";
    private static final String INVALID_INPUT_ENTER_AGAIN = "Invalid input. Enter again.";

    private final Random random = new Random();
    private final Scanner scan = new Scanner(System.in);
    private final char[] box = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};

    private boolean boxEmpty = false;

    public void startGame() {
        System.out.println(ENTER_BOX_NUMBER_TO_SELECT_ENJOY);

        while (true) {
            System.out.println("\n\n " + box[0] + " | " + box[1] + " | " + box[2] + " ");
            System.out.println("-----------");
            System.out.println(" " + box[3] + " | " + box[4] + " | " + box[5] + " ");
            System.out.println("-----------");
            System.out.println(" " + box[6] + " | " + box[7] + " | " + box[8] + " \n");

            if (!boxEmpty) {
                for (int i = 0; i < 9; i++)
                    box[i] = ' ';
                boxEmpty = true;
            }

            while (true) {
                int input = scan.nextInt();
                if (input > 0 && input < 10) {
                    if (box[input - 1] == 'X' || box[input - 1] == 'O')
                        System.out.println(THAT_ONE_IS_ALREADY_IN_USE_ENTER_ANOTHER);
                    else {
                        box[input - 1] = 'X';
                        break;
                    }
                } else {
                    System.out.println(INVALID_INPUT_ENTER_AGAIN);
                }
            }

            if (isWin(box, 'X') && winner(YOU_WON_THE_GAME)) {
                break;
            }

            if (!isBoxAvailable(box) && winner(IT_S_A_DRAW)) {
                break;
            }

            while (true) {
                int rand = random.nextInt(9);
                if (box[rand] != 'X' && box[rand] != 'O') {
                    box[rand] = 'O';
                    break;
                }
            }

            if (isWin(box, 'O') && winner(YOU_LOST_THE_GAME)) {
                break;
            }
        }
    }

    private static boolean isBoxAvailable(final char[] box) {
        for (int i = 0; i < 9; i++) {
            if (box[i] != 'X' && box[i] != 'O') {
                return true;
            }
        }
        return false;
    }

    private static boolean isWin(final char[] box, final char symbol) {
        return (box[0] == symbol && box[1] == symbol && box[2] == symbol) || (box[3] == symbol && box[4] == symbol && box[5] == symbol)
                || (box[6] == symbol && box[7] == symbol && box[8] == symbol) || (box[0] == symbol && box[3] == symbol && box[6] == symbol)
                || (box[1] == symbol && box[4] == symbol && box[7] == symbol) || (box[2] == symbol && box[5] == symbol && box[8] == symbol)
                || (box[0] == symbol && box[4] == symbol && box[8] == symbol) || (box[2] == symbol && box[4] == symbol && box[6] == symbol);
    }

    private static boolean winner(final String winner) {
        if (winner.equalsIgnoreCase(YOU_WON_THE_GAME)) {
            System.out.println(YOU_WON_THE_GAME);
            System.out.println(CREATED_BY_SHREYAS_SAHA_THANKS_FOR_PLAYING);
            return true;
        } else if (winner.equalsIgnoreCase(YOU_LOST_THE_GAME)) {
            System.out.println(YOU_LOST_THE_GAME);
            System.out.println(CREATED_BY_SHREYAS_SAHA_THANKS_FOR_PLAYING);
            return true;
        } else if (winner.equalsIgnoreCase(IT_S_A_DRAW)) {
            System.out.println(IT_S_A_DRAW);
            System.out.println(CREATED_BY_SHREYAS_SAHA_THANKS_FOR_PLAYING);
            return true;
        }
        return false;
    }
}
