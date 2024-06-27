package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class PlayingField {
    private static final int LENGTH = 3; //заделка на будущее, если захотим задавать размер поля.
    private static final int HEIGHT = 3;

    public static int getLength(){
        return LENGTH;
    }
    public static int getHeight(){
        return HEIGHT;
    }

    public static String getField(Cell[][] cellsArray) { //используем не новую копию массива, а одну и ту же, которая будет использоваться в приложении.
        StringBuilder stringBuilder = new StringBuilder();
        List<String> stringList2 = new ArrayList<>();
        for (Cell[] cells : cellsArray) {
            List<String> stringList = new ArrayList<>();
            for (Cell cell : cells) {
                stringList.add(cell.getValue());
            }
            stringList2.add(" " + String.join(" | ", stringList) + ("\n"));
        }
        stringBuilder.append(String.join(("___ ___ ___\n"), stringList2));

        return stringBuilder.toString();
    }

}
