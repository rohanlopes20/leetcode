package com.leetcode;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class WordSearch {

    public static void main(String[] args) {
        char[][] board = new char[][] {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "CED";
        System.out.println(new WordSearch().exist(board, word));

        char[][] data = { {'1','1','1','1','0'}, {'1','1','0','0','1'},{'1','1','0','1','0'}, {'0','0','1','0','1'}};
        System.out.println(new WordSearch().noOfIslands(data));
    }

    public int noOfIslands(char[][] data) {
        int counter = 0;
        for (int row = 0; row < data.length; row++) {
            for (int col = 0; col < data[row].length; col++) {
                if (data[row][col] == '1') {
                    islandsHelper(data, row, col);
                    counter++;
                }
            }
        }

        return counter;
    }

    private void islandsHelper(char[][] board, int row, int col) {
        if(row < 0 || col < 0 || row >= board.length || col >= board[0].length
          || board[row][col] == '0') {
            return;
        }
        board[row][col] = '0';
        islandsHelper(board, row + 1, col);
        islandsHelper(board, row - 1, col);
        islandsHelper(board, row, col + 1);
        islandsHelper(board, row, col - 1);
    }

    public boolean exist(char[][] board, String word) {
        Set<String> set = new LinkedHashSet<>();
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                boolean exists = existHelper(board, word, row, col, 0, set);
                if (exists) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean existHelper(char[][] board, String word, int row, int col, int l, Set<String> set) {
        boolean result;

        if(l == word.length() ) {
            return true;
        }

        if(row < 0 ||
                col < 0 ||
                row >= board.length ||
                col >= board[0].length ||
                word.charAt(l) != board[row][col] ||
                set.contains(row + " " + col)) {
            return false;
        }

        set.add(row + " " + col);
        result = existHelper(board, word,row + 1, col,l + 1, set) ||
                 existHelper(board, word, row,col + 1,l + 1, set) ||
                 existHelper(board, word,row - 1 , col,l + 1, set) ||
                 existHelper(board, word, row,col - 1,l + 1, set) ;
        set.remove(row + " " + col);
        return result;
    }
}