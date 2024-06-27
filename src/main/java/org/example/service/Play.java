package org.example.service;

import org.example.model.Cell;
import org.example.model.Move;
import org.example.model.Player;
import org.example.model.PlayingField;
import org.example.util.CellChanger;
import org.example.util.CellGenerator;
import org.example.util.WinnerChecker;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Play {
    private Cell[][] cellsArray;
    private List<Move> moveList;
    private final Player player1;
    private final Player player2;
    private CellChanger cellChanger;
    private WinnerChecker winnerChecker;

    public Play(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public void getPlay(Scanner scanner) {
        initAllNecessaryUnits();
        doPlay(scanner);
    }

    private Player playerWhoGoesFirst() {
        Random random = new Random();
        int firstMove = random.nextInt(1, 3);//до 2 включительно

        if (firstMove == player1.getId()) {
            return player1;
        } else {
            return player2;
        }
    }

    private void initAllNecessaryUnits() {
        //создаем 2 объекта ходов
        Move move1 = new Move(player1);
        Move move2 = new Move(player2);

        //из них готовим список ходов
        moveList = new ArrayList<>();
        moveList.add(move1);
        moveList.add(move2);

        //получаем массив ячеек
        cellsArray = CellGenerator.getCells();

        //Кладем его в изменятель
        cellChanger = new CellChanger(cellsArray);

        //получаем проверщика победителя
        winnerChecker = new WinnerChecker(player1, player2, cellsArray);

        //Выводим девственное поле:
        System.out.println(PlayingField.getField(cellsArray));
    }

    private void doPlay(Scanner scanner) {
        boolean whileNotVictory = true; //флаг, чтобы можно было выключить цикл while при победе одного из игроков
        //псевдослучайным образом определяем, какой игрок ходит первым
        Player firstMovePlayer = playerWhoGoesFirst();
        System.out.printf("Первым ходит игрок %s \n", firstMovePlayer.getName());

        boolean isFirstMove = true; // Флаг, чтобы следить за первым ходом
        while (whileNotVictory) {
            for (Move move : moveList) {
                if (isFirstMove && move.getPlayer().getId() == firstMovePlayer.getId()) { //если ход первый
                    doMove(scanner, move);
                    isFirstMove = false; // меняем флаг, чтобы это условие больше не сработало

                    //проверим ход на победу
                    if (winnerChecker.isWinner()) {
                        System.out.println("Победил игрок " + move.getPlayer().getName());
                        whileNotVictory = false;
                        break;
                    }
                } else if (!isFirstMove && !move.isMadeMove()) { // остальные ходы
                    doMove(scanner, move);

                    //проверим ход на победу
                    if (winnerChecker.isWinner()) {
                        System.out.println("Победил игрок " + move.getPlayer().getName());
                        whileNotVictory = false;
                        break;
                    }
                }
            }
            if (whileNotVictory) {
                for (Move move : moveList) {
                    move.setMadeMove(false);
                }
            }
        }
    }

    private void doMove(Scanner scanner, Move move) {
        System.out.printf("Игрок %s, введи номер ячейки, куда установить маркер %s : ", move.getPlayer().getName(), move.getPlayer().getMarker());
        String cellNumber = scanner.next();
        cellChanger.getChangedCells(move.getPlayer(), cellNumber);
        move.setMadeMove(true);
        System.out.println(PlayingField.getField(cellsArray));
    }
}
