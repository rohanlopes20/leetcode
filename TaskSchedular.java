package com.leetcode;

import com.sun.jmx.remote.internal.ArrayQueue;
import javafx.util.Pair;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.counting;

public class TaskSchedular {
	public static void main(String[] args) {
		System.out.println(new TaskSchedular().leastInterval(new char[]{'A','A','A','B','B','B'}, 2));
	}

	public int leastInterval(char[] tasks, int n) {
		int counter = 0;
		Map<Character, Long> counterMap = IntStream
				.range(0, tasks.length)
				.mapToObj(i -> tasks[i])
				.collect(Collectors.groupingBy(Function.identity(), counting()));

		PriorityQueue<Pair<Character, Integer>> list = new PriorityQueue<>((a, b) -> Integer.compare(b.getValue(), a.getValue()));
		counterMap.forEach((k,v) -> list.add(new Pair<>(k, v.intValue())));
		List<Pair<Character, Pair<Integer, Integer>>> queue = new ArrayList<>();

		while (!list.isEmpty() || !queue.isEmpty()) {
			counter++;
			System.out.println(counter);
			if(!list.isEmpty()) {
				Pair<Character, Integer> pair = list.poll();

				if(pair.getValue() > 1) {
					queue.add(new Pair<>(pair.getKey(), new Pair<>(pair.getValue() - 1, counter + n)));
				}
			}
			if(!queue.isEmpty() && queue.get(0).getValue().getValue() <= counter) {
				Pair<Character, Pair<Integer, Integer>> pair = queue.remove(0);
				if(pair.getValue().getKey() > 1)
					list.add(new Pair<>(pair.getKey(), pair.getValue().getKey()));

//				Pair<Character, Integer> pair2 = list.poll();
//
//				if(pair2 != null && pair2.getValue() > 1) {
//					queue.add(new Pair<>(pair2.getKey(), new Pair<>(pair2.getValue() - 1, counter + n)));
//				}
			}
		}

		return counter;
	}
}
