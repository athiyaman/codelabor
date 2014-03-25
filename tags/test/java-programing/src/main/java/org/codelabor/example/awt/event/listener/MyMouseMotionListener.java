package org.codelabor.example.awt.event.listener;

import java.awt.TextArea;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class MyMouseMotionListener implements MouseMotionListener {

	private TextArea textArea;
	
	public MyMouseMotionListener(TextArea textArea) {
		this.textArea = textArea;
	}


	public void mouseDragged(MouseEvent e) {
		textArea.append("dragged");
		textArea.append(": ");
		textArea.append(e.getPoint().toString());
		textArea.append(System.getProperty("line.separator"));
	}

	public void mouseMoved(MouseEvent e) {
		textArea.append("moved");
		textArea.append(": ");
		textArea.append(e.getPoint().toString());
		textArea.append(System.getProperty("line.separator"));
		
	}

}
