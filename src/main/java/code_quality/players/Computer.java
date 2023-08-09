package code_quality.players;

public class Computer {

    public void takeStep(char[] box) {
        while (true) {
            int computerStep = (byte) (Math.random() * (9 - 1 + 1) + 1);
            if (box[computerStep - 1] != 'X' && box[computerStep - 1] != 'O') {
                box[computerStep - 1] = 'O';
                break;
            }
        }
    }
}
