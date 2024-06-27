package org.example.runner;

import org.example.model.Player;
import org.example.service.Play;

import java.util.Scanner;

public class PlayRunner {
    public static void run() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Добро пожаловать в игру крестики-нолики!");
        System.out.print("Как зовут первого игрока : ");
        String name1 = sc.next();
        System.out.printf("Выберите свой маркер, %s : ", name1);
        String marker1 = sc.next();
        Player player1 = new Player(name1, marker1);

        System.out.print("Как зовут второго игрока : ");
        String name2 = sc.next();
        System.out.printf("Выберите свой маркер, %s : ", name2);
        String marker2 = sc.next();
        Player player2 = new Player(name2, marker2);

        System.out.println("\nДа начнется битва!\n");

        //создаем объект игры и стартуем
        Play play = new Play(player1, player2);
        play.getPlay(sc);
        sc.close();
    }
}
