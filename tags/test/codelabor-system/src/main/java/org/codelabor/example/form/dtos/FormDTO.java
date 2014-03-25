package org.codelabor.example.form.dtos;

import java.io.Serializable;

public class FormDTO implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 2455688651838489079L;
	private String[] checkboxItems;

	public String[] getCheckboxItems() {
		return checkboxItems;
	}

	public void setCheckboxItems(String[] checkboxItems) {
		this.checkboxItems = checkboxItems;
	}
}
