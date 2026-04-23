package com.functionalPrograms;


public class ResverseString { 

	public static void main(String[] args) {

		String s = "Hello Java..!", reverse = "";

		String[] arr = s.split("");

		for (int i = arr.length - 1; i >= 0; i--) {
			reverse = reverse.concat(arr[i]);
		}
		System.out.println("Reverse : " + reverse);
		
		
		
		
		String s1 = "radar";
		StringBuilder builder = new StringBuilder("radar");
		builder.reverse();
		System.out.println(builder);
		System.out.println("------------------------");

		
		String[] arr1 = s1.split("");
		String str = "";
		for (int i = arr1.length - 1; i >= 0; i--) {
			str = str + s1.charAt(i);	//str = str + char[i];
		}
		System.out.println("str : " + str);
		
		
		
	}
}


/*
 
 s.concat("") is generally faster because it avoids 
 creating an unnecessary StringBuilder instance, whereas s + "" uses StringBuilder and has a minor overhead.
 
 */
 