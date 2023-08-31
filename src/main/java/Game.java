import java.util.Scanner;

public class Game {
    private final Output output;
    Scanner scan = new Scanner(System.in);
    private Winner winner = Winner.NOBODY;
    char[] box = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
    int gridSize = 9;
    byte userInput;
    byte randomPosition;

    public Game(Output output) {
        this.output = output;
    }

    public void startGame() {

        System.out.println("Enter box number to select. Enjoy!\n");

        output.drawGrid(box);
        clearBoard();
        while (!isGridFilled()) {

            getUserInput();

            if (isWinner('X')) {
                winner = Winner.USER;
                output.printResult(getWinner());
                break;
            }


            if (isGridFilled()) {
                winner = Winner.DRAW;
                output.printResult(getWinner());
                break;
            }

            computerMove();

            if (isWinner('O')) {
                winner = Winner.PC;
                output.printResult(getWinner());
                break;
            }

            output.drawGrid(box);
        }

    }

    private void computerMove() {
        while (!isGridFilled()) {
            randomPosition = (byte) (Math.random() * (9 - 1 + 1) + 1);
            if (box[randomPosition - 1] != 'X' && box[randomPosition - 1] != 'O') {
                box[randomPosition - 1] = 'O';
                break;
            }
        }
    }

    private void getUserInput() {
        while (!isGridFilled()) {
            userInput = scan.nextByte();
            if (userInput > 0 && userInput < 10) {
                if (box[userInput - 1] == 'X' || box[userInput - 1] == 'O')
                    System.out.println("That one is already in use. Enter another.");
                else {
                    box[userInput - 1] = 'X';
                    break;
                }
            } else
                System.out.println("Invalid input. Enter again.");
        }
    }


    private void clearBoard() {
        for (int i = 0; i < gridSize; i++) {
            box[i] = ' ';
        }
    }

    public boolean isGridFilled() {
        for (int i = 0; i < gridSize; i++) {
            if (box[i] != 'X' && box[i] != 'O') {
                return false;
            }
        }
        return true;
    }

    public boolean isWinner(char symbol) {
        if (box[0] == symbol && box[1] == symbol && box[2] == symbol) {
            return true;
        }
        if (box[3] == symbol && box[4] == symbol && box[5] == symbol) {
            return true;
        }
        if (box[6] == symbol && box[7] == symbol && box[8] == symbol) {
            return true;
        }
        if (box[0] == symbol && box[3] == symbol && box[6] == symbol) {
            return true;
        }
        if (box[1] == symbol && box[4] == symbol && box[7] == symbol) {
            return true;
        }
        if (box[2] == symbol && box[5] == symbol && box[8] == symbol) {
            return true;
        }
        if (box[0] == symbol && box[4] == symbol && box[8] == symbol) {
            return true;
        }
        if (box[2] == symbol && box[4] == symbol && box[6] == symbol) {
            return true;
        }
        return false;
    }

    public Winner getWinner() {
        if (isWinner('0')) {
            return Winner.PC;
        }
        if (isWinner('X')) {
            return Winner.USER;
        }
        return Winner.DRAW;
    }

}
