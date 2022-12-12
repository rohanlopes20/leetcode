package com.leetcode;

import java.security.SecureRandom;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class NoOfIslands {
    public static void main(String[] args) throws Exception {

        char[][] data = { {'1','1','1','1','0'}, {'1','1','0','0','1'},{'1','1','0','1','0'}, {'0','0','1','0','1'}};
//        char[][] data  = {{'1','1','1','1','1','0','1','1','1','1'},
//                {'1','0','1','0','1','1','1','1','1','1'},
//                {'0','1','1','1','0','1','1','1','1','1'},
//                {'1','1','0','1','1','0','0','0','0','1'},
//                {'1','0','1','0','1','0','0','1','0','1'},
//                {'1','0','0','1','1','1','0','1','0','0'},
//                {'0','0','1','0','0','1','1','1','1','0'},
//                {'1','0','1','1','1','0','0','1','1','1'},
//                {'1','1','1','1','1','1','1','1','0','1'},
//                {'1','0','1','1','1','1','1','1','1','0'}};
        System.out.println(new NoOfIslands().numIslands(data));
        System.out.println(new NoOfIslands().maxAreaOfIsland(data));

        System.out.println(new NoOfIslands().generateRandomValue("CH"));
    }

    public String generateRandomValue(String moduleId) throws Exception {

        StringBuilder finalSeq = new StringBuilder();
        String randomNumber = "";
        int seqNo = 123;
        String seqNoStr = String.valueOf(seqNo);
        String systemRefPrefix = "";
        if (moduleId.trim().length() == 2) {
            systemRefPrefix = moduleId;
            finalSeq.append(systemRefPrefix.toUpperCase());
        }

        finalSeq.append(seqNoStr);
        int randomNumberLength = 15 - finalSeq.length();
        SecureRandom random = new SecureRandom();

        randomNumber = String.valueOf(random.nextInt((int) 100000000000000L));

        for (int i = 0; i < randomNumberLength - randomNumber.length(); i++) {

            finalSeq.append(0);
        }

        finalSeq.append(randomNumber);

        return finalSeq.toString();
    }


    public int maxAreaOfIsland(char[][] grid) {
        int num = 0;
        Set<String> visited = new LinkedHashSet<>();

        for(int row = 0; row < grid.length; row++) {
            for(int col = 0; col < grid[row].length; col++) {
                System.out.print(grid[row][col] + " " );

                if(!visited.contains(row + "|" + col) && grid[row][col] == '1') {
                    num = Math.max(num, doBFS(row, col, grid, visited));
                }
            }
            System.out.println();
        }

        return num;
    }

    public int numIslands(char[][] grid) {
        int num = 0;
        Set<String> visited = new LinkedHashSet<>();

        for(int row = 0; row < grid.length; row++) {
            for(int col = 0; col < grid[row].length; col++) {
                System.out.print(grid[row][col] + " " );

                if(!visited.contains(row + "|" + col) && grid[row][col] == '1') {
                    doBFS(row, col, grid, visited);
                    num++;
                }
            }
            System.out.println();
        }

        return num;
    }

    private int doBFS(int row, int col, char[][] grid, Set<String> visited) {
        int sum = 1;
        String currentNode = row + "|" + col;
        visited.add(currentNode);
        Queue<String> queue = new LinkedList<>();
        queue.add(currentNode);

        while (!queue.isEmpty()) {
            String node = queue.poll();
            int rowVal = Integer.parseInt(node.split("\\|")[0]);
            int colVal = Integer.parseInt(node.split("\\|")[1]);

            //up
            if (isValid(grid, rowVal - 1, colVal, visited) && grid[rowVal - 1][colVal] == '1') {
                visited.add(rowVal - 1 + "|" + colVal);
                queue.add(rowVal - 1 + "|" + colVal);
                sum++;
            }

            //bottom
            if (isValid(grid, rowVal + 1, colVal, visited) && grid[rowVal + 1][colVal] == '1') {
                visited.add(rowVal + 1 + "|" + colVal);
                queue.add(rowVal + 1 + "|" + colVal);
                sum++;
            }

            //left
            if (isValid(grid, rowVal, colVal - 1, visited) && grid[rowVal][colVal - 1] == '1') {
                visited.add(rowVal + "|" + (colVal - 1));
                queue.add(rowVal + "|" + (colVal - 1));
                sum++;
            }

            //right
            if (isValid(grid, rowVal, colVal + 1, visited) && grid[rowVal][colVal + 1] == '1') {
                visited.add(rowVal + "|" + (colVal + 1));
                queue.add(rowVal  + "|" + (colVal + 1));
                sum++;
            }
        }

        return sum;
    }

    private boolean isValid(char[][] grid, int row, int col, Set<String> visited) {
        if(!visited.contains(row + "|" + col) && (row < grid.length && row > -1) && (col < grid[0].length && col > -1)) {
            return true;
        }
        return false;
    }
}
