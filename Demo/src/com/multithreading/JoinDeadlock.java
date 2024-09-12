package com.multithreading;

public class JoinDeadlock extends Thread {

	static Thread mt;

	public void run() {

		try {
			mt.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		for (int i = 1; i <= 10; i++) {
			System.out.println(i + " " + Thread.currentThread().getName());
		}
	}

	public static void main(String[] args) {

		mt = Thread.currentThread();
		JoinDeadlock demo = new JoinDeadlock();
		demo.start();
		
		try {
			demo.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		for (int i = 1; i <= 10; i++) {
			System.out.println(i + " " + Thread.currentThread().getName());
		}
	}
}
