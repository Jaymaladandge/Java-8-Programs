package com.functionalPrograms;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class DecimalInReverseOrder {

	public static void main(String[] args) {
		

		List<Double> list = Arrays.asList(23.1, 36.0, 78.4, 95.2);
		
		list.stream().sorted(Comparator.reverseOrder()).forEach(num->System.out.print(num+", "));
		
	}
}
