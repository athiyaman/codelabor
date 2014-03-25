package org.codelabor.example.awt.event.listener;

import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.event.MouseListener;

public class MouseEventExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TextArea textArea = new TextArea("", 5, 30, TextArea.SCROLLBARS_VERTICAL_ONLY);
		MouseListener mouseListener = new MyMouseListener(textArea);
		textArea.addMouseListener(mouseListener);
		
		Panel textAreaPanel = new Panel();
		textAreaPanel.setSize(100, 150);
		textAreaPanel.add(textArea);
		
		Frame frame = new Frame("mouse event example");
		frame.add(textAreaPanel);
		frame.setBounds(0, 0, 300, 200);
		frame.setVisible(true);
	}

}
