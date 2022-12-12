package com.leetcode;

public class MaxSubArray {
    public static void main(String[] args) {
        MaxSubArray maxSubArray = new MaxSubArray();
        int[] array = new int[]{-1, 2,-3, 4,-5, -6, 7,-8,0};
        System.out.println(maxSubArray.maxSum(array));
    }

    private int maxSum(int[] array){
        int globalSum = array[0];
        int currentSum = array[0];

        for(int i = 1; i < array.length; i++ ) {
            currentSum = Math.max( array[i], currentSum + array[i]);
            globalSum = Math.max(globalSum, currentSum);
            System.out.println("i | " + i + " | " + currentSum + " | " + globalSum );
            System.out.println("-----------");
        }

        return globalSum;
    }
}
