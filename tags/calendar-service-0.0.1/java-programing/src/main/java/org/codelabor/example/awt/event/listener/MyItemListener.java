package org.codelabor.example.awt.event.listener;

import java.awt.TextArea;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class MyItemListener implements ItemListener {

	private TextArea textArea;

	public MyItemListener(TextArea textArea) {
		this.textArea = textArea;
	}

	public void itemStateChanged(ItemEvent e) {
		this.textArea.append(e.getItem().toString());
		switch (e.getStateChange()) {
		case ItemEvent.SELECTED:
			this.textArea.append(" selected.");
			break;
		case ItemEvent.DESELECTED:
			this.textArea.append(" deselected.");
			break;
		}
		this.textArea.append(System.getProperty("line.separator"));
	}
}
