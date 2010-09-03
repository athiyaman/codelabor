package org.codelabor.example.swing.container;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;

public class JTextPaneExample extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1175585618858605416L;

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		new JTextPaneExample();
	}
	
	public JTextPaneExample() throws Exception {
		super("JTextPane example");
		JTextPane textPane = createTextPane();
		JScrollPane scrollPane = new JScrollPane(textPane);
		scrollPane.setPreferredSize(new Dimension(250, 250));
		this.add(scrollPane);
		this.pack();
		this.setLocation(300, 200);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private JTextPane createTextPane() throws Exception {
		JTextPane textPane = new JTextPane();
		StyledDocument styledDocument = textPane.getStyledDocument();
		this.addStylesToDocument(styledDocument);
		styledDocument.insertString(styledDocument.getLength(), "일반체입니다.\n", styledDocument.getStyle("regular"));
		styledDocument.insertString(styledDocument.getLength(), "이탤릭입니다.\n", styledDocument.getStyle("italic"));
		styledDocument.insertString(styledDocument.getLength(), "볼드체입니다.\n", styledDocument.getStyle("bold"));
		return textPane;
	}

	private void addStylesToDocument(StyledDocument styledDocument) {
		Style style = StyleContext.getDefaultStyleContext().getStyle(StyleContext.DEFAULT_STYLE);
		
		Style regular = styledDocument.addStyle("regular", style);
		StyleConstants.setFontFamily(style, "SansSerif");
		
		Style italic = styledDocument.addStyle("italic", regular);
		StyleConstants.setItalic(italic, true);
		
		Style bold = styledDocument.addStyle("bold", regular);
		StyleConstants.setBold(bold, true);
	}

}
