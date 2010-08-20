package org.codelabor.example.applet;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;

public class ImageExample extends Applet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1466240508290248069L;
	private Image image;
	
	public void init() {
		image = getImage(getDocumentBase(), "ksmiletris.png");
	}
	
	public void paint(Graphics graphics) {
		graphics.drawImage(image, 0, 0, this);
	}
}
