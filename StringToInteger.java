package com.leetcode;

public class StringToInteger {
    public static void main(String[] args) {
        StringToInteger stringToInteger = new StringToInteger();
        System.out.println(stringToInteger.parseInt("1234567"));
    }

    private int parseInt(String str) {
        int num = 0;
        int i = 0;

        while(i < str.length() && Character.isDigit(str.charAt(i))) {
            int digit = Character.getNumericValue(str.charAt(i));
            num = num*10 + digit;
            i++;
        }

        return num;
    }
}
