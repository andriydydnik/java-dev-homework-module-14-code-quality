package com.example;
import com.example.game_resources.Ai;
import com.example.game_resources.Box;
import com.example.game_resources.GameStates;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    private static final Box box = new Box();
    private static final Ai ai = new Ai();
    private static final String GREETINGS = "Enter box number to select. Enjoy!\n";
    private static final String ALREADY_IN_USE_MESSAGE = "That one is already in use. Enter another.";
    private static final String INVALID_INPUT = "Invalid input. Enter again.";

    public static void main(String[] args) {
        System.out.println(GREETINGS);

        while (true) {
            box.printBoxState();
            if(box.isBoxEmpty()){
                box.cleanBox();
            }
            GameStates currentState = box.getGameState();
            if(currentState!= GameStates.ONGOING){
                System.out.println(currentState.getMessage());
                break;
            }
            takePlayerGo();
            box.updateGameState();
            if(box.getGameState()== GameStates.ONGOING){
                box.setSquare(ai.getAiGoCoordinate(box), Box.ZERO);
                box.updateGameState();
            }
        }
    }
    public static void takePlayerGo(){
        while (true) {
            try {
               Scanner scanner = new Scanner(System.in);
               int input = scanner.nextInt();
               if (input > 0 && input <= box.getBoxState().length) {
                   if (box.getSquare(input) == Box.X || box.getSquare(input) == Box.ZERO){
                       System.out.println(ALREADY_IN_USE_MESSAGE);
                   }else {
                       box.setSquare(input, Box.X);
                       break;
                   }
               }else{
                   System.out.println(INVALID_INPUT);
               }
            } catch(InputMismatchException ime){
                System.out.println(INVALID_INPUT);
            }
        }
    }
}