package org.codelabor.example.awt.event.adapter;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyWindowAdapter extends WindowAdapter {

	@Override
	public void windowClosing(WindowEvent e) {
		super.windowClosing(e);
		System.out.println("closing");
		System.exit(0);
	}
}
