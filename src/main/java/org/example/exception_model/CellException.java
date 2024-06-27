package org.example.exception_model;

public class CellException extends NumberFormatException {
    /**
     * Класс исключения для пробы работы с ними.
     */
    public CellException() {
        super("Ячейка не пуста или ввод не корректен!\n");
    }
}
