package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LargestTriangleArea {
    public static void main(String[] args) {
        System.out.println(new LargestTriangleArea().largestTriangleArea(new int[][]{{1,0},{0,0},{0,1}}));
        System.out.println(new LargestTriangleArea().largestPerimeter(new int[]{3,6,2,3}));
        System.out.println(new LargestTriangleArea().singleNumber(new int[]{4,1,2,1,2}));
        System.out.println(new LargestTriangleArea().singleNumber2(new int[]{2,2,3,2}));
        System.out.println(Arrays.toString(new LargestTriangleArea().singleNumber3(new int[]{0,1,2,2})));
        System.out.println(new LargestTriangleArea().checkDistances("aa", new int[]{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}));
    }

    public double largestTriangleArea(int[][] points) {
        double area = 0;

        for(int i = 0; i < points.length; i++) {
            for(int j = 0; j < points.length; j++) {
                for(int k = 0; k < points.length; k++) {
                    double currentArea = 0.5 * Math.abs(points[i][0]*(points[j][1]-points[k][1]) + points[j][0]*(points[k][1]-points[i][1]) + points[k][0]*(points[i][1]-points[j][1])) ;
                    area = Math.max(currentArea, area);
                }
            }
        }

        return area;
    }

    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);

        for(int i = nums.length - 3; i >=0; i--) {
            if (nums[i] + nums[i + 1] > nums[i + 2])
                return nums[i] + nums[i + 1] + nums[i + 2];
        }

        return 0;
    }

    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        int i = 0;
        while(i < nums.length-1) {
            if(nums[i] == nums[i+1]) {
                i++;
                i++;
            } else {
                return nums[i];
            }
        }

        return nums[nums.length-1];
    }

    public int singleNumber2(int[] nums) {
        Arrays.sort(nums);
        int i = 0;
        while(i < nums.length-2) {
            if(nums[i] == nums[i+1] && nums[i+1] == nums[i+2]) {
                i+=3;
            } else {
                return nums[i];
            }
        }

        return nums[nums.length-2];
    }

    public int[] singleNumber3(int[] nums) {
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>(2);
        int i = 0;
        while(i < nums.length-2) {
            if(nums[i] == nums[i+1]) {
                i+=2;
            } else {
                list.add(nums[i]);
                i++;
            }
        }

        if(list.isEmpty()) {
            list.add(nums[nums.length-2]);
            list.add(nums[nums.length-1]);
        } else if(list.size() == 1) {
            list.add(nums[nums.length-1]);
        }

        return list.stream().mapToInt(ii->ii).toArray();
    }

    public boolean checkDistances(String s, int[] distance) {
        List<Character> checked = new ArrayList<>();

        System.out.println(s.charAt(0));
        for(int i = 0; i < s.length(); i++) {
            char letter = s.charAt(i);
            int dist = (letter - 97);
            if(!checked.contains(letter)) {
                if(s.lastIndexOf(letter) - 1 - i == distance[dist]) {
                    checked.add(letter);
                } else {
                    return false;
                }
            }
        }

        return true;
    }
}
