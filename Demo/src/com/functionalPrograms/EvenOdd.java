package com.functionalPrograms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@SuppressWarnings("all")
public class EvenOdd {

	public static void main(String[] args) {


		List<Integer> list = new ArrayList<>();
		list.add(54);
		list.add(3);
		list.add(78);
		list.add(25);
		list.add(34);
		list.add(67);

		Map<Boolean, List<Integer>> map = list.stream().collect(Collectors.partitioningBy(p -> p % 2 == 0));
		map.forEach((k, v) -> {
			String key = k ? "Even" : "Odd";
			System.out.println(key + " " + v);
		});
		
		System.out.println("Even : "+map.get(true));

	}
}
