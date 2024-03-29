package com.leetcode;

import java.util.*;

public class Combinations {
    public static void main(String[] args) {
//        System.out.println(new Combinations().combine(4, 2));
//
//        System.out.println(new Combinations().combinationSum(new int[] {2,3,6,7}, 7));
//        System.out.println(new Combinations().combinationSum2(new int[] {10,1,2,7,6,1,5}, 8));
        System.out.println(new Combinations().zeroFilledSubarray(new int[] {1,3,0,0,2,0,0,4}));
        System.out.println(new Combinations().zeroFilledSubarray(new int[] {0,0,0,2,0,0}));
        System.out.println(new Combinations().zeroFilledSubarray(new int[] {2,10,2019}));

    }

    public long zeroFilledSubarray(int[] nums) {
        long res = 0;
        int  j = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] != 0)
                j = i + 1;
            res += i - j + 1;
        }
        return res;

        /*//int[] counterArray = new int[nums.length];
        Map<Integer, Integer> counterMap = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) {
                int index = i;
                int repeatCounter = 0;
                while (index < nums.length) {
                    if(nums[index] == 0) {
                        counterMap.put(repeatCounter, counterMap.getOrDefault(repeatCounter, 0) + 1);
                        repeatCounter++;
                        //counterArray[repeatCounter++]++;
                    } else {
                        break;
                    }
                    index++;
                }
            }
        }
        System.out.println(counterMap);
        //System.out.println(Arrays.toString(counterArray));
//        return Arrays.stream(counterArray).filter(i-> i != 0).sum();
        return counterMap.values().stream().mapToInt(i->i).sum();*/
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = combinationSum2Helper(candidates, target, 0, new ArrayList<>());
        return ans;
    }

    private List<List<Integer>> combinationSum2Helper(int[] candidates, int target, int index, List<Integer> integerList) {
        List<List<Integer>> list = new ArrayList<>();

        if(target == 0) {
            list.add(new ArrayList<>(integerList));
            return list;
        }

        if(target < 0) {
            return list;
        }

        int prev = -1;

        for(int i = index; i < candidates.length; i++) {
            if(prev == candidates[i]) {
                continue;
            }
            integerList.add(candidates[i]);
            List<List<Integer>> ans1 = combinationSum2Helper(candidates, target - candidates[i], i + 1, integerList);
            list.addAll(ans1);
            integerList.remove(integerList.size()-1);
            prev = candidates[i];
        }

        return list;
    }

    private List<List<Integer>> combinationSumHelper(int[] candidates, int target, int index,  int total, List<Integer> integerList) {
        List<List<Integer>> list = new ArrayList<>();

        if(total == target) {
            list.add(new ArrayList<>(integerList));
            return list;
        }

        if(index >= candidates.length || total > target) {
            return list;
        }

        integerList.add(candidates[index]);
        List<List<Integer>> ans1 = combinationSumHelper(candidates, target, index, total + candidates[index], integerList);
        list.addAll(ans1);
        integerList.remove(integerList.size() - 1);
        List<List<Integer>> ans2 = combinationSumHelper(candidates, target, index + 1, total, integerList);
        list.addAll(ans2);
        return list;
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = combinationSumHelper(candidates, target, 0, 0, new ArrayList<>());
        return ans;
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> list = helper(1, n, k, new ArrayList<>());
        System.out.println(list);
        return list;
    }

    public List<List<Integer>> helper(int start, int n, int k, List<Integer> combinations) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> integerList = new ArrayList<>();
        if(combinations.size() == k) {
            integerList.addAll(combinations);
            list.add(integerList);
            return list;
        }

        for(int i = start; i <= n; i++) {
            combinations.add(i);
            List<List<Integer>> list2 = helper(i+1, n, k, combinations);
            list.addAll(list2);
            combinations.remove(combinations.size()-1);
        }

        return list;
    }

}
