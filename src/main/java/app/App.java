package app;

import java.util.Scanner;

public class App {
    private static byte i;
    private static byte winner = 0;
    private static final char[] box = { '1', '2', '3', '4', '5', '6', '7', '8', '9' };

    public static void main(String[] args) {
        boolean boxEmpty = false;
        boolean game = false;
        while (!game) {
            printKeyboard();
            if (!boxEmpty) {
                clearKeyboard();
                boxEmpty = true;
            }
            moviePlayer();
            setWinner();
            if (winner == 1 || winner == 2 || winner == 3) {
                printWinner();
                game = true;
            }

            movieComputer();
            setWinner();
            if (winner == 1 || winner == 2 || winner == 3) {
                printWinner();
                game = true;
            }
        }

    }
    private static void printKeyboard () {
        System.out.println("\n\n " + box[0] + " | " + box[1] + " | " + box[2] + " ");
        System.out.println("-----------");
        System.out.println(" " + box[3] + " | " + box[4] + " | " + box[5] + " ");
        System.out.println("-----------");
        System.out.println(" " + box[6] + " | " + box[7] + " | " + box[8] + " \n");
    }
    private static void clearKeyboard () {
        for(i = 0; i < 9; i++)
            box[i] = ' ';
    }
    private static void setWinner() {
        boolean boxAvailable = false;
        checkWinner();
        for (i = 0; i < 9; i++) {
            if (box[i] != 'X' && box[i] != 'O') {
                boxAvailable = true;
                break;
            }
        }
        if (!boxAvailable) {
            winner = 3;
        }
    }
    private static void checkWinner() {
        char[] symbols = {'X', 'O'};
        for (char symbol : symbols) {
            if (lineWinner(symbol)) {
                winner = (byte) ((symbol == 'X') ? 1 : 2);
                return;
            }
        }
    }
    private static boolean lineWinner(char symbol) {
        return checkLine(symbol, 0, 1, 2) ||
                checkLine(symbol, 3, 4, 5) ||
                checkLine(symbol, 6, 7, 8) ||
                checkLine(symbol, 0, 3, 6) ||
                checkLine(symbol, 1, 4, 7) ||
                checkLine(symbol, 2, 5, 8) ||
                checkLine(symbol, 0, 4, 8) ||
                checkLine(symbol, 2, 4, 6);
    }

    private static boolean checkLine(char symbol, int a, int b, int c) {
        return box[a] == symbol && box[b] == symbol && box[c] == symbol;
    }

    private static void printWinner() {
        printKeyboard();
        if (winner == 1) {
            System.out.println("You won the game!\nCreated by Shreyas Saha. Thanks for playing!");

        } else if (winner == 2) {
            System.out.println("You lost the game!\nCreated by Shreyas Saha. Thanks for playing!");

        } else if (winner == 3) {
            System.out.println("It's a draw!\nCreated by Shreyas Saha. Thanks for playing!");

        }
    }
    private static void moviePlayer() {
        byte input;
        Scanner scan = new Scanner(System.in);
        while (true) {
            if (scan.hasNextByte()) {
                input = scan.nextByte();
                if (input > 0 && input < 10) {
                    if (box[input - 1] == 'X' || box[input - 1] == 'O')
                        System.out.println("That one is already in use. Enter another.");
                    else {
                        box[input - 1] = 'X';
                        break;
                    }
                } else
                    System.out.println("Invalid input. Enter again.");
            } else {
                scan.next();
                System.out.println("Invalid input. Enter again.");
            }
        }
    }
    private static void movieComputer() {
        byte rand;
        while (true) {
            rand = (byte) (Math.random() * (9 - 1 + 1) + 1);
            if (box[rand - 1] != 'X' && box[rand - 1] != 'O') {
                box[rand - 1] = 'O';
                break;
            }
        }
    }
}
