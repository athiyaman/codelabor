package org.codelabor.system.strategies;

import anyframe.core.idgen.IdGenerationStrategy;

public class PrefixStrategy implements IdGenerationStrategy {

	protected String prefix;
	protected String delimeter;

	public String makeId(String originalId) {
		StringBuilder sb = new StringBuilder();
		sb.append(prefix).append(delimeter);
		sb.append(originalId);
		return sb.toString();
	}

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public void setDelimeter(String delimeter) {
		this.delimeter = delimeter;
	}

}
