package org.codelabor.system.util;

import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.AntPathMatcher;

/**
 * List Utility
 * 
 * @author Shin Sang-jae
 * 
 */
public class ListUtils {
	/**
	 * 로거
	 */
	private static Logger logger = LoggerFactory.getLogger(ListUtils.class);

	/**
	 * 리스트 안의 내용중 매칭되는 것이 있는지 확인한다.
	 * 
	 * @param patternList
	 *            패턴 List
	 * @param text
	 *            매칭할 문자열
	 * @return 매칭 여부
	 * @since 3.0.5
	 */
	static public boolean contains(List<String> patternList, String text) {
		return patternList.contains(text);
	}

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
		boolean isContained = false;
		AntPathMatcher antPathMatcher = new AntPathMatcher();
		Iterator<String> iterator = patternList.iterator();
		while (iterator.hasNext()) {
			String pattern = iterator.next();
			if (antPathMatcher.match(pattern, text)) {
				isContained = true;
			} else {
				// bypass
			}
		}
		return isContained;
	}

	/**
	 * 리스트 안의 내용 중 Regex 패턴에 매칭되는 것이 있는지 확인한다.
	 * 
	 * @param patternList
	 *            패턴 List
	 * @param text
	 *            매칭할 문자열
	 * @return 매칭 여부
	 * @since 3.0.5
	 */
	static public boolean containsByRegexPattern(List<String> patternList,
			String text) {
		boolean isContained = false;
		Iterator<String> iterator = patternList.iterator();
		while (iterator.hasNext()) {
			String pattern = iterator.next();
			if (Pattern.matches(pattern, text)) {
				isContained = true;
			} else {
				// bypass
			}
		}
		return isContained;
	}

	/**
	 * List의 내용을 delimeter로 구분하여 문자열 형태로 만든다.
	 * 
	 * @param list
	 *            List
	 * @param delimeter
	 *            구분자
	 * @return List의 내용이 delimeter로 구분되어 나열된 문자열
	 */
	public static <T> String toDelimetedString(List<T> list, String delimeter) {
		if (list.isEmpty())
			return "";
		StringBuilder sb = new StringBuilder();
		for (T listItem : list) {
			sb.append(listItem);
			sb.append(delimeter);
		}
		sb.delete(sb.length() - delimeter.length(), sb.length());
		logger.debug("delimeted string: {}", sb.toString());
		return sb.toString();
	}
}
