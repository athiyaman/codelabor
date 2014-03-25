package org.codelabor.example.awt.component;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

public class MyCanvas extends Canvas {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1568832864420071093L;

	public void paint(Graphics graphics) {
		graphics.setColor(Color.BLUE);
		graphics.drawRect(10, 10, 50, 50);
	}
}
