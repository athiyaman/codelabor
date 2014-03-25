package org.codelabor.example.thread;

import java.util.Queue;

public class Consumer implements Runnable {

	private final Queue<String> queue;

	public void run() {
		for (int i=0; true; i++) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}			
			String item = queue.poll();
			StringBuilder stringBuilder = new StringBuilder();
			stringBuilder.append("consume: ").append(item);
			stringBuilder.append(", queue size: ").append(queue.size());
			System.out.println(stringBuilder.toString());
		}
	}

	public Consumer(Queue<String> queue) {
		super();
		this.queue = queue;
	}

}
