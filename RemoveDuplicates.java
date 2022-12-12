package com.leetcode;

import java.util.*;

public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] array = {1,1,3,3,5,5,6,7};

        System.out.println(Arrays.toString(Arrays.stream(array).distinct().toArray()));

//        int j = 1;
//        for (int i = 0; i < array.length - 1; i++) {
//            if(array[i] != array[i+1]){
//                array[j++] = array[i+1];
//            }
//        }

        Stack<Integer> stack = new Stack<>();
        int counter = 0;

        for (int i = 0; i < array.length ; i++) {
            if(!stack.isEmpty() && stack.peek() == array[i]) {
                continue;
            } else {
                stack.push(array[i]);
                array[counter] = array[i];
                counter++;
            }
        }

        int i = 0;
//        System.out.println(Arrays.toString(array));
//        System.out.println(new RemoveDuplicates().removeDuplicates(array));
//        System.out.println(new RemoveDuplicates().removeElement(new int[]{3,3},3));
////        System.out.println(new RemoveDuplicates().removeElement(new int[]{3,2,2,3},3));
//        System.out.println(new RemoveDuplicates().removeElement(new int[]{1},1));
//        System.out.println(new RemoveDuplicates().removeElement(new int[]{0,1,2,2,3,0,4,2},2));
//        new RemoveDuplicates().moveZeroes(new int[]{0,1,2,3,0,5});
//        System.out.println(new RemoveDuplicates().findPeakElement(new int[]{1,2,1,3,5,6,4}));
//        System.out.println(new RemoveDuplicates().findPeakElement(new int[]{1,2,3}));
//        System.out.println(new RemoveDuplicates().findPeakElement(new int[]{1,2}));
//        System.out.println(new RemoveDuplicates().findPeakElement(new int[]{3,1,2}));
//        System.out.println(new RemoveDuplicates().isMonotonic(new int[]{4,3,2,1}));
//        System.out.println(new RemoveDuplicates().isMonotonic(new int[]{11,11,9,4,3,3,3,1,-1,-1,3,3,3,5,5,5}));
//        System.out.println(new RemoveDuplicates().isMonotonic(new int[]{11}));
//        System.out.println(new RemoveDuplicates().isMonotonic(new int[]{11,11,11}));
        System.out.println(new RemoveDuplicates().uniqueMorseRepresentations(new String[]{"rwjje","aittjje","auyyn","lqtktn","lmjwn"}));

    }

    public int uniqueMorseRepresentations(String[] words) {
        String[] arrayOfMorse = new String[] {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};

        Map<String, Integer> word = new HashMap<>();

        for(int i = 0; i < words.length; i++) {
            String currentWord =  words[i];
            StringBuilder morseString = new StringBuilder();

            for(int j = 0; j < currentWord.length(); j++) {
                morseString.append(arrayOfMorse[currentWord.charAt(j)-97]);
            }
            String str = morseString.toString();
            if(word.containsKey(str)) {
                word.put(str, word.get(str)+1);
            } else {
                word.put(str, 1);
            }
        }

        return word.size();
    }

    public boolean isMonotonic(int[] nums) {
        boolean up = true;
        boolean down = true;

        for(int i = 1;  i < nums.length; i++) {
            //check low
            if(nums[i] > nums[i-1]) {
                down = false;
            }

            //check high
            if(nums[i] < nums[i-1]) {
                up = false;
            }

            if(!down && !up) {
                return false;
            }
        }

        return true;
    }

    public int findPeakElement(int[] nums) {
        if(nums.length <= 1) {
            return 0;
        }

        int ans = 0;
       
        for(int i=1; i < nums.length; i++){
            if(nums[i-1]<nums[i]){
                ans = i;
            }
        }
        return ans;
    }

    public void moveZeroes(int[] nums) {
        int n= nums.length;
        int low=0;

        for(int i=0;i<n;i++){
            if(nums[i] != 0){
                swap(nums,i,low);
                low++;
            }
        }

        System.out.println(Arrays.toString(nums));
    }

    private void swap(int[] array, int index1, int index2) {
        int tmp = array[index1];
        array[index1] = array[index2];
        array[index2] = tmp;
    }

    public int removeElement(int[] nums, int val) {
        int count = 0;

        if(nums.length == 1 && nums[0] == val){
            return 1;
        }

        int left  = 0;
        int right = nums.length-1;
        while(left <= right) {
            if(nums[left] == val && nums[right] == val) {
                right--;count++;
            } else if(nums[left] == val) {
                nums[left] = nums[right];
                left++;
                right--;
                count++;
            } else {
                left++;
            }
        }
        return nums.length-count;
    }

    public int removeDuplicates(int[] nums) {
        //If length of array is 1, return 1
        if(nums.length ==1){
            return 1;
        }
        // we will use two pointer technique
        //since we already ahndled when array length is 1
        //take pointer left at index 0
        //take pointer right at index 1
        int left = 0;
        int right=1;
        while(right<nums.length){
            if(nums[left] != nums[right]){
                left++;
                nums[left] = nums[right];
            }
            right++;
        }
        //we return left+1,because our in-place replaced array is at index=left and length of an array is always lastIndex + 1
        return left+1;

    }
}
