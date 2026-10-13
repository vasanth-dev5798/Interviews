package com.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Java21Features {

	public static void main(String[] args) {

		List<String> list = new ArrayList<>();

		list.add("four");
		list.add("two");

		list.addFirst("three");
		list.addLast("one");

		System.out.println(list.reversed());
		System.out.println(list.getFirst());

		System.out.println(list.getLast());

		Object obj = "0";

		switch (obj) {
			case String s:
				System.out.println("It is s string");
				break;
			case Integer n:
				System.out.println("It is a number");
				break;
			default:
				System.out.println("Unknown");
				break;
		}

		String name = "Vasanth";

		System.out.println(System.getProperty("java.version"));

		String[] arr = { "V1", "V4", "V7" };

		String s = arr[0].replaceAll("\\d+", "");

		Set<Integer> intSet = Arrays.stream(arr).map(i -> Integer.parseInt(i.replaceAll("\\D+", "")))
				.collect(Collectors.toSet());

		int min = Collections.min(intSet);
		int max = Collections.max(intSet);

		List<String> result = IntStream.rangeClosed(min, max).filter(n -> !intSet.contains(n))
				.mapToObj(n -> s + n).collect(Collectors.toList());
		
		System.out.println(result);

		int n = 5;

		int fn = IntStream.rangeClosed(1, n).reduce(1,(a,b)->a*b);

		System.out.println(fn);
	}

}
