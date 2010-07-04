package org.codelabor.example.awt.container;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;

public class PanelExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Frame frame = new Frame();
		frame.setTitle("panel example");
		frame.setSize(200, 150);
		
		Panel panel = new Panel();
		panel.setBackground(Color.blue);
		frame.add(panel);
		frame.setVisible(true);
	}

}
