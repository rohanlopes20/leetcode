package com.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Toeplitz {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,2,3,4},{5,1,2,3},{9,5,1,2}};

//        System.out.println(new Toeplitz().isToeplitzMatrix(matrix));
//        System.out.println(new Toeplitz().lengthOfLastWord("   fly me   to   the moon  "));
//        System.out.println(Arrays.toString(new Toeplitz().replaceElements(new int[]{17,18,5,4,6,1})));"bbbaaaba"
//"aaabbbba""badc"
//"baba"
        System.out.println(new Toeplitz().isIsomorphic("paper","title"));
    }

    public boolean isIsomorphic(String s, String t) {
        int counter = 0;
        Map<Character, Character> sToTMap = new HashMap<>();
        Map<Character, Character> tToSMap = new HashMap<>();

        while (counter < s.length()) {
            Character s1 = s.charAt(counter);
            Character t1 = t.charAt(counter);

            if((sToTMap.containsKey(s1) && sToTMap.get(s1) != t1) || (tToSMap.containsKey(t1) && tToSMap.get(t1) != s1))
                return false;
            sToTMap.put(s1, t1);
            tToSMap.put(t1, s1);
            counter++;
        }

        return true;
    }

    public int[] replaceElements(int[] arr) {
        for(int i = 0; i < arr.length-1; i++) {
            arr[i] = getMax( i + 1, arr);
        }

        arr[arr.length-1] = -1;

        return arr;
    }

    public int getMax(int start, int arr[]) {
        int max = Integer.MIN_VALUE;

        for(int i = start; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }

        return max;
    }


    public boolean isToeplitzMatrix(int[][] matrix) {
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(!isSame(i, j, matrix)) {
                    return false;
                }
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("");
        }

        return true;
    }

    private boolean isSame (int i, int j, int[][] matrix) {
        //check top
        if(i-1 >= 0
                && j+1 < matrix[i].length
                && matrix[i-1][j] != matrix[i][j+1]) {
            return false;
        }

        return true;
    }

    public int lengthOfLastWord(String s) {
        String[] arr = s.trim().split("\\s");
        return arr[arr.length-1].length();
    }
}