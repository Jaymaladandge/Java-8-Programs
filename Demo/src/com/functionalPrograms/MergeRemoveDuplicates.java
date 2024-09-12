package com.functionalPrograms;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MergeRemoveDuplicates {

	public static void main(String[] args) {

		int[] a = { 65, 57, 23, 23, 15 };
		int[] b = { 2, 8, 3, 7, 2 };

		IntStream.concat(Arrays.stream(a), Arrays.stream(b)).sorted().distinct().forEach(n -> System.out.print(n + " "));

	}
}
