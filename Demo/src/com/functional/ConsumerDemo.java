package com.functional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ConsumerDemo {

	static void showDetails(String name, Integer age) {
		System.out.println(name + " " + age);
	}

	static void printMessage(String name) {
		System.out.println("Hello " + name);
	}

	public static void doIterate(List<String> list) {

		list.stream().forEach(System.out::println);
	}

	public static Integer doSum(List<Integer> list) {

		return list.stream().mapToInt(Integer::intValue).sum();
	}

	static Boolean checkAge(int age) {
		return age > 17 ? true : false;
	}
	
	static void getCount(List<Integer> list) {
		System.out.println(list.stream().count());
	}
	
	public static void main(String[] args) {

		
		BiConsumer<String, Integer> bi = ConsumerDemo::showDetails;
		bi.accept("Rama", 20);
		ConsumerDemo.showDetails("Rama", 20);

		Consumer<String> consumer1 = ConsumerDemo::printMessage;
		consumer1.accept("John");

		List<String> nums = new ArrayList<String>();
		nums.add("10");
		nums.add("50");
		nums.add("20");
		nums.add("70");

		List<Integer> num = new ArrayList<Integer>();
		num.add(10);
		num.add(50);
		num.add(20);
		num.add(70);

		System.out.println("-----------------------");
		nums.stream().mapToInt(n -> Integer.parseInt(n)).filter(num1 -> num1 > 20).forEach(System.out::println);

		System.out.println("-----------------------");
		Consumer<List<String>> con = ConsumerDemo::doIterate;
		con.accept(nums);

		System.out.println("-----------------------");
		Function<List<Integer>, Integer> fun = ConsumerDemo::doSum;
		System.out.println("Sum : "+fun.apply(num));
		
		System.out.println("----------------------");
		Predicate<Integer> pre = ConsumerDemo::checkAge;
		System.out.println("CheckAge : "+pre.test(25));
		
		
		Supplier<Long> sup = () -> num.stream().count();
		System.out.println("Count : "+sup.get());
		
		Supplier<Supplier<Long>> s = () -> new Supplier<Long>() {
			
			@Override
			public Long get() {
				return 5L;
			}
		};
		System.out.println("s : "+s.get().get());
	}

}
