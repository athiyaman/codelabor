package org.codelabor.example.applet;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;

public class AppletExample extends Applet implements ActionListener, TextListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8168824117968858474L;
	
	private Label label = new Label("message");
	private TextField textField = new TextField();
	private Button button = new Button("send");
	private TextArea textArea = new TextArea("", 5, 30, TextArea.SCROLLBARS_VERTICAL_ONLY);
	
	public void init() {
		textField.setColumns(10);
		textField.addTextListener(this);
		button.setEnabled(false);
		button.addActionListener(this);
		textArea.setEditable(false);
		
		Panel inputPanel = new Panel();
		inputPanel.add(label);
		inputPanel.add(textField);
		inputPanel.add(button);
		
		Panel textAreaPanel = new Panel();
		textAreaPanel.setSize(100, 150);
		textAreaPanel.add(textArea);
		
		this.setLayout(new BorderLayout());
		this.add(inputPanel, BorderLayout.NORTH);
		this.add(textAreaPanel, BorderLayout.CENTER);
		this.setSize(300, 200);
	}

	public void actionPerformed(ActionEvent e) {
		this.textArea.append(textField.getText());
		this.textArea.append(System.getProperty("line.separator"));		
		this.textField.setText("");
		this.textField.requestFocus();
	}

	public void textValueChanged(TextEvent e) {
		if (textField.getText().equals("")) {
			this.button.setEnabled(false);
		} else {
			this.button.setEnabled(true);
		}
	}
}
