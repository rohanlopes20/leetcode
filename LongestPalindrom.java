package com.leetcode;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class LongestPalindrom {
    public static void main(String[] args) throws IOException {
        LongestPalindrom palindrom = new LongestPalindrom();
        String chars1 = "eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee";
        chars1 = "babad";
        chars1 = "abcabc";
//        chars1 = "LIZALROHANLOPES";
        System.out.println("max length is : " + palindrom.longestPalindrome(chars1));
//        String content = new String(Files.readAllBytes(Paths.get("data.txt")));
        System.out.println(palindrom.isPalindrome("aba"));
    }

    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length()-1;

        while(left < right) {
            char l = s.toLowerCase().charAt(left);
            char r = s.toLowerCase().charAt(right);

            if(!Character.isLetterOrDigit(l)) {
                left++;
                continue;
            }
            if(!Character.isLetterOrDigit(r)) {
                right--;
                continue;
            }

            if(l != r) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    public String longestPalindrome(String s) {
        String palindrom = "";

        for(int i = 0; i <= s.length(); i++) {
            for(int j = i+1; j <= s.length(); j++) {
                String tmp = s.substring(i, j);
                if(isPalindrom(tmp)) {
                    palindrom = (tmp.length() > palindrom.length()) ? tmp : palindrom ;
                }
            }
        }

        return palindrom;
    }

    private boolean isPalindrom(String inputStr) {
        for(int i = 0; i < inputStr.length()/2; i++) {
            if(inputStr.charAt(i) != inputStr.charAt((inputStr.length() -1) -i)) {
                return false;
            }
        }
        return true;
    }
}
