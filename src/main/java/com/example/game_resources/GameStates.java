package com.example.game_resources;

public enum GameStates {
    DRAW("It's a draw!\nCreated by Shreyas Saha. Thanks for playing!"),
    VICTORY("You won the game!\nCreated by Shreyas Saha. Thanks for playing!"),
    DEFEAT("You lost the game!\nCreated by Shreyas Saha. Thanks for playing!"),
    ONGOING("not finished");

    private final String message;
    GameStates(String message){
        this.message = message;
    }
    public String getMessage(){
        return message;
    }
}
