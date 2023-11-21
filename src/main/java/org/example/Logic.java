package org.example;
import java.util.Scanner;
public class Logic {

    static byte winner;
    static byte userValue;
    static boolean boxAvailable;
    static boolean boxEmpty = false;
    static boolean endOfGame = false;

    static char[]valueForField = { '1', '2', '3', '4', '5', '6', '7', '8', '9' };
    static Scanner scan = new Scanner(System.in);

    public static boolean checkEndOfGame() {
        endOfGame = true;
        if (winner == 1) {
            System.out.println("You won the game!\nCreated by Shreyas Saha. Thanks for playing!");
            return true;
        } else if (winner == 2) {
            System.out.println("You lost the game!\nCreated by Shreyas Saha. Thanks for playing!");
            return true;
        } else if (winner == 3) {
            System.out.println("It's a draw!\nCreated by Shreyas Saha. Thanks for playing!");
            return true;
        }
        endOfGame = false;
        return false;
    }
    public static void clearField(){
         if(!boxEmpty){
            for(byte i = 0; i < 9; i++)
                Logic.valueForField[i] = ' ';
            boxEmpty = true;
         }
    }

    public static void inputValueForUser(){
        while (true) {
            userValue = scan.nextByte();
            if (userValue > 0 && userValue < 10) {
                if (valueForField[userValue - 1] == 'X' || valueForField[userValue - 1] == 'O')
                    System.out.println("That one is already in use. Enter another.");
                else {
                    valueForField[userValue - 1] = 'X';
                    break;
                }
            }
            else
                System.out.println("Invalid userValue. Enter again.");
        }
    }
    public static void checkForValueX(){
        if((valueForField[0]=='X' && valueForField[1]=='X' && valueForField[2]=='X') ||
                (valueForField[3]=='X' && valueForField[4]=='X' && valueForField[5]=='X') ||
                (valueForField[6]=='X' && valueForField[7]=='X' && valueForField[8]=='X') ||
                (valueForField[0]=='X' && valueForField[3]=='X' && valueForField[6]=='X') ||
                (valueForField[1]=='X' && valueForField[4]=='X' && valueForField[7]=='X') ||
                (valueForField[2]=='X' && valueForField[5]=='X' && valueForField[8]=='X') ||
                (valueForField[0]=='X' && valueForField[4]=='X' && valueForField[8]=='X') ||
                (valueForField[2]=='X' && valueForField[4]=='X' && valueForField[6]=='X')){
            winner = 1;
        }
    }

    public static void checkForValue0(){
        if((valueForField[0]=='O' && valueForField[1]=='O' && valueForField[2]=='O') ||
                (valueForField[3]=='O' && valueForField[4]=='O' && valueForField[5]=='O') ||
                (valueForField[6]=='O' && valueForField[7]=='O' && valueForField[8]=='O') ||
                (valueForField[0]=='O' && valueForField[3]=='O' && valueForField[6]=='O') ||
                (valueForField[1]=='O' && valueForField[4]=='O' && valueForField[7]=='O') ||
                (valueForField[2]=='O' && valueForField[5]=='O' && valueForField[8]=='O') ||
                (valueForField[0]=='O' && valueForField[4]=='O' && valueForField[8]=='O') ||
                (valueForField[2]=='O' && valueForField[4]=='O' && valueForField[6]=='O')){
            winner = 2;
        }
    }

    public static boolean checkBoxAvailable(){
        boxAvailable = false;
        for(byte i=0; i<9; i++){
            if(valueForField[i] != 'X' && valueForField[i] != 'O'){
                boxAvailable = true;
                break;
            }
        }
        if(boxAvailable == false){
            winner = 3;
         }
        return boxAvailable;
    }

    public static void setRandomValue(){
        while (true) {
            byte randomValue = (byte) (Math.random() * (9 - 1 + 1) + 1);
            if (valueForField[randomValue - 1] != 'X' && valueForField[randomValue - 1] != 'O') {
                valueForField[randomValue - 1] = 'O';
                break;
            }
        }
    }
}
