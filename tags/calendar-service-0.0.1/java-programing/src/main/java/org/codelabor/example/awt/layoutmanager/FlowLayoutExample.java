package org.codelabor.example.awt.layoutmanager;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;

public class FlowLayoutExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Button button1 = new Button("button1");
		Button button2 = new Button("button2");
		Button button3 = new Button("button3");
		Button button4 = new Button("button4");
		Button button5 = new Button("button5");
		Button button6 = new Button("button6");
		Button button7 = new Button("button7");
		Button button8 = new Button("button8");
		Button button9 = new Button("button9");
		
		
		Panel panel = new Panel();
		panel.add(button1);
		panel.add(button2);
		panel.add(button3);
		panel.add(button4);
		panel.add(button5);
		panel.add(button6);
		panel.add(button7);
		panel.add(button8);
		panel.add(button9);
		
		Frame frame = new Frame();
		frame.setTitle("flow layout example");
		frame.setSize(300, 150);
		frame.add(panel);
		frame.setVisible(true);
	}

}
