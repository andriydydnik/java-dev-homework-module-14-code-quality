package sergey.goit;

import java.text.MessageFormat;

import lombok.Setter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class App {

    private static final char[] BOX = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
    @Setter
    private static boolean game = true;
    static final Logger logger = LogManager.getLogger(App.class.getName());

    public static void main(String[] args) {
        logger.info("Enter box number to select. Enjoy!\n");
        startGame();
    }

    public static void startGame() {
        boolean boxEmpty = false;
        while (game) {
            logger.info(MessageFormat.format("\n  {0} | {1} | {2} ", BOX[0], BOX[1], BOX[2]));
            logger.info("-----------");
            logger.info(MessageFormat.format(" {0} | {1} | {2} ", BOX[3], BOX[4], BOX[5]));
            logger.info("-----------");
            logger.info(MessageFormat.format(" {0} | {1} | {2} \n", BOX[6], BOX[7], BOX[8]));
            if (!boxEmpty) {
                for (int i = 0; i < 9; i++)
                    BOX[i] = ' ';
                boxEmpty = true;
            }
            OverGame.hwoIsWinner(OverGame.getWinner());
            Turn.playerTurn(BOX);
            OverGame.checkGameOver(BOX);
            OverGame.checkBoxEmpty(BOX);
            Turn.computerTurn(BOX);
            OverGame.checkGameOver(BOX);
        }
    }


}