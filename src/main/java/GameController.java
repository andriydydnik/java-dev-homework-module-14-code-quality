import java.util.Scanner;
public class GameController {
    private final GameBoard gameBoard;
    private static final char[] BOX = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
    private static byte winner = 0;

    public GameController(GameBoard gameBoard) {
        this.gameBoard = gameBoard;
    }

    public char[] getBox() {
        return BOX;
    }

    public void startGame() {
        Scanner scan = new Scanner(System.in);
        GameMessages gameMessages=new GameMessages();
        gameMessages.displayStartMessage();

        boolean boxEmpty = false;
        while (winner == 0) {
            gameBoard.displayBoard(getBox());

            if (!boxEmpty) {
                gameBoard.resetBoard(BOX);
                boxEmpty = true;
            }

            if (checkAndProcessUserMove()) {
                continue;
            }
            userMove(scan);
            checkAndProcessAIMove();
        }

        gameMessages.printResultMessage(winner);



        scan.close();
    }

    private static boolean checkAndProcessUserMove() {
        if (checkWin('X')) {
            winner = 1;
            return true;
        } else if (!checkAvailable()) {
            winner = 3;
            return true;
        }
        return false;
    }

    private static void checkAndProcessAIMove() {
        aiMove();
        if (checkWin('O')) {
            winner = 2;
        }
    }

    private static void userMove(Scanner scan) {
        GameMessages gameMessages =new GameMessages();
        byte input;
        while (true) {
            input = scan.nextByte();
            if (input > 0 && input < 10) {
                if (BOX[input - 1] == 'X' || BOX[input - 1] == 'O') {
                    gameMessages.displayMessage("That one is already in use. Enter another.");
                } else {
                    BOX[input - 1] = 'X';
                    break;
                }
            } else {
                gameMessages.displayMessage("Invalid input. Enter again.");
            }
        }
    }

    private static boolean checkWin(char symbol) {
        return (BOX[0] == symbol && BOX[1] == symbol && BOX[2] == symbol) ||
                (BOX[3] == symbol && BOX[4] == symbol && BOX[5] == symbol) ||
                (BOX[6] == symbol && BOX[7] == symbol && BOX[8] == symbol) ||
                (BOX[0] == symbol && BOX[3] == symbol && BOX[6] == symbol) ||
                (BOX[1] == symbol && BOX[4] == symbol && BOX[7] == symbol) ||
                (BOX[2] == symbol && BOX[5] == symbol && BOX[8] == symbol) ||
                (BOX[0] == symbol && BOX[4] == symbol && BOX[8] == symbol) ||
                (BOX[2] == symbol && BOX[4] == symbol && BOX[6] == symbol);
    }

    private static boolean checkAvailable() {
        for (char c : BOX) {
            if (c != 'X' && c != 'O') {
                return true;
            }
        }
        return false;
    }

    private static void aiMove() {
        byte rand;
        while (true) {
            rand = (byte) (Math.random() * (9 - 1 + 1) + 1);
            if (BOX[rand - 1] != 'X' && BOX[rand - 1] != 'O') {
                BOX[rand - 1] = 'O';
                break;
            }
        }

    }

}
