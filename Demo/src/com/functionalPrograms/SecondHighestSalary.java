package com.functionalPrograms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SecondHighestSalary {
 
	public static void main(String[] args) {
		
		List<Employee> list = new ArrayList<Employee>();
		list.add(new Employee("2", "kiran", 100000));
		list.add(new Employee("1", "dipal", 70000));
		list.add(new Employee("5", "paurnima", 80000));
		list.add(new Employee("4", "vijay", 40000));
		
		
		double d = list.stream().mapToDouble(e -> e.getSalary()).sorted().limit(list.size()-1).max().getAsDouble();
		System.out.println(d);
		
		
		d = list.stream().map(e -> e.getSalary()).sorted(Comparator.reverseOrder()).skip(1).findFirst().get();
		System.out.println(d);
		
	}
}
