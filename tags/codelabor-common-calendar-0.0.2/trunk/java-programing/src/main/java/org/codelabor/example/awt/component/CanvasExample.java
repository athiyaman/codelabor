package org.codelabor.example.awt.component;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;

public class CanvasExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MyCanvas myCanvas = new MyCanvas();
		myCanvas.setBackground(Color.GREEN);
		myCanvas.setSize(100, 100);
		
		Panel panel = new Panel();
		panel.add(myCanvas);
		
		Frame frame = new Frame();
		frame.setTitle("canvas exmple");
		frame.setSize(200, 150);
		frame.add(panel);
		frame.setVisible(true);
	}

}
