package com.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StringReverse {

	public static void main(String[] args) {

		String str = "Java coding guide";

		String reversed = Arrays.stream(str.split(" ")).map(word -> new StringBuilder(word).reverse())
				.collect(Collectors.joining(" "));

		System.out.println(reversed);

		Map<String, Long> strmap = Arrays.stream(str.split(" "))
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		System.out.println(strmap);

		String s = "Vasanthakumar";

		Optional<String> sreversed = Arrays.stream(s.split("")).reduce((a, b) -> b + a);

		System.out.println(sreversed);

		Map<Character, Long> smap = s.chars().mapToObj(c -> (char) c)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println(smap);

		String[] newstr = { "A1", "A3", "A5", "A7" };

		String letter = newstr[0].replaceAll("\\d", "");

		System.out.println(letter);

		Set<Integer> input = Arrays.stream(newstr).map(i -> Integer.parseInt(i.replaceAll("\\D", "")))
				.collect(Collectors.toSet());

		int min = Collections.min(input);
		int max = Collections.max(input);

		List<String> resList = IntStream.rangeClosed(min, max).filter(i -> !input.contains(i)).mapToObj(i -> letter + i)
				.collect(Collectors.toList());

		System.out.println(resList);

		String p = "Madam";

		if (p.equalsIgnoreCase(new StringBuilder(p).reverse().toString())) {
			System.out.println(p + " is palindrome");
		}

		String st = "JavaCodingProblemSolutionavaCodingroblemSolution";

		Map<Character, Integer> rmap = new WeakHashMap();

		for (char c : st.toCharArray()) {
			rmap.put(c, rmap.getOrDefault(c, 0) + 1);
		}

		System.out.println(rmap);

		for (char ch : st.toCharArray()) {
			if (rmap.get(ch) == 1) {
				System.out.println(ch);
			}
		}

		System.out.println("2nd unique element is - ");

		st.chars().mapToObj(u -> (char) u).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
				.entrySet().stream().filter(e -> e.getValue() == 1).skip(1).forEach(System.out::println);

		String[] newst = { "A1", "A3", "A5", "A7" };

		String c = newst[0].replaceAll("\\d", "");

		Set<Integer> sint = Arrays.stream(newst).map(s1 -> Integer.parseInt(s1.replaceAll("\\D", "")))
				.collect(Collectors.toSet());

		int mn = Collections.min(sint);
		int mx = Collections.max(sint);

		List<String> rs = IntStream.rangeClosed(mn, mx).filter(n -> !sint.contains(n)).mapToObj(n -> c + n).toList();

		System.out.println(rs);

		String[] sr = { "test1", "user2", "user3", "test4" };

		Arrays.stream(sr).filter(t -> t.startsWith("user")).forEach(System.out::println);

		List<String> comma = new ArrayList<String>();
		comma.add("one,twooo");
		comma.add("java,spring");
		comma.add("welcome, hello");

		String max1 = comma.stream().flatMap(s1 -> Arrays.stream(s1.split(",")))
				.max(Comparator.comparing(String::length)).toString();

		comma.stream().map(s2 -> Arrays.stream(s2.split("\\s*,\\s*")).max(Comparator.comparingInt(String::length)))
				.forEach(System.out::println);

		System.out.println(max1);

		String strg = "Vasanth";

		String reverse = "";
		for (int i = strg.length() - 1; i >= 0; i--) {
			reverse += strg.charAt(i);
		}
		System.out.println("Reverse using the for loop: "+reverse);
		
		String word = "Vasanthakumar";
		
		char[] arr = word.toCharArray();
		
		int left = 0;
		int right = arr.length-1;
		
		while(left<right) {
			char temp = arr[left];
			arr[left] = arr[right];
			arr[right] = temp;
			left++;
			right--;
		}
		
		System.out.println(arr);
		
	}

}
