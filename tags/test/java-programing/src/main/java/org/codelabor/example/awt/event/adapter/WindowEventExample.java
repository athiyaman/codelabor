package org.codelabor.example.awt.event.adapter;

import java.awt.Frame;
import java.awt.event.WindowAdapter;

public class WindowEventExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		WindowAdapter windowAdapter = new MyWindowAdapter();
		
		Frame frame = new Frame("window event example");
		frame.addWindowListener(windowAdapter);
		frame.setBounds(0, 0, 300, 200);
		frame.setVisible(true);
	}

}
