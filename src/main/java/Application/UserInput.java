package Application;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class UserInput {
    static final Logger logger = LoggerFactory.getLogger(UserInput.class);
    Scanner scan = new Scanner(System.in);

    protected byte userChoice() {
        byte input;
        logger.info("Enter box number to select. Enjoy!\n");
        while (true) {
            input = scan.nextByte();
            if (input > 0 && input < 10) {
                return input;
            } else
                logger.info("Invalid input. Enter again.");
        }
    }

    protected void closeInput() {
        scan.close();
    }
}
