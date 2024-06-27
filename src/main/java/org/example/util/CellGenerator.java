package org.example.util;

import org.example.model.Cell;
import org.example.model.PlayingField;

public class CellGenerator {

    private static final Cell[][] CELLS = generateCells();

    /**
     * Публичный метод для получения массива заполненных ячеек.
     */
    public static Cell[][] getCells(){
        return CELLS.clone(); // Возвращаем копию, а не оригинал.
    }

    private static Cell[][] generateCells(){
        Cell[][] cellsArray = new Cell[PlayingField.getLength()][PlayingField.getHeight()];
        int counter = 0;
        for (int i = 0; i < cellsArray.length; i++) {
            Cell[] cells = cellsArray[i];
            for (int j = 0; j < cells.length; j++) {
                Cell cell = new Cell(String.valueOf(++counter), i, j);
                cellsArray[i][j] = cell;
            }
        }
        return cellsArray;
    }
}
