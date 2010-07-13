package org.codelabor.example.awt.layoutmanager;

import java.awt.Button;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

public class GridBagLayoutExample {

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
		
		GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
		gridBagConstraints1.gridx = 0;
		gridBagConstraints1.gridy = 0;
		gridBagConstraints1.gridwidth = 2;
		gridBagConstraints1.gridheight = 1;
		gridBagConstraints1.fill = GridBagConstraints.BOTH;
		GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
		gridBagConstraints2.gridx = 2;
		gridBagConstraints2.gridy = 0;
		gridBagConstraints2.gridwidth = 1;
		gridBagConstraints2.gridheight = 1;
		gridBagConstraints2.fill = GridBagConstraints.BOTH;
		GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
		gridBagConstraints3.gridx = 0;
		gridBagConstraints3.gridy = 1;
		gridBagConstraints3.gridwidth = 3;
		gridBagConstraints3.gridheight = 1;
		gridBagConstraints3.fill = GridBagConstraints.BOTH;
		GridBagConstraints gridBagConstraints4 = new GridBagConstraints();
		gridBagConstraints4.gridx = 0;
		gridBagConstraints4.gridy = 2;
		gridBagConstraints4.gridwidth = 1;
		gridBagConstraints4.gridheight = 2;
		gridBagConstraints4.fill = GridBagConstraints.BOTH;
		GridBagConstraints gridBagConstraints5 = new GridBagConstraints();
		gridBagConstraints5.gridx = 1;
		gridBagConstraints5.gridy = 2;
		gridBagConstraints5.gridwidth = 2;
		gridBagConstraints5.gridheight = 1;
		gridBagConstraints5.fill = GridBagConstraints.BOTH;
		GridBagConstraints gridBagConstraints6 = new GridBagConstraints();
		gridBagConstraints6.gridx = 1;
		gridBagConstraints6.gridy = 3;
		gridBagConstraints6.gridwidth = 2;
		gridBagConstraints6.gridheight = 1;
		gridBagConstraints6.fill = GridBagConstraints.BOTH;
		
		Frame frame = new Frame();
		frame.setTitle("gridbag layout example");
		frame.setSize(300, 150);
		frame.setLayout(new GridBagLayout());
		frame.add(button1, gridBagConstraints1);
		frame.add(button2, gridBagConstraints2);
		frame.add(button3, gridBagConstraints3);
		frame.add(button4, gridBagConstraints4);
		frame.add(button5, gridBagConstraints5);
		frame.add(button6, gridBagConstraints6);
		frame.setVisible(true);
	}

}
