package com.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class IntegerArray {

	public static void main(String[] args) {

		int[] nums = { 2, 11, 15, 7 };
		int[] result = new int[2];
		int target = 9;

		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] + nums[j] == target) {
					result[0] = i;
					result[1] = j;
				}
			}
		}

		System.out.println(Arrays.toString(result));

		int secondHigh = Arrays.stream(nums).sorted().skip(1).findFirst().orElse(0);

		int LastsecondHigh = Arrays.stream(nums).boxed().sorted(Comparator.reverseOrder()).skip(1).findFirst()
				.orElse(0);

		System.out.println(" Second Highest number : " + secondHigh);

		System.out.println(" Last Second Highest number : " + LastsecondHigh);

		String[] words = { "one", "two", "123", "23as", "45", "three", "123e" };

		List<String> wordresult = Arrays.stream(words).filter(word -> word.matches("[a-zA-Z]+"))
				.collect(Collectors.toList());

		List<Integer> numresult = Arrays.stream(words).filter(word -> word.matches("\\d+")).map(Integer::parseInt)
				.collect(Collectors.toList());

		System.out.println(" Only Strings : " + wordresult);

		System.out.println(" Only numbers : " + numresult);

		int[] first = { 12, 5, 6 };
		int[] two = { 4, 10, 2 };
		int[] resultArr = new int[first.length + two.length];
		int n = 0;
		int temp = first[0];
		/*
		 * for (int i = 0; i<first.length;i++) { for(int j = 0; j<two.length; j++) {
		 * 
		 * if(temp < two[j]) { resultArr[n]=first[i]; n++; } } }
		 */

		for (int num : first) {
			resultArr[n] = num;
			n++;
		}
		for (int num1 : two) {
			resultArr[n] = num1;
			n++;
		}
		Arrays.sort(resultArr);
		System.out.println(Arrays.toString(resultArr));

		int[][] arrinterval = { { 1, 3 }, { 8, 10 }, { 2, 6 }, { 15, 18 } };

		List<int[]> res = new ArrayList<int[]>();

		Arrays.sort(arrinterval, Comparator.comparingInt(i -> i[0]));

		System.out.println(Arrays.deepToString(arrinterval));

		int[] firstSet = arrinterval[0];
		res.add(firstSet);
		for (int[] tempArr : arrinterval) {
			if (tempArr[0] <= firstSet[1]) {
				firstSet[1] = Math.max(tempArr[1], firstSet[1]);
			} else {
				firstSet = tempArr;
				res.add(firstSet);

			}
		}

		for (int[] printArr : res) {
			System.out.print(Arrays.toString(printArr));
		}
		
		//Leader Numbers

		int[] numbers = { 15, 18, 16, 8, 6, 3, 5, 4 };

		System.out.println(" Leaders numbers are : ");
		for (int i = 0; i < numbers.length; i++) {
			boolean isLeader = true;

			for (int j = i + 1; j < numbers.length; j++) {
				if (numbers[j] > numbers[i]) {
					isLeader = false;
					break;
				}
			}

			if (isLeader) {
				System.out.print(numbers[i] + " ");
			}
		}
		
		int right = Integer.MIN_VALUE;
		
		System.out.println("Leaders with maxright solution ");
		for(int i=numbers.length-1;i>0;i--) {
			if(numbers[i]>right) {
				System.out.println("The leader number is - "+numbers[i]+" at index - "+i);
				right = numbers[i];
			}
		}
		
		int max = Arrays.stream(numbers).max().orElseGet(null);
		System.out.println();
		System.out.println(max);
		
		int num = 5;
		
		int[][] arrinterval1 = { { 1, 3 }, { 8, 10 }, { 2, 6 }, { 15, 18 } };
		
		Arrays.sort(arrinterval1 , Comparator.comparingInt(i->i[0]));	
		
		int[] fir = arrinterval1[0];
		
		List<int[]> r = new LinkedList<int[]>();
		r.add(fir);
		for(int[] temp1: arrinterval1) {
			
			if(temp1[0]<=fir[1]) {
				fir[1] = Math.max(temp1[1], fir[1]);
			}else {
				fir = temp1;
				r.add(fir);
			}
			
		}
		
		for(int[] disp:r) {
		System.out.println(Arrays.toString(disp));
		}

		
		int[] dup = {3,45,5,4,56,6,4,3,2,5,4,45};
		
		Set<Integer> dupres = new LinkedHashSet<Integer>();
		
		for(int i : dup ) {
			dupres.add(i);
		}
		System.out.println(dupres);	
		
		Arrays.stream(dup).boxed().
		collect(Collectors.groupingBy(Function.identity() , Collectors.counting())).entrySet()
		.stream().filter(h->h.getValue()>1).forEach(f->System.out.print("only duplicates - "+String.valueOf(f.getKey())+" "));
	
		System.out.println();
		Arrays.stream(dup).distinct().forEach(System.out::print);
		
		System.out.println();
		
		Arrays.stream(dup).distinct().sorted().forEach(System.out::println);
		
		Arrays.stream(dup).distinct().boxed().sorted(Comparator.reverseOrder()).forEach(System.out::println);
		
		int[] farr = {3, 5, 6, 1};
		int[] sarr = {9, 8, 7, 2};
		
		int[] rarr = IntStream.concat(Arrays.stream(farr), Arrays.stream(sarr)).sorted().toArray();
		
		System.out.println(Arrays.toString(rarr));
		
		int [] addarr = {4,5,6,7,8,9};
		
		int t = 9;
		
		for(int i=0;i<addarr.length;i++) {
			for (int j=0;j<addarr.length;j++) {
				if(addarr[i]+addarr[j] == target) {
					System.out.println("The target addition values are : " + addarr[i] +" "+  addarr[j] +" and the indices are : "+ i +" "+ j);
				}
			}
		}
		
		int [] adarr = {84,15,46,77,18,29};
		
		int mn = Integer.MIN_VALUE;
		List<Integer> r1 = new ArrayList<Integer>();
		for(int i=adarr.length-1;i>=0;i--) {
			if(adarr[i]>mn) {
				r1.add(adarr[i]);
				mn = adarr[i];
			}
		}
		
		System.out.println(r1);
		
		int min = 1;
		int mx = 5;
		
		int fact = IntStream.rangeClosed(min, mx).reduce(1, (a,b)->a*b);
		System.out.println(fact);
		
	    String srt = Stream.of("One","Two","Three").reduce("", (a,b)->(a+" "+b));
	    System.out.println(srt);
	    
	    
	    int[] arr = {1,1,1,2,2,4,4,4,4,5,5,5,5,6,6,6,6,6,7,7,7};
        //Scanner sc = new Scanner(System.in);
        //int k = sc.nextInt();
        int k = 4;
        
        Arrays.stream(arr).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
        .entrySet().stream().filter(e->e.getValue()>=k).forEach(System.out::print);
	}
}
