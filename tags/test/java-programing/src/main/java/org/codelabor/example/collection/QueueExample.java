package org.codelabor.example.collection;

import java.util.LinkedList;
import java.util.Queue;

public class QueueExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Queue<String> queue = new LinkedList<String>();
		queue.offer("item1");
		queue.offer("item2");
		queue.offer("item3");
		
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		System.out.println(queue.poll());
	}

}
