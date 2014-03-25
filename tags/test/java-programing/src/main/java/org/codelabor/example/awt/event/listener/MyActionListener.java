package org.codelabor.example.awt.event.listener;

import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyActionListener implements ActionListener {

	private TextArea textArea;

	public MyActionListener(TextArea textArea) {
		this.textArea = textArea;
	}

	public void actionPerformed(ActionEvent e) {
		String actionCommand = e.getActionCommand();
		this.textArea.append(actionCommand);
		this.textArea.append(System.getProperty("line.separator"));
	}

}
