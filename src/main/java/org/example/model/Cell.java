package org.example.model;

public class Cell {
    private int index;
    private String value;
    private final int x; //индекс строки массива [x][]
    private final int y; //индекс столбца массива [][y]

    public Cell(int index, String value, int x, int y) {
        this.index = index;
        this.value = value;
        this.x = x;
        this.y = y;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public void setValue(String value) {
        this.value = value;
    }


    public int getIndex() {
        return index;
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
        return "index=" + index +
                ", value=" + value +
                ", x=" + x +
                ", y=" + y;
    }
}