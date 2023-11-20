package playing_field;

public class PlayingField {
    private PlayingField() {
        throw new IllegalStateException("Utility class");
    }
    private static char[] box = { '1', '2', '3', '4', '5', '6', '7', '8', '9' };

    public static char[] getBox() {
        return box;
    }
    public static void setBox(char ch, int i) {
        box[i] = ch;
    }

    public static void printField() {
        System.out.println(" " + box[0] + " | " + box[1] + " | " + box[2] + " " + "\n-----------\n" +
                " " + box[3] + " | " + box[4] + " | " + box[5] + " " + "\n-----------\n" +
                " " + box[6] + " | " + box[7] + " | " + box[8] + " \n");
        if(Character.isDigit(box[0])) {
            for(int i = 0; i < 9; i++) {
                box[i] = ' ';
            }
        }
    }
}
