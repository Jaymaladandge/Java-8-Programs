package com.test;

public class Factorial {

	public static void main(String[] args) {

		int num = 7;

		for (int i = num - 1; i > 0; i--) {
			num = num * i;
		}
		System.out.println("num : " + num);
	}
}
