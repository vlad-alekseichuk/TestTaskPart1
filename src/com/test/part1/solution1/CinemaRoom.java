package com.test.part1.solution1;

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
        for (int i = 0; i < cinemaRoom[row].length; i++) {
            if (i + countPersons <= cinemaRoom[row].length) {
                find(countPersons, i, row);
            }
        }
    }

    private void find(int countPersons, int currentIndex, int row) {
        if (isFoundPlacesOnRow(countPersons, currentIndex, row)) {
            System.out.print("\nРяд " + (row + 1) + ": ");
            printPlaces(countPersons, currentIndex, row);
        }
    }

    private void printPlaces(int countPersons, int currentIndex, int row) {
        int personNunber = 0;
        System.out.print("(");

        while (personNunber != countPersons) {
            if (cinemaRoom[row][currentIndex + personNunber] == 0) {
                System.out.print(currentIndex + personNunber + 1 + (personNunber != countPersons - 1 ? "," : ""));
            }
            personNunber++;
        }
        System.out.print(")");

    }

    private boolean isFoundPlacesOnRow(int countPersons, int currentIndex, int row) {
        while (countPersons != 0) {
            if (cinemaRoom[row][currentIndex + countPersons - 1] != 0) {
                return false;
            }
            countPersons--;
        }
        return true;
    }

}
