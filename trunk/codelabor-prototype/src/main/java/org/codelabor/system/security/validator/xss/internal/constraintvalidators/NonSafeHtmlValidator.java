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
package org.codelabor.system.security.validator.xss.internal.constraintvalidators;

import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.lang3.StringUtils;
import org.codelabor.system.security.validator.xss.Blacklist;
import org.codelabor.system.security.validator.xss.constraints.NonSafeHtml;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Shin Sang-Jae
 */
public class NonSafeHtmlValidator implements
		ConstraintValidator<NonSafeHtml, CharSequence> {
	private List<String> blacklist = null;
	private Logger logger = LoggerFactory.getLogger(NonSafeHtmlValidator.class);

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

	public boolean isValid(CharSequence value,
			ConstraintValidatorContext context) {
		if (StringUtils.isNotBlank(value)) {
			for (String blacklistPattern : blacklist) {
				logger.debug("value: {}, blacklistPattern: {}", value,
						blacklistPattern);
				if (StringUtils.containsIgnoreCase(value, blacklistPattern)) {
					return false;
				}
			}
		}
		return true;
	}
}
