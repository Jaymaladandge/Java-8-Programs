package com.functionalPrograms;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SecondLargestArray {

	
	public static void main(String[] args) {
		
		
		List<Integer> list = Arrays.asList(12, 35, 46, 75, 89, 25, 6, 4);
		
		System.out.print("Second largest :");
		list.stream().sorted(Comparator.reverseOrder()).limit(2).skip(1).forEach(n -> System.out.print(" "+n));
		
		
		System.out.println();
		
		
		int second = list.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst().get();
		System.out.println("Second largest : "+second);
		
		
	}
}
