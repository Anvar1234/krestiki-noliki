package org.example.model;

public class Cell {
    private String value;
    private final int x; //индекс строки массива [x][]
    private final int y; //индекс столбца массива [][y]

    public Cell(String value, int x, int y) {
        this.value = value;
        this.x = x;
        this.y = y;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return  "value=" + value +
                ", x=" + x +
                ", y=" + y;
    }
}