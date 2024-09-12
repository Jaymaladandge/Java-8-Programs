package com.functionalPrograms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SuppressWarnings("all")
public class RemoveDuplicate {
	
	public static void main(String[] args) {
		
		
		int[] nums = { 54, 3, 3, 25, 34, 34 };
		
		
		Arrays.stream(nums).distinct().forEach(n -> System.out.print(n+" "));
		System.out.println();
		
		
		
		List<Integer> list = new ArrayList<>();
		list.add(54);
		list.add(3);
		list.add(3);
		list.add(25);
		list.add(34);
		list.add(34);
		
		list.stream().distinct().forEach(n -> System.out.print(n+" "));
		
		
	}

}
