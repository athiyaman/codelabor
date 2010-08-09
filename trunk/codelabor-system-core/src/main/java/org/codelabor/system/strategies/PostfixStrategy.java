package org.codelabor.system.strategies;

import anyframe.core.idgen.IdGenerationStrategy;

public class PostfixStrategy implements IdGenerationStrategy {

	protected String postfix;
	protected String delimeter;

	public String makeId(String originalId) {
		StringBuilder sb = new StringBuilder();
		sb.append(originalId).append(delimeter);
		sb.append(postfix);
		return sb.toString();
	}

	public String getPostfix() {
		return postfix;
	}

	public void setPostfix(String prefix) {
		this.postfix = prefix;
	}

	public void setDelimeter(String delimeter) {
		this.delimeter = delimeter;
	}

}
