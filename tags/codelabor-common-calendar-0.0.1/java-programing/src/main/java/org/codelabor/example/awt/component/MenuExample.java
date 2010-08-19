package org.codelabor.example.awt.component;

import java.awt.CheckboxMenuItem;
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;

public class MenuExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MenuItem menuItem1 = new MenuItem("menuItem1");
		MenuItem menuItem2 = new MenuItem("menuItem2");
		MenuItem menuItem3 = new MenuItem("menuItem3");
		MenuItem menuItem4 = new MenuItem("menuItem4");
		Menu menu1 = new Menu("menu1");
		menu1.add(menuItem1);
		menu1.add(menuItem2);
		menu1.add(menuItem3);
		menu1.add(menuItem4);
		
		CheckboxMenuItem checkboxMenuItem1 = new CheckboxMenuItem("checkboxMenuItem1");
		CheckboxMenuItem checkboxMenuItem2 = new CheckboxMenuItem("checkboxMenuItem2");
		CheckboxMenuItem checkboxMenuItem3 = new CheckboxMenuItem("checkboxMenuItem3");
		CheckboxMenuItem checkboxMenuItem4 = new CheckboxMenuItem("checkboxMenuItem4");
		Menu menu2 = new Menu("menu2");
		menu2.add(checkboxMenuItem1);
		menu2.add(checkboxMenuItem2);
		menu2.add(checkboxMenuItem3);
		menu2.add(checkboxMenuItem4);
		
		Menu menu3 = new Menu("menu3");
		Menu menu4 = new Menu("menu4");
		
		MenuBar menuBar = new MenuBar();
		menuBar.add(menu1);
		menuBar.add(menu2);
		menuBar.add(menu3);
		menuBar.add(menu4);
		
		Frame frame = new Frame();
		frame.setTitle("menu exmple");
		frame.setSize(300, 200);
		frame.setMenuBar(menuBar);
		frame.setVisible(true);
	}

}
