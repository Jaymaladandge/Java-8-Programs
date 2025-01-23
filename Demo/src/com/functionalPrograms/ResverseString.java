package com.functionalPrograms;


public class ResverseString { 

	public static void main(String[] args) {

		String s = "Hello Java..!", reverse = "";

		String[] arr = s.split("");

		for (int i = arr.length - 1; i >= 0; i--) {
			reverse = reverse.concat(arr[i]);
		}
		System.out.println("Reverse : " + reverse);
	}
}


/*
 
 s.concat("") is generally faster because it avoids 
 creating an unnecessary StringBuilder instance, whereas s + "" uses StringBuilder and has a minor overhead.
 
 */
 