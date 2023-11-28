package game;

public class BoxIsAvailble {
    public boolean boxAvailable;
    public byte i;
    public static final byte NUMBEROFCELLINBOX = 9;

    public boolean isAvailbl(char[] box) {
        boxAvailable = false;
        for (i = 0; i < 9; i++) {
            if (box[i] != 'X' && box[i] != 'O') {
                boxAvailable = true;
                break;
            }
        }
        return !boxAvailable;
    }
}