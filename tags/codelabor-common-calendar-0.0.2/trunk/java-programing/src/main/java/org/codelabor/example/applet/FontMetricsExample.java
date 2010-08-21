package org.codelabor.example.applet;

import java.applet.Applet;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

public class FontMetricsExample extends Applet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2799404011437259895L;
	private Font font;
	private FontMetrics fontMetrics;
	private String message;
	Dimension size;
	int x, y;
	
	public void init() {
		message = "Hello, World";
		font = new Font("impact", Font.BOLD, 30);
		fontMetrics = getFontMetrics(font);
		size= getSize();
		x = (size.width / 2) - (fontMetrics.stringWidth(message) / 2);
		y = (size.height / 2) - (fontMetrics.getDescent() / 2);}
	
	public void paint(Graphics graphics) {

		graphics.setFont(font);
		graphics.drawString(message, x, y);
	}
}
