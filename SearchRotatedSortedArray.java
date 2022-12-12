package com.leetcode;

public class SearchRotatedSortedArray {
    public static void main(String[] args) {

//        System.out.println(new SearchRotatedSortedArray().search(new int[] {4,5,6,7,0,1,2}, 0));
//        System.out.println(new SearchRotatedSortedArray().search(new int[] {4,5,6,7,0,1,2}, 3));
//        System.out.println(new SearchRotatedSortedArray().search(new int[] {1}, 0));
//        System.out.println(new SearchRotatedSortedArray().search(new int[] {1}, 1));
//        System.out.println(new SearchRotatedSortedArray().findMin(new int[] {4,5,6,7,0,1,2}));
//        System.out.println(new SearchRotatedSortedArray().findMin(new int[] {11,13,15,17}));
        System.out.println(new SearchRotatedSortedArray().findMin(new int[] {5,1,2,3,4}));
//        System.out.println(new SearchRotatedSortedArray().findMin(new int[] {1,2,3,4}));
    }

    public int search(int[] nums, int target) {
        int l = 0;
        int r  = nums.length-1;

        while (l <= r) {
            int mid = (l+r)/2;

            if(nums[mid] == target) {
                return mid;
            }

            if(nums[l] <= nums[mid]) {
                if (target > nums[mid] || target < nums[l]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            } else {
                if (target < nums[mid] || target > nums[r]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
        }

        return -1;
    }

    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        int res = nums[low];

        while (low <= high) {
            if(nums[low] < nums[high]) {
                res = Math.min(res, nums[low]);
                break;
            }

            int mid = (low+high)/2;
            res = Math.min(res, nums[mid]);

            if(nums[mid] >= nums[low]) {
                //search right
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return res;
    }
}
