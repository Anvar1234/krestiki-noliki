package org.example.util;

import org.example.model.Cell;
import org.example.exception_model.CellException;
import org.example.model.Player;

import java.util.Optional;

public class CellChanger {
    private final Cell[][] cells;

    public CellChanger(Cell[][] inputCells) {
        this.cells = inputCells;
    }

    /**
     * Публичный метод для изменения значения в ячейке, когда игрок устанавливает в нее свой маркер.
     */
    public void getChangedCells(Player player, String cellNumber) {
        Optional<Cell> cellOptional = getNumberedCell(cellNumber);
        if(cellOptional.isEmpty()){
            throw new CellException();
        }
        cellOptional.ifPresent(cell -> cell.setValue(player.getMarker()));
    }

    private Optional<Cell> getNumberedCell(String cellNumber) { //принимает значение (1-9) ячейки
        String validDigits = "123456789";
        for (Cell[] cells : cells) {
            for (Cell cell : cells) {
                if (validDigits.contains(cellNumber) && cell.getValue().equals(cellNumber)) {
                    return Optional.of(cell);
                }
            }
        }
        return Optional.empty();
    }
}
