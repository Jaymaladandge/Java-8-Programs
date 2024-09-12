package com.test;

import java.util.stream.Collectors;

public class CharOccurence {

	public static void main(String[] args) {

		String str = "Java";

		str.chars() // Convert the String to an IntStream.  each element in the stream is the integer representation (Unicode code point) of a character in the string.
				.mapToObj(c -> (char) c) // Convert each int in the stream to a char
				.collect(Collectors.groupingBy(c -> c, Collectors.counting())) // Group by character and count them
				.forEach((character, frequency) -> System.out.println(character + ": " + frequency));
		
		

	}
}
