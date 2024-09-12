package com.functionalPrograms;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@SuppressWarnings("all")
public class CharecterFrequency {

	public static void main(String[] args) {

		String s = "Hello World";
		String[] arr = s.split("");

		Map<Object, List<String>> map = Arrays.stream(arr).collect(Collectors.groupingBy(c -> c));
		map = Arrays.stream(arr).collect(Collectors.groupingBy(Function.identity()));
		map.forEach((k, v) -> System.out.println(k + " " + v.size()));

		
		System.out.println("--------------------------------------");

		
		Map<String, Long> map2 = Arrays.stream(arr).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		map2.forEach((k, v) -> System.out.println(k + " " + v));

		
		System.out.println("--------------------------------------");

		
		Map<Character, Long> map3 = s.chars().mapToObj(i -> (char) i).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		map3.forEach((k, v) -> System.out.println(k + " " + v));
	}

}
