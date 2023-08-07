public class App {
    public static void main(String[] args) {
        GameBoard gameBoard = new GameBoard();
        GameController gameController = new GameController(gameBoard);
        gameController.startGame();
    }
}