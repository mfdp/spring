package com.java8;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ForkJoinPool;

public class ConcurrentMapTest {

	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<>();
		map.putIfAbsent("A", 1);
		map.putIfAbsent("B", -2);
		map.putIfAbsent("C", -2);
		map.putIfAbsent("D", 22);
		map.putIfAbsent("E", -32);
		map.putIfAbsent("F", 12);
		map.putIfAbsent("G", 332);

		map.forEach((key, value) -> {
			System.out.println(key + "-" + value);
		});

		System.out.println(map.getOrDefault("C", 666));

		map.replaceAll((key, value) -> value < 0 ? -1 * value : value);

		map.forEach((key, value) -> {
			System.out.println(key + "-" + value);
		});

		map.compute("C", (key, value) -> value > 0 ? -1 * value : value);

		map.forEach((key, value) -> {
			System.out.println(key + "-" + value);
		});

		map.merge("D", 666666, (oldVal, newVal) -> oldVal + newVal);
		map.merge("D", 666666, (oldVal, newVal) -> oldVal + newVal);


		System.out.println(ForkJoinPool.getCommonPoolParallelism());  // 3

		ConcurrentHashMap<String, String> map2 = new ConcurrentHashMap<>();
		map2.put("foo", "bar");
		map2.put("han", "solo");
		map2.put("r2", "d2");
		map2.put("c3", "p0");


		String result = map2.reduce(1,
			(key, value) -> {
				System.out.println("Transform: " + Thread.currentThread().getName());
				return key + "=" + value;
			},
			(s1, s2) -> {
				System.out.println("Reduce: " + Thread.currentThread().getName());
				return s1 + ", " + s2;
			});

		String result2 = map2.reduce(1, (key, value) -> "[" + key + "]" + value, (e1, e2) -> e1 + "," + e2);
		String result3 = map2.reduceValues(1, (value) -> value.toUpperCase(), (e1, e2) -> e1 + "," + e2);
		int resultInt = map2.reduceToInt(1, (key, value) -> key.length(), 0, (e1, e2) -> e1 + e2);

	}

}
