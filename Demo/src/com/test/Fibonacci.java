package com.test;

public class Fibonacci {

	public static void main(String[] args) {

		int a = 0, b = 1, c = 0, sum = 0;
		c = a + b;
		System.out.print(a + " " + b + " " + c+" ");
		
		for (int i = 1; i <= 10; i++) {
			sum = b + c;
			System.out.print(sum + " ");
			b = c;
			c = sum;
		}

	}

}
