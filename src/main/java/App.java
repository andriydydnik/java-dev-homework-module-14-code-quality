import board.TicTacToeBoard;
import ticTacToeLogic.GameLogic;

public class App {

    public static void main(String[] args) {
        TicTacToeBoard ticTacToeBoard = new TicTacToeBoard();
        GameLogic gameLogic = new GameLogic(ticTacToeBoard);
        gameLogic.startGame();
    }
}