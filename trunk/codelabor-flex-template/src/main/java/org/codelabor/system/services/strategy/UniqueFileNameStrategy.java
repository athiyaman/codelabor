package org.codelabor.system.services.strategy;

import java.text.SimpleDateFormat;

import anyframe.common.util.StringUtil;
import anyframe.core.idgen.IdGenerationStrategy;

public class UniqueFileNameStrategy implements IdGenerationStrategy {

	private String prefix;

	private int cipers;

	private String dateAndTimePattern;

	private char fillChar;

	public int getCipers() {
		return cipers;
	}

	public void setCipers(int cipers) {
		this.cipers = cipers;
	}

	public String getDateAndTimePattern() {
		return dateAndTimePattern;
	}

	public void setDateAndTimePattern(String dateAndTimePattern) {
		this.dateAndTimePattern = dateAndTimePattern;
	}

	public char getFillChar() {
		return fillChar;
	}

	public void setFillChar(char fillChar) {
		this.fillChar = fillChar;
	}

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public String makeId(String originalId) {
		SimpleDateFormat dateAndTimeFormat = new SimpleDateFormat(
				dateAndTimePattern);
		String dateAndTimeString = dateAndTimeFormat.format(System
				.currentTimeMillis());
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(prefix);
		stringBuilder.append(dateAndTimeString);
		stringBuilder.append(StringUtil
				.fillString(originalId, fillChar, cipers));
		return stringBuilder.toString();
	}
}
