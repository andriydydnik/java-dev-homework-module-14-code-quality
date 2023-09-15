package com.game;

import static com.game.Win.result;

public class Computer {
    byte rand;

    public boolean computerMove(char[] box) {
        while (true) {
            rand = (byte) (Math.random() * (9 - 1 + 1) + 1);
            if (box[rand - 1] != 'X' && box[rand - 1] != 'O') {
                box[rand - 1] = 'O';
                break;
            }
        }
        return result(box, 'O');
    }
}
