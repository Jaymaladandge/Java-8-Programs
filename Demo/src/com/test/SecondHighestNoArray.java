package com.test;

import java.util.Arrays;

public class SecondHighestNoArray {

	public static void main(String[] args) {

		int[] nums = new int[] { 2, 9, 3, 4, 5 };
		Arrays.sort(nums);
		System.out.println(Arrays.toString(nums));

		int secondHighest = nums[nums.length - 2];
		System.out.println("Second highest number using Arrays.sort() : " + secondHighest);

		System.out.println("----------------------------------");

		int[] numbers = new int[] { 2, 9, 3, 4, 5, 10 };
		secondHighest = Arrays.stream(numbers).sorted().toArray()[numbers.length - 2];
		System.out.println("Second highest number using stream : " + secondHighest);

		System.out.println("-----------------------------------");

		int[] arr = new int[] { 2, 9, 12, 4, 5, 11};
		
		int first = arr[0];  		//2
		int second = arr[1];		//9

		if (first < second) {
			first = arr[1];			//9
			second = arr[0];		//2
		}

		for (int i = 2; i <= arr.length-1 ; i++) {
			
			if (arr[i] > first) {
				second = first;		//9
				first = arr[i];		
			} 
			else if (arr[i] > second) {
				second = arr[i];
			}
		}
		System.out.println("First Highest : " + first + " Second Highest : " + second);

	}
}
