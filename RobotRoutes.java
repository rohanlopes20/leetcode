package com.leetcode;

import java.util.Arrays;

public class RobotRoutes {
    public static void main(String[] args) {
        System.out.println(new RobotRoutes().getUniquePaths(8,3));
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
