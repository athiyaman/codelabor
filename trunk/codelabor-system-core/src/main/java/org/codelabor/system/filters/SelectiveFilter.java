package org.codelabor.system.filters;

import java.util.List;

import javax.servlet.FilterConfig;

public interface SelectiveFilter {

	public final String delimeterPattern = "([ ]*[,; ][ ]*)";

	public List<String> getIncludePatterns(FilterConfig filterConfig);

	public List<String> getExcludePatterns(FilterConfig filterConfig);
}
