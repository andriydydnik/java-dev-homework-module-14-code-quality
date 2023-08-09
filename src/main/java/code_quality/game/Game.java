package code_quality.game;

import code_quality.players.Computer;
import code_quality.players.User;

public class Game {

    private final char[] box = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};

    GameField field = new GameField();
    User user = new User();
    Computer computer = new Computer();
    GameResult result = new GameResult();

    public void startGame() {
        getInfo();
        for (int i = 0; i < 4; i++) {
            user.takeStep(box);
            computer.takeStep(box);
            field.getField(box);
            if (result.isWinnerExist(box)) break;
        }
        result.getWinner();
    }

    private void getInfo() {
        System.out.println("Enter box number to select. Enjoy!");
        field.getField(box);
    }

}
