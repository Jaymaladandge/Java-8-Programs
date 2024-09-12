package com.functionalPrograms;

import java.util.ArrayList;
import java.util.List;

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

		
	}
}
