package com.test;

public class ReverseString {

	public static void main(String[] args) {

		String s = "radar";
		StringBuilder builder = new StringBuilder("radar");
		builder.reverse();
		System.out.println(builder);
		System.out.println("------------------------");

		
		String[] arr = s.split("");
		String str = "";
		for (int i = arr.length - 1; i >= 0; i--) {
			str = str + s.charAt(i);	//str = str + char[i];
		}
		System.out.println("str : " + str);
		
		
		
		
	}
}
