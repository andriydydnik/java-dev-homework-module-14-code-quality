package com.example;

import com.example.service.Winer;

import static com.example.input.InputFunction.*;
import static com.example.output.OutputFunction.*;
import static com.example.service.Estimation.whoHasWon;
import static com.example.service.Winer.*;

public class AppTicTakToe {
    public static void main(String[] args) {
        boolean endOfGame = false;
        Winer winner = ACTION;
        char[] box = { '1', '2', '3', '4', '5', '6', '7', '8', '9' };

        while (!endOfGame) {

            outputGameTable(box);

            endOfGame = outputResult(winner);

            if(!endOfGame) waitingInput(box);

            winner = whoHasWon(box);

        }
    }
}