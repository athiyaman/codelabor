package org.codelabor.example.awt.event.listener;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class MyWindowListener implements WindowListener {
	public MyWindowListener() {
	}

	public void windowActivated(WindowEvent e) {
		System.out.println("activated");
	}

	public void windowClosed(WindowEvent e) {
		System.out.println("closed");
	}

	public void windowClosing(WindowEvent e) {
		System.out.println("closing");
		System.exit(0);
	}

	public void windowDeactivated(WindowEvent e) {
		System.out.println("deactivated");
	}

	public void windowDeiconified(WindowEvent e) {
		System.out.println("deiconified");
	}

	public void windowIconified(WindowEvent e) {
		System.out.println("iconified");
	}

	public void windowOpened(WindowEvent e) {
		System.out.println("opened");
	}

}
