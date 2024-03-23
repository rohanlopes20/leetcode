package com.leetcode;

import javafx.util.Pair;
import org.apache.commons.chain.web.MapEntry;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class Test {
	public static void main(String[] args) {
		FunctionTest functionTest = x -> x+1;
//		System.out.println(functionTest.add(123));

		BiFunction<Integer,Integer, Integer> biFunction = (x, y) -> x+y;
//		System.out.println(biFunction.apply(1,2));
//		System.out.println(biFunction.apply(1,2));

		Consumer<Integer> integerConsumer = System.out::println;
//		integerConsumer.accept(123);
		Comparator<Integer> comparator = (x, y) -> y.compareTo(x);

		Integer[] data = new Integer[]{4,35,5,1,2};
		Arrays.sort(data, comparator);
//		System.out.println(Arrays.toString(data));

		Deque<Integer> integers = new ArrayDeque<>();
		integers.add(1);
		integers.add(2);
		integers.add(3);
		integers.add(4);
//		System.out.println(integers);
		integers.removeFirst();
//		System.out.println(integers);
//		System.out.println(Arrays.toString(new Test().maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3)));
//		System.out.println(new Test().convertToTitle(1000));
//		System.out.println(new Test().rearrangeStr("aaab"));
//		System.out.println(new Test().findLongestChain(new int[][]{{1,2},{2,3},{3,4}}));
//		System.out.println(new Test().findLongestChain(new int[][]{{1,2},{7,8},{4,5}}));
//		System.out.println(new Test().findLongestChain(new int[][]{{-6,9},{1,6},{8,10},{-1,4},{-6,-2},{-9,8},{-5,3},{0,3}}));
//		System.out.println(new Test().bestClosingTime("YYNY"));
//
//		System.out.println(String.join(" | ", new ArrayList<String>()));
//		System.out.println(new Test().groupThePeople(new int[]{3,3,3,3,3,1,3}));
//		System.out.println(new Test().minDeletions("aaabbbcc"));
//		System.out.println(new Test().kWeakestRows(new int[][]{{1,1,1,0},
//							 {1,1,1,1},
//							 {1,0,0,0},
//							 {1,0,0,0}}, 3 ));
//		System.out.println(new Test().minOperations(new int[]{3,2,20,1,1,3}, 10));
//		System.out.println(new Test().longestStrChain(new String[]{"a","b","ba","bca","bda","bdca"}));
//		System.out.println(new Test().longestStrChain(new String[]{"xbc","pcxbcf","xb","cxbc","pcxbc"}));
//		System.out.println(new Test().champagneTower(1, 1, 1));
//		System.out.println(new Test().champagneTower(2, 1, 1));
//		System.out.println(new Test().champagneTower(100000009, 33, 17));
//		new Test().pascalTriangle(1000);
		//		int[] nums = new int[] {3,1,2,4};
//		Arrays.sort(nums, (a, b) -> (((int)a%2 == 0) ? 1 : -1) -  (((int)b%2 == 0) ? 1 : -1) );
//		nums = Arrays.stream(nums).boxed().sorted((a, b) -> ((b%2 == 0) ? 1 : -1) -  ((a%2 == 0) ? 1 : -1)).mapToInt(i->i).toArray();
//		System.out.println(Arrays.toString(nums));
//		int[] nums2 = new int[] {4,1,2,3};

//		System.out.println(new Test().longestConsecutive(new int[]{100,4,200,1,3,2}));
//		System.out.println(Arrays.toString(new Test().searchRange(new int[]{5,7,7,8,8,10}, 8)));

		System.out.println(Math.pow(4, 2));

		List<List<Integer>> listPerRow = new ArrayList<>();
		List<Integer> ans = new ArrayList<>();


	}

	public int[] searchRange(int[] nums, int target) {
		int[] output = new int[2];
		Arrays.fill(output, -1);

		return output;
	}

	public int longestConsecutive(int[] nums) {
		int longest = 0;
		Set<Integer> integers = Arrays.stream(nums).boxed().collect(Collectors.toSet());

		for(int num : nums) {
			if(!integers.contains(num - 1)) {
				int currentLong = 1;
				int index = 1;
				while (integers.contains(num + index)) {
					currentLong++;
					index++;
				}
				longest = Math.max(currentLong, longest);
			}
		}

		return longest;
	}

	public void pascalTriangle(int num) {
		List<List<Integer>> list = new ArrayList<>();
		list.add(new ArrayList<>());
		list.get(0).add(1);

		for(int i = 1; i < num; i++) {
			List<Integer> integers = new ArrayList<>();
			list.add(integers);
			integers.add(list.get(i-1).get(0));
			for(int j = 1; j < i ; j++) {
				int val = list.get(i-1).get(j) + list.get(i-1).get(j-1);
				integers.add(val);
			}
			integers.add(list.get(i-1).get(list.get(i-1).size()-1));
			System.out.println(integers);
		}

		System.out.println(list);
	}


	public double champagneTower(int poured, int query_row, int query_glass) {
		double[][] triangle = new double[query_row + 1][query_glass + 2];
		triangle[0][0] = poured;

		for (int i = 0; i < query_row; i++) {
			for (int j = 0; j <= query_glass; j++) {
				double rest = Math.max(triangle[i][j] - 1.0, 0);
				triangle[i+1][j] += rest / 2.0;
				triangle[i+1][j+1] += rest / 2.0;
			}
		}

		return Math.min(triangle[query_row][query_glass], 1.0);
	}

	public int longestStrChain(String[] words) {
		int max = 1;

		Arrays.sort(words, Comparator.comparing(String::length));

		String prev = words[words.length - 1];

		for(int i = words.length - 2; i >=0; i--) {
			String currentWord = words[i];
			StringBuffer stringBuffer = new StringBuffer();
			int k = 0;
			int del = 0;
			for (int j = 0; j < currentWord.length(); j++) {
				while (k < prev.length() && prev.charAt(k) != currentWord.charAt(j)) {
					k++;
					del++;
				}
				if(k < prev.length() && prev.charAt(k) == currentWord.charAt(j)) {
					stringBuffer.append(currentWord.charAt(j));
					k++;
				}
			}
			System.out.println(stringBuffer);
			if(del <= 1 && stringBuffer.length() > 0) {
				prev = stringBuffer.toString();
				max++;
			}
		}

		System.out.println(Arrays.toString(words));
		return max;
	}

	public int minOperations(int[] nums, int x) {
		int ops = 0;
		int left = 0;
		int right = nums.length-1;
		int currentSum = 0;

		while (currentSum != x) {
			int leftSum  = currentSum + nums[left];
			int rightSum = currentSum + nums[right];

			if(leftSum <= x && rightSum <= leftSum) {
				currentSum = leftSum;
				ops++;
				left++;
			} else if(rightSum <= x && leftSum <= rightSum) {
				currentSum = rightSum;
				ops++;
				right--;
			} else {
				return -1;
			}
		}

		return ops;
	}

	public int[] kWeakestRows(int[][] mat, int k) {
		List<Pair<Integer, Integer>> integers = new ArrayList<>();

		for (int i = 0; i < mat.length; i++) {
			integers.add(new Pair<>(i, (int) Arrays.stream(mat[i]).filter(ii -> ii == 1).count()));
		}

		System.out.println(integers);

		Comparator one = Comparator.comparing(Pair<Integer, Integer>::getValue);
		Comparator two = Comparator.comparing(Pair<Integer, Integer>::getKey);

		Collections.sort(integers, one.thenComparing(two));

		return integers.stream().map(i->i.getKey()).mapToInt(i->i).limit(k).toArray();
	}

	public int minDeletions(String s) {
		int del = 0;

		PriorityQueue<Pair<Character, Integer>> pairs = new PriorityQueue<>(Comparator.comparingInt(Pair::getValue));
		Map<Character, Integer> map = new HashMap<>();

		for(int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);

			if(map.containsKey(ch)) {
				map.put(ch, map.get(ch)+1);
			} else {
				map.put(ch, 1);
			}
		}

		System.out.println(map);
		List<Integer> integers = new ArrayList<>(map.values());
		List<Integer> used = new ArrayList<>();
		Collections.sort(integers, Collections.reverseOrder());

		System.out.println(integers);
		int prev = integers.get(0);

		for(int i = 1; i < integers.size(); i++) {
			if(prev == integers.get(i)) {
				int val = integers.get(i);
				val --;
				while (integers.contains(val)) {
					del++;
				}
				used.add(val);
			}
		}

		return del;
	}

	public List<List<Integer>> groupThePeople(int[] groupSizes) {
		List<List<Integer>> list = new ArrayList<>();
		Map<Integer, List<Integer>> map = new HashMap<>();

		for(int i = 0; i < groupSizes.length; i++) {
			List<Integer> integers = map.get(groupSizes[i]) == null ? new ArrayList<>() : map.get(groupSizes[i]);
			integers.add(i);
			map.put(groupSizes[i], integers);
		}

		for(Map.Entry<Integer, List<Integer>> integerListMapEntry : map.entrySet()) {
			int count = 0;
			int key = integerListMapEntry.getKey();
			List<Integer> values = integerListMapEntry.getValue();
			List<Integer> curr = new ArrayList<>();

			for (Integer integer : values) {
				count++;
				curr.add(integer);

				if(count == key) {
					list.add(new ArrayList<>(curr));
					curr = new ArrayList<>();
					count = 0;
				}
			}
		}

		return list;
	}

	public int bestClosingTime(String customers) {
		Map<Integer, Integer> indexPenalty = new HashMap<>();
		int[] penalty = new int[customers.length() + 1];

		for(int i = 0; i < customers.length() + 1; i++) {
			penalty[i] = getCount(customers, i, indexPenalty);
		}

		int minIndex = 0;
		int currMin  = Integer.MAX_VALUE;

		for(int i = 0; i < penalty.length; i++) {
			currMin = Math.min(penalty[i], currMin);
		}

		for(int i = 0; i < penalty.length; i++) {
			if(penalty[i] == currMin) {
				minIndex = i;
				break;
			}
		}

		return minIndex;
	}

	private int getCount(String customers, int index, Map<Integer, Integer> indexPenalty) {
		int penalty = 0;

		for(int i = 0; i < customers.length(); i++) {
			if(customers.charAt(i) == 'Y' && (i >= index) ) {
				penalty += 1;
				continue;
			}
			if(customers.charAt(i) == 'N' && i < index) {
				penalty += 1;
			}
		}

		return penalty;
	}

	public int findLongestChain(int[][] pairs) {
		int ans = 0;
		Arrays.sort(pairs, (a,b) -> Integer.compare(a[1], b[1]));

		int[] arrPrev = pairs[0];

		for(int i = 1; i < pairs.length; i++) {
			if(arrPrev[1] < pairs[i][0]) {
				arrPrev = pairs[i];
				ans++;
			}
		}

		System.out.println(Arrays.deepToString(pairs));

		return ans + 1;
	}

	public String rearrangeStr(String str) {
		String s = "";
		Map<String, Integer> count = new HashMap<>();

		for(int i = 0; i < str.length(); i++) {
			if(count.get(String.valueOf(str.charAt(i))) != null) {
				count.put(String.valueOf(str.charAt(i)), count.get(String.valueOf(str.charAt(i))) + 1);
			} else {
				count.put(String.valueOf(str.charAt(i)),1);
			}
		}
		System.out.println(count);

		PriorityQueue<Pair<String, Integer>> pairs = new PriorityQueue<>((a , b) -> Integer.compare(b.getValue(),a.getValue()));

		for(Map.Entry<String, Integer> stringIntegerEntry : count.entrySet()) {
			pairs.add(new Pair<>(stringIntegerEntry.getKey(), stringIntegerEntry.getValue()));
		}

		for(int i = 0; i <= pairs.size(); i++) {
			//System.out.println(pairs.poll());
		}

		while(!pairs.isEmpty()) {
			Pair<String, Integer> pair = pairs.poll();
			Pair<String, Integer> pairBk = null;
			if(s.length() > 0 && String.valueOf(s.charAt(s.length()-1)).equals(pair.getKey())) {
				pairBk = new Pair<>(pair.getKey(), pair.getValue());
				pair = pairs.poll();
			}
			if(pair.getValue() > 0) {
				pairs.add(new Pair<>(pair.getKey(), pair.getValue() -1));
			}
			if(pairBk != null) {
				pairs.add(new Pair<>(pairBk.getKey(), pairBk.getValue()));
			}
			s += pair.getKey();
		}

//		for(int i = 1; i < str.length(); i++) {
//			if(s.charAt(i) == s.charAt( i - 1)) {
//				return "";
//			}
//		}

		return s;
	}

	public String convertToTitle(int columnNumber) {
		StringBuilder s = new StringBuilder();

		while (columnNumber > 0) {
			columnNumber -= 1;
			int column1 = columnNumber%26;
			s.append((char) ('A' + column1));
			columnNumber = columnNumber/26;
		}

		return s.reverse().toString();
	}


	public int[] maxSlidingWindow(int[] nums, int k) {
		Deque<Integer> integers = new ArrayDeque<>();
		List<Integer> list = new ArrayList<>();

		for(int num : nums) {
			integers.add(num);
			if(integers.size() == k) {
				int max = Collections.max(integers);
				list.add(max);
				integers.removeFirst();
			}
		}

		return list.stream().mapToInt(i->i).toArray();
	}

	interface FunctionTest {
		Integer add(Integer one);
	}
}
