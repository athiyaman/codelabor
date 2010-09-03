package org.codelabor.example.awt.event.listener;

import java.awt.TextArea;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyKeyListener implements KeyListener {

	private TextArea textArea;
	
	public MyKeyListener(TextArea textArea) {
		this.textArea = textArea;
	}

	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
			case KeyEvent.VK_UP:
				textArea.append("up");
				textArea.append(System.getProperty("line.separator"));
				break;
			case KeyEvent.VK_DOWN:
				textArea.append("down");
				textArea.append(System.getProperty("line.separator"));
				break;
			case KeyEvent.VK_LEFT:
				textArea.append("left");
				textArea.append(System.getProperty("line.separator"));
				break;
			case KeyEvent.VK_RIGHT:
				textArea.append("right");
				textArea.append(System.getProperty("line.separator"));
				break;
		}
	}

	public void keyReleased(KeyEvent e) {
	}

	public void keyTyped(KeyEvent e) {
	}
}
