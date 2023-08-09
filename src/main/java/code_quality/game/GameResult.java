package code_quality.game;

public class GameResult {

    private int winner = 0;

    public boolean isWinnerExist(char[] box) {
        if (isUserWon(box)) {
            winner = 1;
            return true;
        }
        if (isComputerWon(box)) {
            winner = 2;
            return true;
        }
        return false;
    }

    private boolean isUserWon(char[] box) {
        return (box[0] == 'X' && box[1] == 'X' && box[2] == 'X')
                || (box[3] == 'X' && box[4] == 'X' && box[5] == 'X')
                || (box[6] == 'X' && box[7] == 'X' && box[8] == 'X')
                || (box[0] == 'X' && box[3] == 'X' && box[6] == 'X')
                || (box[1] == 'X' && box[4] == 'X' && box[7] == 'X')
                || (box[2] == 'X' && box[5] == 'X' && box[8] == 'X')
                || (box[0] == 'X' && box[4] == 'X' && box[8] == 'X')
                || (box[2] == 'X' && box[4] == 'X' && box[6] == 'X');
    }

    private boolean isComputerWon(char[] box) {
        return (box[0] == 'O' && box[1] == 'O' && box[2] == 'O')
                || (box[3] == 'O' && box[4] == 'O' && box[5] == 'O')
                || (box[6] == 'O' && box[7] == 'O' && box[8] == 'O')
                || (box[0] == 'O' && box[3] == 'O' && box[6] == 'O')
                || (box[1] == 'O' && box[4] == 'O' && box[7] == 'O')
                || (box[2] == 'O' && box[5] == 'O' && box[8] == 'O')
                || (box[0] == 'O' && box[4] == 'O' && box[8] == 'O')
                || (box[2] == 'O' && box[4] == 'O' && box[6] == 'O');
    }

    public void getWinner() {
        switch (winner) {
            case 1 -> System.out.println("You won the game!\nCreated by Dmytro Volodovskyi. Thanks for playing!");
            case 2 -> System.out.println("You lost the game!\nCreated by Dmytro Volodovskyi. Thanks for playing!");
            default -> System.out.println("It's a draw!\nCreated by Dmytro Volodovskyi. Thanks for playing!");
        }
    }
}
