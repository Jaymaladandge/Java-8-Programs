package com.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.functionalPrograms.Person;
import com.test.lambda.Product;

@SuppressWarnings("all")
public class StreamDemo {

	public static void main(String[] args) {

		List<String> list = Arrays.asList(new String[] { "jayu", "kajal", "kanchan", "kiran", "rupali" });
		list.stream().mapToInt(l -> l.length()).forEach(n -> System.out.print(n + " "));

		
		System.out.println("\n-------------------");
		list.stream().filter(s -> s.length() > 5).forEach(System.out::println);

		
		System.out.println("---------------------");

		List<Product> productList = new ArrayList<>();
		productList.add(new Product(1, "Laptop", 50000));
		productList.add(new Product(5, "mouse", 1000));
		productList.add(new Product(3, "keyboard", 4000));

		
		
		List<Product> products = productList.stream().filter(p -> p.getPrice() < 10000).collect(Collectors.toList());
		products.stream().forEach(System.out::println);
		
		
		
		List<Float> lst = productList.stream().filter(p -> p.getPrice() < 10000).map(Product::getPrice).collect(Collectors.toList()); 
		System.out.println("==="+lst);
		
		
		
		System.out.println("----------limit------------");
		long l = productList.stream().filter(p -> p.getPrice() < 10000).limit(1).count();
		System.out.println("Count : " + l);

		
		
		System.out.println("--------------------");
		List<Integer> array = Arrays.asList(4, 6, 2);
		int sum = array.stream().reduce(1, (element1, element2) -> element1 * element2);
		System.out.println("The sum of all elements is " + sum);

		
		
		System.out.println("--------------longestString--------------");
		Optional<String> longestString = list.stream()
				.reduce((word1, word2) -> word1.length() > word2.length() ? word1 : word2);
		longestString.ifPresent(System.out::println);

		
		List<Integer> num = Arrays.asList(45, 25, 98, 35, 47);
		int big = num.stream().reduce((n1, n2) -> n1 > n2 ? n1 : n2).get();
		System.out.println("----big-----"+big);
		
		
		System.out.println("-------------Optional--------------");
		Optional<String> String_combine = list.stream().reduce((str1, str2) -> str1 + "-" + str2);
		if (String_combine.isPresent()) {
			System.out.println(String_combine.get());
		}
		
		

		System.out.println("--------------------------------");
		
		float salSum = productList.stream().map(product -> product.getPrice()).reduce(Float::sum).orElseThrow();
		
		
		salSum = productList.stream().map(product -> product.getPrice()).reduce((p1,p2) -> Float.sum(p1, p2)).get();
		System.out.println("----------salSum-----------"+salSum);
		
		
		OptionalDouble op = productList.stream().mapToDouble(p -> p.getPrice()).reduce(Double::sum);
		System.out.println("-------------------------"+op.getAsDouble());
		
		
		double salDouble = productList.stream().mapToDouble(p -> p.getPrice()).sum();
		System.out.println("---------salDouble---------"+salDouble);
		
		
		double totalPrice3 = productList.stream().collect(Collectors.summingDouble(p -> p.getPrice()));
		System.out.println("totalPrice3 : " + totalPrice3);
		
		
		Product product = productList.stream().max((p1, p2)-> p1.getPrice() > p2.getPrice() ? 1 : -1).get();
		System.out.println("product : "+product);
		
		
		
		System.out.println("--------------------------------------");
		
		
		List<Person> list1 = new ArrayList<>(); 
		list1.add(new Person("kasturi","mumbai", "Maharashtra",20000));
		list1.add(new Person("bakula", "pune", "Maharashtra",32000));
		list1.add(new Person("phulwanti", "mumbai", "Maharashtra",50000));
		list1.add(new Person("krutika", "ujjain", "Mp",25000));
		
		
		System.out.println("------Grouping + transformation  - ------\n");
		list1.stream().collect(Collectors.groupingBy(p -> p.getState(),Collectors.mapping(n -> n.getName(), Collectors.toSet()))).forEach((k,v) -> System.out.println(k + " " + v));
		System.out.println("----");
		list1.stream().collect(Collectors.groupingBy(p -> p.getState(),Collectors.counting())).forEach((k,v) -> System.out.println(k + " " + v));
		System.out.println("---Group by state and city--");
		list1.stream().collect(Collectors.groupingBy(p -> p.getState(), Collectors.groupingBy(c -> c.getCity()))).forEach((k,v) -> System.out.println(k + " " + v));
		
		
		System.out.println("------Simple grouping - Group by state------\n");
		list1.stream().collect(Collectors.groupingBy(p -> p.getState())).forEach((k,v) -> System.out.println(k + " " + v));
		
		
		System.out.println("-----Custom Map (e.g., sorted keys) - Sort map keys in ascending order------\n");
		list1.stream().collect(Collectors.groupingBy(p -> p.getState(), TreeMap::new, Collectors.counting())).forEach((k,v) -> System.out.println(k + " " + v));
		
		
		long count = list1.stream().collect(Collectors.filtering(p -> p.getSalary() > 25000, Collectors.counting()));
		System.out.println("count : "+count);
		
		list1.stream().collect(Collectors.groupingBy(Person::getState, Collectors.filtering(p -> p.getSalary()>20000, Collectors.mapping(p -> p.getName(), Collectors.toList()))))
				.forEach((k,v) -> System.out.println(k + " = " + v));
		
		Person p =list1.stream().collect(Collectors.reducing((p1, p2) -> p1.getSalary() > p2.getSalary() ? p1 : p2)).get();
		System.out.println("Highest salary : "+ p);
		
		double highSal = list1.stream().collect(Collectors.reducing(0, person -> p.getSalary(), (p1, p2) -> p1.doubleValue() > p2.doubleValue() ? p1 : p2)).doubleValue();
		System.out.println("Highest salary : "+ highSal);
		
		
		
		String s = list1.stream().collect(Collectors.mapping(person -> person.getName(), Collectors.joining(" & ")));
		System.out.println(s);
		System.out.println("---------------");
		
		Map<Boolean, List<Person>> map = list1.stream().collect(Collectors.partitioningBy(person -> person.getSalary() > 25000));
		for(Map.Entry<Boolean, List<Person>> entry : map.entrySet()) {
			System.out.println(entry);
		}
		
		list1.stream().collect(Collectors.partitioningBy(person -> person.getSalary() > 25000, Collectors.mapping(Person::getName, Collectors.toList())))
					  .forEach((k,v) -> System.out.println(k + " " + v));
	}
}
