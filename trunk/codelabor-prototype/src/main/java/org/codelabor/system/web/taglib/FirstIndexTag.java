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

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Sang Jae Shin
 * 
 */
public class FirstIndexTag extends SimpleTagSupport {

	private final static Logger logger = LoggerFactory
			.getLogger(FirstIndexTag.class);

	protected String cssClass;
	protected String onclick;

	PaginationTag parent;

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.jsp.tagext.SimpleTagSupport#doTag()
	 */
	@Override
	public void doTag() throws JspException, IOException {
		logger.debug("doTag");

		parent = (PaginationTag) getParent();
		JspWriter out = getJspContext().getOut();

		// first page number of first
		logger.debug("firstPageNoOnFirstIndex: {}",
				parent.getFirstPageNoOnFirstIndex());
		StringBuilder sb = new StringBuilder();
		sb.append(this.generateAnchorTagForFirstIndex(parent.getQueryString(),
				parent.getFirstPageNoOnFirstIndex(), parent.getMaxRowPerPage()));
		sb.append(System.getProperty("line.separator"));
		out.print(sb.toString());
	}

	protected String generateAnchorTagForFirstIndex(String queryString,
			int pageNo, int maxRowPerPage) throws JspException, IOException {
		StringWriter sw = new StringWriter();
		StringBuilder sb = new StringBuilder(40);
		sb.append("<a href=\"?").append(
				parent.replacePageNoInQueryString(queryString, pageNo,
						maxRowPerPage));
		sb.append('\"');
		if (StringUtils.isNotBlank(cssClass)) {
			sb.append(" class=\"").append(cssClass).append('\"');
		}
		if (StringUtils.isNotBlank(onclick)) {
			sb.append(" onclick=\"").append(onclick).append('\"');
		}
		sb.append('>');
		getJspBody().invoke(sw);
		sb.append(sw.getBuffer());
		sb.append("</a>");
		return sb.toString();
	}

	/**
	 * @return the cssClass
	 */
	public String getCssClass() {
		return cssClass;
	}

	/**
	 * @return the onclick
	 */
	public String getOnclick() {
		return onclick;
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
