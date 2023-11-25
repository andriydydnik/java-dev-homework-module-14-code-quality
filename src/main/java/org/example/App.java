package org.example;

import org.example.logic.Checker;
import org.example.logic.GameLogic;
import org.example.output.OutputForConsole;

public class App {

    @SuppressWarnings("java:S106")
    public static void main(String[] args) {

        GameLogic game = new GameLogic();

        while (!game.isEndOfGame()) {

            OutputForConsole.printField(game.getValueForField());

            game.clearField();

            if (Checker.checkEndOfGame(game)){
                continue;
            }

            game.inputValueForUser();

            Checker.checkForValueX(game);
            Checker.checkForValue0(game);

            Checker.checkBoxAvailable(game);

            game.setRandomValue();

        }
    }
}