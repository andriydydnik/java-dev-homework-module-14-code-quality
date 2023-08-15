package com.andriiiiiko.tictactoe;

import com.andriiiiiko.tictactoe.game.Game;

public class App {

    private static final String START_INFO_MESSAGE = """
            
            Enter box number to select. Enjoy!
            

             1 | 2 | 3
            -----------
             4 | 5 | 6
            -----------
             7 | 8 | 9
            """;

    private static void printStartInfo() {
        System.out.println(START_INFO_MESSAGE);
    }

    public static void main(String[] args) {
        printStartInfo();

        Game game = new Game();

        game.play();
    }
}