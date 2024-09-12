package com.functionalPrograms;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SomeOfDigit {

	
	public static void main(String[] args) {
		
		String s = "1324";
		
		int sum = Arrays.stream(s.split("")).mapToInt(Integer::valueOf).sum();
		System.out.println("Sum : "+sum);
		
		System.out.println("---------------------");
		
		
		int i = 1234;
		Integer sumOfDigits = Stream.of(String.valueOf(i).split("")).collect(Collectors.summingInt(Integer::parseInt));
        System.out.println(sumOfDigits);
	}
}
