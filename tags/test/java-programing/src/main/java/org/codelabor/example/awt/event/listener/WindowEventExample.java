package org.codelabor.example.awt.event.listener;

import java.awt.Frame;
import java.awt.event.WindowListener;

public class WindowEventExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		WindowListener windowListener = new MyWindowListener();
		
		Frame frame = new Frame("window event example");
		frame.addWindowListener(windowListener);
		frame.setBounds(0, 0, 300, 200);
		frame.setVisible(true);
	}

}
