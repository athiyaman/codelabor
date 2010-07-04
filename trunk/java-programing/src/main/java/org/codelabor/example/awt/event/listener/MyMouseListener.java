package org.codelabor.example.awt.event.listener;

import java.awt.TextArea;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MyMouseListener implements MouseListener {

	private TextArea textArea;
	
	public MyMouseListener(TextArea textArea) {
		this.textArea = textArea;
	}

	public void mouseClicked(MouseEvent e) {
		textArea.append("clicked");
		textArea.append(System.getProperty("line.separator"));
	}

	public void mouseEntered(MouseEvent e) {
		textArea.append("entered");
		textArea.append(System.getProperty("line.separator"));
	}

	public void mouseExited(MouseEvent e) {
		textArea.append("exited");
		textArea.append(System.getProperty("line.separator"));	
	}

	public void mousePressed(MouseEvent e) {
		textArea.append("pressed");
		textArea.append(System.getProperty("line.separator"));
	}

	public void mouseReleased(MouseEvent e) {
		textArea.append("released");
		textArea.append(System.getProperty("line.separator"));
	}

}
