package com.functionalPrograms;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@SuppressWarnings("all")
public class MergeArray {

	public static void main(String[] args) {

		int[] a = { 65, 57, 23, 15 };
		int[] b = { 2, 8, 3, 7 };
		
		
		IntStream.concat(Arrays.stream(a), Arrays.stream(b)).sorted().forEach(System.out::println);
		
		int[] c = IntStream.concat(Arrays.stream(a), Arrays.stream(b)).sorted().toArray();
		System.out.println(Arrays.toString(c));

	}

}
