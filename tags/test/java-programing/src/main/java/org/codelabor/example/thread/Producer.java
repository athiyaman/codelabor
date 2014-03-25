package org.codelabor.example.thread;

import java.util.Queue;

public class Producer implements Runnable {

	private final Queue<String> queue;

	public void run() {
		for (int i=0; true; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			StringBuilder stringBuilder = new StringBuilder();
			stringBuilder.append("item").append(i);
			String item = stringBuilder.toString();
			queue.offer(item);
			
			stringBuilder = new StringBuilder();
			stringBuilder.append("produce: ").append(item);
			stringBuilder.append(", queue size: ").append(queue.size());
			System.out.println(stringBuilder.toString());
		}
	}

	public Producer(Queue<String> queue) {
		super();
		this.queue = queue;
	}

}
