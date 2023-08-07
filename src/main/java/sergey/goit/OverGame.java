package sergey.goit;

import lombok.Getter;

import static sergey.goit.App.logger;

public class OverGame {

    private static final int[][] WINNING_COMBINATIONS = {
            {0, 1, 2}, {3, 4, 5}, {6, 7, 8},
            {0, 3, 6}, {1, 4, 7}, {2, 5, 8},
            {0, 4, 8}, {2, 4, 6}
    };
    private static byte count = 1;
    @Getter
    private static byte winner = 0;

    private OverGame() {
        throw new IllegalStateException();
    }

    public static void hwoIsWinner(byte winner) {
        switch (winner) {
            case 1 -> {
                logger.info("You won the game!\n Thanks for playing!");
                App.setGame(false);
            }
            case 2 -> {
                logger.info("You lost the game!\n Thanks for playing!");
                App.setGame(false);
            }
            case 3 -> {
                logger.info("It's a draw!\n Thanks for playing!");
                App.setGame(false);
            }
        }
    }

    public static void checkGameOver(char[] box) {
        count++;
        char symbol = (count % 2 == 0) ? 'X' : 'O';
        if (checkLine(symbol, box)) {
            winner = (byte) ((symbol == 'X') ? 1 : 2);
            App.startGame();
        }
    }

    private static boolean checkLine(char symbol, char[] box) {
        for (int[] combination : WINNING_COMBINATIONS) {
            if (box[combination[0]] == symbol &&
                    box[combination[1]] == symbol &&
                    box[combination[2]] == symbol) {
                return true;
            }
        }
        return false;
    }

    public static void checkBoxEmpty(char[] box) {
        boolean boxAvailable = false;
        int numberOfMoves = 9;
        for (int i = 0; i < numberOfMoves; i++) {
            if (box[i] != 'X' && box[i] != 'O') {
                boxAvailable = true;
                break;
            }
        }
        if (!boxAvailable) {
            winner = 3;
            hwoIsWinner(winner);
        }
    }
}
