package com.functionalPrograms;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SortAccordingToLength {

	
	public static void main(String[] args) {
		
		List<String> list = Arrays.asList("Java", "Python", "C#", "HTML", "Kotlin", "C++", "COBOL", "C");
		list.stream().sorted(Comparator.comparing(String::length)).forEach(System.out::println);
	}
	
}
