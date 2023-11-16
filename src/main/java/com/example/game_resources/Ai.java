package com.example.game_resources;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Ai {
    /**
     *The method uses i = 1 because getSquare method operates with natural numbers (first element is represented by 1 not 0)
     * */
    public int getAiGoCoordinate(Box box){
        List<Integer> list = new LinkedList<>();
        for(int i = 1; i<=box.getBoxState().length; i++){
            if(box.getSquare(i)!=box.X && box.getSquare(i)!=box.ZERO){
                list.add(i);
            }
        }
        if(!list.isEmpty()) {
            Collections.shuffle(list);
            return list.get(0);
        } else{
            return -1;
        }
    }
}
