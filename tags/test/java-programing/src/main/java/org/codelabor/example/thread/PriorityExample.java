package org.codelabor.example.thread;

public class PriorityExample implements Runnable  {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PriorityExample runnableExample1 = new PriorityExample();
		Thread thread1 = new Thread(runnableExample1);
		thread1.setPriority(Thread.MIN_PRIORITY);
		PriorityExample runnalbeExample2 = new PriorityExample();
		Thread thread2 = new Thread(runnalbeExample2);
		thread2.setPriority(Thread.MAX_PRIORITY);
		PriorityExample runnableExample3 = new PriorityExample();
		Thread thread3 = new Thread(runnableExample3);
		thread3.setPriority(Thread.NORM_PRIORITY);
		
		thread1.start();
		thread2.start();
		thread3.start();
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
