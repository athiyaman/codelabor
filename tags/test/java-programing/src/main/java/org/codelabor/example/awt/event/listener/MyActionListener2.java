package org.codelabor.example.awt.event.listener;

import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyActionListener2 implements ActionListener {

	private TextField textField;
	private TextArea textArea;

	public MyActionListener2(TextField textField, TextArea textArea) {
		this.textField = textField;
		this.textArea = textArea;
	}

	public void actionPerformed(ActionEvent e) {
		this.textArea.append(textField.getText());
		this.textArea.append(System.getProperty("line.separator"));		
		this.textField.setText("");
		this.textField.requestFocus();
	}

}
