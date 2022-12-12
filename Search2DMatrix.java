package com.leetcode;

public class Search2DMatrix {
    public static void main(String[] args) {
        int[][] test1 = new int[][] {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        System.out.println(new Search2DMatrix().searchMatrix(test1, 13));
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int row = 0;

        while(row != matrix.length) {
            if(target < matrix[row][0]) {
                return false;
            }

            if(target > matrix[matrix.length -  1][matrix[0].length - 1]) {
                return false;
            }

            if(target >= matrix[row][0] && matrix[row][matrix[row].length - 1] >= target) {
                int low = 0;
                int high = matrix[0].length - 1;

                while (low <= high) {
                    int mid = (low + high) / 2;

                    if(matrix[row][mid] == target) {
                        return true;
                    } else if(matrix[row][mid] > target) { // 1, 2, 3, 4 , 5
                        high = mid - 1;
                    } else {
                        low = mid + 1;
                    }
                }

                return false;
            } else {
                row++;
            }
        }

        return false;
    }
}
