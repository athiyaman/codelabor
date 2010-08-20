package org.codelabor.example.thread;

public class ThreadExample extends Thread {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ThreadExample threadExample1 = new ThreadExample();
		ThreadExample threadExample2 = new ThreadExample();
		ThreadExample threadExample3 = new ThreadExample();
		
		threadExample2.start();
		threadExample1.start();
		threadExample3.start();
	}
	
	public void run() {
		for (int i=0; i<50; i++) {
    		StringBuilder stringBuilder = new StringBuilder();
    		stringBuilder.append("thread: ").append(Thread.currentThread().getName());
    		stringBuilder.append(", priority: ").append(Thread.currentThread().getPriority());
    		stringBuilder.append(", count: ").append(i);
    		System.out.println(stringBuilder.toString());
    	}
	}
}
