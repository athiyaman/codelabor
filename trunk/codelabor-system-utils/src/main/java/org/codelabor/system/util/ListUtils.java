package org.codelabor.system.util;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * List Utility
 * @author Shin Sang-jae
 *
 */
public class ListUtils {
	/**
	 * 로거
	 */
	private static Logger logger = LoggerFactory.getLogger(ListUtils.class);
	/**
	 * List의 내용을 delimeter로 구분하여 문자열 형태로 만든다.
	 * @param list List
	 * @param delimeter 구분자
	 * @return List의 내용이 delimeter로 구분되어 나열된 문자열
	 */
	static String toDelimetedString(List<? extends Object> list, String delimeter) {
		if (list.isEmpty()) return "";
		StringBuilder sb = new StringBuilder();
		for (Object listItem : list) {
			sb.append(listItem);
			sb.append(delimeter);
		}
		sb.delete(sb.length() - delimeter.length(), sb.length());
		logger.debug("delimeted string: {}", sb.toString());
		return sb.toString();
	}
}
