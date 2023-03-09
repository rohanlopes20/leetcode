package com.leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class BuySellStock {
    public static void main(String[] args) {
//        System.out.println(new BuySellStock().maxProfit(new int[]{7,1,5,3,6,4}));
//        System.out.println(new BuySellStock().maxProfit(new int[]{7,6,4,3,1}));
//        System.out.println(new BuySellStock().maxProfit(new int[]{2,4,1}));
//        System.out.println(new BuySellStock().countOdds(3, 7));
//        System.out.println(new BuySellStock().countOdds(8, 10));
//        System.out.println(new BuySellStock().addToArrayForm(new int[]{1, 2,0,0}, 34));
//        System.out.println(new BuySellStock().addToArrayForm(new int[]{9,9,9,9,9,9,9,9,9,9}, 1));
//        System.out.println(new BuySellStock().addToArrayForm(new int[]{1,2,6,3,0,7,1,7,1,9,7,5,6,6,4,4,0,0,6,3}, 516));
//        System.out.println(new BuySellStock().addToArrayForm(new int[]{0}, 10000));
//        System.out.println(new BuySellStock().firstBadVersion(2126753390));
//        System.out.println(new BuySellStock().minMaxDifference(11891));
//        System.out.println(new BuySellStock().singleNonDuplicate(new int[]{1,1,2,3,3,4,4,8, 8}));
//        System.out.println(new BuySellStock().maximumDifference(new int[]{87,68,91,86,58,63,43,98,6,40}));
//        System.out.println(Arrays.toString(new BuySellStock().plusOne(new int[]{1, 2, 4})));
//        System.out.println(Arrays.toString(new BuySellStock().plusOne(new int[]{1, 9})));
//        System.out.println(Arrays.toString(new BuySellStock().plusOne(new int[]{9, 9})));
//        System.out.println((new BuySellStock().convertToTitle(28)));
//        System.out.println((new BuySellStock().shiftGrid(new int[][]{{1,2,3},{4,5,6},{7,8,9}}, 1)));
//        System.out.println((new BuySellStock().arrangeCoins(5)));
        System.out.println(Arrays.toString(new BuySellStock().productExceptSelf(new int[]{1,2,3,4})));
    }

    public int[] productExceptSelf(int[] nums) {
        int[] productArray = new int[nums.length];
        int[] leftProduct   = new int[nums.length];
        int[] rightProduct  = new int[nums.length];
        Arrays.fill(leftProduct, 1);
        Arrays.fill(rightProduct, 1);

        for(int i = 1; i < nums.length; i++) {
            leftProduct[i] = leftProduct[i-1]*nums[i-1];
        }

        for(int i = nums.length-2; i >= 0; i--) {
            rightProduct[i] = rightProduct[i+1]*nums[i+1];
        }

        for(int i = 0; i < nums.length; i++) {
            productArray[i] = leftProduct[i]*rightProduct[i];
        }

        return productArray;
    }

    public int arrangeCoins(int n) {
        int counter = 0;

        while(n !=0) {
            if(counter <= n && n-(counter+1) >= 0) {
                counter+=1;
            } else  {
                return counter;
            }

            n-=counter;
        }

        return counter;
    }

    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        List<List<Integer>> list = new ArrayList<>();

        List<Integer> list2 = new ArrayList<>();
        List<Integer> list3 = new ArrayList<>();

        for(int row = 0; row < grid.length; row++) {
            for(int col = 0; col < grid[row].length; col++) {
                list2.add(grid[row][col]);
            }
        }

        for(int i = 0; i < list2.size(); i++) {
            list3.add(newValue(list2, i, k));
        }

        for(int i = 0; i < list3.size(); i++) {
            list2.set(list3.get(i), list3.get(i));
        }

        System.out.println(list2);
        System.out.println(list3);

        return list;
    }

    private Integer newValue(List<Integer> list, int index, int k) {
        int newPos = ((index + k) < list.size()) ? index + k : index + k - list.size() ;

        return newPos;
    }

    public String convertToTitle(int columnNumber) {
        String[] charMap = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};

        int column1 = columnNumber%26;
        int column2 = columnNumber/26;

        return (columnNumber > 26) ? charMap[column2 - 1] + "" + charMap[column1 - 1] : charMap[columnNumber - 1] ;
    }

    public int[] plusOne(int[] digits) {
        List<Integer> list = new ArrayList<>();
        int sum = 1;

        for(int i = digits.length - 1; i >=0 ; i--) {
            sum = sum + digits[i];
            int numToAdd = sum % 10 ;
            sum = sum / 10;
            list.add(numToAdd);
        }

        if(sum != 0) {
            list.add(sum);
        }

        Collections.reverse(list);

        return list.stream().mapToInt(i -> i).toArray();
    }

    public int maximumDifference(int[] nums) {
        int maximumDifference = -1;

        int L = 0, R = 1;

        while(R < nums.length) {
            if(nums[R] > nums [L]) {
                System.out.println(maximumDifference);
                maximumDifference = Math.max(maximumDifference, nums[R] - nums [L]);
                R++;
            } else {
                L = R;
                R++;
            }
        }


        return maximumDifference;
    }

    public int singleNonDuplicate(int[] nums) {
        int ans = nums[0];
        int counter = 0;

        while (counter < nums.length-1) {
            int first = nums[counter];
            int second = nums[counter+1];

            if(first == second) {
                counter++;
                counter++;
            } else {
                return first;
            }
        }

        return (counter > 0) ? nums[nums.length-1] : ans;
    }

    public int minMaxDifference(int num) {
        String maxNum = String.valueOf(num);
        String minNum = String.valueOf(num);

        for(int i = 0; i < maxNum.length(); i++) {
            if(maxNum.charAt(i) != '9') {
                maxNum = maxNum.replaceAll(String.valueOf(maxNum.charAt(i)), "9");
                break;
            }
        }

        for(int i = 0; i < minNum.length(); i++) {
            if(minNum.charAt(i) != '0') {
                minNum = minNum.replaceAll(String.valueOf(minNum.charAt(i)), "0");
                break;
            }
        }

        return Integer.parseInt(maxNum.toString()) - Integer.parseInt(minNum.toString());
    }

    public boolean isBadVersion(long n) {
        return n>= 1702766719;
    }
    public long firstBadVersion(int n) {
        long min = 1;
        long max = n;
        long mid = (max+min)/2;

        long bad = mid;

        //1 2(bad) 3 4 5
        //mid = 3

        while(min <= max) {
            mid = (max+min)/2;

            if(isBadVersion(mid)) {
                bad = mid;
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return bad;
    }

    public List<Integer> addToArrayForm(int[] digits, int k) {
        List<Integer> list = new ArrayList<>();
        int sum = k;

        for(int i = digits.length - 1; i >=0 ; i--) {
            sum = sum + digits[i];
            int numToAdd = sum % 10 ;
            sum = sum / 10;
            list.add(numToAdd);
        }

        while (sum != 0) {
            int num = sum%10;
            sum=sum/10;
            list.add(num);
        }

        Collections.reverse(list);

        return list;
    }
    public int countOdds(int low, int high) {
        int count = 0;
        //3,7 7-3   = 4/2 = 2+1
        //8,10 10-8 = 2/2 = 1
        //8,11 11-8 = 3/2 = 1+1

        count = (high - low) / 2;

        if(low % 2 != 0 || high % 2 != 0) {
            count++;
        }

        return count;
    }

    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int l = 0, r = 1;

        while (r < prices.length) {
            if(prices[l] < prices[r]) {
                maxProfit = Math.max(maxProfit, prices[r] - prices[l]);
                r++;
            } else {
                l = r;
                r++;
            }
        }

        return maxProfit;
    }
}
