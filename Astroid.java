package com.leetcode;

import java.util.*;

public class Astroid {
	public static void main(String[] args) {
//		System.out.println(Arrays.toString(new Astroid().asteroidCollision(new int[] {5,10,-5})));
//		System.out.println(Arrays.toString(new Astroid().asteroidCollision(new int[] {8,-8})));
//		System.out.println(Arrays.toString(new Astroid().asteroidCollision(new int[] {10,2,-5})));
//		System.out.println(new Astroid().PredictTheWinner(new int[] {1,5,2})); //false
		System.out.println(new Astroid().PredictTheWinner(new int[] {1,5,233,7})); //true
	}

	public boolean PredictTheWinner(int[] nums) {
		int left = 0;
		int right = nums.length-1;
		int player1Sum = 0;
		int player2Sum = 0;
		boolean player1Selection = true;

		while (left < right) {
			int leftNo 	= nums[left];
			int rightNo = nums[right];

			if(player1Selection) {
				player1Sum += Math.max(leftNo, rightNo);
				player1Selection = false;
			} else {
				player2Sum += Math.max(leftNo, rightNo);
				player1Selection = true;
			}
			if(leftNo > rightNo) {
				left++;
			} else {
				right--;
			}
		}

		return player1Sum == player2Sum || player1Sum > player2Sum;
	}

	public int[] asteroidCollision(int[] asteroids) {
		Stack<Integer> integers = new Stack<>();
		int index = 0;

		while (index != asteroids.length) {
			int current = asteroids[index];
			if(integers.isEmpty()) {
				integers.push(current);
				index++;
				continue;
			}
			boolean checkIfValid = false;
			while (!checkIfValid && !integers.isEmpty()) {
				int stackPeek = integers.peek();
				if (stackPeek > 0 && current < 0 || stackPeek < 0 && current > 0) {
					stackPeek = integers.pop();

					if (Math.abs(stackPeek) > Math.abs(current)) {
						integers.push(stackPeek);
					} else if (Math.abs(stackPeek) < Math.abs(current)) {
						integers.push(current);
					} else {
						//do nothing
					}
				} else {
					integers.push(current);
					checkIfValid = true;
				}
				index++;
			}
		}

		return integers.stream().mapToInt(i->i).toArray();
	}
}
