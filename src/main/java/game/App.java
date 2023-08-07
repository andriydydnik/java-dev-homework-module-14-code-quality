package game;

import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Logger;

public class App {
    public static void main(String[] args) {

        //Logger timestamp formatter
        Logger rootLogger = Logger.getLogger("");
        for (Handler handler : rootLogger.getHandlers()) {
            if (handler instanceof ConsoleHandler) {
                handler.setFormatter(new CustomSimpleFormatter());
            }
        }

        GameBoard gameBoard = new GameBoard();
        Player player = new Player(GameBoard.PLAYER_SYMBOL);
        Computer computer = new Computer(GameBoard.COMPUTER_SYMBOL);

        gameBoard.displayStartMessage();
        playGame(gameBoard, player, computer);

    }

    public static void playGame(GameBoard gameBoard, Player player, Computer computer) {
        byte winner;
        boolean boxEmpty = false;

        while (true) {
            gameBoard.displayBoard();

            if (!boxEmpty) {
                gameBoard.resetBoard();
                boxEmpty = true;
            }

            winner = gameBoard.isWinner();
            gameBoard.announceGameResult(winner);

            if (winner != 0) {
                break;
            }

            byte input = player.getPlayerInput(gameBoard);
            gameBoard.makeMove(input, player.getSymbol());

            int computerMove = computer.getComputerMove(gameBoard);
            gameBoard.makeMove(computerMove, computer.getSymbol());


        }
        player.closeScanner();
    }
}