package com.tictactoe;

import static com.tictactoe.WinCombination.isWinning;

public class ComputerStep {

    static byte rand;

    public static boolean computerSte(char[] box) {
        while (true) {
            rand = (byte) (Math.random() * (9 - 1 + 1) + 1);
            if (box[rand - 1] != 'X' && box[rand - 1] != 'O') {
                box[rand - 1] = 'O';
                break;
            }
        }

        return isWinning(box, 'O');
    }

    private ComputerStep() {
        throw new IllegalStateException("ComputerStep class");
    }
}
