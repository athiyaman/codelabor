package org.codelabor.example.awt.event.listener;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionListener;
import java.awt.event.TextListener;

public class TextEventExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Label label = new Label("message");
		
		TextField textField = new TextField();
		textField.setColumns(10);
		
		Button button = new Button("send");
		button.setEnabled(false);
		
		TextArea textArea = new TextArea("", 5, 30, TextArea.SCROLLBARS_VERTICAL_ONLY);
		textArea.setEditable(false);
		
		TextListener textListener = new MyTextListener(textField, button);
		textField.addTextListener(textListener);
		
		ActionListener actionListener = new MyActionListener2(textField, textArea);
		button.addActionListener(actionListener);
		
		Panel inputPanel = new Panel();
		inputPanel.add(label);
		inputPanel.add(textField);
		inputPanel.add(button);
		
		Panel textAreaPanel = new Panel();
		textAreaPanel.setSize(100, 150);
		textAreaPanel.add(textArea);
		
		Frame frame = new Frame("text event example");
		frame.add(inputPanel, BorderLayout.NORTH);
		frame.add(textAreaPanel, BorderLayout.CENTER);
		frame.setBounds(0, 0, 300, 200);
		frame.setVisible(true);
	}

}
