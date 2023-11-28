package game;

import java.util.Scanner;
import java.util.logging.Logger;

import static game.Win.result;

public class Human {
    Scanner scan = new Scanner(System.in);
    private static final Logger logger = Logger.getLogger(Human.class.getName());
    byte input;
    public boolean playerMove(char [] box){
        while (true) {
            input = scan.nextByte();
            if (input > 0 && input < 10) {
                if (box[input - 1] == 'X' || box[input - 1] == 'O')
                    logger.info("That one is alr5eady in use. Enter another.");
                else {
                    box[input - 1] = 'X';
                    break;
                }
            }
            else
                logger.info("Invalid input. Enter again.");
        }
        return result(box, 'X');
    }
}

