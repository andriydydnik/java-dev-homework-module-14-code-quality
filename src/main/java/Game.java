import java.util.Scanner;

public class Game {
    Scanner scan = new Scanner(System.in);
    byte input;
    byte rand;
    byte i;
    boolean boxAvailable;
    byte winner = 0;
    boolean finishState = false;
    char[] box = { '1', '2', '3', '4', '5', '6', '7', '8', '9' };

    boolean boxEmpty = false;
    public void start(){

        while (true) {
            print("\n\n " + box[0] + " | " + box[1] + " | " + box[2] + " ");
            print("-----------");
            print(" " + box[3] + " | " + box[4] + " | " + box[5] + " ");
            print("-----------");
            print(" " + box[6] + " | " + box[7] + " | " + box[8] + " \n");

            if(!boxEmpty){
                for(i = 0; i < 9; i++)
                    box[i] = ' ';
                boxEmpty = true;
            }

            checkWinState();
            if (isFinish()) {
                break;
            }

            while (true) {
                input = scan.nextByte();
                if (input > 0 && input < 10) {
                    if (box[input - 1] == 'X' || box[input - 1] == 'O')
                        print("That one is already in use. Enter another.");
                    else {
                        box[input - 1] = 'X';
                        break;
                    }
                }
                else
                    print("Invalid input. Enter again.");
            }

            checkUserWin();

            boxAvailable = false;
            for(i=0; i<9; i++){
                if(box[i] != 'X' && box[i] != 'O'){
                    boxAvailable = true;
                    break;
                }
            }

            if(!boxAvailable){
                winner = 3;
            }

            while (true) {
                rand = (byte) (Math.random() * (9 - 1 + 1) + 1);
                if (box[rand - 1] != 'X' && box[rand - 1] != 'O') {
                    box[rand - 1] = 'O';
                    break;
                }
            }
            checkBotWin();
        }

    }

    private void checkWinState() {
        if(winner == 3){
            print("It's a draw!\nCreated by Shreyas Saha. Thanks for playing!");
            return;
        }
        if (winner != 0) {
            finishState = true;
        }
    }

    private boolean isFinish() {
        return finishState;
    }

    private void checkUserWin() {
        if((box[0]=='X' && box[1]=='X' && box[2]=='X') || (box[3]=='X' && box[4]=='X' && box[5]=='X') || (box[6]=='X' && box[7]=='X' && box[8]=='X') ||
                (box[0]=='X' && box[3]=='X' && box[6]=='X') || (box[1]=='X' && box[4]=='X' && box[7]=='X') || (box[2]=='X' && box[5]=='X' && box[8]=='X') ||
                (box[0]=='X' && box[4]=='X' && box[8]=='X') || (box[2]=='X' && box[4]=='X' && box[6]=='X')){
            winner = 1;
        }
    }

    private void checkBotWin() {
        if((box[0]=='O' && box[1]=='O' && box[2]=='O') || (box[3]=='O' && box[4]=='O' && box[5]=='O') || (box[6]=='O' && box[7]=='O' && box[8]=='O') ||
                (box[0]=='O' && box[3]=='O' && box[6]=='O') || (box[1]=='O' && box[4]=='O' && box[7]=='O') || (box[2]=='O' && box[5]=='O' && box[8]=='O') ||
                (box[0]=='O' && box[4]=='O' && box[8]=='O') || (box[2]=='O' && box[4]=='O' && box[6]=='O')){
            winner = 2;
        }
    }


    public static void print(String text){
        System.out.println(text);
    }

}
