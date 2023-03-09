package com.leetcode;

import java.util.*;

public class SortArray {
	public static void main(String[] args) {
//		System.out.println(Arrays.toString(new SortArray().sortArray(new int[]{5,2,3,1})));
//		System.out.println(new SortArray().compress(new char[]{'a','b','b','b','b','b','b','b','b','b','b','b','b'}));
//		System.out.println(new SortArray().sort(new int[][]{{0,30},{5,10},{15,20}}));
		System.out.println(new SortArray().findKthPositive(new int[]{2,3,4,7,11}, 5));
	}

	public int findKthPositive(int[] arr, int k) {
		List<Integer> list = new ArrayList<>();
		int arrayCounter = 0;
		int missingCounter = 1;

		while(missingCounter < arr.length + k) {
			if(arrayCounter>= arr.length || arr[arrayCounter] != missingCounter) {
				list.add(missingCounter);
				missingCounter++;
			} else {
				missingCounter++;
				arrayCounter++;
			}
		}
		System.out.println(list);

		return list.get(k-1);
	}

	public boolean sort(int[][] input) {
		Arrays.sort(input, Comparator.comparingInt(a -> a[1]));
		System.out.println(Arrays.deepToString(input));

		for(int i = 1; i < input.length; i++) {
			int prev[] 		= input[i-1];
			int current[] 	= input[i];

			if(prev[1] > current[0]) {
				return true;
			}
		}

		return false;
	}

	public int compress(char[] chars) {
		if(chars.length == 0) {
			return 0;
		}

		int count = 1;
		Stack<Character> prevChar = new Stack<>();
		StringBuilder stringBuilder = new StringBuilder();

		for(int i = 0; i < chars.length; i++) {
			if(!prevChar.isEmpty() && prevChar.peek() == chars[i]) {
				count++;
			} else {
				if(prevChar.isEmpty()) {
					prevChar.push(chars[i]);
				} else {
					if(count > 1) {
						stringBuilder.append(prevChar.pop() + "" + count);
					} else {
						stringBuilder.append(prevChar.pop());
						prevChar.push(chars[i]);
					}
					count = 1;
				}
			}
			if(i == chars.length - 1) {
				if(count > 1) {
					stringBuilder.append(prevChar.pop() + "" + count);
				} else {
					stringBuilder.append(prevChar.pop());
				}
			}
		}
		System.out.println(stringBuilder);
		return stringBuilder.toString().length();
	}

	public int[] sortArray(int[] nums) {
		if(nums.length == 1) {
			return nums;
		}

		int mid = nums.length/2;
		int [] leftHalf = sortArray(getHalf(nums, 0, mid));
		int [] rightHalf = sortArray(getHalf(nums, mid, nums.length - mid));

		int[] mergeArray = mergeArrays(leftHalf, rightHalf);

		return mergeArray;
	}

	private int[] getHalf(int[] array, int startPos, int size) {
		int[] out = new int[size];

		int i = 0;
		while(i != size) {
			out[i] = array[startPos];
			startPos++;
			i++;
		}

		return out;
	}

	private int[] mergeArrays(int[] leftHalf, int[] rightHalf) {
		int[] mergedArray = new int[leftHalf.length + rightHalf.length];

		int i = 0;
		int j = 0;
		int total = 0;

		while(i != leftHalf.length &&  j != rightHalf.length) {
			if(leftHalf[i] < rightHalf[j]) {
				mergedArray[total] = leftHalf[i];
				i++;
			} else {
				mergedArray[total] = rightHalf[j];
				j++;
			}
			total++;
		}

		while(i < leftHalf.length) {
			mergedArray[total] = leftHalf[i];
			i++;
			total++;
		}

		while(j < rightHalf.length) {
			mergedArray[total] = rightHalf[j];
			j++;
			total++;
		}

		return mergedArray;
	}
}
