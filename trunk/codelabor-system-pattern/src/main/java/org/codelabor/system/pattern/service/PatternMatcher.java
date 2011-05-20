package org.codelabor.system.pattern.service;

import java.util.List;

public interface PatternMatcher {
	public boolean maches(String inputString);
	public boolean maches(String pattern, String inputString);
	public boolean maches(List<String> patternList, String inputString);
	public boolean maches(List<String> includesPatternList, List<String> excludesPatternList, String inputString);
}
