package com.functionalPrograms;

import java.util.ArrayList;
import java.util.stream.Collectors;

@SuppressWarnings("all")
public class JoinString {

	public static void main(String[] args) {

		ArrayList<String> list = new ArrayList<>();
		list.add("aditi");
		list.add("paurnima");
		list.add("rashmi");
		list.add("omakar");
		list.add("kiran");

		String s = list.stream().collect(Collectors.joining());
		System.out.println(s);

		s = list.stream().collect(Collectors.joining(", ", "***", "******"));
		System.out.println(s);

		
		
	}
}
