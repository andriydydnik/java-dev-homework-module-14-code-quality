package com.example.input;

import java.util.Scanner;

@SuppressWarnings("java:S106")

public class InputFunction {
    private InputFunction() { throw new IllegalStateException("Utility class"); }

    public static void waitingInput(char[] box) {
        Scanner scan = new Scanner(System.in);
        byte input;
        boolean truthValue = false;
        while (!truthValue) {
            input = scan.nextByte();
            if (input > 0 && input < 10) {
                if (box[input - 1] == 'X' || box[input - 1] == 'O')
                    System.out.println("That one is already in use. Enter another.");
                else {
                    box[input - 1] = 'X';
                    truthValue = true;
                }
            } else {
                System.out.println("Invalid input. Enter again.");
            }
        }
    }

}
