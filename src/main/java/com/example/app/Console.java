package com.example.app;

import java.util.InputMismatchException;
import java.util.Scanner;

import static com.example.app.AppConstants.*;

public final class Console {
    private static final Scanner scanner = new Scanner(System.in);

    private Console() {
        throw new IllegalStateException("Utility class");
    }

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
        final int length = box.length;
        for (int i = 0; i < length; i += 3) {
            System.out.println(" " + box[i] + " | " + box[i + 1] + " | " + box[i + 2] + " ");
            if (i != length - 3)
                System.out.println("-----------");
        }
    }
}
