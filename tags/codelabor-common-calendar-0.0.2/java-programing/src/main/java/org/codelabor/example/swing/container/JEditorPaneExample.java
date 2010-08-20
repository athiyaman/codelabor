package org.codelabor.example.swing.container;

import java.awt.Dimension;
import java.io.IOException;

import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

public class JEditorPaneExample extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1175585618858605416L;

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		new JEditorPaneExample();
	}
	
	public JEditorPaneExample() throws IOException {
		super("JEditorPane example");
		JEditorPane editorPane = new JEditorPane();
		editorPane.setEditable(false);
		editorPane.setPage("http://www.naver.com/");
		
		JScrollPane scrollPane = new JScrollPane(editorPane);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setPreferredSize(new Dimension(800, 600));
		
		this.add(scrollPane);
		this.pack();
		this.setLocation(300, 200);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
