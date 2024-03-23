package com.leetcode;

public class ATOI {

	public static void main(String[] args) {
		System.out.println(new ATOI().myAtoi("-123123"));
	}

	public int myAtoi(String s) {
		int ans = 0;
		int n = s.length();
		int i = 0;
		int sign = 1;

		s = s.trim();

		if(s.charAt(i) == '-') {
			sign = -1;
			i++;
		}
		while(i < n && !Character.isDigit(s.charAt(i))) i++;

		while(i < n && Character.isDigit(s.charAt(i))) {
			ans = ans * 10 + Character.getNumericValue(s.charAt(i));
			i++;
		}

		return ans * sign;
	}
}
