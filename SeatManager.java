package com.leetcode;

import javafx.util.Pair;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

class SeatManager {
    PriorityQueue<Integer> reservedSeats;
    PriorityQueue<Integer> unreservedSeats;

    int totalSeats;
    public SeatManager(int n) {
        reservedSeats = new PriorityQueue<>(n);
        unreservedSeats = new PriorityQueue<>(n);
        totalSeats = n;

        for(int i = 1 ; i <= totalSeats; i++) {
            unreservedSeats.add(i);
        }
    }
    
    public int reserve() {
        int currentReserverd = 0;
        currentReserverd = unreservedSeats.poll();
        reservedSeats.add(currentReserverd);

        return currentReserverd;
    }
    
    public void unreserve(int seatNumber) {
        reservedSeats.remove(seatNumber);
        unreservedSeats.add(seatNumber);
    }

    public static void main(String[] args) {
        SeatManager seatManager = new SeatManager(5);
//        System.out.println(seatManager.reserve());
//        System.out.println(seatManager.reserve());
//        seatManager.unreserve(2);
//        System.out.println(seatManager.reserve());
//        System.out.println(seatManager.reserve());
//        System.out.println(seatManager.reserve());
//        System.out.println(seatManager.reserve());
//        seatManager.unreserve(5);

        System.out.println(seatManager.getWinner(new int[] {3,2,1},10));
    }

    public int getWinner(int[] arr, int k) {
//        Round |       arr       | winner | win_count
//        1   | [2,1,3,5,4,6,7] | 2      | 1
//        2   | [2,3,5,4,6,7,1] | 3      | 1
//        3   | [3,5,4,6,7,1,2] | 5      | 1
//        4   | [5,4,6,7,1,2,3] | 5      | 2
//        So we can see that 4 rounds will be played and 5 is the winner because it wins 2 consecutive games.
        int winner = 0;
        int winCount = 0;
        int prevWinner = -1;

        while (winCount != k) {
            int player1 = arr[0];
            int player2 = arr[1];

            if(player1 > player2) {
                winner = player1;
                //swap
                swapLoserWithLast(arr);
            } else {
                winner = player2;
                swap(1, 0, arr);
                swapLoserWithLast(arr);
            }

            if(prevWinner != -1 && prevWinner != winner) {
                winCount = 0;
            }
            winCount++;
            prevWinner = winner;
        }

        return winner;
    }

    private void swap(int pos, int des, int arr[]) {
        int tmp  = arr[pos];
        arr[pos] = arr[des];
        arr[des] = tmp;
    }

    private void swapLoserWithLast(int arr[]) {
        int loser = arr[1];
        for(int i = 2; i < arr.length; i++) {
            arr[i-1] = arr[i];
        }

        arr[arr.length-1] = loser;
    }
}
