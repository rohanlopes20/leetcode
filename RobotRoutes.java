package com.leetcode;

import java.util.Arrays;

public class RobotRoutes {
    public static void main(String[] args) {
//        System.out.println(new RobotRoutes().getUniquePaths(8,3));
        System.out.println(new RobotRoutes().uniquePathsWithObstacles(new int[][]{{0,0,0},{0,1,0},{0,0,0}}));
        System.out.println(new RobotRoutes().uniquePathsWithObstacles(new int[][]{{0,0,0},{0,0,0},{1,0,0}}));
        System.out.println(new RobotRoutes().uniquePathsWithObstacles(new int[][]{{0,1},{0,0}}));
        System.out.println(new RobotRoutes().uniquePathsWithObstacles(new int[][]{{0,0},{1,1},{0,0}}));
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int grid[][] = new int[obstacleGrid.length][obstacleGrid[0].length];

        if(obstacleGrid[0][0] == 1) {
            return 0;
        }

        grid[0][0] = 1;

        //row
        for(int i = 1; i < obstacleGrid[0].length; i++) {
            if(obstacleGrid[0][i] != 1) {
                grid[0][i] = grid[0][i-1] == 0 ? 0 : 1;
            } else {
                grid[0][i] = obstacleGrid[0][i] == 1 ? 0 : grid[0][i-1];
            }
        }

        //col
        for(int i = 1; i < obstacleGrid.length; i++) {
            if(obstacleGrid[i][0] != 1) {
                grid[i][0] = grid[i-1][0] == 0 ? 0 : 1;
            } else {
                grid[i][0] = obstacleGrid[i][0] == 1 ? 0 : grid[i-1][0];
            }
        }

        for(int i = 1; i < obstacleGrid.length; i++) {
            for(int j = 1; j < obstacleGrid[i].length; j++) {
                if(obstacleGrid[i][j] != 1) {
                    grid[i][j] = grid[i-1][j] + grid[i][j-1];
                }
            }
        }


        return grid[obstacleGrid.length-1][obstacleGrid[0].length-1];
    }

    private int getUniquePaths(int m, int n) {
        int[][] matrix = new int[n][m];

        for (int j = m-1; j >=0; j--) {
            matrix[n-1][j] = 1;
        }

        for (int j = n-1; j >=0; j--) {
            matrix[j][m-1] = 1;
        }

        for (int i = n-2; i >=0; i--) {
            for (int j = m-2; j >=0; j--) {
                matrix[i][j] = matrix[i][j+1] + matrix[i+1][j];
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        return matrix[0][0];
    }
}
