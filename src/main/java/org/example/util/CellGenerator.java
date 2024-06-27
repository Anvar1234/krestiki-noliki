package org.example.util;

import org.example.model.Cell;
import org.example.model.PlayingField;

public class CellGenerator {
    //чтобы не запускать при каждом вызове где-то метод generateCells(), один раз
    // инициализируем поле CELLS результатом работы метода.
    private static final Cell[][] CELLS = generateCells();
    public static Cell[][] getCells(){
        return CELLS.clone();
    }

    private static Cell[][] generateCells(){
        Cell[][] cellsArray = new Cell[PlayingField.getLength()][PlayingField.getHeight()];
        int counter = 0;
        for (int i = 0; i < cellsArray.length; i++) {
            Cell[] cells = cellsArray[i];
            for (int j = 0; j < cells.length; j++) {
                Cell cell = new Cell(counter, String.valueOf(++counter), i, j); //не будет ли ошибки? в одном случае ++counter, а  в другом просто
                cellsArray[i][j] = cell;
            }
        }
        return cellsArray;
    }
}
