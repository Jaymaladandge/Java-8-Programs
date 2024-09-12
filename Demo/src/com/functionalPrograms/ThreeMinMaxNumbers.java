package com.functionalPrograms;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ThreeMinMaxNumbers {

	public static void main(String[] args) {

		List<Integer> list = Arrays.asList(12, 35, 46, 75, 89, 25, 6, 4);

		System.out.print("Three max numbers :");
		list.stream().sorted(Comparator.reverseOrder()).limit(3).forEach(max -> System.out.print(" " + max));

		System.out.println();

		System.out.print("Three min numbers :");
		list.stream().sorted().limit(3).forEach(min -> System.out.print(" "+min));

	}

}

//https://javaconceptoftheday.com/java-8-interview-sample-coding-questions/