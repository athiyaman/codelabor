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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.apache.commons.lang3.StringUtils;
import org.codelabor.system.SystemConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Sang Jae Shin
 *
 */
public class TextPaginationTag extends SimpleTagSupport {

	public static final String FIRST_PAGE_LINK_STRING_ON_FIRST_INDEX = "&lt;&lt;";
	public static final String FIRST_PAGE_LINK_STRING_ON_NEXT_INDEX = "&gt;";
	public static final String FIRST_PAGE_LINK_STRING_ON_PREVIOUS_INDEX = "&lt;";
	public static final String LAST_PAGE_LINK_STRING_ON_LAST_INDEX = "&gt;&gt;";

	private static final Logger logger = LoggerFactory
			.getLogger(TextPaginationTag.class);

	protected String firstPageAnchorClassOnFirstIndex = null;
	protected String firstPageAnchorClassOnNextIndex = null;
	protected String firstPageAnchorClassOnPreviousIndex = null;
	protected String firstPageLinkStringOnFirstIndex = FIRST_PAGE_LINK_STRING_ON_FIRST_INDEX;
	protected String firstPageLinkStringOnNextIndex = FIRST_PAGE_LINK_STRING_ON_NEXT_INDEX;

	protected String firstPageLinkStringOnPreviousIndex = FIRST_PAGE_LINK_STRING_ON_PREVIOUS_INDEX;
	protected String lastPageAnchorClassOnLastIndex = null;
	protected String lastPageLinkStringOnLastIndex = LAST_PAGE_LINK_STRING_ON_LAST_INDEX;
	protected Integer maxIndexPerPage = PaginationConstants.MAX_INDEX_PER_PAGE;

	protected Integer maxRowPerPage = PaginationConstants.MAX_ROW_PER_PAGE;
	protected String maxRowPerPageParamName = PaginationConstants.MAX_ROW_PER_PAGE_PARAM_NAME;
	protected Integer numberOfRow = 0;
	protected String pageNoParamName = PaginationConstants.PAGE_NO_PARAM_NAME;

	/*
	 * (non-Javadoc)
	 *
	 * @see javax.servlet.jsp.tagext.SimpleTagSupport#doTag()
	 */
	@Override
	public void doTag() throws JspException, IOException {
		super.doTag();

		// if numberOfRow is 0, do nothing
		if (numberOfRow == 0) {
			return;
		}

		PageContext context = (PageContext) this.getJspContext();
		HttpServletRequest request = (HttpServletRequest) context.getRequest();
		JspWriter out = context.getOut();

		// queryString
		String queryString = request.getQueryString();

		// max row per page
		String maxRowPerPageString = request
				.getParameter(maxRowPerPageParamName);
		if (StringUtils.isNotBlank(maxRowPerPageString)) {
			maxRowPerPage = Integer.parseInt(maxRowPerPageString);
		}

		// total count
		int totalPageCount = (int) Math.ceil((double) numberOfRow
				/ (double) maxRowPerPage);

		// page number
		int firstPageNo = 1;
		int lastPageNo = totalPageCount;
		int currentPageNo = 1;
		String pageNoString = request.getParameter(pageNoParamName);
		if (StringUtils.isNotBlank(pageNoString)) {
			currentPageNo = Integer.parseInt(pageNoString);
		}

		// validation
		if (currentPageNo > lastPageNo) {
			StringBuilder sb = new StringBuilder();
			sb.append(pageNoParamName).append(" is exeeded.");
			sb.append(" (");
			sb.append("requested page number: ").append(currentPageNo)
			.append(", ");
			sb.append("last page number: ").append(lastPageNo).append(')');
			throw new JspException(sb.toString());
		}

		// current index
		int lastPageNoOnCurrentIndex = ((int) Math.ceil((double) currentPageNo
				/ (double) maxIndexPerPage))
				* maxIndexPerPage;
		int firstPageNoOnCurrentIndex = (lastPageNoOnCurrentIndex - maxIndexPerPage) + 1;

		// compensate page number
		if (lastPageNoOnCurrentIndex > lastPageNo) {
			lastPageNoOnCurrentIndex = lastPageNo;
		}

		// first page number on previous, next index
		int firstPageNoOnPreviousIndex = firstPageNoOnCurrentIndex
				- maxIndexPerPage;
		int firstPageNoOnNextIndex = lastPageNoOnCurrentIndex + 1;

		// compensate page number
		if (firstPageNoOnPreviousIndex < firstPageNo) {
			firstPageNoOnPreviousIndex = firstPageNo;
		}
		if (firstPageNoOnNextIndex > lastPageNo) {
			firstPageNoOnNextIndex = lastPageNo;
		}

		// first page number of first index
		int firstPageNoOnFirstIndex = firstPageNo;
		// last page number of last index
		int lastPageNoOnLastIndex = ((int) Math.floor((double) numberOfRow
				/ (double) maxRowPerPage)) + 1;

		// debug
		logger.debug("queryString: {}", queryString);
		logger.debug("numberOfRow: {}", numberOfRow);
		logger.debug("totalPageCount: {}", totalPageCount);
		logger.debug("firstPageNo: {}", firstPageNo);
		logger.debug("lastPageNo: {}", lastPageNo);

		// print html tags
		StringBuilder sb = new StringBuilder();

		// first page number of first
		logger.debug("firstPageNoOnFirstIndex: {}", firstPageNoOnFirstIndex);
		sb.setLength(0);
		sb.trimToSize();
		sb.append(this.generateAnchorTagForFirstIndex(queryString,
				firstPageNoOnFirstIndex, maxRowPerPage));
		sb.append(SystemConstants.LINE_SEPARATOR);
		out.print(sb.toString());

		// first page number on previous index
		logger.debug("firstPageNoOnPreviousIndex: {}",
				firstPageNoOnPreviousIndex);
		sb.setLength(0);
		sb.trimToSize();
		sb.append(this.generateAnchorTagForPreviousIndex(queryString,
				firstPageNoOnPreviousIndex, maxRowPerPage));
		sb.append(SystemConstants.LINE_SEPARATOR);
		out.print(sb.toString());

		// current index
		logger.debug("firstPageNoOnCurrentIndex: {}", firstPageNoOnCurrentIndex);
		for (int i = firstPageNoOnCurrentIndex; (i <= lastPageNoOnCurrentIndex)
				&& (i <= lastPageNo); i++) {
			logger.debug("pageNo: {}", i);
			sb.setLength(0);
			sb.trimToSize();
			if (i == currentPageNo) {
				sb.append("<span>").append(i).append("</span>");
			} else {
				sb.append(this.generateAnchorTagForCurrentIndex(queryString, i,
						maxRowPerPage));
			}
			sb.append(SystemConstants.LINE_SEPARATOR);
			out.print(sb.toString());
		}
		logger.debug("lastPageNoOnCurrentIndex: {}", lastPageNoOnCurrentIndex);

		// first page number on next index
		logger.debug("firstPageNoOnNextIndex: {}", firstPageNoOnNextIndex);
		sb.setLength(0);
		sb.trimToSize();
		sb.append(this.generateAnchorTagForNextIndex(queryString,
				firstPageNoOnNextIndex, maxRowPerPage));
		sb.append(SystemConstants.LINE_SEPARATOR);
		out.print(sb.toString());

		// first page number of last index
		logger.debug("firstPageNoOnLastIndex: {}", lastPageNoOnLastIndex);
		sb.setLength(0);
		sb.trimToSize();
		sb.append(this.generateAnchorTagForLastIndex(queryString,
				lastPageNoOnLastIndex, maxRowPerPage));
		sb.append(SystemConstants.LINE_SEPARATOR);
		out.print(sb.toString());

	}

	protected String generateAnchorTagForCurrentIndex(String queryString,
			int pageNo, int maxRowPerPage) {
		StringBuilder sb = new StringBuilder();
		sb.append("<a href=\"?").append(
				this.replacePageNoInQueryString(queryString, pageNo,
						maxRowPerPage));
		sb.append("\">").append(pageNo);
		sb.append("</a>");
		return sb.toString();
	}

	protected String generateAnchorTagForFirstIndex(String queryString,
			int pageNo, int maxRowPerPage) {
		StringBuilder sb = new StringBuilder();
		sb.append("<a href=\"?").append(
				this.replacePageNoInQueryString(queryString, pageNo,
						maxRowPerPage));
		if (StringUtils.isNotBlank(firstPageAnchorClassOnFirstIndex)) {
			sb.append("\" class=\"").append(firstPageAnchorClassOnFirstIndex);
		}
		sb.append("\">").append(firstPageLinkStringOnFirstIndex);
		sb.append("</a>");
		return sb.toString();
	}

	protected String generateAnchorTagForLastIndex(String queryString,
			int pageNo, int maxRowPerPage) {
		StringBuilder sb = new StringBuilder();
		sb.append("<a href=\"?").append(
				this.replacePageNoInQueryString(queryString, pageNo,
						maxRowPerPage));
		if (StringUtils.isNotBlank(firstPageAnchorClassOnFirstIndex)) {
			sb.append("\" class=\"").append(lastPageAnchorClassOnLastIndex);
		}
		sb.append("\">").append(lastPageLinkStringOnLastIndex);
		sb.append("</a>");
		return sb.toString();
	}

	protected String generateAnchorTagForNextIndex(String queryString,
			int pageNo, int maxRowPerPage) {
		StringBuilder sb = new StringBuilder();
		sb.append("<a href=\"?").append(
				this.replacePageNoInQueryString(queryString, pageNo,
						maxRowPerPage));
		if (StringUtils.isNotBlank(firstPageAnchorClassOnFirstIndex)) {
			sb.append("\" class=\"").append(firstPageAnchorClassOnNextIndex);
		}
		sb.append("\">").append(firstPageLinkStringOnNextIndex);
		sb.append("</a>");
		return sb.toString();
	}

	protected String generateAnchorTagForPreviousIndex(String queryString,
			int pageNo, int maxRowPerPage) {
		StringBuilder sb = new StringBuilder();
		sb.append("<a href=\"?").append(
				this.replacePageNoInQueryString(queryString, pageNo,
						maxRowPerPage));
		if (StringUtils.isNotBlank(firstPageAnchorClassOnFirstIndex)) {
			sb.append("\" class=\"")
			.append(firstPageAnchorClassOnPreviousIndex);
		}
		sb.append("\">").append(firstPageLinkStringOnPreviousIndex);
		sb.append("</a>");
		return sb.toString();
	}

	/**
	 * @return the firstPageAnchorClassOnFirstIndex
	 */
	public String getFirstPageAnchorClassOnFirstIndex() {
		return firstPageAnchorClassOnFirstIndex;
	}

	/**
	 * @return the firstPageAnchorClassOnNextIndex
	 */
	public String getFirstPageAnchorClassOnNextIndex() {
		return firstPageAnchorClassOnNextIndex;
	}

	/**
	 * @return the firstPageAnchorClassOnPreviousIndex
	 */
	public String getFirstPageAnchorClassOnPreviousIndex() {
		return firstPageAnchorClassOnPreviousIndex;
	}

	/**
	 * @return the firstPageLinkStringOnFirstIndex
	 */
	public String getFirstPageLinkStringOnFirstIndex() {
		return firstPageLinkStringOnFirstIndex;
	}

	/**
	 * @return the firstPageLinkStringOnNextIndex
	 */
	public String getFirstPageLinkStringOnNextIndex() {
		return firstPageLinkStringOnNextIndex;
	}

	/**
	 * @return the firstPageLinkStringOnPreviousIndex
	 */
	public String getFirstPageLinkStringOnPreviousIndex() {
		return firstPageLinkStringOnPreviousIndex;
	}

	/**
	 * @return the lastPageAnchorClassOnLastIndex
	 */
	public String getLastPageAnchorClassOnLastIndex() {
		return lastPageAnchorClassOnLastIndex;
	}

	/**
	 * @return the lastPageLinkStringOnLastIndex
	 */
	public String getLastPageLinkStringOnLastIndex() {
		return lastPageLinkStringOnLastIndex;
	}

	/**
	 * @return the maxIndexPerPage
	 */
	public Integer getMaxIndexPerPage() {
		return maxIndexPerPage;
	}

	/**
	 * @return the maxRowPerPage
	 */
	public Integer getMaxRowPerPage() {
		return maxRowPerPage;
	}

	/**
	 * @return the maxRowPerPageParamName
	 */
	public String getMaxRowPerPageParamName() {
		return maxRowPerPageParamName;
	}

	/**
	 * @return the numberOfRow
	 */
	public Integer getNumberOfRow() {
		return numberOfRow;
	}

	/**
	 * @return the pageNoParamName
	 */
	public String getPageNoParamName() {
		return pageNoParamName;
	}

	protected String replacePageNoInQueryString(String queryString, int pageNo,
			int maxRowPerPage) {
		String replacedQueryString = null;
		if (StringUtils.isNotBlank(queryString)) {
			if (StringUtils.contains(queryString, pageNoParamName)) {
				StringBuilder sb = new StringBuilder();
				sb.append(pageNoParamName).append("=[0-9]*");
				Pattern pattern = Pattern.compile(sb.toString());
				Matcher matcher = pattern.matcher(queryString);
				sb.setLength(0);
				sb.trimToSize();
				sb.append(pageNoParamName).append('=').append(pageNo);
				replacedQueryString = matcher.replaceAll(sb.toString());
			} else {
				StringBuilder sb = new StringBuilder();
				sb.append(pageNoParamName).append('=').append(pageNo);
				sb.append('&');
				sb.append(maxRowPerPageParamName).append('=')
				.append(maxRowPerPage);
				sb.append('&');
				sb.append(queryString);
				replacedQueryString = sb.toString();
			}
		} else {
			StringBuilder sb = new StringBuilder();
			sb.append(pageNoParamName).append('=').append(pageNo);
			sb.append('&');
			sb.append(maxRowPerPageParamName).append('=').append(maxRowPerPage);
			replacedQueryString = sb.toString();
		}
		return replacedQueryString;
	}

	/**
	 * @param firstPageAnchorClassOnFirstIndex
	 *            the firstPageAnchorClassOnFirstIndex to set
	 */
	public void setFirstPageAnchorClassOnFirstIndex(
			String firstPageAnchorClassOnFirstIndex) {
		this.firstPageAnchorClassOnFirstIndex = firstPageAnchorClassOnFirstIndex;
	}

	/**
	 * @param firstPageAnchorClassOnNextIndex
	 *            the firstPageAnchorClassOnNextIndex to set
	 */
	public void setFirstPageAnchorClassOnNextIndex(
			String firstPageAnchorClassOnNextIndex) {
		this.firstPageAnchorClassOnNextIndex = firstPageAnchorClassOnNextIndex;
	}

	/**
	 * @param firstPageAnchorClassOnPreviousIndex
	 *            the firstPageAnchorClassOnPreviousIndex to set
	 */
	public void setFirstPageAnchorClassOnPreviousIndex(
			String firstPageAnchorClassOnPreviousIndex) {
		this.firstPageAnchorClassOnPreviousIndex = firstPageAnchorClassOnPreviousIndex;
	}

	/**
	 * @param firstPageLinkStringOnFirstIndex
	 *            the firstPageLinkStringOnFirstIndex to set
	 */
	public void setFirstPageLinkStringOnFirstIndex(
			String firstPageLinkStringOnFirstIndex) {
		this.firstPageLinkStringOnFirstIndex = firstPageLinkStringOnFirstIndex;
	}

	/**
	 * @param firstPageLinkStringOnNextIndex
	 *            the firstPageLinkStringOnNextIndex to set
	 */
	public void setFirstPageLinkStringOnNextIndex(
			String firstPageLinkStringOnNextIndex) {
		this.firstPageLinkStringOnNextIndex = firstPageLinkStringOnNextIndex;
	}

	/**
	 * @param firstPageLinkStringOnPreviousIndex
	 *            the firstPageLinkStringOnPreviousIndex to set
	 */
	public void setFirstPageLinkStringOnPreviousIndex(
			String firstPageLinkStringOnPreviousIndex) {
		this.firstPageLinkStringOnPreviousIndex = firstPageLinkStringOnPreviousIndex;
	}

	/**
	 * @param lastPageAnchorClassOnLastIndex
	 *            the lastPageAnchorClassOnLastIndex to set
	 */
	public void setLastPageAnchorClassOnLastIndex(
			String lastPageAnchorClassOnLastIndex) {
		this.lastPageAnchorClassOnLastIndex = lastPageAnchorClassOnLastIndex;
	}

	/**
	 * @param lastPageLinkStringOnLastIndex
	 *            the lastPageLinkStringOnLastIndex to set
	 */
	public void setLastPageLinkStringOnLastIndex(
			String lastPageLinkStringOnLastIndex) {
		this.lastPageLinkStringOnLastIndex = lastPageLinkStringOnLastIndex;
	}

	/**
	 * @param maxIndexPerPage
	 *            the maxIndexPerPage to set
	 */
	public void setMaxIndexPerPage(Integer maxIndexPerPage) {
		this.maxIndexPerPage = maxIndexPerPage;
	}

	/**
	 * @param maxRowPerPage
	 *            the maxRowPerPage to set
	 */
	public void setMaxRowPerPage(Integer maxRowPerPage) {
		this.maxRowPerPage = maxRowPerPage;
	}

	/**
	 * @param maxRowPerPageParamName
	 *            the maxRowPerPageParamName to set
	 */
	public void setMaxRowPerPageParamName(String maxRowPerPageParamName) {
		this.maxRowPerPageParamName = maxRowPerPageParamName;
	}

	/**
	 * @param numberOfRow
	 *            the numberOfRow to set
	 */
	public void setNumberOfRow(Integer numberOfRow) {
		this.numberOfRow = numberOfRow;
	}

	/**
	 * @param pageNoParamName
	 *            the pageNoParamName to set
	 */
	public void setPageNoParamName(String pageNoParamName) {
		this.pageNoParamName = pageNoParamName;
	}

}
