package com.test.part1.solution2;

public class CinemaRoom {
    private int[][] cinemaRoom;

    public CinemaRoom(int rows, int seats) {
        cinemaRoom = new int[rows][seats];

        for (int i = 0; i < cinemaRoom.length; i++) {
            for (int j = 0; j < cinemaRoom[i].length; j++) {
                cinemaRoom[i][j] = (int) (Math.random() + 0.5);
            }
        }
    }

    public void printCinemaRoom() {
        for (int[] row : cinemaRoom) {
            for (int seat : row) {
                System.out.print(seat + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void findPlaces(int numOfPersons) {
        for (int i = 0; i < cinemaRoom.length; i++) {
            findPlaces(numOfPersons, i);
        }
    }

    public void findPlaces(int countPersons, int row) {
        int personNunber = countPersons;
        boolean printFlag = true;
        System.out.print("Ряд " + (row + 1) + ": ");
        for (int j = 0; j < cinemaRoom[row].length; j++) {
            int[] buff = new int[countPersons];
            while (personNunber != 0) {
                if (j + countPersons - personNunber <= cinemaRoom[row].length - 1
                        && cinemaRoom[row][j + countPersons - personNunber] == 0) {
                    buff[countPersons - personNunber] = j + countPersons - personNunber + 1;
                } else {
                    printFlag = false;
                }
                --personNunber;
            }
            personNunber = countPersons;
            if (printFlag) {
                System.out.print("(");
                for (int i = 0; i < buff.length; i++) {
                    System.out.print(buff[i] + (i != buff.length - 1 ? "," : ""));
                }
                System.out.print(")");
                System.out.print(" ");
            } else {
                printFlag = true;
            }
        }
        System.out.println();
    }

}
