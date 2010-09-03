package org.codelabor.example.awt.container;

import java.awt.Dialog;
import java.awt.Frame;

public class DialogExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Frame frame = new Frame();
		frame.setTitle("button example");
		frame.setSize(200, 150);

		Dialog dialog = new Dialog(frame);
		dialog.setSize(50, 50);
		dialog.setVisible(true);
		frame.setVisible(true);
	}
}
