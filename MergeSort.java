package com.leetcode;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MergeSort {
    public static void main(String[] args) {
        int[] array = {5,3,6,9,2,1,4,7,0,8,};
        long time = System.currentTimeMillis();
        new MergeSort().mergeSort(uniqueRandomElements(1000000));
//        System.out.println(System.currentTimeMillis() - time);
        time = System.currentTimeMillis();
//        new MergeSort().bubbleSort(uniqueRandomElements(1000000));
//        System.out.println(System.currentTimeMillis() - time);
//        new MergeSort().merge(new int[]{1,7,8,0,0,0}, 3, new int[] {2,5,6}, 3);
//        System.out.println(Arrays.toString(new MergeSort().sortedSquares(new int[] {2,5,6})));
        System.out.println(new MergeSort().customSortString("exv", "xwvee"));
    }

    public String customSortString(String order, String s) {
        Map<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < order.length(); i++) {
            map.put(order.charAt(i), i);
        }

        char[] arr = s.toCharArray();
        List<Character> list = new ArrayList<>();

        for(int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
        }

        list.sort((a, b) -> {
            System.out.println(a + " " + b);
            if (map.containsKey(a) && map.containsKey(b)) {
                return Integer.compare(map.get(a), map.get(b));
            } else {
                return map.containsKey(a) ? 1 : map.containsKey(b)  ? 1 : -1;
            }
        });

        return list.stream().map(i->i+"").collect(Collectors.joining());
    }

    public int[] sortedSquares(int[] nums) {
        int[] ans = new int[nums.length];

        return Arrays.stream(nums).boxed().mapToInt( i -> i*i).sorted().toArray();
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] num3 = new int[nums1.length];

        int i = 0, j = 0, k = 0;

        while(i != m && j != n) {
            if(nums1[i] > nums2[j]) {
                num3[k] = nums2[j];
                j++;
                k++;
            } else {
                num3[k] = nums1[i];
                i++;
                k++;
            }
        }

        if(m > i) {
            while(i != m) {
                num3[k] = nums1[i];
                i++;
                k++;
            }
        }

        if(n > j) {
            while(j != n) {
                num3[k] = nums2[j];
                j++;
                k++;
            }
        }

        for(int ii = 0; ii < num3.length; ii++) {
            nums1[ii] = num3[ii];
        }
        nums1=num3;
        System.out.println(Arrays.toString(nums1));
    }

    public int[] move(int[] nums1, int startIndex) {
        for(int i = nums1.length - 1; i > startIndex; i--) {
            nums1[i] = nums1[i-1];
        }

        return nums1;
    }

    private int[] bubbleSort(int[] array) {
        /*for(int i = 0; i < array.length-1; i++) {
            for(int j = 0; j < array.length-1; j++) {
                if(array[j] > array[j+1]) {
                    int tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                }
                System.out.println(Arrays.toString(array));
            }
        }*/

        for(int i = 0; i < array.length-1; i++) {
            for(int j=1; j < (array.length-i); j++){
                if(array[j-1] > array[j]){
                    //swap elements
                    int temp = array[j-1];
                    array[j-1] = array[j];
                    array[j] = temp;
                }
            }
//            System.out.println(Arrays.toString(array));
        }

        return array;
    }

    public static int[] uniqueRandomElements(int size) {
        List<Integer> numbers = IntStream.rangeClosed(0, size).boxed().collect(Collectors.toList());
        Collections.shuffle(numbers);
        return numbers.stream().mapToInt(i->i).toArray();
    }

    private int[] mergeSort(int[] array) {
//        System.out.println(Arrays.toString(array));
        if(array.length == 1) {
            return array;
        }

        int mid = array.length/2;

        int[] left = mergeSort(getHalf(array, mid, 0));
        int[] right = mergeSort(getHalf(array, array.length - mid, mid));

        return mergeTwoHalf(left, right);
    }

    private int[] mergeTwoHalf(int[] left, int[] right) {
        int[] out = new int[left.length + right.length];

        int i = 0, j = 0, k = 0;

        while(i != left.length && j != right.length) {
            if(left[i] > right[j]) {
                out[k] = right[j];
                j++;
                k++;
            } else {
                out[k] = left[i];
                i++;
                k++;
            }
        }

        if(left.length > i) {
            while(i != left.length) {
                out[k] = left[i];
                i++;
                k++;
            }
        }

        if(right.length > j) {
            while(j != right.length) {
                out[k] = right[j];
                j++;
                k++;
            }
        }

        return out;
    }

    private int[] getHalf(int[] array, int size, int startPos) {
        int[] out = new int[size];

        int i = 0;
        while(i != size) {
            out[i] = array[startPos];
            startPos++;
            i++;
        }

        return out;
    }
}
