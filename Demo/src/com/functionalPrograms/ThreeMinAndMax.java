package com.functionalPrograms;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ThreeMinAndMax {

	public static void main(String[] args) {

		List<Integer> list = Arrays.asList(45, 12, 56, 15, 24, 75, 31, 89);

		System.out.println("Minimum numbers : ");
		list.stream().sorted().limit(3).forEach(n -> System.out.println(n));
		

		System.out.println("Maximum numbers : ");
		list.stream().sorted(Comparator.reverseOrder()).limit(3).forEach(n -> System.out.println(n));
	}
}
