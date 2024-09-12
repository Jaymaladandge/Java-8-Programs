package com.multithreading;

public class YieldDemo extends Thread {

	public void run() {
		for (int i = 1; i <= 5; i++) {
			Thread.yield();
			System.out.println("child");
		}
	}

	public static void main(String[] args) {

		YieldDemo thread = new YieldDemo();
		thread.start();
		
		for (int i = 0; i < 5; i++) {
			System.out.println("main");
		}
	}
}
