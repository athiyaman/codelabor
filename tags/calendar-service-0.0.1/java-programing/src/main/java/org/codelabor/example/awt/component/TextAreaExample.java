package org.codelabor.example.awt.component;

import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;

public class TextAreaExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TextArea textArea = new TextArea("default", 5, 30, TextArea.SCROLLBARS_VERTICAL_ONLY);
		
		Panel panel = new Panel();
		panel.add(textArea);
		
		Frame frame = new Frame();
		frame.setTitle("textfield exmple");
		frame.setSize(300, 200);
		frame.add(panel);
		frame.setVisible(true);
	}

}
