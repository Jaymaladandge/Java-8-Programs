package com.functionalPrograms;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("all")
public class MultipleOfNumber {

	public static void main(String[] args) {

		List<Integer> list = new ArrayList<>();
		list.add(54);
		list.add(3);
		list.add(78);
		list.add(25);
		list.add(34);
		list.add(67);

		list.stream().filter(n -> n % 5 == 0).forEach(System.out::println);

	}
}
