package org.codelabor.example.awt.event.listener;

import java.awt.Button;
import java.awt.TextField;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;

public class MyTextListener implements TextListener {

	private TextField textField;
	private Button button;

	public MyTextListener(TextField textField, Button button) {
		this.textField = textField;
		this.button = button;
	}

	public void textValueChanged(TextEvent e) {
		if (textField.getText().equals("")) {
			button.setEnabled(false);
		} else {
			button.setEnabled(true);
		}
	}

}
