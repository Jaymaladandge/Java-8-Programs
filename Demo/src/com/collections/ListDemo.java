package com.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.test.lambda.Product;

public class ListDemo {

	static void m1() {

	}

	public static void main(String[] args) {

		ArrayList<Integer> nums = new ArrayList<>(10);
		nums.add(100);
		nums.add(500);

		nums.forEach((n) -> System.out.println(n));
		nums.add(2, 700);
		System.out.println("-----------------" + nums.size());
		nums.forEach((n) -> System.out.println(n));
		System.out.println("contains : " + nums.contains(900));

		System.out.println("---------------------------");
		Hashtable<Integer, String> map = new Hashtable<Integer, String>();
		map.put(100, "Amit");
		map.put(102, "Ravi");
		map.put(101, "Vijay");
		map.put(103, "Rahul");

		Enumeration<Integer> enu = map.keys();

		while (enu.hasMoreElements()) {
			map.put(106, "rohit");
			System.out.println(map.get(enu.nextElement()));
		}
		System.out.println(map);

		System.out.println("-------------------------");
		map.forEach((k, v) -> System.out.println(k + "===" + v));

		/*
		 * System.out.println("--------------------------"); List<Integer> source =
		 * Arrays.asList(1, 2, 3, 4); List<Integer> dest = Arrays.asList(5, 6, 7);
		 * Collections.copy(dest, source); System.out.println(dest);
		 */

		System.out.println("=----------------------------");
		ArrayList<Product> al = new ArrayList<Product>();
		al.add(new Product(101, "laptop", 23));
		al.add(new Product(106, "keyboard", 27));
		al.add(new Product(105, "mouse", 21));

		System.out.println("------------Sorting 1-------------");
		Comparator<Product> cmp = Comparator.comparing(Product::getName);
		Collections.sort(al, cmp);
		al.forEach(System.out::println);

		System.out.println("---------------Sorting 2---------------");
		al.stream().sorted((p1, p2) -> p1.getId() - p2.getId()).collect(Collectors.toList())
				.forEach(System.out::println);

		System.out.println("--------------Sorting 3--------------");
		List<Integer> list = Arrays.asList(2, 4, 1, 3, 7, 5, 9, 6, 8);
		List<Integer> sortedList = list.stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList());
		System.out.println(sortedList);

		System.out.println("-----------------------");
		HashMap<String, Integer> mapcon = new HashMap<>();
		mapcon.put("k1", 100);
		mapcon.put("k2", 200);
		mapcon.put("k3", 300);
		mapcon.put("k4", 400);
		System.out.println("HashMap values :\n " + mapcon.toString());
		mapcon.computeIfAbsent("k5", k -> 200 + 300);
		mapcon.computeIfAbsent("k6", k -> 60 * 10);
		System.out.println("New HashMap after computeIfAbsent :\n " + mapcon);

	}

}
