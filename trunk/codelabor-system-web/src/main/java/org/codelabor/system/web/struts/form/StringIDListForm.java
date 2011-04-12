package org.codelabor.system.web.struts.form;

import java.io.Serializable;
import java.util.List;

/**
 * String 타입의 ID List
 * 
 * @author Shin Sang-jae
 * 
 */
public class StringIDListForm implements Serializable {
	/**
	 * 시리얼 버전 UID
	 */
	private static final long serialVersionUID = -2901651626902956583L;
	/**
	 * Id List
	 */
	private List<String> id;

	/**
	 * Id를 가져온다.
	 * 
	 * @return Id
	 */
	public List<String> getId() {
		return id;
	}

	/**
	 * Id를 설정한다.
	 * 
	 * @param id
	 *            Id
	 */
	public void setId(List<String> id) {
		this.id = id;
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

		retValue.append("StringIDListForm ( ").append(super.toString()).append(
				TAB).append("id = ").append(this.id).append(TAB).append(" )");

		return retValue.toString();
	}
}
