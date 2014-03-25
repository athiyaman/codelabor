package org.codelabor.example.awt.component;

import java.awt.List;
import java.awt.Frame;
import java.awt.Panel;

public class ListExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List list = new List(3, true);
		
		list.add("item1");
		list.add("item2");
		list.add("item3");
		list.add("item4");
		
		Panel panel = new Panel();
		panel.add(list);
		
		Frame frame = new Frame();
		frame.setTitle("list exmple");
		frame.setSize(200, 150);
		frame.add(panel);
		frame.setVisible(true);
	}

}
