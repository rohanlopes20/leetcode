package com.leetcode;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

public class Subsets {

    public static void main(String[] args) {
//        System.out.println(new Subsets().subsets(new int[]{1,2,2}));
//        System.out.println(new Subsets().subsets2(new int[]{1,2,2,2,3}));

        int[] students = {1, 2, 3};
//        System.out.println(new Subsets().permute(students));
//        System.out.println(new Subsets().letterCombinations("23"));
//        System.out.println(new Subsets().generateParenthesis(3));
//        BigDecimal product = new BigDecimal("0").multiply(BigDecimal.valueOf(0));
//        new Subsets().generatePermutations("123");
//        System.out.println(new Subsets().findDifferentBinaryString(new String[]{"01", "10"}));
        new Subsets().newPermute("123");

        int i = 0;
    }

    public void newPermute(String str) {
        newPermuteHelper(str, str.length(), "");
    }

    public void newPermuteHelper(String str, int length, String current) {
        if(current.length() == length) {
            System.out.println(current);
            return;
        }

        for(int i = 0; i < str.length(); i++) {
            //if(!current.contains("" + str.charAt(i)))
                newPermuteHelper(str.substring(0, i) + str.substring(i+1), length, current + str.charAt(i));
        }
    }

    public String findDifferentBinaryString(String[] nums) {
//        Create a function generate(curr):
//        If curr.length = n:
//        If curr is not in numsSet, return curr.
//                Return an empty string.
//                Set addZero = generate(curr + "0").
//                If addZero is not an empty string, return it.
//                Return generate(curr + "1").
//                Set n = nums.length.
//                Convert nums to a hash set numsSet.
//        Return generate("").

        Set<String> strings = new HashSet<>();
        strings.addAll(Arrays.asList(nums));
        return generate("", nums[0].length(), strings);
    }

    private String generate(String str, int n, Set<String> set) {
        if(str.length() == n) {
            return set.contains(str) ? "" : str;
        }

        String addZero = generate(str + "0", n, set);

        if(addZero != "") {
            return addZero;
        }

        return generate(str + "1", n, set);
    }

    public void generatePermutations(String input) {
        permutationHelper(input, "", input.length());
    }

    public void permutationHelper(String str, String permute, int len) {
        if(permute.length() == len) {
            System.out.println(">>>" + str + permute);
            return;
        }

        for(int i = 0; i < str.length(); i++) {
            permutationHelper(str.substring(0, i) + str.substring(i+1), permute + String.valueOf(str.charAt(i)), len);
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        ans = generateParenthesisHelper(n, 0, 0, "");
        return ans;
    }

    private List<String> generateParenthesisHelper(int length, int openN, int closeN, String str) {
        List<String> ans = new ArrayList<>();
        System.out.println(length + " " + openN + " " + closeN + " " + str);
        if(length == openN && closeN == length) {
            ans.add(str);
            return ans;
        }

        if(openN < length) {
           List<String> ans1 = generateParenthesisHelper(length, openN + 1, closeN, str + "(");
           ans.addAll(ans1);
        }
        if (closeN < openN) {
            List<String> ans2 = generateParenthesisHelper(length, openN, closeN + 1, str + ")");
            ans.addAll(ans2);
        }
        return ans;
    }

    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if(!digits.isEmpty())
            phoneHelper(ans, digits, 0, "");
        return ans;
    }

    private void phoneHelper (List<String> ans, String digits, int index, String currentString) {
        Map<String, String> stringStringMap = new HashMap<>();
        stringStringMap.put("2", "abc");
        stringStringMap.put("3", "def");
        stringStringMap.put("4", "ghi");
        stringStringMap.put("5", "jkl");
        stringStringMap.put("6", "mno");
        stringStringMap.put("7", "pqrs");
        stringStringMap.put("8", "tuv");
        stringStringMap.put("9", "wxyz");

        if(currentString.length() == digits.length()) {
            ans.add(currentString);
            return;
        }

        String str = stringStringMap.get(String.valueOf(digits.charAt(index)));

        for(int i = 0; i < str.length(); i ++) {
            System.out.println(ans + " " + (index + 1) + " " + currentString + " " + str.charAt(i));
            phoneHelper(ans, digits, index + 1, currentString + str.charAt(i));
        }
    }

    private String helper(String val, int[] nums) {
        for (int j : nums) {
            val += "," + j;
        }

        return val;
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        //function(ans, nums, 0);
        List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
        System.out.println(function2(list));
        return ans;
    }

    public List<List<Integer>> function2(List<Integer> copy) {
        List<List<Integer>> ans = new ArrayList<>();
        if(copy.size() == 1) {
            List<Integer> list = new ArrayList<>();
            list.add(copy.get(0));
            List<List<Integer>> list2 = new ArrayList<>();
            list2.add(list);
            return list2;
        }

        for(int i = 0 ; i < copy.size(); i++) {
            int j = copy.remove(0);

            List<List<Integer>> perms = function2(new ArrayList<>(copy));

            for(List<Integer> integerList : perms) {
                integerList.add(j);
            }
//            System.out.println(perms + " " + j);
            ans.addAll(perms);
            copy.add(j);
        }
        return ans;
    }

    public void function(List<List<Integer>> ans, int[] arr, int start) {
        if (start == arr.length) {
            List<Integer> list = new ArrayList();
            for (int i = 0; i < arr.length; i++) list.add(arr[i]);
            ans.add(list);
            return;
        }

        for (int i = start; i < arr.length; i++) {
            swap(arr, start, i);
            function(ans, arr, start + 1);
            swap(arr, start, i);
        }
    }

    public void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        helper(ans, 0, nums, list);
        return ans;
    }

    public void helper(List<List<Integer>> ans, int start, int[] nums, List<Integer> list) {
        System.out.println(ans + " " + start  + " " + list);
        if (start >= nums.length) {
            ans.add(new ArrayList<>(list));
        } else {
            list.add(nums[start]);
            helper(ans, start + 1, nums, list);
            list.remove(list.size() - 1);
            helper(ans, start + 1, nums, list);
        }
    }

    public List<List<Integer>> subsets2(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        helper2(ans, 0, nums, list);
        return ans;
    }

    public void helper2(List<List<Integer>> ans, int start, int[] nums, List<Integer> list) {
        System.out.println(ans + " " + start  + " " + list);
        if (start >= nums.length) {
            ans.add(new ArrayList<>(list));
        } else {
            list.add(nums[start]);
            helper2(ans, start + 1, nums, list);
            list.remove(list.size() - 1);

            while(start + 1 < nums.length && nums[start] == nums[start+1]) {
                start += 1;
            }

            helper2(ans, start + 1, nums, list);
        }
    }
}
