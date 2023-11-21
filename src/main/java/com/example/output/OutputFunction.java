package com.example.output;

import com.example.service.Winer;

@SuppressWarnings("java:S106")

public class OutputFunction {
    private static final String ALL_RIGHT_RESERVED = "Created by Shreyas Saha. Thanks for playing!";
    private OutputFunction() {
        throw new IllegalStateException("Utility class");
    }
    public static void outputGameTable(char[] box) {
        String outTable = String.format("%n%n %s | %s | %s %n-----------%n %s | %s | %s %n-----------%n %s | %s | %s %n",
                box[0], box[1], box[2], box[3], box[4], box[5], box[6], box[7], box[8]);
        if(box[0] == '1') {
            System.out.println("Enter box number to select. Enjoy!\n");
            for(byte i = 0; i < 9; i++) {
                box[i] = ' ';
            }
        }
        System.out.println(outTable);
    }

    public static boolean outputResult(Winer winner) {
        switch (winner) {
            case HUMAN -> System.out.println("You won the game!");
            case AI -> System.out.println("You lost the game!");
            case DRAW -> System.out.println("It's a draw!");
            default -> {
                return false;
            }
        }
        System.out.println(ALL_RIGHT_RESERVED);
        return true;
    }
}
