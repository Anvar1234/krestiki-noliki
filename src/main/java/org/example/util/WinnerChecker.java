package org.example.util;

import org.example.model.Cell;
import org.example.model.Player;

public class WinnerChecker {
    private final Player player1;
    private final Player player2;
    private final Cell[][] cellsArray;

    public WinnerChecker(Player player1, Player player2, Cell[][] cellsArray) {
        this.player1 = player1;
        this.player2 = player2;
        this.cellsArray = cellsArray;
    }

    /**
     * Публичный метод для проверки победный ли ход.
     */
    public boolean isWinner(){
        return checkWinner();
    }

    // Переписать на стримы:
    private boolean checkWinner() {
        // Не обернул оба for в один while (count != 2), чтобы не проходить по массиву по два раза в случае, если победитель определится уже в строках.
        // Поэтому и counter-ы разные.

        //проверяем строки
        int countInRow = 0;
        String player1Markers = player1.getMarker()+player1.getMarker()+player1.getMarker();
        String player2Markers = player2.getMarker()+player2.getMarker()+player2.getMarker();

        while (countInRow < cellsArray.length) {
            for (Cell[] cells : cellsArray) {
                StringBuilder winnerMarkersInRow = new StringBuilder();
                for (Cell cell : cells) {
                    if (cell.getX() == countInRow) {
                        winnerMarkersInRow.append(cell.getValue());
                    }
                }
                if (winnerMarkersInRow.toString().equals(player1Markers)) {
                    return true;
                } else if (winnerMarkersInRow.toString().equals(player2Markers)) {
                    return true;
                }
            }
            countInRow++;
        }

        //проверяем столбцы
        int countInColumn = 0;

        while (countInColumn < cellsArray.length) {
            StringBuilder winnerMarkersInColumn = new StringBuilder();
            for (Cell[] cells : cellsArray) {
                for (Cell cell : cells) {
                    if (cell.getY() == countInColumn && (cell.getValue().equals(player1.getMarker())
                            || cell.getValue().equals(player2.getMarker()))) {
                        winnerMarkersInColumn.append(cell.getValue());
                    }
                }
            }
            if (winnerMarkersInColumn.toString().equals(player1Markers)) {
                return true;
            } else if (winnerMarkersInColumn.toString().equals(player2Markers)) {
                return true;
            }
            countInColumn++;
        }

        //проверяем главную диагональ
        int countInDiagonal = 0;
        StringBuilder winnerMarkersInMainDiagonal = new StringBuilder();
        for (Cell[] cells : cellsArray) {
            for (Cell cell : cells) {
                if (cell.getY() == countInDiagonal && cell.getX() == countInDiagonal) {
                    winnerMarkersInMainDiagonal.append(cell.getValue());
                }
            }
            countInDiagonal++;
        }
        if (winnerMarkersInMainDiagonal.toString().equals(player1Markers)) {
            return true;
        } else if (winnerMarkersInMainDiagonal.toString().equals(player2Markers)) {
            return true;
        }

        //проверяем вспомогательную диагональ

        //на выходе из предыдущего for countInDiagonal будет равен 3 (это было условием выхода из while), тогда
        // включаем проверку второй диагонали уменьшив входящий countInDiagonal:
        --countInDiagonal;
        StringBuilder winnerMarkersInSideDiagonal = new StringBuilder();
        for (Cell[] cells : cellsArray) {
            for (Cell cell : cells) {
                if (cell.getY() == countInDiagonal) {//x==0 -> 1 -> 2 && cell.getX() == (cellsArray.length -1 - countInDiagonal)
                    winnerMarkersInSideDiagonal.append(cell.getValue());
                }
            }
            countInDiagonal--; //но здесь уже постепенно уменьшаем counter до 0.
        }
        if (winnerMarkersInSideDiagonal.toString().equals(player1Markers)) {
            return true;
        } else {
            return winnerMarkersInSideDiagonal.toString().equals(player2Markers);
        }
    }


}
