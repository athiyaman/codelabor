package org.codelabor.system.tags;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.apache.commons.lang.StringUtils;

import anyframe.common.Page;

public class TextPagenationTag extends SimpleTagSupport {

	private Page page;
	private Map<String, Object> param;
	private String pageIndexParamName = "pageIndex";
	private String pageDelimeter = "&nbsp;";

	private String previousUnitPageString = "&lt;&lt;";
	private String previousPageString = "&lt;";
	private String nextPageString = "&gt;";
	private String nextUnitPageString = "&gt;&gt;";

	private String previousUnitPageStyleId = null;
	private String previousPageStyleId = null;
	private String currentPageStyleId = null;
	private String pageStyleId = null;
	private String nextPageStyleId = null;
	private String nextUnitPageStyleId = null;

	private String previousUnitPageStyleClass = null;
	private String previousPageStyleClass = null;
	private String currentPageStyleClass = null;
	private String pageStyleClass = null;
	private String nextPageStyleClass = null;
	private String nextUnitPageStyleClass = null;

	@SuppressWarnings("unchecked")
	protected String createQueryStringWithPageIndex(Page page, Map param,
			int pageIndex) {
		Set keySet = param.keySet();
		Iterator iterator = keySet.iterator();
		StringBuilder sb = new StringBuilder();
		sb.append("?").append(pageIndexParamName).append("=").append(pageIndex);
		while (iterator.hasNext()) {
			String key = (String) iterator.next();
			if (!key.equals(pageIndexParamName)) {
				sb.append("&").append(key).append("=").append(param.get(key));
			}
		}
		return sb.toString();
	}

	protected String createAnchorTag(String anchorBody, int pageIndex) {
		StringBuilder sb = new StringBuilder();
		String queryString = createQueryStringWithPageIndex(page, param,
				pageIndex);
		sb.append("<a href='");
		sb.append(queryString);
		sb.append("'>");
		sb.append(anchorBody);
		sb.append("</a>");
		return sb.toString();
	}

	protected String createSpanTag(String body, String styleId,
			String styleClass) {
		StringBuilder sb = new StringBuilder();
		sb.append("<span");
		if (StringUtils.isNotBlank(styleId)) {
			sb.append(" id='").append(styleId).append("'");
		}
		if (StringUtils.isNotBlank(styleClass)) {
			sb.append(" class='").append(styleClass).append("'");
		}
		sb.append(">");
		sb.append(body);
		sb.append("</span>");
		return sb.toString();
	}

	protected String getPageIndexBody(String body, String styleId,
			String styleClass) {
		if (StringUtils.isNotBlank(styleId)
				&& StringUtils.isNotBlank(styleClass)) {
			StringBuilder sb = new StringBuilder();
			sb.append(createSpanTag(body, styleId, styleClass));
			return sb.toString();
		} else if (StringUtils.isNotBlank(styleId)) {
			StringBuilder sb = new StringBuilder();
			sb.append(createSpanTag(body, styleId, null));
			return sb.toString();
		} else if (StringUtils.isNotBlank(styleClass)) {
			StringBuilder sb = new StringBuilder();
			sb.append(createSpanTag(body, null, styleClass));
			return sb.toString();
		} else {
			return body;
		}
	}

	@Override
	public void doTag() throws JspException, IOException {
		JspWriter out = getJspContext().getOut();
		String pageIndexBody = null;
		int beginUnitPage = page.getBeginUnitPage();
		// int endUnitPage = page.getEndUnitPage();
		int currentPage = page.getCurrentPage();
		int endLinePage = page.getEndListPage();

		// left unit page link
		pageIndexBody = getPageIndexBody(previousUnitPageString,
				previousUnitPageStyleId, previousUnitPageStyleClass);
		if (page.hasPreviousPageUnit()) {
			out.print(createAnchorTag(pageIndexBody, page
					.getPageOfPreviousPageUnit()));
		} else {
			out.print(pageIndexBody);
		}
		out.print(pageDelimeter);

		// left page link
		pageIndexBody = getPageIndexBody(previousPageString, previousPageStyleId,
				previousPageStyleClass);
		if (page.hasPreviousPage()) {
			out.print(createAnchorTag(pageIndexBody, page.getPreviousPage()));
		} else {
			out.print(pageIndexBody);
		}
		out.print(pageDelimeter);

		// index
		int availableEndLinePage = 0;
		if (currentPage < endLinePage) {
			availableEndLinePage = endLinePage;
		} else {
			availableEndLinePage = currentPage;
		}
		for (int i = beginUnitPage; i <= availableEndLinePage; i++) {
			if (i != currentPage) {
				pageIndexBody = getPageIndexBody(String.valueOf(i), pageStyleId,
						pageStyleClass);
				out.print(createAnchorTag(pageIndexBody, i));
			} else {
				pageIndexBody = getPageIndexBody(String.valueOf(i),
						currentPageStyleId, currentPageStyleClass);
				out.print(pageIndexBody);
			}
			out.print(pageDelimeter);
		}

		// right page link
		pageIndexBody = getPageIndexBody(nextPageString, nextPageStyleId,
				nextPageStyleClass);
		if (page.hasNextPage()) {
			out.print(createAnchorTag(pageIndexBody, page.getNextPage()));
		} else {
			out.print(pageIndexBody);
		}
		out.print(pageDelimeter);

		// right unit page link
		pageIndexBody = getPageIndexBody(nextUnitPageString, nextUnitPageStyleId,
				nextUnitPageStyleClass);
		if (page.hasNextPageUnit()) {
			out
					.print(createAnchorTag(pageIndexBody, page
							.getPageOfNextPageUnit()));
		} else {
			out.print(pageIndexBody);
		}
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public Map<String, Object> getParam() {
		return param;
	}

	public void setParam(Map<String, Object> param) {
		this.param = param;
	}

	public String getPageIndexParamName() {
		return pageIndexParamName;
	}

	public void setPageIndexParamName(String pageIndexParamName) {
		this.pageIndexParamName = pageIndexParamName;
	}

	public String getPageDelimeter() {
		return pageDelimeter;
	}

	public void setPageDelimeter(String pageDelimeter) {
		this.pageDelimeter = pageDelimeter;
	}

	public String getPreviousUnitPageString() {
		return previousUnitPageString;
	}

	public void setPreviousUnitPageString(String previousUnitPageString) {
		this.previousUnitPageString = previousUnitPageString;
	}

	public String getPreviousPageString() {
		return previousPageString;
	}

	public void setPreviousPageString(String previousPageString) {
		this.previousPageString = previousPageString;
	}

	public String getNextPageString() {
		return nextPageString;
	}

	public void setNextPageString(String nextPageString) {
		this.nextPageString = nextPageString;
	}

	public String getNextUnitPageString() {
		return nextUnitPageString;
	}

	public void setNextUnitPageString(String nextUnitPageString) {
		this.nextUnitPageString = nextUnitPageString;
	}

	public String getPreviousUnitPageStyleId() {
		return previousUnitPageStyleId;
	}

	public void setPreviousUnitPageStyleId(String previousUnitPageStyleId) {
		this.previousUnitPageStyleId = previousUnitPageStyleId;
	}

	public String getPreviousPageStyleId() {
		return previousPageStyleId;
	}

	public void setPreviousPageStyleId(String previousPageStyleId) {
		this.previousPageStyleId = previousPageStyleId;
	}

	public String getCurrentPageStyleId() {
		return currentPageStyleId;
	}

	public void setCurrentPageStyleId(String currentPageStyleId) {
		this.currentPageStyleId = currentPageStyleId;
	}

	public String getPageStyleId() {
		return pageStyleId;
	}

	public void setPageStyleId(String pageStyleId) {
		this.pageStyleId = pageStyleId;
	}

	public String getNextPageStyleId() {
		return nextPageStyleId;
	}

	public void setNextPageStyleId(String nextPageStyleId) {
		this.nextPageStyleId = nextPageStyleId;
	}

	public String getNextUnitPageStyleId() {
		return nextUnitPageStyleId;
	}

	public void setNextUnitPageStyleId(String nextUnitPageStyleId) {
		this.nextUnitPageStyleId = nextUnitPageStyleId;
	}

	public String getPreviousUnitPageStyleClass() {
		return previousUnitPageStyleClass;
	}

	public void setPreviousUnitPageStyleClass(String previousUnitPageStyleClass) {
		this.previousUnitPageStyleClass = previousUnitPageStyleClass;
	}

	public String getPreviousPageStyleClass() {
		return previousPageStyleClass;
	}

	public void setPreviousPageStyleClass(String previousPageStyleClass) {
		this.previousPageStyleClass = previousPageStyleClass;
	}

	public String getCurrentPageStyleClass() {
		return currentPageStyleClass;
	}

	public void setCurrentPageStyleClass(String currentPageStyleClass) {
		this.currentPageStyleClass = currentPageStyleClass;
	}

	public String getPageStyleClass() {
		return pageStyleClass;
	}

	public void setPageStyleClass(String pageStyleClass) {
		this.pageStyleClass = pageStyleClass;
	}

	public String getNextPageStyleClass() {
		return nextPageStyleClass;
	}

	public void setNextPageStyleClass(String nextPageStyleClass) {
		this.nextPageStyleClass = nextPageStyleClass;
	}

	public String getNextUnitPageStyleClass() {
		return nextUnitPageStyleClass;
	}

	public void setNextUnitPageStyleClass(String nextUnitPageStyleClass) {
		this.nextUnitPageStyleClass = nextUnitPageStyleClass;
	}
}
