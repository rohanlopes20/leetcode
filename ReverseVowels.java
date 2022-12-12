package com.leetcode;

public class ReverseVowels {

    public static void main(String[] args) {
        System.out.println(new ReverseVowels().reverseVowels("hello"));
        System.out.println(new ReverseVowels().reverseVowels("leetcode"));
    }

    public String reverseVowels(String s) {
        StringBuilder newString = new StringBuilder(s);

        int start = 0;
        int end = s.length() - 1;

        while (start < end) {
            char s1 = s.charAt(start);
            char c1 = s.charAt(end);

            boolean b   = s1 == 'a' || s1 == 'A' || s1 == 'i' || s1 == 'I' || s1 == 'o' || s1 == 'O' || s1 == 'u' || s1 == 'U' || s1 == 'e' || s1 == 'E';
            boolean b1  = c1 == 'a' || c1 == 'A' || c1 == 'i' || c1 == 'I' || c1 == 'o' || c1 == 'O' || c1 == 'u' || c1 == 'U' || c1 == 'e' || c1 == 'E';

            if(b
                && b1) {
                newString.setCharAt(start, c1);
                newString.setCharAt(end, s1);
                start++;
                end--;
            } else if(b) {
                end--;
            } else if (b1) {
                start++;
            } else {
                start++;
                end--;
            }
        }

        return newString.toString();
    }
}
