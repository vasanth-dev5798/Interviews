package com.interview;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

class Java17Features {

    public static void main(String[] args) {

        String name = "Vasanthakumar";

        Map<Character, Integer> frequency = new LinkedHashMap<>();

        for (char ch : name.toCharArray()) {

            frequency.put(ch, frequency.getOrDefault(ch, 0) + 1);
        }

        for (Map.Entry<Character, Integer> entry : frequency.entrySet()) {

            if (entry.getValue() == 1) {
                System.out.println(entry.getKey());
                break;
            }

        }

        LinkedHashMap<Character, Long> strMap = name.chars().mapToObj(c->(char)c).
        collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting()));

        strMap.entrySet().stream().filter(e->e.getValue()==1).findFirst().ifPresent(System.out::println);

        System.out.println(frequency);

        String s1 = "Java";
        String s2 = "Java";
        String s3 = new String("Java");

        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
        System.out.println(s1.equals(s3));
        

    }

}
