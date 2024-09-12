package com.functionalPrograms;

import java.util.Arrays;

public class SumAverage {

	public static void main(String[] args) {

		int[] arr = new int[] { 45, 12, 56, 15, 24, 75, 31, 89 };
		
		int sum =Arrays.stream(arr).sum();
		System.out.println("Sum : " +sum);
		
		Double average= Arrays.stream(arr).average().getAsDouble();
		System.out.println("Average : "+average);

	}
}
