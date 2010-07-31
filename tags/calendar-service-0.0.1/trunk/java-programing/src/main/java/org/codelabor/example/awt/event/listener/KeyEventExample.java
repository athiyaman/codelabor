package org.codelabor.example.awt.event.listener;

import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.event.KeyListener;

public class KeyEventExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TextArea textArea = new TextArea("", 5, 30, TextArea.SCROLLBARS_VERTICAL_ONLY);
		KeyListener keyListener = new MyKeyListener(textArea);
		textArea.addKeyListener(keyListener);
		
		Panel textAreaPanel = new Panel();
		textAreaPanel.setSize(100, 150);
		textAreaPanel.add(textArea);
		
		Frame frame = new Frame("key event example");
		frame.add(textAreaPanel);
		frame.setBounds(0, 0, 300, 200);
		frame.setVisible(true);
	}

}
