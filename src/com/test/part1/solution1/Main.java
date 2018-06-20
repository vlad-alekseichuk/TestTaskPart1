package com.test.part1.solution1;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        new Main().createCinemaRoom();
    }

    private void createCinemaRoom() {
        System.out.println("Введите колличество рядов и мест в рядах");
        int rows;
        int seats;
        try (Scanner in = new Scanner(System.in)) {
            rows = in.nextInt();
            seats = in.nextInt();
        }

        CinemaRoom cinemaRoom = new CinemaRoom(rows, seats);
        System.out.println("Карта мест кинозала: ");
        cinemaRoom.printCinemaRoom();
        System.out.println("0 - место свободно");
        System.out.println("1 - место занято");

        System.out.println("3 места в первом ряду: ");
        cinemaRoom.findPlaces(3, 0);

        System.out.println("\n2 места в любом ряду: ");
        cinemaRoom.findPlaces(2);

    }
}
