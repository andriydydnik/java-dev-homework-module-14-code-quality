package com.tictactoe;

import java.util.Scanner;

public class Game {
    private static final Scanner scan = new Scanner(System.in);
    private static final String ENDGAME_TEMPLATE = "\nCreated by Shreyas Saha. Thanks for playing!";
    private final char[] gameField = new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9'};
    private boolean isGoing = true;

    public Game(){
        System.out.println("Enter box number to select. Enjoy!\n");
    }

    protected void userInput(){
        byte input;
        while (true) {
            input = scan.nextByte();
            if (input > 0 && input < 10) {
                if (gameField[input - 1] == 'X' || gameField[input - 1] == 'O')
                    System.out.println("That one is already in use. Enter another.");
                else {
                    gameField[input - 1] = 'X';
                    break;
                }
            }
            else
                System.out.println("Invalid input. Enter again.");
        }
    }

    protected void computerMove(){
        byte rand;
        while (true) {
            rand = (byte) (Math.random() * (9 - 1 + 1) + 1);
            if (gameField[rand - 1] != 'X' && gameField[rand - 1] != 'O') {
                gameField[rand - 1] = 'O';
                break;
            }
        }
    }

    protected void userWin(){
        if(isAllTaken('X')){
            isGoing = false;
            winningStatus(GameStatus.WON);
        }
    }

    protected void isDraw(){
        boolean boxAvailable = false;
        for(byte i=0; i<9; i++){
            if(gameField[i] != 'X' && gameField[i] != 'O'){
                boxAvailable = true;
                break;
            }
        }
        if(!boxAvailable){
            isGoing = false;
            winningStatus(GameStatus.DRAW);
        }
    }

    protected void userLose(){
        if(isAllTaken('O')){
            isGoing = false;
            winningStatus(GameStatus.LOST);
        }
    }

    protected boolean isAllTaken(char symbol){
        return (gameField[0]==symbol && gameField[1]==symbol && gameField[2]==symbol) ||  //first string
                (gameField[3]==symbol && gameField[4]==symbol && gameField[5]==symbol) || //second string
                (gameField[6]==symbol && gameField[7]==symbol && gameField[8]==symbol) || //third string
                (gameField[0]==symbol && gameField[3]==symbol && gameField[6]==symbol) || //first row
                (gameField[1]==symbol && gameField[4]==symbol && gameField[7]==symbol) || //second row
                (gameField[2]==symbol && gameField[5]==symbol && gameField[8]==symbol) || //third row
                (gameField[0]==symbol && gameField[4]==symbol && gameField[8]==symbol) || //left diagonal
                (gameField[2]==symbol && gameField[4]==symbol && gameField[6]==symbol);   //right diagonal
    }

    protected void winningStatus(GameStatus gameStatus){
        switch(gameStatus){
            case WON -> System.out.println("You won the game!"+ ENDGAME_TEMPLATE);
            case LOST -> System.out.println("You lost the game!"+ ENDGAME_TEMPLATE);
            case DRAW -> System.out.println("It's a draw!"+ ENDGAME_TEMPLATE);
            default -> System.out.println("Something went wrong!");
        }
    }

    protected void gameStatus(){
        boolean boxEmpty = false;
        while (isGoing) {
            Box.boxDrawing(gameField);
            if(!boxEmpty){
                for(byte i = 0; i < 9; i++)
                    gameField[i] = ' ';
                boxEmpty = true;
            }
            userInput();
            userWin();
            computerMove();
            userLose();
            isDraw();
        }
    }

    enum GameStatus {
        WON,
        LOST,
        DRAW
    }
}
