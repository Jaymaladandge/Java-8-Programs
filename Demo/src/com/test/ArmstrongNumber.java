package com.test;

import java.util.Arrays;
import java.util.Comparator;

public class ArmstrongNumber {

	public static void main(String[] args) {

		int num = 1634;
		int a = 0;
		String s = String.valueOf(num);
		char[] ch = s.toCharArray();

		for (int i = 0; i <= ch.length - 1; i++) {
			int b = (int) ch[i];
			b = Integer.valueOf(String.valueOf(ch[i]));
			int n = b;

			for (int j = 1; j <= ch.length - 1; j++) {
				b = b * n;
			}
			a = a + b;
		}
		String result = (num == a) ? "Armstrong number : " + s : "Not Armstrong number : " + s;
		System.out.println(result);

		System.out.println("--------------------------------------------------");

		int number = 9474;
		String s1 = String.valueOf(number);
		int sum = 0;

		for (int i = 1; i <= s1.length(); i++) {
			int c = number % 10;
			int d = c;
			
			for (int j = 1; j <= ch.length - 1; j++) {
				d = d * c;
			}
			sum = sum + d;
			number = number / 10;

		}
		result = (num == a) ? "Armstrong number : " + s1 : "Not Armstrong number : " + s1;
		System.out.println(result);
	}
	
	
	
}
