package com.functionalPrograms;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SuppressWarnings("all")
public class AnagramString {

	public static void main(String[] args) {

		String s1 = "RaceCar";
		String s2 = "CarRace";

		s1 = Stream.of(s1.split("")).map(String::toUpperCase).sorted().collect(Collectors.joining());
		s2 = Arrays.stream(s2.split("")).map(String::toUpperCase).sorted().collect(Collectors.joining());

		boolean match = s1.equals(s2) ? true : false;
		System.out.println("Both Strings are anagram : "+match);

	}

}
//https://javaconceptoftheday.com/java-8-interview-sample-coding-questions/