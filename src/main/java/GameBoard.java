import java.util.Arrays;
import java.util.logging.Logger;

public class GameBoard {

    private static final Logger logger = Logger.getLogger(GameBoard.class.getName());


    public void displayBoard(char [] box) {
        String boardString = "\n\n " + box[0] + " | " + box[1] + " | " + box[2] + " "
                + "\n-----------"
                + "\n " + box[3] + " | " + box[4] + " | " + box[5] + " "
                + "\n-----------"
                + "\n " + box[6] + " | " + box[7] + " | " + box[8] + " \n";

        logger.info(boardString);
    }

    public void resetBoard(char [] box) {
        Arrays.fill(box, ' ');
    }

}
