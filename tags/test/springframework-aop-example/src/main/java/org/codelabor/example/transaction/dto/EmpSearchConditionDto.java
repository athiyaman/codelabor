package org.codelabor.example.transaction.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;

import org.codelabor.system.web.taglib.PaginationConstants;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.SafeHtml;
import org.hibernate.validator.constraints.SafeHtml.WhiteListType;

public class EmpSearchConditionDto implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = -8775262849710511736L;

	@Digits(integer = 7, fraction = 2)
	protected BigDecimal salFrom;

	@Digits(integer = 7, fraction = 2)
	protected BigDecimal salTo;

	@Min(1)
	protected Integer pageNo = 1;

	@Min(1)
	protected Integer maxRowPerPage = PaginationConstants.MAX_ROW_PER_PAGE;

	@Length(max = 9)
	@SafeHtml(whitelistType = WhiteListType.NONE)
	protected String job;

	/**
	 *
	 */
	public EmpSearchConditionDto() {
		super();
	}

	/**
	 * @param salFrom
	 * @param salTo
	 * @param pageNo
	 * @param maxRowPerPage
	 * @param job
	 */
	public EmpSearchConditionDto(BigDecimal salFrom, BigDecimal salTo,
			Integer pageNo, Integer maxRowPerPage, String job) {
		super();
		this.salFrom = salFrom;
		this.salTo = salTo;
		this.pageNo = pageNo;
		this.maxRowPerPage = maxRowPerPage;
		this.job = job;
	}

	/**
	 * @return the salFrom
	 */
	public BigDecimal getSalFrom() {
		return salFrom;
	}

	/**
	 * @param salFrom
	 *            the salFrom to set
	 */
	public void setSalFrom(BigDecimal salFrom) {
		this.salFrom = salFrom;
	}

	/**
	 * @return the salTo
	 */
	public BigDecimal getSalTo() {
		return salTo;
	}

	/**
	 * @param salTo
	 *            the salTo to set
	 */
	public void setSalTo(BigDecimal salTo) {
		this.salTo = salTo;
	}

	/**
	 * @return the pageNo
	 */
	public Integer getPageNo() {
		return pageNo;
	}

	/**
	 * @param pageNo
	 *            the pageNo to set
	 */
	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	/**
	 * @return the maxRowPerPage
	 */
	public Integer getMaxRowPerPage() {
		return maxRowPerPage;
	}

	/**
	 * @param maxRowPerPage
	 *            the maxRowPerPage to set
	 */
	public void setMaxRowPerPage(Integer maxRowPerPage) {
		this.maxRowPerPage = maxRowPerPage;
	}

	/**
	 * @return the job
	 */
	public String getJob() {
		return job;
	}

	/**
	 * @param job
	 *            the job to set
	 */
	public void setJob(String job) {
		this.job = job;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (prime * result) + ((job == null) ? 0 : job.hashCode());
		result = (prime * result)
				+ ((maxRowPerPage == null) ? 0 : maxRowPerPage.hashCode());
		result = (prime * result) + ((pageNo == null) ? 0 : pageNo.hashCode());
		result = (prime * result)
				+ ((salFrom == null) ? 0 : salFrom.hashCode());
		result = (prime * result) + ((salTo == null) ? 0 : salTo.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		EmpSearchConditionDto other = (EmpSearchConditionDto) obj;
		if (job == null) {
			if (other.job != null) {
				return false;
			}
		} else if (!job.equals(other.job)) {
			return false;
		}
		if (maxRowPerPage == null) {
			if (other.maxRowPerPage != null) {
				return false;
			}
		} else if (!maxRowPerPage.equals(other.maxRowPerPage)) {
			return false;
		}
		if (pageNo == null) {
			if (other.pageNo != null) {
				return false;
			}
		} else if (!pageNo.equals(other.pageNo)) {
			return false;
		}
		if (salFrom == null) {
			if (other.salFrom != null) {
				return false;
			}
		} else if (!salFrom.equals(other.salFrom)) {
			return false;
		}
		if (salTo == null) {
			if (other.salTo != null) {
				return false;
			}
		} else if (!salTo.equals(other.salTo)) {
			return false;
		}
		return true;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("EmpSearchConditionDto [salFrom=").append(salFrom)
				.append(", salTo=").append(salTo).append(", pageNo=")
				.append(pageNo).append(", maxRowPerPage=")
				.append(maxRowPerPage).append(", job=").append(job).append("]");
		return builder.toString();
	}

}
