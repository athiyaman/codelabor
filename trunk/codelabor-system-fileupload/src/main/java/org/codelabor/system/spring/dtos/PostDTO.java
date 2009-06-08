package org.codelabor.system.spring.dtos;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class PostDTO {
	private String subject;
	private String description;
	private String writer;
	private List<MultipartFile> file = new ArrayList<MultipartFile>();

	public List<MultipartFile> getFile() {
		return file;
	}

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

	public void setFile(List<MultipartFile> file) {
		this.file = file;
	}

}
