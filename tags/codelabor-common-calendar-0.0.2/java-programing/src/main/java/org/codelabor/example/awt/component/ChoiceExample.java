package org.codelabor.example.awt.component;

import java.awt.Choice;
import java.awt.Frame;
import java.awt.Panel;

public class ChoiceExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Choice choice = new Choice();
		choice.addItem("item1");
		choice.addItem("item2");
		choice.addItem("item3");
		choice.addItem("item4");
		
		Panel panel = new Panel();
		panel.add(choice);
		
		Frame frame = new Frame();
		frame.setTitle("choice exmple");
		frame.setSize(200, 150);
		frame.add(panel);
		frame.setVisible(true);
	}

}
