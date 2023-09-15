package com.game;

public class Welcome {
    boolean boxEmpty;
    public static final byte NUMBEROFCELLINBOX = 9;

    public void start(char[] arrayOfCells) {
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
        for (byte i = 0; i < NUMBEROFCELLINBOX; i++) {
            arrayOfCells[i] = ' ';
            boxEmpty = true;
        }
    }

}
