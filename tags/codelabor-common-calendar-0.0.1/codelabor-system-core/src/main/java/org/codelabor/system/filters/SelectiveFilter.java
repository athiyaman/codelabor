package org.codelabor.system.filters;

import java.util.List;

import javax.servlet.FilterConfig;

public interface SelectiveFilter {

	/**
	 * 필터 적용 포함 리스트를 설정 파라미터에서 가져온다.
	 * 
	 * @param filterConfig
	 * @return 포함 항목의 리스트
	 */
	public List<String> getIncludePatterns(FilterConfig filterConfig);

	/**
	 * 필터 적용 예외 리스트를 설정 파라미터에서 가져온다.
	 * 
	 * @param filterConfig
	 * @return 예외 항목의 리스트
	 */
	public List<String> getExcludePatterns(FilterConfig filterConfig);

	/**
	 * 최종적으로 필터 로직 수행 여부를 판단한다.
	 * 
	 * @param requestURI
	 * @return 필터 로직 수행 여부
	 */
	public boolean isFilterRequired(String requestURI);
}
