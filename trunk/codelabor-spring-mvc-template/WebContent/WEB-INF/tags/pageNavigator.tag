<%@ tag language="java" pageEncoding="UTF-8" import="anyframe.common.Page, java.util.*"%>
<%


	Page pageObject = (Page) request.getAttribute("page");

	int pageIndex = 0;
	Map parameterMap = request.getParameterMap();

	int beginUnitPage = pageObject.getBeginUnitPage();
	int endUnitPage = pageObject.getEndUnitPage();
	int currentPage = pageObject.getCurrentPage();
	int endLinePage = pageObject.getEndListPage();

	StringBuilder sb = new StringBuilder();

	// left bundle link
	if (pageObject.hasPreviousPageUnit()) {
		pageIndex = pageObject.getPageOfPreviousPageUnit();

		parameterMap.put("pageIndex", pageIndex);
		Set keySet = parameterMap.keySet();
		Iterator iterator = keySet.iterator();

		StringBuilder queryStringBuilder = new StringBuilder();
		queryStringBuilder.append("?");
		while (iterator.hasNext()) {

			String key = (String) iterator.next();
			Object value = parameterMap.get(key);
			queryStringBuilder.append(key).append("=").append(value);
			if (iterator.hasNext()) {
				queryStringBuilder.append("&");
			}
		}

		sb.append("<a href='");
		sb.append(queryStringBuilder.toString());
		sb.append("'>");
		sb.append("&lt;&lt;");
		sb.append("</a>");
	} else {
		sb.append("&lt;&lt;");
	}
	sb.append("&nbsp;");

	// left page link
	if (pageObject.hasPreviousPage()) {
		pageIndex = pageObject.getPreviousPage();

		parameterMap.put("pageIndex", pageIndex);
		Set keySet = parameterMap.keySet();
		Iterator iterator = keySet.iterator();

		StringBuilder queryStringBuilder = new StringBuilder();
		queryStringBuilder.append("?");
		while (iterator.hasNext()) {

			String key = (String) iterator.next();
			Object value = parameterMap.get(key);
			queryStringBuilder.append(key).append("=").append(value);
			if (iterator.hasNext()) {
				queryStringBuilder.append("&");
			}
		}

		sb.append("<a href='");
		sb.append(queryStringBuilder.toString());
		sb.append("'>");
		sb.append("&lt;");
		sb.append("</a>");
	} else {
		sb.append("&lt;");
	}
	sb.append("&nbsp;");


	// index
	int availableEndLinePage = 0;
	if (currentPage < endLinePage) {
		availableEndLinePage = endLinePage;
	} else {
		availableEndLinePage = currentPage;
	}
	for (int i=beginUnitPage; i<=availableEndLinePage; i++) {
		if (i != currentPage) {
			pageIndex = i;
			parameterMap.put("pageIndex", pageIndex);

			Set keySet = parameterMap.keySet();
			Iterator iterator = keySet.iterator();

			StringBuilder queryStringBuilder = new StringBuilder();
			queryStringBuilder.append("?");
			while (iterator.hasNext()) {

				String key = (String) iterator.next();
				Object value = parameterMap.get(key);
				queryStringBuilder.append(key).append("=").append(value);
				if (iterator.hasNext()) {
					queryStringBuilder.append("&");
				}
			}

			sb.append("<a href='");
			sb.append(queryStringBuilder.toString());
			sb.append("'>");
			sb.append(i);
			sb.append("</a>");
		} else {
			sb.append(i);
		}
		sb.append("&nbsp;");
	}


	// right page link
	if (pageObject.hasNextPage()) {
		pageIndex = pageObject.getNextPage();

		parameterMap.put("pageIndex", pageIndex);
		Set keySet = parameterMap.keySet();
		Iterator iterator = keySet.iterator();

		StringBuilder queryStringBuilder = new StringBuilder();
		queryStringBuilder.append("?");
		while (iterator.hasNext()) {

			String key = (String) iterator.next();
			Object value = parameterMap.get(key);
			queryStringBuilder.append(key).append("=").append(value);
			if (iterator.hasNext()) {
				queryStringBuilder.append("&");
			}
		}

		sb.append("<a href='");
		sb.append(queryStringBuilder.toString());
		sb.append("'>");
		sb.append("&gt;");
		sb.append("</a>");
	} else {
		sb.append("&gt;");
	}
	sb.append("&nbsp;");

	// right bundle link
	if (pageObject.hasNextPageUnit()) {
		pageIndex = pageObject.getPageOfNextPageUnit();

		parameterMap.put("pageIndex", pageIndex);
		Set keySet = parameterMap.keySet();
		Iterator iterator = keySet.iterator();

		StringBuilder queryStringBuilder = new StringBuilder();
		queryStringBuilder.append("?");
		while (iterator.hasNext()) {

			String key = (String) iterator.next();
			Object value = parameterMap.get(key);
			queryStringBuilder.append(key).append("=").append(value);
			if (iterator.hasNext()) {
				queryStringBuilder.append("&");
			}
		}

		sb.append("<a href='");
		sb.append(queryStringBuilder.toString());
		sb.append("'>");
		sb.append("&gt;&gt;");
		sb.append("</a>");
	} else {
		sb.append("&gt;&gt;");
	}

	out.print(sb.toString());
%>