package com.functionalPrograms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SuppressWarnings("all")
public class RemoveDuplicate {
	
	public static void main(String[] args) {
		
		
		int[] nums = { 54, 3, 3, 25, 34, 34 };
		List<Integer> list = new ArrayList<>();
		
		for(int i=0; i<nums.length;i++) {
			
			if(!list.contains(nums[i])) {
				list.add(nums[i]);
			}
		}
		System.out.println(list);
		
		System.out.println("-------------");
		
		
		int[] nums1 = { 54, 3, 3, 25, 34, 34 };
		
		Arrays.stream(nums1).distinct().forEach(n -> System.out.print(n+" "));
		System.out.println();
		
		
		List<Integer> list1 = new ArrayList<>();
		list1.add(54);
		list1.add(3);
		list1.add(3);
		list1.add(25);
		list1.add(34);
		list1.add(34);
		
		list1.stream().distinct().forEach(n -> System.out.print(n+" "));
		
		
	}

}
