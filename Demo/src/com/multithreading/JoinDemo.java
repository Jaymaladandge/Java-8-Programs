package com.multithreading;

public class JoinDemo implements Runnable {

	@Override
	public void run() {
		for (int i = 1; i <= 10; i++) {
			System.out.println(i + " " + Thread.currentThread().getName());
		}
	}

	public static void main(String[] args) {

		JoinDemo demo = new JoinDemo();
		Thread thread = new Thread(demo, "A");
		Thread thread1 = new Thread(demo, "B");
		
		thread.start();
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		thread1.start();
	}

}
