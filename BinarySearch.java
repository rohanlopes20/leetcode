package com.leetcode;

public class BinarySearch {
    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();
        int[] array = new int[]{-1,0,3,5,9,12};

        System.out.println(binarySearch.binarySearch(array, 0));
    }

    private int binarySearch(int[] array, int searchElement) {
        int index = -1;

        int min = 0 ;
        int max = array.length-1;

        if(searchElement > array[array.length-1] || searchElement < array[0]) {
            return -1;
        }

        while(min <= max) {
            int mid = (max + min)/2;
            if (array[mid] == searchElement) {
                return mid;
            } else if (array[mid] > searchElement) {
                max = mid-1;
            } else {
                min = mid+1;
            }
        }

        return index;
    }
}

