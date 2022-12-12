package com.leetcode;

import java.util.*;

public class TwoSum {

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        int[] nums = new int[] {2,7,11,15};
        System.out.println(Arrays.toString(twoSum.twoSum(nums, 9)));
        int[] nums2 = new int[] {2,7,11,15};
        System.out.println(Arrays.toString(twoSum.twoSum2(nums2, 9)));
        int[] nums3 = new int[] {-14,-3,11,-3,12,-1,11,13,5,6,-11,-14,-6,11,-4,-15,3,-15,9,-10,13,-10,-9,-13,-12,12,-7,12,12,3,9,5,-14,-3,9,13,11,5,3,-6,-12,-1,-5,-3,-4,-2,-10,6,-10,14,3,-11,11,10,-9,7,-1,-9,4,-12,2,-2,8,3,3,-6,-7,-1,6,12,8,9,-12,10,-8,-1,-7,-3,12,-9,-12,1,-5,6,-12,-7,-2,2,-8,-13,5,9,-7,-10,-3,11,-1,-3,-13,-10,-14,11,6,-10,6,13,4,7,-13,-6,13,12,10,-15,4,13,-7,9,-8,0,4,4,-6,12,9,-2,0};
        System.out.println(twoSum.threeSum(nums3));
        System.out.println(twoSum.threeSum2(nums3));
    }

    public List<List<Integer>> threeSum2(int[] nums) {
        Arrays.sort(nums);
        LinkedList<List<Integer>> sol = new LinkedList<List<Integer>>();

        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                int target = -nums[i];
                int left = i + 1;
                int right = nums.length - 1;

                while (left < right) {
                    if (nums[left] + nums[right] == target) {
                        ArrayList<Integer> miniSol = new ArrayList<>();
                        miniSol.add(nums[i]);
                        miniSol.add(nums[left]);
                        miniSol.add(nums[right]);
                        sol.add(miniSol);
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        left++;
                        right--;
                    } else if (nums[left] + nums[right] > target) {
                        right--;
                    } else {
                        left++;
                    }
                }
            }
        }

        return sol;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();

        Arrays.sort(nums);

        for(int i = 0; i < nums.length; i++) {
            for(int j = i+1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> list2 = Arrays.asList(nums[i], nums[j], nums[k]);
                        if (!list.contains(list2))
                            list.add(list2);
                    }
                }
            }
        }

        return list;
    }

    public int[] twoSum2(int[] numbers, int target) {
        int low = 0;
        int high = numbers.length-1;

        while(low < high) {
            if(numbers[high] + numbers[low] > target) {
                high --;
            } else if(numbers[low] + numbers[high] < target) {
                low ++;
            } else {
                return new int[]{low+1, high+1};
            }
        }

        return null;
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        int index = 0;
        for(int i : nums) {
            if(map.get(i) != null) {
                return new int[]{map.get(i), i};
            } else {
                map.put(target - i, index++);
            }
        }
        return null;
    }
}

