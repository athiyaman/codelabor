/*
 * Copyright 2002-2012 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
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

import javax.servlet.jsp.JspException;

import org.springframework.web.servlet.tags.form.TagWriter;

public class UnorderedListErrorsTag extends
		org.springframework.web.servlet.tags.form.ErrorsTag {

	private static final String LIST_END_TAG = "</ul>";
	private static final String LIST_ITEM_END_TAG = "</li>";
	private static final String LIST_ITEM_START_TAG = "<li>";
	private static final String LIST_START_TAG = "<ul>";

	/**
	 *
	 */
	private static final long serialVersionUID = 5908052274328975704L;

	@Override
	protected void renderDefaultContent(TagWriter tagWriter)
			throws JspException {
		tagWriter.startTag(getElement());
		writeDefaultAttributes(tagWriter);

		tagWriter.appendValue(LIST_START_TAG);
		String[] errorMessages = getBindStatus().getErrorMessages();
		for (int i = 0; i < errorMessages.length; i++) {
			tagWriter.appendValue(LIST_ITEM_START_TAG);
			tagWriter.appendValue(getDisplayString(errorMessages[i]));
			tagWriter.appendValue(LIST_ITEM_END_TAG);
		}
		tagWriter.appendValue(LIST_END_TAG);
		tagWriter.endTag();
	}

}
