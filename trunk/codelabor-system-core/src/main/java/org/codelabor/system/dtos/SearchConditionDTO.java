package org.codelabor.system.dtos;

import java.io.Serializable;
import java.util.Date;

public class SearchConditionDTO implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 5397867402929461708L;
	private int pageIndex = 1;
	private Date fromDate;
	private Date toDate;

	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
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

		retValue.append("SearchConditionDTO ( ").append(super.toString())
				.append(TAB).append("fromDate = ").append(this.fromDate)
				.append(TAB).append("pageIndex = ").append(this.pageIndex)
				.append(TAB).append("toDate = ").append(this.toDate)
				.append(TAB).append(" )");

		return retValue.toString();
	}
}
