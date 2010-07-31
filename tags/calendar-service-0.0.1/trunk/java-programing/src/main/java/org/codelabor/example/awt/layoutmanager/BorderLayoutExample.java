package org.codelabor.example.awt.layoutmanager;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;

public class BorderLayoutExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Button button1 = new Button("button1");
		Button button2 = new Button("button2");
		Button button3 = new Button("button3");
		Button button4 = new Button("button4");
		Button button5 = new Button("button5");
		
		Frame frame = new Frame();
		frame.setTitle("border layout example");
		frame.setSize(300, 150);
		frame.add(button1, BorderLayout.NORTH);
		frame.add(button2, BorderLayout.WEST);
		frame.add(button3, BorderLayout.EAST);
		frame.add(button4, BorderLayout.SOUTH);
		frame.add(button5, BorderLayout.CENTER);
		frame.setVisible(true);
	}

}
