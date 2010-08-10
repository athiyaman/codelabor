package org.codelabor.system.strategies;

import anyframe.core.idgen.IdGenerationStrategy;

public class PostfixStrategy implements IdGenerationStrategy {

	protected String postfix;
	protected String delimiter;

	public String makeId(String originalId) {
		StringBuilder sb = new StringBuilder();
		sb.append(originalId);
		if (delimiter != null) {
			sb.append(delimiter);
		}
		sb.append(postfix);
		return sb.toString();
	}

	public String getPostfix() {
		return postfix;
	}

	public void setPostfix(String prefix) {
		this.postfix = prefix;
	}

	public void setDelimiter(String delimiter) {
		this.delimiter = delimiter;
	}

}
