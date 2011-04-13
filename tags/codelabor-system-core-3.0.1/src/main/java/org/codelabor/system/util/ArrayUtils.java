package org.codelabor.system.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Array Utility
 * @author Shin Sang-jae
 *
 */
public class ArrayUtils {
	/**
	 * 로거
	 */
	private static Logger logger = LoggerFactory.getLogger(ArrayUtils.class);

	/**
	 * 배열의 내용을 delimeter로 구분하여 문자열 형태로 만든다.
	 * @param array 배열
	 * @param delimeter 구분자
	 * @return List의 내용이 delimeter로 구분되어 나열된 문자열
	 */
	public static <T>String toDelimetedString(T[] array, String delimeter) {
		if (array.length == 0) return "";
		StringBuilder sb = new StringBuilder();
		for (T arrayItem : array) {
			sb.append(arrayItem);
			sb.append(delimeter);
		}
		sb.delete(sb.length() - delimeter.length(), sb.length());
		logger.debug("delimeted string: {}", sb.toString());
		return sb.toString();
	}
}
