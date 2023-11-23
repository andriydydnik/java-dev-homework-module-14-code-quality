package org.example.logic;

public class Checker {

    public static void checkForValueX(GameLogic game){
        char[] valueForField = game.getValueForField();
        if((valueForField[0]=='X' && valueForField[1]=='X' && valueForField[2]=='X') ||
                (valueForField[3]=='X' && valueForField[4]=='X' && valueForField[5]=='X') ||
                (valueForField[6]=='X' && valueForField[7]=='X' && valueForField[8]=='X') ||
                (valueForField[0]=='X' && valueForField[3]=='X' && valueForField[6]=='X') ||
                (valueForField[1]=='X' && valueForField[4]=='X' && valueForField[7]=='X') ||
                (valueForField[2]=='X' && valueForField[5]=='X' && valueForField[8]=='X') ||
                (valueForField[0]=='X' && valueForField[4]=='X' && valueForField[8]=='X') ||
                (valueForField[2]=='X' && valueForField[4]=='X' && valueForField[6]=='X')){
            game.setWinner(GameLogic.USER_WON);
        }
    }

    public static void checkForValue0(GameLogic game){
        char[] valueForField = game.getValueForField();
        if((valueForField[0]=='O' && valueForField[1]=='O' && valueForField[2]=='O') ||
                (valueForField[3]=='O' && valueForField[4]=='O' && valueForField[5]=='O') ||
                (valueForField[6]=='O' && valueForField[7]=='O' && valueForField[8]=='O') ||
                (valueForField[0]=='O' && valueForField[3]=='O' && valueForField[6]=='O') ||
                (valueForField[1]=='O' && valueForField[4]=='O' && valueForField[7]=='O') ||
                (valueForField[2]=='O' && valueForField[5]=='O' && valueForField[8]=='O') ||
                (valueForField[0]=='O' && valueForField[4]=='O' && valueForField[8]=='O') ||
                (valueForField[2]=='O' && valueForField[4]=='O' && valueForField[6]=='O')){
            game.setWinner(GameLogic.USER_LOS);
        }
    }
    public static boolean checkEndOfGame(GameLogic game) {
        game.endOfGame = true;
        if (game.getWinner() == GameLogic.USER_WON) {
            System.out.println("You won the game!\nCreated by Shreyas Saha. Thanks for playing!");
            return true;
        } else if (game.getWinner() == GameLogic.USER_LOS) {
            System.out.println("You lost the game!\nCreated by Shreyas Saha. Thanks for playing!");
            return true;
        } else if (game.getWinner() == GameLogic.USER_DRAW) {
            System.out.println("It's a draw!\nCreated by Shreyas Saha. Thanks for playing!");
            return true;
        }
        game.endOfGame = false;
        return false;
    }

    public static void checkBoxAvailable(GameLogic game){
        game.boxAvailable = false;
        char[] valueForField = game.getValueForField();
        for(byte i=0; i<9; i++){
            if(valueForField[i] != 'X' && valueForField[i] != 'O'){
                game.boxAvailable = true;
                break;
            }
        }
        if(!game.boxAvailable){
            game.setWinner(GameLogic.USER_DRAW);
        }
    }
}
