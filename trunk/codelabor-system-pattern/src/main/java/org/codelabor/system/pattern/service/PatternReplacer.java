package org.codelabor.system.pattern.service;

import java.util.List;
import java.util.Map;

public interface PatternReplacer {
	public String replace(String inputString);
	public String replace(String searchPattern, String replacePattern, String inputString);
	public String replace(Map<String, String> includesPatternMap, String inputString);
	public String replace(Map<String, String> includesPatternMap, List<String> excludesPatternMap, String inputString);
}
