package com.tictactoe;

public class Box {

    private Box(){
        throw new IllegalStateException("Utils class");
    }
    protected static void boxDrawing(char[] gameField){
        System.out.println();
        for(byte i = 0; i < 2; i++){
            System.out.printf("%n %s | %s | %s %n", gameField[i*3], gameField[i*3+1], gameField[i*3+2]);
            System.out.print("-----------");
        }
        System.out.printf("%n %s | %s | %s %n", gameField[6], gameField[7], gameField[8]);
    }
}
