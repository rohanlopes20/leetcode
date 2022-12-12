package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class RomanToINt {

    public static void main(String[] args) {
        System.out.println(new RomanToINt().romanToInt("LVIII"));
    }

    public int romanToInt(String s) {
        int num = 0;
        int count = 0;

        while(count != s.length()) {
            if(s.charAt(count) == 'I' && (count+1) != s.length() && s.charAt(count+1) == 'V') {
                num +=4;
                count +=2;
            } else if(s.charAt(count) == 'X' && (count+1) != s.length() && s.charAt(count+1) == 'L') {
                num +=40;
                count +=2;
            }  else if(s.charAt(count) == 'C' && (count+1) != s.length() && s.charAt(count+1) == 'D') {
                num +=400;
                count +=2;
            } else if(s.charAt(count) == 'I' && (count+1) != s.length() && s.charAt(count+1) == 'X') {
                num +=9;
                count +=2;
            } else if(s.charAt(count) == 'X' && (count+1) != s.length() && s.charAt(count+1) == 'C') {
                num +=90;
                count +=2;
            }  else if(s.charAt(count) == 'C' && (count+1) != s.length() && s.charAt(count+1) == 'M') {
                num +=900;
                count +=2;
            } else {
                num +=getValue(s.charAt(count));
                count +=1;
            }

        }

        return num;
    }

    private int getValue(char key) {
        Map<Character, Integer> symbolValue = new HashMap<>();
        symbolValue.put('I', 1);
        symbolValue.put('V', 5);
        symbolValue.put('X', 10);
        symbolValue.put('L', 50);
        symbolValue.put('C', 100);
        symbolValue.put('D', 500);
        symbolValue.put('M', 1000);

        return symbolValue.get(key);
    }
}
