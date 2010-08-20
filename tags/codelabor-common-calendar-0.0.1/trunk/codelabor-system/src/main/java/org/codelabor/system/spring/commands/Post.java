package org.codelabor.system.spring.commands;

import org.codelabor.system.file.spring.commands.FileList;

public class Post extends FileList {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8992970774637965899L;
	private String subject;
	private String description;
	private String writer;

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
