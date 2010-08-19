package org.codelabor.example.awt.component;

import java.awt.Color;
import java.awt.Label;
import java.awt.Frame;
import java.awt.Panel;

public class LabelExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Label label1 = new Label("label1");
		Label label2 = new Label("label2", Label.LEFT);
		Label label3 = new Label("label3", Label.CENTER);
		Label label4 = new Label("label4", Label.RIGHT);
		
		label1.setBackground(Color.GRAY);
		label2.setBackground(Color.GRAY);
		label3.setBackground(Color.GRAY);
		label4.setBackground(Color.GRAY);
		
		Panel panel = new Panel();
		panel.add(label1);
		panel.add(label2);
		panel.add(label3);
		panel.add(label4);
		
		Frame frame = new Frame();
		frame.setTitle("label exmple");
		frame.setSize(200, 150);
		frame.add(panel);
		frame.setVisible(true);
	}

}
