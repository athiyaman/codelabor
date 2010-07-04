package org.codelabor.example.awt.component;

import java.awt.Checkbox;
import java.awt.Frame;
import java.awt.Panel;

public class CheckboxExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Checkbox checkbox1 = new Checkbox("checkbox1", true);
		Checkbox checkbox2 = new Checkbox("checkbox2");
		Checkbox checkbox3 = new Checkbox("checkbox3");
		Checkbox checkbox4 = new Checkbox("checkbox4");
		
		Panel panel = new Panel();
		panel.add(checkbox1);
		panel.add(checkbox2);
		panel.add(checkbox3);
		panel.add(checkbox4);
		
		Frame frame = new Frame();
		frame.setTitle("checkbox exmple");
		frame.setSize(200, 150);
		frame.add(panel);
		frame.setVisible(true);
	}

}
