package org.codelabor.example.awt.component;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;

public class ButtonExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Button button1 = new Button("button1");
		Button button2 = new Button("button2");
		Button button3 = new Button("button3");
		Button button4 = new Button("button4");
		
		Panel panel = new Panel();
		panel.add(button1);
		panel.add(button2);
		panel.add(button3);
		panel.add(button4);
		
		Frame frame = new Frame();
		frame.setTitle("panel example");
		frame.setSize(200, 150);
		frame.add(panel);
		frame.setVisible(true);
	}
}
