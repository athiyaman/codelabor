package org.codelabor.system.strategies;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

import anyframe.common.util.StringUtil;
import anyframe.core.idgen.IdGenerationStrategy;

public class PrefixDateNumberStrategy implements IdGenerationStrategy {

	protected String prefix;

	protected String delimiter;

	protected String datePattern;

	protected char fillChar;

	protected int cipers;

	public void setCipers(int cipers) {
		this.cipers = cipers;
	}

	public void setDatePattern(String dateAndTimePattern) {
		this.datePattern = dateAndTimePattern;
	}

	public void setFillChar(char fillChar) {
		this.fillChar = fillChar;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public void setDelimiter(String delimiter) {
		this.delimiter = delimiter;
	}

	public String makeId(String originalId) {
		DateFormat dateFormat = new SimpleDateFormat(datePattern, Locale
				.getDefault());
		String dateFormatString = dateFormat.format(System.currentTimeMillis());
		StringBuilder sb = new StringBuilder();
		sb.append(prefix);
		if (delimiter != null) {
			sb.append(delimiter);
		}
		sb.append(dateFormatString);
		if (delimiter != null) {
			sb.append(delimiter);
		}
		sb.append(StringUtil.fillString(originalId, fillChar, cipers));
		return sb.toString();
	}

}
