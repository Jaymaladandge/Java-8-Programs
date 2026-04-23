package com.functionalPrograms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class TryCode {

	public static void main(String[] args) {

		List<Employee> emps = new ArrayList<>();
		emps.add(new Employee("555", "rashmi", 750000));
		emps.add(new Employee("666", "krutika", 750000));
		emps.add(new Employee("111", "paurnima", 60000));
		emps.add(new Employee("777", "kiran", 65000));
		
		
		emps.stream().sorted(Comparator.comparingDouble(Employee::getSalary).thenComparing(Employee::getName)).forEach(System.out::println);
		
		
	}
}
