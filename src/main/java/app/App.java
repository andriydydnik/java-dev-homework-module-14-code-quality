package app;

import java.util.Scanner;

public class App {
    private static byte i;
    private static byte winner = 0;
    private static final char[] box = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};

    public static void main(String[] args) {
        boolean boxEmpty = false;
        boolean finish = false;

        while (!finish) {
            logGameUi();

            if (!boxEmpty) {
                clearGameUi();
                boxEmpty = true;
            }

            movePlayer();
            setWinner();
            if (winner == 1 || winner == 2 || winner == 3) {
                logWinner();
                finish = true;
            }

            if (!finish) {
                randomMove();
                setWinner();
                if (winner == 1 || winner == 2 || winner == 3) {
                    logWinner();
                    finish = true;
                }
            }

        }
    }

    private static void logGameUi() {
        log("\n\n " + box[0] + " | " + box[1] + " | " + box[2] + " ");
        log("-----------");
        log(" " + box[3] + " | " + box[4] + " | " + box[5] + " ");
        log("-----------");
        log(" " + box[6] + " | " + box[7] + " | " + box[8] + " \n");
    }

    private static void clearGameUi() {
        for (i = 0; i < 9; i++)
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
            if (isWinGame(symbol)) {
                winner = (byte) ((symbol == 'X') ? 1 : 2);
                return;
            }
        }
    }

    private static boolean isWinGame(char symbol) {
        return isWinCombination(symbol, 0, 1, 2) ||
                isWinCombination(symbol, 3, 4, 5) ||
                isWinCombination(symbol, 6, 7, 8) ||
                isWinCombination(symbol, 0, 3, 6) ||
                isWinCombination(symbol, 1, 4, 7) ||
                isWinCombination(symbol, 2, 5, 8) ||
                isWinCombination(symbol, 0, 4, 8) ||
                isWinCombination(symbol, 2, 4, 6);
    }

    private static boolean isWinCombination(char symbol, int a, int b, int c) {
        return box[a] == symbol && box[b] == symbol && box[c] == symbol;
    }

    private static void logWinner() {
        logGameUi();
        if (winner == 1) {
            log("You won the game!\nCreated by Shreyas Saha. Thanks for playing!");
            return;
        }
        if (winner == 2) {
            log("You lost the game!\nCreated by Shreyas Saha. Thanks for playing!");
            return;
        }
        log("It's a draw!\nCreated by Shreyas Saha. Thanks for playing!");

    }

    private static void movePlayer() {
        byte input;
        Scanner scan = new Scanner(System.in);
        while (true) {
            if (!scan.hasNextByte()) {
                scan.next();
                log("Invalid input. Enter again.");
                return;
            }
            input = scan.nextByte();
            if (input > 0 && input < 10) {
                if (box[input - 1] == 'X' || box[input - 1] == 'O')
                    log("That one is already in use. Enter another.");
                else {
                    box[input - 1] = 'X';
                    break;
                }
            } else
                log("Invalid input. Enter again.");

        }
    }

    private static void randomMove() {
        byte random;
        while (true) {
            random = (byte) (Math.random() * (9 - 1 + 1) + 1);
            if (box[random - 1] != 'X' && box[random - 1] != 'O') {
                box[random - 1] = 'O';
                break;
            }
        }
    }

    private static void log(String text) {
        System.out.println(text);
    }
}