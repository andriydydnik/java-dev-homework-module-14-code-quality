package com.example.app;

import java.util.InputMismatchException;
import java.util.Scanner;

import static com.example.app.AppConstants.*;

public class Console {
    private static final Scanner scanner = new Scanner(System.in);

    public static void readBoxNumber(char[] box) {
        int value;
        while (true) {
            try {
                value = scanner.nextInt();
            } catch (InputMismatchException ex) {
                System.out.print("Please, enter an integer number: ");
                scanner.nextLine();
                continue;
            }

            if (value >= 1 && value <= box.length) {
                int index = value - 1;
                if (box[index] == EMPTY_SYMBOL) {
                    box[index] = PLAYER_SYMBOL;
                    break;
                }
                else System.out.print("That one (" + value + ") is already in use. Enter another: ");
            }
            else System.out.print("Invalid input. Enter again: ");
        }
    }

    public static void displayBox(char[] box) {
        for (int i = 0; i < box.length; i++) {
            System.out.println(" " + box[i] + " | " + box[++i] + " | " + box[++i] + " ");
            if (i != box.length - 1)
                System.out.println("-----------");
        }
    }
}
