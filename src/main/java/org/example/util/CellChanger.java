package org.example.util;

import org.example.model.Cell;
import org.example.model.Player;

import java.util.Optional;

public class CellChanger {
    private final Cell[][] cells;

    public CellChanger(Cell[][] cells) {
        this.cells = cells;
    }
    public void getChangedCells(Player player, String value) {
        Optional<Cell> cellOptional = getNumberedCell(value);
        cellOptional.ifPresent(cell1 -> cell1.setValue(player.getMarker())); //получается, что меняем ячейку ТОЛЬКО если optional не пустой.
    }

    private Optional<Cell> getNumberedCell(String value) { //принимает значение (1-9) ячейки
        for (Cell[] cells1 : cells) {
            for (Cell cell1 : cells1) {
                if (cell1.getValue().equals(value)) {
                    return Optional.of(cell1);
                }
            }
        }
        return Optional.empty();
    }
}
