package com.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

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
		int sum = array.stream().reduce(2, (element1, element2) -> element1 * element2);
		System.out.println("The sum of all elements is " + sum);

		
		
		System.out.println("----------------------------");
		Optional<String> longestString = list.stream()
				.reduce((word1, word2) -> word1.length() > word2.length() ? word1 : word2);
		longestString.ifPresent(System.out::println);

		
		
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
	}
}
