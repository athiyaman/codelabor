package org.codelabor.example.thread;

public class RunnableExample implements Runnable  {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		RunnableExample runnableExample1 = new RunnableExample();
		Thread thread1 = new Thread(runnableExample1);
		RunnableExample runnalbeExample2 = new RunnableExample();
		Thread thread2 = new Thread(runnalbeExample2);
		RunnableExample runnableExample3 = new RunnableExample();
		Thread thread3 = new Thread(runnableExample3);
		
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
