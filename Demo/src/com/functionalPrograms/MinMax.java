package com.functionalPrograms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@SuppressWarnings("all")
public class MinMax {

	public static void main(String[] args) {

		List<Integer> list = new ArrayList<>();
		list.add(54);
		list.add(3);
		list.add(78);
		list.add(25);
		list.add(34);
		list.add(67);
		list.add(100);

		int max = list.stream().max((n1, n2) -> n1.compareTo(n2)).orElseThrow();
		System.out.println("max : "+max);
		
		int min = list.stream().min(Integer::compare).orElseThrow();
		System.out.println("min : "+min);

		
		min = list.stream().min(Comparator.naturalOrder()).get();
		System.out.println(min);
		
		max = list.stream().max(Comparator.naturalOrder()).get();
		System.out.println(max);
		
		min = list.stream().collect(Collectors.minBy(Comparator.naturalOrder())).get();
		System.out.println(min);
		
		min = list.stream().mapToInt(Integer::valueOf).min().getAsInt();
		System.out.println(min);
		
	}
}
