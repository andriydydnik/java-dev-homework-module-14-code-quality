import java.util.Scanner;

public class GameController {
    private final GameBoard gameBoard;
    private final char[] box = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
    public static final char PLAYER_SYMBOL = 'X';
    public static final char COMPUTER_SYMBOL = 'O';
    private byte winner = 0;
    private static final byte BOARD_SIDE = 9;

    public GameController(GameBoard gameBoard) {
        this.gameBoard = gameBoard;
    }

    public char[] getBox() {
        return box;
    }

    public void startGame() {
        Scanner scan = new Scanner(System.in);
        GameMessages gameMessages = new GameMessages();
        gameMessages.displayStartMessage();


        boolean boxEmpty = false;

        while (winner == 0) {
            gameBoard.displayBoard(getBox());


            if (!boxEmpty) {
                gameBoard.resetBoard(box);
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

    private boolean checkAndProcessUserMove() {
        if (checkWin(PLAYER_SYMBOL)) {
            winner = 1;
            return true;
        } else if (!checkAvailable()) {
            winner = 3;
            return true;
        }
        return false;
    }

    private void checkAndProcessAIMove() {
        aiMove();
        if (checkWin(COMPUTER_SYMBOL)) {
            winner = 2;
        }
    }

    private void userMove(Scanner scan) {
        GameMessages gameMessages = new GameMessages();
        byte input;
        while (true) {
            input = scan.nextByte();
            if (input > 0 && input <= BOARD_SIDE) {
                if (box[input - 1] == PLAYER_SYMBOL || box[input - 1] == COMPUTER_SYMBOL) {
                    gameMessages.displayMessage("That one is already in use. Enter another.");
                } else {
                    box[input - 1] = PLAYER_SYMBOL;
                    break;
                }
            } else {
                gameMessages.displayMessage("Invalid input. Enter again.");
            }
        }
    }

    private boolean checkWin(char symbol) {
        return (box[0] == symbol && box[1] == symbol && box[2] == symbol) ||
                (box[3] == symbol && box[4] == symbol && box[5] == symbol) ||
                (box[6] == symbol && box[7] == symbol && box[8] == symbol) ||
                (box[0] == symbol && box[3] == symbol && box[6] == symbol) ||
                (box[1] == symbol && box[4] == symbol && box[7] == symbol) ||
                (box[2] == symbol && box[5] == symbol && box[8] == symbol) ||
                (box[0] == symbol && box[4] == symbol && box[8] == symbol) ||
                (box[2] == symbol && box[4] == symbol && box[6] == symbol);
    }

    private boolean checkAvailable() {
        for (char c : box) {
            if (c != PLAYER_SYMBOL && c != COMPUTER_SYMBOL) {
                return true;
            }
        }
        return false;
    }

    private void aiMove() {
        byte rand;
        while (true) {
            rand = (byte) (Math.random() * (BOARD_SIDE - 1 + 1) + 1);
            if (box[rand - 1] != PLAYER_SYMBOL && box[rand - 1] != COMPUTER_SYMBOL) {
                box[rand - 1] = COMPUTER_SYMBOL;
                break;
            }
        }

    }

}
