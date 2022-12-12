package com.leetcode;

public class FibbonaciSum {
    public static void main(String[] args) {
        System.out.println(new FibbonaciSum().fib(5));
    }

    private int fib(int num) {
        int num1 = 0;
        int num2 = 1;
        int sum = num1 + num2;

        System.out.print(num1 + " " + num2 + " " + sum);

        int i = 2;
        while(i++ <= num) {
            num1 = num2;
            num2 = sum;
            sum = num1+num2;
            System.out.print(" " + sum + " ");
        }
        System.out.println(" ");

        return sum;
    }
}
