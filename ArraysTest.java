package com.leetcode;

import java.util.Arrays;

public class ArraysTest {
	public static void main(String[] args) {
		int[] arr = new int[] {1,2,3,4,5,6,7,8,9,10};

		//
		System.out.println(Arrays.toString(shiftBySize(1, arr.clone(), true)));
		System.out.println(Arrays.toString(shiftBySize(1, arr.clone(), false)));
	}

	private static int[] shiftBySize(int stepSize, int[] arr, boolean direction) {
		int arrNew[] = new int[arr.length];

		for(int i = 0; i < arr.length; i++) {
			arrNew[i] = arr[getIndex(direction, arr.length, stepSize, i)];
		}

		return arrNew;
	}

	private static int getIndex(boolean direction, int size, int stepSize, int currentIndex) {
		return Math.abs(direction ?
				(size + currentIndex + stepSize) % size
			 :  (size + currentIndex - stepSize) % size);
	}
}
