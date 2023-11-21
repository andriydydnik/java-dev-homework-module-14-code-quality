package game_engine;

import playing_field.PlayingField;

import java.util.Scanner;

public class Engine {
    private final PlayingField playingField = new PlayingField();
    private final Scanner scan = new Scanner(System.in);
    public void player() {

        byte input = scan.nextByte();
        while(input > 0 && input < 10 && (playingField.getBox()[input - 1] == 'X' || playingField.getBox()[input - 1] == 'O')) {
            if(playingField.getBox()[input - 1] == 'X' || playingField.getBox()[input - 1] == 'O') {
                System.out.println("That one is already in use. Enter another.");
            }
            input = scan.nextByte();
        }
        playingField.setBox('X',input - 1);
    }
    public void enemy() {
        byte rand = (byte) (Math.random() * (9 - 1 + 1) + 1);
        while (playingField.getBox()[rand - 1] == 'X' || playingField.getBox()[rand - 1] == 'O') {
            rand = (byte) (Math.random() * (9 - 1 + 1) + 1);
        }
        playingField.getBox()[rand - 1] = 'O';
    }
    private byte findWinner() {
        char[] winner = {'X', 'O'};
        String[] winningCombinations = {"012", "345","678","036","147","258","048","246"};
        for(String combination : winningCombinations) {
            for(char winChar : winner) {
                if (playingField.getBox()[Integer.parseInt(String.valueOf(combination.charAt(0)))] == winChar &&
                        playingField.getBox()[Integer.parseInt(String.valueOf(combination.charAt(1)))] == winChar &&
                        playingField.getBox()[Integer.parseInt(String.valueOf(combination.charAt(2)))] == winChar) {
                    return (byte) (winChar == 'X' ? 1 : 2);
                }
            }
        }
        return 0;
    }
    public boolean isDraw() {
        int countFullBox = 9;
        for(char box : playingField.getBox()){
            if(box == 'X' || box == 'O'){
                countFullBox--;
            }
            if(countFullBox == 0) {
                return true;
            }
        }
        return false;
    }
    private boolean resultOfGame() {
        if(findWinner() == 1){
            System.out.println("You won the game!\nCreated by Shreyas Saha. Thanks for playing!");
        } else if(findWinner()== 2){
            System.out.println("You lost the game!\nCreated by Shreyas Saha. Thanks for playing!");
        } else if(isDraw()){
            System.out.println("It's a draw!\nCreated by Shreyas Saha. Thanks for playing!");
        }
        return findWinner() == 0;
    }
    public void startGame() {
        System.out.println("Enter box number to select. Enjoy!\n");
        playingField.printField();
        int round = 0;
        while(resultOfGame()) {
            if (round % 2 == 0) {
                player();
            } else {
                enemy();
            }
            round++;
            playingField.printField();
        }
        scan.close();
    }
}
