package com.functionalPrograms;

public class PalindromeString {

	public static void main(String[] args) {

		String s = "12321", result = "";
		String[] arr = s.split("");

		for (int i = arr.length - 1; i >= 0; i--) {

			result = result.concat(arr[i]);

		}
		if (s.equals(result))
			System.out.println("Palindrome");
		else
			System.out.println("Not Palindrome");

		System.out.println("-------------------------------------------------------");

		
		
		result = "";
		for (int i = s.length() - 1; i >= 0; i--) {
			result = result.concat(String.valueOf(s.charAt(i)));
		}
		if (s.equals(result))
			System.out.println("Palindrome");
		else
			System.out.println("Not Palindrome");
	}

}
