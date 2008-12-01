package org.codelabor.system.dtos;

import java.io.File;
import java.io.Serializable;
import java.util.Map;

import javax.activation.FileTypeMap;
import javax.mail.internet.InternetAddress;

public class MailDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1384134034435785654L;

	private InternetAddress from;

	private InternetAddress replyTo;

	private InternetAddress[] to;

	private InternetAddress[] bcc;

	private InternetAddress[] cc;

	private String subject;

	private String text;

	private String encoding = "UTF-8";

	private boolean html = true;

	private boolean multipart = true;

	private FileTypeMap fileTypeMap;

	private File[] attachement;

	private Map<String, File> imageFileMap;

	public File[] getAttachement() {
		return attachement;
	}

	public void setAttachement(File[] attachement) {
		this.attachement = attachement;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public InternetAddress[] getBcc() {
		return bcc;
	}

	public void setBcc(InternetAddress[] bcc) {
		this.bcc = bcc;
	}

	public InternetAddress[] getCc() {
		return cc;
	}

	public void setCc(InternetAddress[] cc) {
		this.cc = cc;
	}

	public FileTypeMap getFileTypeMap() {
		return fileTypeMap;
	}

	public void setFileTypeMap(FileTypeMap fileTypeMap) {
		this.fileTypeMap = fileTypeMap;
	}

	public InternetAddress getFrom() {
		return from;
	}

	public void setFrom(InternetAddress from) {
		this.from = from;
	}

	public boolean isHtml() {
		return html;
	}

	public void setHtml(boolean html) {
		this.html = html;
	}

	public InternetAddress getReplyTo() {
		return replyTo;
	}

	public void setReplyTo(InternetAddress replyTo) {
		this.replyTo = replyTo;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public InternetAddress[] getTo() {
		return to;
	}

	public void setTo(InternetAddress[] to) {
		this.to = to;
	}

	public Map<String, File> getImageFileMap() {
		return imageFileMap;
	}

	public void setImageFileMap(Map<String, File> imageFileMap) {
		this.imageFileMap = imageFileMap;
	}

	public String getEncoding() {
		return encoding;
	}

	public void setEncoding(String encoding) {
		this.encoding = encoding;
	}

	public boolean isMultipart() {
		return multipart;
	}

	public void setMultipart(boolean multipart) {
		this.multipart = multipart;
	}

	/**
	 * Constructs a <code>String</code> with all attributes in name = value
	 * format.
	 * 
	 * @return a <code>String</code> representation of this object.
	 */
	@Override
	public String toString() {
		final String TAB = "    ";

		StringBuilder retValue = new StringBuilder();

		retValue.append("MailDTO ( ").append(super.toString()).append(TAB)
				.append("from = ").append(this.from.getAddress()).append(TAB)
				.append("replyTo = ").append(this.replyTo).append(TAB).append(
						"to = ").append(this.to).append(TAB).append("bcc = ")
				.append(this.bcc).append(TAB).append("cc = ").append(this.cc)
				.append(TAB).append("subject = ").append(this.subject).append(
						TAB).append("text = ").append(this.text).append(TAB)
				.append("encoding = ").append(this.encoding).append(TAB)
				.append("html = ").append(this.html).append(TAB).append(
						"multipart = ").append(this.multipart).append(TAB)
				.append("fileTypeMap = ").append(this.fileTypeMap).append(TAB)
				.append("attachement = ").append(this.attachement).append(TAB)
				.append("imageFileMap = ").append(this.imageFileMap)
				.append(TAB).append(" )");

		return retValue.toString();
	}
}
