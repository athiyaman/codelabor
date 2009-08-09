package org.codelabor.example.emp.dtos;

import java.util.Date;

public class SearchConditionDTO extends EmpDTO {
	/**
	 *
	 */
	private static final long serialVersionUID = -6044818297184197414L;

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
}
