package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class PlayingField {
    private static final int LENGTH = 3;
    private static final int HEIGHT = 3;

    public static int getLength(){
        return LENGTH;
    }
    public static int getHeight(){
        return HEIGHT;
    }

    /**
     * Публичный метод для получения рисованного поля с указанием маркеров каждой ячейки.
     */
    public static String getField(Cell[][] cellsArray) {
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
