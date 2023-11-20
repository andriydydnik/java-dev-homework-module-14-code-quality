package org.example;

public class App {
    @SuppressWarnings("java:S106")
    public static void main(String[] args) {
        System.out.println("Enter box number to select. Enjoy!");
        Game game = new Game();
        game.startGame();
    }
}
