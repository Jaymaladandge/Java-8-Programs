package com.functionalPrograms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@SuppressWarnings("all")
public class ReverseSort {

	public static void main(String[] args) {

		ArrayList<String> list = new ArrayList<>();
		list.add("aditi");
		list.add("paurnima");
		list.add("rashmi");
		list.add("omakar");
		list.add("kiran");

		list.stream().sorted((a, b) -> b.compareTo(a)).forEach(System.out::println);

		System.out.println("---------------------------");

		list.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);

		System.out.println("----------------------------");

		List<Employee> emps = new ArrayList<>();
		emps.add(new Employee("666", "krutika", 750000));
		emps.add(new Employee("555", "rashmi", 750000));
		emps.add(new Employee("111", "paurnima", 60000));
		emps.add(new Employee("777", "kiran", 65000));

		emps.stream().sorted(Comparator.comparing(e -> e.getId())).forEach(System.out::println);
		System.out.println("----");
		
		emps.stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed()).forEach(System.out::println);
		System.out.println("----");
		
		emps.stream().sorted(Comparator.comparingDouble(Employee::getSalary).thenComparing(Employee::getName).reversed()).forEach(System.out::println);



	}
}
