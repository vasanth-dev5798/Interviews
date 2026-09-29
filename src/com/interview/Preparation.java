package com.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Preparation {
	
	public static void main(String[] args) {
		
		//1.Char array reverse
		char[] chArr= {'e','r','t','y'};
	    char[] chres = new char[chArr.length];
	    
	    //Using sorted method
		new String(chArr).chars().mapToObj(c->(char)c).sorted(Comparator.reverseOrder())
		.forEach(s->System.out.print(s+" "));
		System.out.println();
		
		//Using For loop
		int n = 0;
		for(int i=chArr.length-1;i>=0;i--) {
			chres[n] = chArr[i];
			n++;
		}
		System.out.print("Reversed Array - ");
		System.out.println(chres);
		
		//2.Second highest length in the given set of words
		
		String str = "Java coding practice programming question";
		
		String SecHigh = Arrays.stream(str.split(" ")).sorted(Comparator.comparingInt(String::length).reversed()).skip(1).findFirst()
		.orElse(null);
		
		System.out.println("The 2nd Highest word and length is - "+SecHigh+" "+SecHigh.length());
		
		//Using for loop
		String[] words = str.split(" ");
		String first ="";
		String second = "";
		for(String srt :words) {
			
			if(srt.length()>first.length()) {
				second = first;
				first = srt;
			}else if(srt.length() > second.length()) {
				second = srt;
			}
		}
		System.out.println("The 2nd highest - "+second+" length - "+second.length());
		
		//3.Right shift of all 0's in int array
		
		int[] zarr = {2,4,6,8,0,6,8,0,3,0,0,2,0};
		int[] resZarr = new int[zarr.length];
		int t = 0;
		for(int i=0;i<zarr.length;i++) {
			if(zarr[i]!=0) {
				resZarr[t]=zarr[i];
				t++;
			}
		}
		if(t<zarr.length) {
			resZarr[t]=0;
			t++;
		}
		System.out.print("0's moved to the right - ");
		System.out.println(Arrays.toString(resZarr));
		
		//Filter palindrome words
		
		String[] strArr = {"Appa","Amma","Java","One","Malayalam"};
		List<String> palindrom = new ArrayList<>();
		
		//Using for loop
		
		for(String st : strArr) {
			if(st.equalsIgnoreCase(new StringBuffer(st.toLowerCase()).reverse().toString())) {
				palindrom.add(st);
			}
		}
		System.out.println(palindrom);
		
		// Using stream
		
		Arrays.stream(strArr).filter(p->p.equalsIgnoreCase(new StringBuilder(p).reverse().toString()))
		.forEach(System.out::println);
		
		//5.Merge two integer array sorted
		
		int[] firstArr = {4,7,9};
		int[] secondArr = {3,5,8};
		
		//Using stream
		IntStream.concat(Arrays.stream(firstArr), Arrays.stream(secondArr)).sorted().forEach(System.out::println);
		
	    //Using for loop
		
		int[] mergeArr = new int[firstArr.length + secondArr.length];
		int num =0;
		for(int i : firstArr) {
			mergeArr[num] = i;
			num++;
		}
		for(int j : secondArr) {
			mergeArr[num] = j;
			num++;
		}
		Arrays.sort(mergeArr);
		System.out.print(Arrays.toString(mergeArr));
		
		//6.convert sentence to hashtag
		String hstr = "java code questions";
		
		//using streams
		
		String hashres = "#"+Arrays.stream(hstr.split(" ")).map(word->word.substring(0,1).toUpperCase()+word.substring(1))
		.collect(Collectors.joining(""));
		System.out.println();
		System.out.println(hashres);
		
		//using for loop
		StringBuilder sb = new StringBuilder("#");
		for(String htemp : hstr.split(" ")) {
			sb.append(htemp.substring(0,1).toUpperCase()).append(htemp.substring(1));
		}
		
		System.out.println(sb);
		
		//7.Filter out the valid numbers from given list of string
		
		List<String> strList = new ArrayList<String>();
		strList.add("one");
		strList.add("two45");
		strList.add("3554");
		strList.add("th434");
		strList.add("123");
		strList.add("0898");
		strList.add("three");
		strList.add("nvyuf");
		
		//Using streams
		System.out.print("Only numbers from given list - ");
		strList.stream().filter(l->l.matches("\\d+")).forEach(ns->System.out.print(ns+" "));
		
		//String intList = strList.stream().filter(l->l.matches("\\d+")).collect(Collectors.joining(","));

		System.out.println();
		
		//using for loop
		for(String st : strList) {
			if(st.matches("\\d+")) {
				System.out.println(st);
			}
		}
		
		System.out.print("Only String from given list - ");
		strList.stream().filter(l->l.matches("\\D+")).forEach(ns->System.out.print(ns+" "));

		//8.calculate sum of the current element and up to the previous k-1 elements 
		
		System.out.println();
		int[] iArr = {1,2,3,4,5};
		int k = 3;
		int sum = 0;
		for(int i =0;i<iArr.length;i++) {
			
			sum+=iArr[i];
			
			if(i>=k) {
				sum-=iArr[i-k];
			}
			
			System.out.println(sum+" ");
		}
		
		//9.Find the duplicate elements
		
		System.out.println();
		int[] darr = {2,3,2,4,5,5,7,8,3};
		
		Map<Integer, Integer> freqMap = new HashMap<>();
		
		for(int i : darr) {
			freqMap.put(i, freqMap.getOrDefault(i,0)+1);
		}
		System.out.print("The duplicate elements - ");
		for(Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
			if(entry.getValue()>1) {
				System.out.print(entry.getKey()+" ");
			}
		}
		
		Map<Integer, Long> freqMap1 = Arrays.stream(darr).boxed()
										.collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		System.out.println();
		System.out.println("The occurences of the number - "+freqMap1);
		
		System.out.println("The duplicate numbers using stream - ");

		Arrays.stream(darr).boxed()
		.collect(Collectors.groupingBy(Function.identity(),Collectors.counting())).entrySet().stream()
		.filter(e->e.getValue()>1).forEach(c->System.out.println(c.getKey()+" "));
	}

}
