package org.codelabor.system.utils;

import java.util.Iterator;
import java.util.List;

import org.springframework.util.AntPathMatcher;

/**
 * 리스트 유틸
 * 
 * @author Shin Sangjae
 * 
 */
public class ListUtils {
	/**
	 * 리스트 안의 내용 중 Ant 스타일 패턴에 매칭되는 것이 있는지 확인한다.
	 * 
	 * @param patternList
	 *            패턴 List
	 * @param text
	 *            매칭할 문자열
	 * @return 매칭 여부
	 */
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
