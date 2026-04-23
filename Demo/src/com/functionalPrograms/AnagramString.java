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

		
		
		
		String s11 = "RaceCar";
		String s21 = "CarRace";
		boolean flag =false;
		s11 = s11.toLowerCase();
		s21 = s21.toLowerCase();
		
		if(s11.length()==s21.length()) {
			
			s11 = Arrays.asList(s11.split("")).stream().sorted().collect(Collectors.joining());
			s21 = Arrays.asList(s21.split("")).stream().sorted().collect(Collectors.joining());
			
			if(s11.equals(s21)) {
				System.out.println("Anagram");
			}else {
				System.out.println("Not Anagram");
			}
		}else {
			System.out.println("Not Anagram");
		}
	}

}
//https://javaconceptoftheday.com/java-8-interview-sample-coding-questions/