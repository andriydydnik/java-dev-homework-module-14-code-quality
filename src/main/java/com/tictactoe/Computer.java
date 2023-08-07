package com.tictactoe;

import static com.tictactoe.WinCombination.isWinning;

public class Computer {

    byte rand;

    public boolean computerStep(char[] box) {
        while (true) {
            rand = (byte) (Math.random() * (9 - 1 + 1) + 1);
            if (box[rand - 1] != 'X' && box[rand - 1] != 'O') {
                box[rand - 1] = 'O';
                break;
            }
        }

        return isWinning(box, 'O');
    }

    public Computer() {
        throw new IllegalStateException("ComputerStep class");
    }
}
