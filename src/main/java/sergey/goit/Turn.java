package sergey.goit;

import java.util.Scanner;

import static sergey.goit.App.logger;

class Turn {

    private Turn() {
        throw new IllegalStateException();
    }

    public static void playerTurn(char[] box) {
        Scanner scan = new Scanner(System.in);
        while (true) {
            byte input = scan.nextByte();
            if (input > 0 && input < 10) {
                if (box[input - 1] == 'X' || box[input - 1] == 'O')
                    logger.info("That one is already in use. Enter another.");
                else {
                    box[input - 1] = 'X';
                    break;
                }
            } else
                logger.info("Invalid input. Enter again.");
        }
    }

    public static void computerTurn(char[] box) {
        boolean rt = true;
        while (rt) {
            byte rand = (byte) (Math.random() * (9 - 1 + 1) + 1);
            if (box[rand - 1] != 'X' && box[rand - 1] != 'O') {
                box[rand - 1] = 'O';
                rt = false;
            }
        }
    }
}
