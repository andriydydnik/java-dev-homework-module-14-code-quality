package org.example;

public class App {

    @SuppressWarnings("java:S106")
    public static void main(String[] args) {

        while (!Logic.endOfGame) {

            OutputForConsole.printField(Logic.valueForField);

            Logic.clearField();

            if (Logic.checkEndOfGame()){
                continue;
            }

            Logic.inputValueForUser();

            Logic.checkForValueX();

            Logic.checkBoxAvailable();

            Logic.setRandomValue();

            Logic.checkForValue0();
        }

    }
}