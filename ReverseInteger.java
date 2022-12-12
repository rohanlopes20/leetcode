package com.leetcode;

public class ReverseInteger {
    public static void main(String[] args) {
        System.out.println(new ReverseInteger().reverse(121));
    }

    private int reverse(int num) {
        int reverseNum = 0;

        while (num !=0) {
            reverseNum = 10 * reverseNum + (num % 10);
            num = num/10;
        }

        return reverseNum;
    }
}
