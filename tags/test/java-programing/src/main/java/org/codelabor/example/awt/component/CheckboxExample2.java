package org.codelabor.example.awt.component;

import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Frame;
import java.awt.Panel;

public class CheckboxExample2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CheckboxGroup checkboxGroup = new CheckboxGroup();
		
		Checkbox checkbox1 = new Checkbox("checkbox1", checkboxGroup, true);
		Checkbox checkbox2 = new Checkbox("checkbox2", checkboxGroup, false);
		Checkbox checkbox3 = new Checkbox("checkbox3", checkboxGroup, false);
		Checkbox checkbox4 = new Checkbox("checkbox4", checkboxGroup, false);
		
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
