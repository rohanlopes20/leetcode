package com.leetcode;

import com.BurnDown;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;
import java.util.stream.Collectors;

public class FindBall {
    public static void main(String[] args) throws IOException, URISyntaxException {
        System.out.println(Arrays.toString(new FindBall().findBall(new int[][] {
                {1,1,1,-1,-1},
                {1,1,1,-1,-1},
                {-1,-1,-1,1,1},
                {1,1,1,1,-1},
                {-1,-1,-1,-1,-1}
        })));
//        System.out.println(Arrays.toString(new FindBall().findBall(new int[][] {{1,1,1,1,1,1},{-1,-1,-1,-1,-1,-1},{1,1,1,1,1,1},{-1,-1,-1,-1,-1,-1}})));
//        System.out.println(new FindBall().makeGood("leEeetcode"));
//        System.out.println(new FindBall().makeGood("abBAcC"));
//        System.out.println(new FindBall().makeGood("s"));
        System.out.println(new FindBall().removeDuplicates("abbaca"));
        System.out.println(new FindBall().removeDuplicates("azxxzy"));
        String test =  new String(Files.readAllBytes(Paths.get(FindBall.class.getResource("/removeduplicates.txt").toURI())));
        System.out.println(new FindBall().removeDuplicates(test));

    }

    public String removeDuplicates(String s) {
        if(s.length() == 1) {
            return s;
        }

        return removeDuplicatesHelper(s);
    }

    private String removeDuplicatesHelper(String s) {
        int pointer1 = 0;
        int pointer2 = 1;

        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++) {
            if(!stack.isEmpty() && stack.peek() == s.charAt(i)) {
                stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
        }

//        while (pointer1 < pointer2 && pointer1 < s.length() && pointer2 < s.length()) {
//            if(s.charAt(pointer1) == s.charAt(pointer2)) {
//                String s1 = removeDuplicatesHelper(s.substring(0, pointer1));
//                String s2 = removeDuplicatesHelper(s.substring(pointer2 + 1));
//                return removeDuplicatesHelper(s1 + s2);
//            } else {
//                pointer1++;
//                pointer2++;
//            }
//        }

        return stack.stream().map(i-> String.valueOf(i)).collect(Collectors.joining());
    }

    public String makeGood(String s) {
        if(s.length() == 1) {
            return s;
        }

        return getString(s);
    }

    private String getString(String s) {
        StringBuffer sb = new StringBuffer(s);
        int pointer1 = 0;
        int pointer2 = 1;

        while (pointer1 < pointer2 && pointer1 < sb.length() && pointer2 < sb.length()) {
            if(sb.charAt(pointer1) != sb.charAt(pointer2)
                && Character.toLowerCase(sb.charAt(pointer1)) == Character.toLowerCase(sb.charAt(pointer2))) {
                sb.deleteCharAt(pointer1);
                sb.deleteCharAt(pointer2-1);
                return getString(sb.toString());
            } else {
                pointer1++;
                pointer2++;
            }
        }

        return sb.toString();
    }

    public int[] findBall(int[][] grid) {
        int roww = grid.length;
        int coll = grid[0].length;

        int[][] ball = new int[grid.length][grid[0].length];
        for(int row = 0; row < ball.length; row++) {
            Arrays.fill(ball[row], -1);
        }

        for(int row = 0; row < grid.length; row++) {
            for(int col = 0; col < grid[row].length; col++) {
                //System.out.print(grid[row][col] + " ");

                if((col == 0 && grid[row][col] == -1) || (col == grid[row].length-1 && grid[row][col] == 1)) {
                    //ball[row][col] = "N";
                    continue;
                }

                if((col != 0 && grid[row][col] == 1) && (col != grid[row].length-1 && grid[row][col+1] == -1)) {
                    //ball[row][col] = "N";
                    continue;
                }

                if(grid[row][col] == 1 && col != grid[row].length-1 && grid[row][col+1] == 1) {
                    if(row == 0) {
                        ball[row][col + 1] = col;
                    } else if(row != 0 && ball[row - 1][col] != -1) {
                        ball[row][col + 1] = ball[row - 1][col];
                    }
                    continue;
                }

                if(col != 0 && grid[row][col-1] == -1 && grid[row][col] == -1) {
                    if(row == 0) {
                        ball[row][col -1] = col;
                    } else if(row != 0 && ball[row - 1][col] != -1) {
                        ball[row][col-1] = ball[row - 1][col];
                    }
                    continue;
                }

                System.out.print(ball[row][col] + " ");
            }
            System.out.println();
        }

        System.out.println("----");

        for(int row = 0; row < ball.length; row++) {
            for(int col = 0; col < ball[row].length ; col++) {
                System.out.print(ball[row][col] + " ");
            }
            System.out.println();
        }
        int ans[] = new int[coll];
        Arrays.fill(ans, -1);

        for(int col = 0; col < coll; col++) {
            if(ball[roww-1][col] != -1) {
                ans[ball[roww-1][col]] = col;
            }
        }

        return ans;
    }
}
