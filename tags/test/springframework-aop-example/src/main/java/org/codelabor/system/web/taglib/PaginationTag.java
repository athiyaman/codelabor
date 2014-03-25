/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.codelabor.system.web.taglib;

import java.io.IOException;
import java.io.StringWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Sang Jae Shin
 * 
 */
public class PaginationTag extends SimpleTagSupport {

	private final static Logger logger = LoggerFactory
			.getLogger(PaginationTag.class);

	protected String cssClass;
	private String queryString;
	protected Integer numberOfRow = 0;
	protected String pageNoParamName = PaginationConstants.PAGE_NO_PARAM_NAME;
	protected String maxRowPerPageParamName = PaginationConstants.MAX_ROW_PER_PAGE_PARAM_NAME;
	protected Integer maxRowPerPage = PaginationConstants.MAX_ROW_PER_PAGE;
	protected Integer maxIndexPerPage = PaginationConstants.MAX_INDEX_PER_PAGE;

	private int firstPageNoOnFirstIndex;
	private int firstPageNoOnPreviousIndex;
	private int firstPageNoOnCurrentIndex;
	private int lastPageNoOnCurrentIndex;
	private int firstPageNoOnNextIndex;
	private int lastPageNoOnLastIndex;
	private int lastPageNo;
	private int currentPageNo;

	protected String onclick;

	/**
	 *
	 */
	public PaginationTag() {
		// TODO Auto-generated constructor stub
	}

	protected String replacePageNoInQueryString(String queryString, int pageNo,
			int maxRowPerPage) {
		String replacedQueryString = null;
		if (!StringUtils.isBlank(queryString)) {
			if (StringUtils.contains(queryString, pageNoParamName)) {
				StringBuilder sb = new StringBuilder();
				sb.append(pageNoParamName).append("=[0-9]*");
				Pattern pattern = Pattern.compile(sb.toString());
				Matcher matcher = pattern.matcher(queryString);
				sb.setLength(0);
				sb.trimToSize();
				sb.append(pageNoParamName).append("=").append(pageNo);
				replacedQueryString = matcher.replaceAll(sb.toString());
			} else {
				StringBuilder sb = new StringBuilder();
				sb.append(pageNoParamName).append("=").append(pageNo);
				sb.append("&");
				sb.append(maxRowPerPageParamName).append("=")
						.append(maxRowPerPage);
				sb.append("&");
				sb.append(queryString);
				replacedQueryString = sb.toString();
			}
		} else {
			StringBuilder sb = new StringBuilder();
			sb.append(pageNoParamName).append("=").append(pageNo);
			sb.append("&");
			sb.append(maxRowPerPageParamName).append("=").append(maxRowPerPage);
			replacedQueryString = sb.toString();
		}
		return replacedQueryString;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.jsp.tagext.SimpleTagSupport#doTag()
	 */
	@Override
	public void doTag() throws JspException, IOException {
		logger.debug("doTag");

		// if numberOfRow is 0, do nothing
		if (numberOfRow == 0) {
			return;
		}

		PageContext context = (PageContext) this.getJspContext();
		HttpServletRequest request = (HttpServletRequest) context.getRequest();
		JspWriter out = context.getOut();

		// queryString
		queryString = request.getQueryString();

		// max row per page
		String maxRowPerPageString = request
				.getParameter(maxRowPerPageParamName);
		if (!StringUtils.isBlank(maxRowPerPageString)) {
			maxRowPerPage = Integer.parseInt(maxRowPerPageString);
		}

		// total count
		int totalPageCount = (int) Math.ceil((double) numberOfRow
				/ (double) maxRowPerPage);

		// page number
		int firstPageNo = 1;
		lastPageNo = totalPageCount;
		currentPageNo = 1;
		String pageNoString = request.getParameter(pageNoParamName);
		if (!StringUtils.isBlank(pageNoString)) {
			currentPageNo = Integer.parseInt(pageNoString);
		}

		// validation
		if (currentPageNo > lastPageNo) {
			StringBuilder sb = new StringBuilder();
			sb.append(pageNoParamName).append(" is exeeded.");
			sb.append(" (");
			sb.append("requested page number: ").append(currentPageNo)
					.append(", ");
			sb.append("last page number: ").append(lastPageNo).append(")");
			throw new JspException(sb.toString());
		}

		// current index
		lastPageNoOnCurrentIndex = ((int) Math.ceil((double) currentPageNo
				/ (double) maxIndexPerPage))
				* maxIndexPerPage;
		firstPageNoOnCurrentIndex = (lastPageNoOnCurrentIndex - maxIndexPerPage) + 1;

		// compensate page number
		if (lastPageNoOnCurrentIndex > lastPageNo) {
			lastPageNoOnCurrentIndex = lastPageNo;
		}

		// first page number on previous, next index
		firstPageNoOnPreviousIndex = firstPageNoOnCurrentIndex
				- maxIndexPerPage;
		firstPageNoOnNextIndex = lastPageNoOnCurrentIndex + 1;

		// compensate page number
		if (firstPageNoOnPreviousIndex < firstPageNo) {
			firstPageNoOnPreviousIndex = firstPageNo;
		}
		if (firstPageNoOnNextIndex > lastPageNo) {
			firstPageNoOnNextIndex = lastPageNo;
		}

		// first page number of first index
		firstPageNoOnFirstIndex = firstPageNo;

		// last page number of last index
		lastPageNoOnLastIndex = ((int) Math.ceil((double) numberOfRow
				/ (double) maxRowPerPage));

		// debug
		logger.debug("queryString: {}", queryString);
		logger.debug("numberOfRow: {}", numberOfRow);
		logger.debug("totalPageCount: {}", totalPageCount);
		logger.debug("firstPageNo: {}", firstPageNo);
		logger.debug("lastPageNo: {}", lastPageNo);

		// write html tag
		StringBuilder sb = new StringBuilder();
		StringWriter sw = new StringWriter();
		sb.append("<div");
		if (!StringUtils.isBlank(cssClass)) {
			sb.append(" class=\"").append(cssClass).append("\"");
		}
		sb.append(" />");
		getJspBody().invoke(sw);
		sb.append(sw.getBuffer());
		sb.append("</ div>");
		out.print(sb.toString());
	}

	/**
	 * @return the numberOfRow
	 */
	public Integer getNumberOfRow() {
		return numberOfRow;
	}

	/**
	 * @param numberOfRow
	 *            the numberOfRow to set
	 */
	public void setNumberOfRow(Integer numberOfRow) {
		this.numberOfRow = numberOfRow;
	}

	/**
	 * @return the pageNoParamName
	 */
	public String getPageNoParamName() {
		return pageNoParamName;
	}

	/**
	 * @param pageNoParamName
	 *            the pageNoParamName to set
	 */
	public void setPageNoParamName(String pageNoParamName) {
		this.pageNoParamName = pageNoParamName;
	}

	/**
	 * @return the maxRowPerPageParamName
	 */
	public String getMaxRowPerPageParamName() {
		return maxRowPerPageParamName;
	}

	/**
	 * @param maxRowPerPageParamName
	 *            the maxRowPerPageParamName to set
	 */
	public void setMaxRowPerPageParamName(String maxRowPerPageParamName) {
		this.maxRowPerPageParamName = maxRowPerPageParamName;
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
	 * @return the maxIndexPerPage
	 */
	public Integer getMaxIndexPerPage() {
		return maxIndexPerPage;
	}

	/**
	 * @param maxIndexPerPage
	 *            the maxIndexPerPage to set
	 */
	public void setMaxIndexPerPage(Integer maxIndexPerPage) {
		this.maxIndexPerPage = maxIndexPerPage;
	}

	/**
	 * @return the firstPageNoOnFirstIndex
	 */
	public int getFirstPageNoOnFirstIndex() {
		return firstPageNoOnFirstIndex;
	}

	/**
	 * @param firstPageNoOnFirstIndex
	 *            the firstPageNoOnFirstIndex to set
	 */
	public void setFirstPageNoOnFirstIndex(int firstPageNoOnFirstIndex) {
		this.firstPageNoOnFirstIndex = firstPageNoOnFirstIndex;
	}

	/**
	 * @return the lastPageNoOnLastIndex
	 */
	public int getLastPageNoOnLastIndex() {
		return lastPageNoOnLastIndex;
	}

	/**
	 * @param lastPageNoOnLastIndex
	 *            the lastPageNoOnLastIndex to set
	 */
	public void setLastPageNoOnLastIndex(int lastPageNoOnLastIndex) {
		this.lastPageNoOnLastIndex = lastPageNoOnLastIndex;
	}

	/**
	 * @return the queryString
	 */
	public String getQueryString() {
		return queryString;
	}

	/**
	 * @param queryString
	 *            the queryString to set
	 */
	public void setQueryString(String queryString) {
		this.queryString = queryString;
	}

	/**
	 * @return the firstPageNoOnPreviousIndex
	 */
	public int getFirstPageNoOnPreviousIndex() {
		return firstPageNoOnPreviousIndex;
	}

	/**
	 * @param firstPageNoOnPreviousIndex
	 *            the firstPageNoOnPreviousIndex to set
	 */
	public void setFirstPageNoOnPreviousIndex(int firstPageNoOnPreviousIndex) {
		this.firstPageNoOnPreviousIndex = firstPageNoOnPreviousIndex;
	}

	/**
	 * @return the firstPageNoOnCurrentIndex
	 */
	public int getFirstPageNoOnCurrentIndex() {
		return firstPageNoOnCurrentIndex;
	}

	/**
	 * @param firstPageNoOnCurrentIndex
	 *            the firstPageNoOnCurrentIndex to set
	 */
	public void setFirstPageNoOnCurrentIndex(int firstPageNoOnCurrentIndex) {
		this.firstPageNoOnCurrentIndex = firstPageNoOnCurrentIndex;
	}

	/**
	 * @return the lastPageNoOnCurrentIndex
	 */
	public int getLastPageNoOnCurrentIndex() {
		return lastPageNoOnCurrentIndex;
	}

	/**
	 * @param lastPageNoOnCurrentIndex
	 *            the lastPageNoOnCurrentIndex to set
	 */
	public void setLastPageNoOnCurrentIndex(int lastPageNoOnCurrentIndex) {
		this.lastPageNoOnCurrentIndex = lastPageNoOnCurrentIndex;
	}

	/**
	 * @return the firstPageNoOnNextIndex
	 */
	public int getFirstPageNoOnNextIndex() {
		return firstPageNoOnNextIndex;
	}

	/**
	 * @param firstPageNoOnNextIndex
	 *            the firstPageNoOnNextIndex to set
	 */
	public void setFirstPageNoOnNextIndex(int firstPageNoOnNextIndex) {
		this.firstPageNoOnNextIndex = firstPageNoOnNextIndex;
	}

	/**
	 * @return the lastPageNo
	 */
	public int getLastPageNo() {
		return lastPageNo;
	}

	/**
	 * @param lastPageNo
	 *            the lastPageNo to set
	 */
	public void setLastPageNo(int lastPageNo) {
		this.lastPageNo = lastPageNo;
	}

	/**
	 * @return the currentPageNo
	 */
	public int getCurrentPageNo() {
		return currentPageNo;
	}

	/**
	 * @param currentPageNo
	 *            the currentPageNo to set
	 */
	public void setCurrentPageNo(int currentPageNo) {
		this.currentPageNo = currentPageNo;
	}

	/**
	 * @return the cssClass
	 */
	public String getCssClass() {
		return cssClass;
	}

	/**
	 * @param cssClass
	 *            the cssClass to set
	 */
	public void setCssClass(String cssClass) {
		this.cssClass = cssClass;
	}

	/**
	 * @param onclick
	 *            the onclick to set
	 */
	public void setOnclick(String onclick) {
		this.onclick = onclick;
	}

}
