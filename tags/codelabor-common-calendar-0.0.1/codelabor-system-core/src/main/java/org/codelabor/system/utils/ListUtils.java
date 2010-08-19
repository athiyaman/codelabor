package org.codelabor.system.utils;

import java.util.Iterator;
import java.util.List;

import org.springframework.util.AntPathMatcher;

public class ListUtils {
	static public boolean containsByAntStylePattern(List<String> patternList,
			String text) {
		boolean isContains = false;
		AntPathMatcher antPathMatcher = new AntPathMatcher();
		Iterator<String> iterator = patternList.iterator();
		while (iterator.hasNext()) {
			String pattern = iterator.next();
			if (antPathMatcher.match(pattern, text)) {
				isContains = true;
			} else {
				// bypass
			}
		}
		return isContains;
	}
}
