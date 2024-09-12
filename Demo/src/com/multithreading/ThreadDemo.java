package com.multithreading;

public class ThreadDemo implements Runnable{

	@Override
	public void run() {
		
		for(int i=1; i<=5;i++) {
			if(Thread.currentThread().getName().equals("A")) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println(i +" "+Thread.currentThread().getName());
		}
	}

	public static void main(String[] args) {
		
		ThreadDemo demo = new ThreadDemo();
		Thread t1 =new Thread(demo,"A");
		Thread t2 =new Thread(demo,"B");
		t1.start();
		t2.start();
	}
}
