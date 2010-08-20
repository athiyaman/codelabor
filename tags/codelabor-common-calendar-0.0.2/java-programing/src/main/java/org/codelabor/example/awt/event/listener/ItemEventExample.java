package org.codelabor.example.awt.event.listener;

import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.event.ItemListener;

public class ItemEventExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Checkbox checkbox1 = new Checkbox("checkbox1", false);
		Checkbox checkbox2 = new Checkbox("checkbox2", false);
		Checkbox checkbox3 = new Checkbox("checkbox3", false);
		Checkbox checkbox4 = new Checkbox("checkbox4", false);
		
		TextArea textArea = new TextArea("", 5, 30, TextArea.SCROLLBARS_VERTICAL_ONLY);
		
		ItemListener itemListener = new MyItemListener(textArea);
		checkbox1.addItemListener(itemListener);
		checkbox2.addItemListener(itemListener);
		checkbox3.addItemListener(itemListener);
		checkbox4.addItemListener(itemListener);
		
		Panel checkboxPanel = new Panel();
		checkboxPanel.add(checkbox1);
		checkboxPanel.add(checkbox2);
		checkboxPanel.add(checkbox3);
		checkboxPanel.add(checkbox4);
		
		Panel textAreaPanel = new Panel();
		textAreaPanel.setSize(100, 150);
		textAreaPanel.add(textArea);
		
		Frame frame = new Frame("item event example");
		frame.add(checkboxPanel, BorderLayout.NORTH);
		frame.add(textAreaPanel, BorderLayout.CENTER);
		frame.setBounds(0, 0, 300, 200);
		frame.setVisible(true);
	}

}
