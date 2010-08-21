package org.codelabor.example.awt.layoutmanager;

import java.awt.Button;
import java.awt.CardLayout;
import java.awt.Frame;
import java.awt.Panel;

public class CardLayoutExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Button button1 = new Button("button1");
		Button button2 = new Button("button2");
		Button button3 = new Button("button3");
		Button button4 = new Button("button4");
		Button button5 = new Button("button5");
		Button button6 = new Button("button6");
		Button button7 = new Button("button7");
		Button button8 = new Button("button8");
		
		Panel panel1 = new Panel();
		panel1.add(button1);
		panel1.add(button2);
		Panel panel2 = new Panel();
		panel2.add(button3);
		panel2.add(button4);
		Panel panel3 = new Panel();
		panel3.add(button5);
		panel3.add(button6);
		Panel panel4 = new Panel();
		panel4.add(button7);
		panel4.add(button8);		
		
		CardLayout cardLayout = new CardLayout();
		
		Frame frame = new Frame();
		frame.setTitle("card layout example");
		frame.setSize(300, 150);
		frame.setLayout(cardLayout);
		frame.add("card1", panel1);
		frame.add("card2", panel2);
		frame.add("card3", panel3);
		frame.add("card4", panel4);
		frame.setVisible(true);
		
		while (true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			cardLayout.next(frame);
		}
	}

}
