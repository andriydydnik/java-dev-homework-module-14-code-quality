package tic_tac_toe;
import java.util.logging.Logger;

/**
 * клас з набором методів для обслуговування гри
 */
public class Game {
    //екземпляр для створення логера
    private static final Game game = new Game();
    private Game (){
    }
    private static final Logger logger = LoggerForMessage.getCustomizedLogger(game);

    //метод для визначення переможця повертає 'X' у разі перемоги людини,
    // 'O' у разі перемоги комп'ютера
    // 'D' у разі нічиєї
    public static char determineWinner(char [] box){
        //перевірка рядків
        for (int i = 0; i < box.length - 2; i+=3){
            if (box[i] != ' ' && box[i] == box[i+1] && box[i] == box[i+2]){
                return  box[i];
            }
        }

        //перевірка стовбців
        for (int i = 0; i < 3; i++){
            if (box[i] != ' ' && box[i] == box[i+3] && box[i] == box[i+6]){
                return box[i];
            }
        }

        //перевірка діагоналі 1
        if (box[0] != ' ' && box[0] == box[4] && box[4] == box[8]){
            return box[0];
        }

        //перевірка діагоналі 1
        if (box[2] != ' ' && box[2] == box[4] && box[4] == box[6]){
            return box[2];
        }
        return 'D';
    }

    //метод, що реалізує хід людини повертає false, якщо хід не зроблено
    //і true, якщо хід зроблено і дані записано до масиву записано
    public static boolean humanMove(byte move, char [] box){
        if (move < 1 || move > box.length){
            logger.warning(MessagesConstants.MOVE_OUT_OF_RANGE);
            return false;
        }

        if (box[move - 1] != ' '){
            logger.warning(MessagesConstants.CELL_IS_OCCUPIED);
            return false;
        }

        box[move-1] = 'X';
        return true;
    }

    //метод, що реалізує хід компьютера повертає false, якщо хід не зроблено
    //і true, якщо хід зроблено і дані записано до масиву записано
    public static boolean computerMove(char [] box){
        byte rand = (byte) (Math.random() * (9 - 1 + 1) + 1);
        if (box[rand - 1] != 'X' && box[rand - 1] != 'O') {
            box[rand - 1] = 'O';
            return true;
        }
        return false;
    }

    //метод для вибору повідомлення за конкретним сценарієм
    public static String getMessageForWinner(char winnCar){
        return switch (winnCar) {
            case 'O' -> MessagesConstants.COMPUTER_WIN;
            case 'X' -> MessagesConstants.HUMAN_WIN;
            default -> MessagesConstants.DRAW;
        };
    }

}
