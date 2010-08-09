package org.codelabor.system.file.strategies;

import anyframe.core.idgen.IdGenerationStrategy;

public class MapIdStrategy implements IdGenerationStrategy {

	protected String prefix;

	public String makeId(String originalId) {
		StringBuilder sb = new StringBuilder();
		sb.append(prefix);
		sb.append(originalId);
		return sb.toString();
	}

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

}
