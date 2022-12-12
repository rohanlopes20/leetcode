package com.leetcode;

import java.util.Arrays;

public class StairJump {
    public static void main(String[] args) {
        StairJump stairJump = new StairJump();
        int[] possibleJumps = {1,2,3};
        System.out.println(stairJump.numOfJumpsNeeded(possibleJumps, 7));

        int[] possibleJumps1 = {1,2};
        int[] costOfJumps = {1,100,1,1,1,100,1,1,100,1};
        System.out.println(stairJump.minCostOfJump(possibleJumps1, costOfJumps));
    }

    private int minCostOfJump(int[] possibleJumps, int[] costOfJumps) {
        int[] arrayCp = new int[costOfJumps.length+1];
        System.arraycopy(costOfJumps,0, arrayCp, 0, costOfJumps.length);

        for ( int i = arrayCp.length - 3; i >= 0; i--) {
            arrayCp[i] = Math.min(arrayCp[i] + arrayCp[i + 1], arrayCp[i] + arrayCp[i + 2]);
        }

        return Math.min(arrayCp[0], arrayCp[1]);
    }

    private int numOfJumpsNeeded(int[] possibleJumps, int noOfSteps) {
        int[] array = new int[noOfSteps+1];
        Arrays.fill(array, noOfSteps + 1);
        System.out.println(Arrays.toString(array));
        array[0] = 0;

        for(int i = 1; i <= noOfSteps;i++) {
            for(int j = 0; j < possibleJumps.length; j++) {
                if(i-j-1 >= 0) {
                    System.out.println(i-j-1 + " " + array[i] + " " +  (array[i-j-1]+1));
                    array[i] = Math.min(array[i], array[i-j-1]+1);
                }
            }
        }

        System.out.println(Arrays.toString(array));
        return array[noOfSteps];
    }
}
