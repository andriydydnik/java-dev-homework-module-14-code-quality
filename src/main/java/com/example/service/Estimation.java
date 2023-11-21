package com.example.service;

public class Estimation {
    private Estimation() { throw new IllegalStateException("Utility class"); }

    public static Winer whoHasWon(char[] box) {
        byte rand;
        boolean boxAvailable;
        if (checkWiner(box, 'X')) {
            return Winer.HUMAN;
        }

        boxAvailable = false;
        for(byte i=0; i<9; i++){
            if(box[i] == ' '){
                boxAvailable = true;
                break;
            }
        }

        if(!boxAvailable){
            return Winer.DRAW;
        }

        while (true) {
            rand = (byte) (Math.random() * (9 - 1 + 1) + 1);
            if (box[rand - 1] == ' ') {
                box[rand - 1] = 'O';
                break;
            }
        }

        if (checkWiner(box, 'O')) {
            return Winer.AI;
        }

        return Winer.ACTION;
    }

    private static boolean checkWiner(char[] box, char who) {
        return ((box[0]==who && box[1]==who && box[2]==who) || (box[3]==who && box[4]==who && box[5]==who) || (box[6]==who && box[7]==who && box[8]==who) ||
                (box[0]==who && box[3]==who && box[6]==who) || (box[1]==who && box[4]==who && box[7]==who) || (box[2]==who && box[5]==who && box[8]==who) ||
                (box[0]==who && box[4]==who && box[8]==who) || (box[2]==who && box[4]==who && box[6]==who));
    }
}
