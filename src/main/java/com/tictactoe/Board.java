package com.tictactoe;

public class Board {

    private static boolean boxEmpty = false;
    private static final byte NUMBEROFBOXES = 9;

    public static void printFieldAll(char[] arrayOfCells) {
        System.out.println("\n " + arrayOfCells[0] + " | " + arrayOfCells[1] + " | " + arrayOfCells[2] + " ");
        System.out.println("-----------");
        System.out.println(" " + arrayOfCells[3] + " | " + arrayOfCells[4] + " | " + arrayOfCells[5] + " ");
        System.out.println("-----------");
        System.out.println(" " + arrayOfCells[6] + " | " + arrayOfCells[7] + " | " + arrayOfCells[8] + " \n");

        if (!boxEmpty) {
            clearField(arrayOfCells);
        }
    }

    public static void clearField(char[] arrayOfCells) {
        for (byte i = 0; i < NUMBEROFBOXES; i++) {
            arrayOfCells[i] = ' ';
            boxEmpty = true;
        }
    }

    private Board() {
        throw new IllegalStateException("Board class");
    }
}
