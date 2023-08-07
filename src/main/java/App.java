import tic_tac_toe.FieldForPlay;
import tic_tac_toe.Game;
import tic_tac_toe.LoggerForMessage;

import java.util.Scanner;
import java.util.logging.Logger;

public class App {

    private static final  App app = new App();
    private static final Logger logger = LoggerForMessage.getCustomizedLogger(app);

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        byte input;
        byte moveCount = 0;
        char [] box = { '1', '2', '3', '4', '5', '6', '7', '8', '9' };
        logger.info("Enter box number to select. Enjoy!\n");

        boolean boxEmpty = false;
        while (true) {
            String fieldForPrint = FieldForPlay.getField(box);
            logger.info(fieldForPrint);
            if(!boxEmpty){
                FieldForPlay.clearFieldForPlay(box);
                boxEmpty = true;
            }


            char winnChar = Game.determineWinner(box);
            if ( winnChar == 'X' ||
                    winnChar == 'O' ||
                    (winnChar == 'D' && moveCount == 10)){
                String message = Game.getMessageForWinner(winnChar);
                logger.info(message);
                break;
            }


            boolean humanMoveDone = false;
            while (!humanMoveDone) {
                input = scan.nextByte();
                humanMoveDone = Game.humanMove(input, box);
            }
            moveCount++;


            boolean computerMoveDone = false;
            while (!computerMoveDone) {
                if (moveCount == 9){
                    break;
                }
            computerMoveDone = Game.computerMove(box);
            }
            moveCount++;
        }

        scan.close();

    }
}