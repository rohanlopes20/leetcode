package com.leetcode;

import javafx.util.Pair;

import java.util.*;

public class MazeEntrance {
    public static void main(String[] args) {
//        System.out.println(new MazeEntrance().nearestExit(new char[][] {{'+','+','.','+'},{'.','.','.','+'},{'+','+','+','.'}}, new int[] {1, 2}));
//        System.out.println(new MazeEntrance().nearestExit(new char[][] {{'+','+','+'},{'.','.','.'},{'+','+','+'}}, new int[] {1, 0}));
//        System.out.println(new MazeEntrance().nearestExit(new char[][] {{'.','+'}}, new int[] {0, 0}));
//        System.out.println(new MazeEntrance().nearestExit(new char[][]
//                {{'+','.','+','+','+','+','+'},
//                {'+','.','+','.','.','.','+'},
//                {'+','.','+','.','+','.','+'},
//                {'+','.','.','.','+','.','+'},
//                {'+','+','+','+','+','.','+'}}, new int[] {0, 1}));
        System.out.println(new MazeEntrance().nearestExit(new char[][]{
                {'.','+','+','+','.','.','.','+','+'},
                {'.','.','+','.','+','.','+','+','.'},
                {'.','.','+','.','.','.','.','.','.'},
                {'.','+','.','.','+','+','.','+','.'},
                {'.','.','.','.','.','.','.','+','.'},
                {'.','.','.','.','.','.','.','.','.'},
                {'.','.','.','+','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.','+'},
                {'+','.','.','.','+','.','.','.','.'}}, new int[] {5, 6}));//2
//        System.out.println(new MazeEntrance().nearestExit(new char[][] //1
//                {{'+','.','+','.','.','+','.','.','+','.','.','.','+','+','.','.','.','.','+','.'},
//                        {'.','+','+','.','+','.','.','.','+','+','+','.','+','.','.','+','.','+','+','.'},
//                        {'+','.','.','.','.','+','.','.','.','.','.','.','.','.','+','.','.','+','+','.'},
//                        {'.','.','.','+','+','.','.','.','+','.','+','.','.','+','.','.','+','.','.','.'},
//                        {'+','.','.','.','.','.','+','.','.','+','.','.','+','+','.','+','+','.','.','.'},
//                        {'.','+','.','.','.','.','+','.','+','.','.','.','.','.','.','+','.','+','+','+'},
//                        {'.','.','.','+','.','.','+','.','+','+','.','+','.','.','.','.','.','+','.','.'},
//                        {'.','.','.','.','.','+','+','+','.','.','.','+','.','+','+','+','+','.','.','.'},
//                        {'.','.','+','.','.','+','.','+','.','.','+','.','.','.','.','.','.','.','+','.'},
//                        {'.','.','.','.','.','.','+','.','+','.','.','.','+','.','+','.','.','.','+','.'},
//                        {'.','+','.','+','.','.','+','.','+','.','.','+','.','+','.','.','.','.','.','+'},
//                        {'.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.'},
//                        {'+','+','+','+','.','.','+','.','.','.','+','.','.','+','+','+','.','.','.','.'},
//                        {'.','.','+','+','.','+','.','.','.','.','.','+','+','.','.','+','.','.','.','.'},
//                        {'.','.','.','+','.','.','.','.','.','.','.','+','.','.','.','.','+','.','.','.'},
//                        {'.','+','+','.','.','+','.','.','.','.','+','+','.','+','+','.','.','.','+','.'},
//                        {'+','.','.','.','.','.','+','.','.','.','.','+','.','.','.','.','.','.','.','.'},
//                        {'.','.','.','.','+','.','.','.','+','.','.','+','.','.','.','.','.','.','.','.'}}, new int[] {17, 15}));
    }

    public int nearestExit(char[][] maze, int[] entrance) {
        int i = entrance[0];
        int j = entrance[1];
        Queue<int[]> directions = new LinkedList<>();
        directions.add(new int[]{i, j});

        return bfs(maze, directions);
    }

    private int bfs(char[][] maze, Queue<int[]> directions) {
        int steps = 0;
        int maxRow      = maze.length;
        int maxColumn   = maze[0].length;

        while (!directions.isEmpty()) {
            steps++;

            int[][] direction = new int[][]{{-1, 0},{1, 0},{0, -1},{0, 1}};
            int n = directions.size();

            for (int ii = 0; ii < n; ii++) {
                int[] step = directions.poll();
                int i = step[0];
                int j = step[1];
                maze[i][j] = '+';
                for (int dirs = 0; dirs < 4; dirs++) {
                    int newRow = direction[dirs][0] + i;
                    int newColumn = direction[dirs][1] + j;

                    if (newRow < 0 || newColumn < 0 || newRow >= maxRow || newColumn >= maxColumn || maze[newRow][newColumn] == '+') {
                        continue;
                    }

                    if (newRow == 0 || newColumn == 0 || newRow == maxRow - 1 || newColumn == maxColumn - 1) {
                        return steps;
                    }
                    directions.add(new int[]{newRow, newColumn});
                    maze[newRow][newColumn] = '+';
                }
            }
        }

        return -1;
    }

    private int bfsBk(char[][] maze, int[] entrance) {
        int rows = maze.length;
        int columns = maze[0].length;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(entrance);
        maze[entrance[0]][entrance[1]] = '+';

        int[][] directions = new int[][] {{0,1},{0,-1},{1,0},{-1,0}};

        int steps = 0;
        int x, y;
        while (!queue.isEmpty()) {
            steps++;

            int n = queue.size();
            for (int i = 0; i < n; i++) {
                int[] current = queue.poll();

                for (int[] direction : directions) {
                    x = current[0] + direction[0];
                    y = current[1] + direction[1];

                    if (x < 0 || x >= rows || y < 0 || y >= columns) continue;
                    if (maze[x][y] == '+') continue;

                    if (x == 0 || x == rows - 1 || y == 0 || y == columns - 1) {
                        return steps;
                    }

                    maze[x][y] = '+';
                    queue.offer(new int[]{x, y});
                }
            }
        }
        return -1;
    }
}
