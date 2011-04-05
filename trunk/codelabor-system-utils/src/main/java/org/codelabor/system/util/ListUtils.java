package org.codelabor.system.util;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ListUtils {
	private static Logger logger = LoggerFactory.getLogger(ListUtils.class);
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
