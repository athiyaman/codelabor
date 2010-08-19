package org.codelabor.example.swing.container;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class JFrameExample extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1175585618858605416L;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new JFrameExample();
	}
	
	public JFrameExample() {
		super("JFrame example");
		JButton button1 = new JButton("button1");
		JButton button2 = new JButton("button2");
		this.add(button1, BorderLayout.NORTH);
		this.add(button2, BorderLayout.CENTER);
		this.setSize(200, 200);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
