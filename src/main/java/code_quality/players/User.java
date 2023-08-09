package code_quality.players;

import java.util.Scanner;

public class User {

    Scanner scan = new Scanner(System.in);

    public void takeStep(char[] box) {
        while (true) {
            byte userStep = scan.nextByte();
            if (userStep > 0 && userStep < 10) {
                if (box[userStep - 1] == 'X' || box[userStep - 1] == 'O')
                    System.out.println("That one is already in use. Enter another.");
                else {
                    box[userStep - 1] = 'X';
                    break;
                }
            } else
                System.out.println("Invalid input. Enter again.");
        }
    }
}
