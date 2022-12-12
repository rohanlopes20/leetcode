package com.leetcode;

public class NonRepeatNumber {
    public static void main(String[] args) {
        int arr[] = {12, 1, 12, 3, 12, 1, 1, 2, 3, 3};
        System.out.println(new NonRepeatNumber().getNonRepeatingNumber(arr));
        //12 1100 ^ 0000 => 12
        //
    }

    private int getNonRepeatingNumber(int arr[]) {
        int num = -1;
        int ones = 0, two = 0;

        for(int i = 0; i < arr.length; i++) {
            System.out.println((ones ^ arr[i]) + " " + ~two);
            ones = (ones ^ arr[i]) & ~two;
            two  = (two ^ arr[i]) & ~two;
        }

        return ones;
    }
}
