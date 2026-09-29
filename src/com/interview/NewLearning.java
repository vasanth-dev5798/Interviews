package com.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NewLearning {

	public static void main(String[] args) {

		int[] intArr = { 5, 8, 9, 5, 4, 0, 7, 0, 4, 3, 2, 5, 1 };

		System.out.println("Unique elements : ");

		Arrays.stream(intArr).distinct().forEach(i -> System.out.print(i + " "));

		System.out.println();

		System.out.println("Max number : ");

		Arrays.stream(intArr).max().ifPresent(System.out::print);// -min

		System.out.println();

		System.out.println("Second max : ");

		Arrays.stream(intArr).boxed().sorted(Comparator.reverseOrder()).skip(1).findFirst()
				.ifPresent(System.out::print);

		Map<Integer, Long> freq = new HashMap<>();

		System.out.println();

		for (int i : intArr) {

			freq.put(i, freq.getOrDefault(i, (long) 0) + 1);
		}
		System.out.println("Frequesncy of numbers : ");
		System.out.println(freq);

		System.out.println();
		System.out.println("Frequesncy of numbers using Stream : ");

		Arrays.stream(intArr).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
				.entrySet().forEach(e -> System.out.print(e + " "));

		System.out.println();

		System.out.println("The leader numbers and indices are : ");

		int maxRight = Integer.MIN_VALUE;

		for (int i = intArr.length - 1; i >= 0; i--) {
			if (intArr[i] >= maxRight) {
				System.out.println(intArr[i] + " " + i);
				maxRight = intArr[i];
			}
		}

		int[][] twoArr = { { 12, 19 }, { 20, 22 }, { 1, 5 }, { 3, 9 }, { 11, 16 } };

		Arrays.sort(twoArr, Comparator.comparingInt(i -> i[0]));

		int[] firstSet = twoArr[0];

		List<int[]> intervalResult = new ArrayList<int[]>();
		intervalResult.add(firstSet);
		for (int[] temp : twoArr) {
			if (temp[0] <= firstSet[1]) {
				firstSet[1] = Math.max(temp[1], firstSet[1]);
				firstSet = temp;
			} else {
				firstSet = temp;
				intervalResult.add(firstSet);
			}
		}
		System.out.println("Merge Interval results :  ");
		for (int[] result : intervalResult) {
			System.out.println(Arrays.toString(result));
		}

		int[] firstArr = { 8, 1, 3 };
		int[] secondArr = { 6, 2, 4 };

		int[] mergerResult = IntStream.concat(Arrays.stream(firstArr), Arrays.stream(secondArr)).sorted().toArray();
		System.out.println("Sort and merge Results : ");

		System.out.println(Arrays.toString(mergerResult));

		String[] strArr = { "B1", "B4", "B6" };

		String ch = strArr[0].replaceAll("\\d+", "");

		Set<Integer> intSet = Arrays.stream(strArr).map(c -> Integer.parseInt(c.replaceAll("\\D+", "")))
				.collect(Collectors.toSet());

		int min = Collections.min(intSet);
		int max = Collections.max(intSet);

		List<String> strResult = IntStream.rangeClosed(min, max).filter(n -> !intSet.contains(n)).mapToObj(i -> ch + i)
				.toList();

		System.out.println("String char with missing count  : ");
		System.out.println(strResult);

		String str = "Vasanthakumarr";
		char[] chArr = str.toCharArray();
		List<Character> strList = new ArrayList<>();
		for (int i = 0; i < chArr.length; i++) {
			for (int j = i + 1; j < chArr.length; j++) {
				if (chArr[i] == chArr[j] && !strList.contains(chArr[i])) {
					strList.add(chArr[i]);
					break;
				}
			}
		}
		System.out.println("Duplicate Characters - " + strList);
		
	}

}
