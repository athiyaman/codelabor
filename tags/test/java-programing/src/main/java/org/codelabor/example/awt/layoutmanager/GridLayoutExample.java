package org.codelabor.example.awt.layoutmanager;

import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;

public class GridLayoutExample {

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
		frame.setTitle("grid layout example");
		frame.setSize(300, 150);
		frame.setLayout(new GridLayout(2, 3));
		frame.add(button1);
		frame.add(button2);
		frame.add(button3);
		frame.add(button4);
		frame.add(button5);
		frame.setVisible(true);
	}

}
