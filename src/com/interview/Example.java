package com.interview;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Example {
	
	public static void main(String[] args) {
	
	List<Integer> numbers =  Arrays.asList(1,2,3,4,2,5,1,6);
	
	Set<Integer> present = new HashSet<>();
	
	List<Integer> duplicates = numbers.stream().filter(i->!present.add(i)).collect(Collectors.toList());
	
	numbers.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
	.entrySet().stream().filter(i->i.getValue()>1).forEach(System.out::println);
	
	numbers.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
	.entrySet().stream().filter(i->i.getValue()>1).forEach(i -> System.out.println(i.getKey()+" presnet - times "+i.getValue()));
     
	System.out.println(duplicates);
	}

}
