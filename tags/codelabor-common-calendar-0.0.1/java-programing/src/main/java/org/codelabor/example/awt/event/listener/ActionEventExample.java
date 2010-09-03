package org.codelabor.example.awt.event.listener;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.event.ActionListener;

public class ActionEventExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Button button1 = new Button("button1");
		Button button2 = new Button("button2");
		TextArea textArea = new TextArea("", 5, 30, TextArea.SCROLLBARS_VERTICAL_ONLY);
		
		ActionListener actionListener = new MyActionListener(textArea);
		button1.addActionListener(actionListener);
		button2.addActionListener(actionListener);
		
		Panel buttonPanel = new Panel();
		buttonPanel.add(button1);
		buttonPanel.add(button2);
		
		Panel textAreaPanel = new Panel();
		textAreaPanel.setSize(100, 150);
		textAreaPanel.add(textArea);
		
		Frame frame = new Frame("action event example");
		frame.add(buttonPanel, BorderLayout.NORTH);
		frame.add(textAreaPanel, BorderLayout.CENTER);
		frame.setBounds(0, 0, 300, 200);
		frame.setVisible(true);
	}

}
