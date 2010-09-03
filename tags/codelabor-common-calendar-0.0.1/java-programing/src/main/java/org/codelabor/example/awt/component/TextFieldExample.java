package org.codelabor.example.awt.component;

import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextField;

public class TextFieldExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TextField userIdField = new TextField("user id", 16);
		TextField passwordField = new TextField("password", 16);
		passwordField.setEchoChar('*');
		
		
		Panel panel = new Panel();
		panel.add(userIdField);
		panel.add(passwordField);
		
		Frame frame = new Frame();
		frame.setTitle("textfield exmple");
		frame.setSize(200, 150);
		frame.add(panel);
		frame.setVisible(true);
	}

}
