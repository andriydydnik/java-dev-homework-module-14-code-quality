package com.tictactoe;

public class Board {

    boolean boxEmpty;
    static final byte NUMBEROFBOXES = 9;

    public void printBoard(char[] arrayOfCells) {
        System.out.println("\n " + arrayOfCells[0] + " | " + arrayOfCells[1] + " | " + arrayOfCells[2] + " ");
        System.out.println("-----------");
        System.out.println(" " + arrayOfCells[3] + " | " + arrayOfCells[4] + " | " + arrayOfCells[5] + " ");
        System.out.println("-----------");
        System.out.println(" " + arrayOfCells[6] + " | " + arrayOfCells[7] + " | " + arrayOfCells[8] + " \n");

        if (!boxEmpty) {
            clearBoard(arrayOfCells);
        }
    }

    public void clearBoard(char[] arrayOfCells) {
        for (byte i = 0; i < NUMBEROFBOXES; i++) {
            arrayOfCells[i] = ' ';
            boxEmpty = true;
        }
    }

    Board() {
        throw new IllegalStateException("Board class");
    }
}
