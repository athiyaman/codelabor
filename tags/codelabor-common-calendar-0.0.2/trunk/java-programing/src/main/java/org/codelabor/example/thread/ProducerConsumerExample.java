package org.codelabor.example.thread;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class ProducerConsumerExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Queue<String> queue = new LinkedBlockingQueue<String>();
		Producer producer = new Producer(queue);
		Consumer consumer = new Consumer(queue);
		
		Thread producerThread = new Thread(producer);
		Thread consumerThread = new Thread(consumer);
		
		producerThread.start();
		consumerThread.start();
	}

}
