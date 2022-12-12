package com.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class StrStr {
    public static void main(String[] args) {

        StrStr strStr = new StrStr();
//        System.out.println(strStr.strStr2("ROHANPHILIPLOPES", "LOPESW"));
//        System.out.println(strStr.checkIfPangram("thequickbrownfoxjumpsoverthelazydog"));
//        System.out.println(strStr.findMaxK(new int [] {-10,8,6,7,-2,-3}));
//        System.out.println(strStr.countDistinctIntegers(new int [] {1,13,10,12,31}));
//        System.out.println(strStr.sumOfNumberAndReverse(0));
//        System.out.println(strStr.countAndSay(4));
//        System.out.println(strStr.say("223314444411"));
//        System.out.println(strStr.print(strStr.say("223314444411")));
        System.out.println(strStr.countTime("?5:00"));
        System.out.println(strStr.longestPalindrome("ccc"));
    }

    public int longestPalindrome(String s) {
        int count = 0;

        Map<String, Integer> mp = new HashMap<>();

        for(int i = 0; i < s.length(); i++) {
            if(mp.containsKey(String.valueOf(s.charAt(i)))) {
                mp.put(String.valueOf(s.charAt(i)), mp.get(String.valueOf(s.charAt(i)))+1);
            } else {
                mp.put(String.valueOf(s.charAt(i)), 1);
            }
        }

        //if even size of map then only even can be taken + 1
        boolean addOne = false;
        for(Map.Entry<String, Integer> entry : mp.entrySet()) {
            if(entry.getValue() % 2 == 0) {
                count += entry.getValue();
            } else {
                count += entry.getValue() - 1;
                addOne = true;
            }
        }

        return count + ((addOne) ? 1 : 0);
    }

    public int countTime(String time) {
        int count = 0;

        String hr = time.split(":")[0];
        String min = time.split(":")[1];

//        if() {
//
//        }

        return count;
    }

    public String countAndSay(int n) {
        StringBuilder stringBuffer = new StringBuilder();

        if(n == 1) { return "1"; }

        if(n == 2) { return "11"; }

        for(int i = 1; i < n - 1; i++) {
            int [][] countArray = say(String.valueOf(i));
            String s = print(countArray);
            System.out.println(s);
            stringBuffer.append(s);
        }

        return stringBuffer.toString();
    }

    private String print(int [][] countArray) {
        StringBuilder stringBuffer = new StringBuilder();

        for(int i = 0; i < countArray.length; i++) {
            if(countArray[i][0] != 0)
                stringBuffer.append(countArray[i][0]);
            stringBuffer.append(countArray[i][1]);
        }

        return stringBuffer.toString();
    }

    private int [][] say(String n) {
        String prev = "";
        int count = 0;

        for(int i = 0 ; i < n.length(); i++) {
            String s = String.valueOf(n.charAt(i));
            if(!s.equals(prev)) {
                prev = s;
               count++;
            }
        }

        int [][] countArray = new int[count][2];
        int arrayIndex = -1;
        count = 1;
        prev = "";

        for(int i = 0 ; i < n.length() ; i++) {
            String s = String.valueOf(n.charAt(i));

            if(!s.equals(prev)) {
                arrayIndex++;
                countArray[arrayIndex][0] = Integer.parseInt(s);
                countArray[arrayIndex][1] = 1;
                count = 1;
                prev = s;
            } else {
                count++;
                countArray[arrayIndex][1] = count;
            }
        }

        return countArray;
    }

    public boolean sumOfNumberAndReverse(int num) {

        for(int i = 0; i < num; i++) {
            if(i + reverse(i) == num) {
                return true;
            }
        }

        return false;
    }

    public int countDistinctIntegers(int[] nums) {
        int joinArray[] = new int[nums.length*2];

        for(int i = 0; i < nums.length; i++) {
            joinArray[i] = nums[i];
        }

        for(int i = nums.length; i < joinArray.length; i++) {
            joinArray[i] = reverse(joinArray[i - nums.length]);
        }

        return (int) Arrays.stream(joinArray).distinct().count();
    }

    private int reverse(int n) {
        int rev = 0;

        while (n != 0) {
            rev = rev*10 + n % 10;
            n = n/10;
        }

        return rev;
    }

    public int findMaxK(int[] nums) {
        Arrays.sort(nums);

        int l = 0;
        int h = nums.length-1;

        while(l < h) {
            if(nums[l] < 0 && nums[h] > 0 && Math.abs(nums[l]) == Math.abs(nums[h])) {
                return nums[h];
            } if(nums[l] < 0 && Math.abs(nums[l]) <  Math.abs(nums[h])) {
                h--;
            } else {
                l++;
            }
        }

        return -1;
    }

    public boolean checkIfPangram(String sentence) {
        int[] chars = new int[26];

        sentence.chars().forEach( i -> chars[i-97] = 1);

        return Arrays.stream(chars).distinct().count() == 1;
    }

    private int strStr(String data, String searchStr) {
        for (int i = 0; ; i++) {
            for (int j = 0; ; j++) {
                if (j == searchStr.length()) return i;
                if (i + j == data.length()) return -1;
                if (searchStr.charAt(j) != data.charAt(i + j)) break;
            }
        }
    }

    private int strStr2(String data, String searchStr) {

        for(int i = 0; i < data.length(); i++) {
            if(searchStr.length() + i > data.length()) {
                return -1;
            }
            if(searchStr.equals(data.substring(i, i + searchStr.length()))) {
                return i;
            }
        }

        return -1;
    }
}
