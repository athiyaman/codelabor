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
package org.codelabor.system.validator.html.internal.constraintvalidators;

import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.codelabor.system.validator.html.constraints.NonSafeHtml;
import org.codelabor.system.validator.xss.Blacklist;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Shin Sang-Jae
 */
public class NonSafeHtmlStringListValidator implements
		ConstraintValidator<NonSafeHtml, List<String>> {
	private List<String> blacklist = null;
	private Logger logger = LoggerFactory
			.getLogger(NonSafeHtmlStringListValidator.class);

	public void initialize(NonSafeHtml nonSafeHtmlAnnotation) {
		logger.debug("blacklist type: {}",
				nonSafeHtmlAnnotation.blacklistType());
		switch (nonSafeHtmlAnnotation.blacklistType()) {
		case ANCHOR:
			blacklist = Blacklist.anchor();
		case SCRIPT:
			blacklist = Blacklist.script();
			break;
		case FORM:
			blacklist = Blacklist.form();
			break;
		case SCRIPT_FORM:
			blacklist = Blacklist.scriptForm();
			break;
		case ANCHOR_SCRIPT_FORM:
			blacklist = Blacklist.anchorScriptForm();
			break;
		case ALL_TAG:
			blacklist = Blacklist.allTag();
			break;
		case NONE:
		default:
			blacklist = Blacklist.none();
			break;
		}
		logger.debug("blacklist: {}", blacklist);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see javax.validation.ConstraintValidator#isValid(java.lang.Object,
	 * javax.validation.ConstraintValidatorContext)
	 */
	@Override
	public boolean isValid(List<String> list, ConstraintValidatorContext context) {
		if (CollectionUtils.isNotEmpty(list)) {
			for (String value : list) {
				if (StringUtils.isNotBlank(value)) {
					for (String blacklistPattern : blacklist) {
						logger.debug("value: {}, blacklistPattern: {}", value,
								blacklistPattern);
						if (StringUtils.containsIgnoreCase(value,
								blacklistPattern)) {
							return false;
						}
					}
				}
			}
		}
		return true;
	}
}
