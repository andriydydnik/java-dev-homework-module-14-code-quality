package tic_tac_toe;

import java.util.Arrays;

/**
 * класс для роботи з ігровим полем
 */
public class FieldForPlay {
    private FieldForPlay (){
    }

    //повертає поле для гри у представленні рядка, на вхід приймає масив символів
    public static String getField(char [] box){
        StringBuilder sb = new StringBuilder();
        int row = box.length/3;
        int count = 0;
        for(char ch : box){
            sb.append(ch);
            count++;
            if (count % row == 0 && count != box.length){
                sb.append("\n---------\n");
                continue;
            }
            if(count != box.length){
                sb.append(" | ");
            }

        }
        return sb.toString();
    }

    //заповнює ігрове поле пустими значеннями
    public static void clearFieldForPlay(char [] box){
        Arrays.fill(box, ' ');
    }

}
