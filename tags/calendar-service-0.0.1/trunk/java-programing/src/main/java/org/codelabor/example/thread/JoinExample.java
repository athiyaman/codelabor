package org.codelabor.example.thread;

public class JoinExample implements Runnable  {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		JoinExample runnableExample1 = new JoinExample();
		Thread thread1 = new Thread(runnableExample1);
		
		thread1.start();
		
		try {
			thread1.join();
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		for (int i=0; i<50; i++) {
    		StringBuilder stringBuilder = new StringBuilder();
    		stringBuilder.append("thread: ").append(Thread.currentThread().getName());
    		stringBuilder.append(", priority: ").append(Thread.currentThread().getPriority());
    		stringBuilder.append(", count: ").append(i);
    		System.out.println(stringBuilder.toString());
    	}		
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
