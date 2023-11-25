package org.example.logic;
import java.util.Scanner;
public class GameLogic {

    public static final byte USER_WON = 1;
    public static final byte USER_LOS = 2;
    public static final byte USER_DRAW = 3;

    private byte winner;
    private byte userValue;
    boolean boxAvailable;
    private boolean boxEmpty = false;
    boolean endOfGame = false;
    private final char[] valueForField = { '1', '2', '3', '4', '5', '6', '7', '8', '9' };
    static Scanner scan = new Scanner(System.in);

    public byte getWinner() {
        return winner;
    }

    public void setWinner(byte winner) {
        this.winner = winner;
    }

    public boolean isEndOfGame() {
        return endOfGame;
    }

    public char[] getValueForField() {
        return valueForField;
    }

    public void clearField(){
         if(!boxEmpty){
            for(byte i = 0; i < 9; i++)
                valueForField[i] = ' ';
            boxEmpty = true;
         }
    }

    public void inputValueForUser(){
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

    public void setRandomValue(){
        while (true) {
            byte randomValue = (byte) (Math.random() * (9 - 1 + 1) + 1);
            if (valueForField[randomValue - 1] != 'X' && valueForField[randomValue - 1] != 'O') {
                valueForField[randomValue - 1] = 'O';
                break;
            }
        }
    }
}