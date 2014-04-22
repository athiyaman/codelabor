<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jspf/taglib.jspf"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<!-- Registration Form -->
<title><spring:message
		code="title.example.validation.hibernate.safeHtml.post" /></title>
</head>
<body>
	<!-- Registration Form -->
	<h1>
		<spring:message
			code="heading.example.validation.hibernate.safeHtml.form" />
	</h1>
	<hr />

	<!-- global errors -->
	<div id="global.errors.area" />

	<h2><spring:message
			code="heading.example.validation.hibernate.safeHtml.whitelistType" /></h2>
	<form:form commandName="htmlContents1Dto">
		<!-- form errors -->
		<form:errors path="*" />
		<codelaborForm:errors path="*" />

		<table>
			<tr>
				<!-- stringData1 -->
				<td><label for="stringData1">@SafeHtml(whitelistType=WhiteListType.NONE)</label></td>
				<td><form:input path="stringData1" type="text" placeholder="" /></td>
				<!-- field errors  -->
				<td><form:errors path="stringData1" /></td>
				<td>This whitelist allows only text nodes: all HTML will be
					stripped.</td>
			</tr>
			<tr>
				<!-- stringData2 -->
				<td><label for="stringData2">@SafeHtml(whitelistType=WhiteListType.SIMPLE_TEXT)</label></td>
				<td><form:input path="stringData2" type="text" placeholder="" /></td>
				<!-- field errors  -->
				<td><form:errors path="stringData2" /></td>
				<td>This whitelist allows only simple text formatting: b, em,
					i, strong, u. All other HTML (tags and attributes) will be removed.</td>
			</tr>
			<tr>
				<!-- stringData3 -->
				<td><label for="stringData3">@SafeHtml(whitelistType=WhiteListType.BASIC)</label></td>
				<td><form:input path="stringData3" type="text" placeholder="" /></td>
				<!-- field errors  -->
				<td><form:errors path="stringData3" /></td>
				<td>This whitelist allows a fuller range of text nodes: a, b,
					blockquote, br, cite, code, dd, dl, dt, em, i, li, ol, p, pre, q,
					small, strike, strong, sub, sup, u, ul , and appropriate
					attributes. Links (a elements) can point to http, https, ftp,
					mailto, and have an enforced rel=nofollow attribute. Does not allow
					images.</td>
			</tr>
			<tr>
				<!-- stringData4 -->
				<td><label for="stringData4">@SafeHtml(whitelistType=WhiteListType.BASIC_WITH_IMAGES)</label></td>
				<td><form:input path="stringData4" type="text" placeholder="" /></td>
				<!-- field errors  -->
				<td><form:errors path="stringData4" /></td>
				<td>This whitelist allows the same text tags as BASIC, and also
					allows img tags, with appropriate attributes, with src pointing to
					http or https.</td>
			</tr>
			<tr>
				<!-- stringData5 -->
				<td><label for="stringData5">@SafeHtml(whitelistType=WhiteListType.RELAXED)</label></td>
				<td><form:input path="stringData5" type="text" placeholder="" /></td>
				<!-- field errors  -->
				<td><form:errors path="stringData5" /></td>
				<td>This whitelist allows a full range of text and structural
					body HTML: a, b, blockquote, br, caption, cite, code, col,
					colgroup, dd, dl, dt, em, h1, h2, h3, h4, h5, h6, i, img, li, ol,
					p, pre, q, small, strike, strong, sub, sup, table, tbody, td,
					tfoot, th, thead, tr, u, ul Links do not have an enforced
					rel=nofollow attribute, but you can add that if desired.</td>
			</tr>
			<tr>
				<td colspan="3"><input id="submit" type="submit"
					value="<spring:message code="button.submit" />" /> <input
					type="reset" value="<spring:message code="button.reset" />" /></td>
			</tr>
		</table>
	</form:form>

	<h2><spring:message
			code="heading.example.validation.hibernate.safeHtml.whitelistType.additionalTags" /></h2>
	<form:form commandName="htmlContents2Dto">
		<!-- form errors -->
		<form:errors path="*" />
		<codelaborForm:errors path="*" />

		<table>
			<tr>
				<!-- stringData1 -->
				<td><label for="stringData1">@SafeHtml(whitelistType=WhiteListType.NONE)</label></td>
				<td><form:input path="stringData1" type="text" placeholder="" /></td>
				<!-- field errors  -->
				<td><form:errors path="stringData1" /></td>
				<td>This whitelist allows only text nodes: all HTML will be
					stripped.</td>
			</tr>
			<tr>
				<!-- stringData2 -->
				<td><label for="stringData2">@SafeHtml(whitelistType=WhiteListType.SIMPLE_TEXT)</label></td>
				<td><form:input path="stringData2" type="text" placeholder="" /></td>
				<!-- field errors  -->
				<td><form:errors path="stringData2" /></td>
				<td>This whitelist allows only simple text formatting: b, em,
					i, strong, u. All other HTML (tags and attributes) will be removed.</td>
			</tr>
			<tr>
				<!-- stringData3 -->
				<td><label for="stringData3">@SafeHtml(whitelistType=WhiteListType.BASIC)</label></td>
				<td><form:input path="stringData3" type="text" placeholder="" /></td>
				<!-- field errors  -->
				<td><form:errors path="stringData3" /></td>
				<td>This whitelist allows a fuller range of text nodes: a, b,
					blockquote, br, cite, code, dd, dl, dt, em, i, li, ol, p, pre, q,
					small, strike, strong, sub, sup, u, ul , and appropriate
					attributes. Links (a elements) can point to http, https, ftp,
					mailto, and have an enforced rel=nofollow attribute. Does not allow
					images.</td>
			</tr>
			<tr>
				<!-- stringData4 -->
				<td><label for="stringData4">@SafeHtml(whitelistType=WhiteListType.BASIC_WITH_IMAGES)</label></td>
				<td><form:input path="stringData4" type="text" placeholder="" /></td>
				<!-- field errors  -->
				<td><form:errors path="stringData4" /></td>
				<td>This whitelist allows the same text tags as BASIC, and also
					allows img tags, with appropriate attributes, with src pointing to
					http or https.</td>
			</tr>
			<tr>
				<!-- stringData5 -->
				<td><label for="stringData5">@SafeHtml(whitelistType=WhiteListType.RELAXED)</label></td>
				<td><form:input path="stringData5" type="text" placeholder="" /></td>
				<!-- field errors  -->
				<td><form:errors path="stringData5" /></td>
				<td>This whitelist allows a full range of text and structural
					body HTML: a, b, blockquote, br, caption, cite, code, col,
					colgroup, dd, dl, dt, em, h1, h2, h3, h4, h5, h6, i, img, li, ol,
					p, pre, q, small, strike, strong, sub, sup, table, tbody, td,
					tfoot, th, thead, tr, u, ul Links do not have an enforced
					rel=nofollow attribute, but you can add that if desired.</td>
			</tr>
			<tr>
				<td colspan="3"><input id="submit" type="submit"
					value="<spring:message code="button.submit" />" /> <input
					type="reset" value="<spring:message code="button.reset" />" /></td>
			</tr>
		</table>
	</form:form>

	<h2><spring:message
			code="heading.example.validation.hibernate.safeHtml.whitelistType.additionalTagsWithAttributes" /></h2>
	<form:form commandName="htmlContents3Dto">
		<!-- form errors -->
		<form:errors path="*" />
		<codelaborForm:errors path="*" />

		<table>
			<tr>
				<!-- stringData1 -->
				<td><label for="stringData1">@SafeHtml(whitelistType=WhiteListType.NONE)</label></td>
				<td><form:input path="stringData1" type="text" placeholder="" /></td>
				<!-- field errors  -->
				<td><form:errors path="stringData1" /></td>
				<td>This whitelist allows only text nodes: all HTML will be
					stripped.</td>
			</tr>
			<tr>
				<!-- stringData2 -->
				<td><label for="stringData2">@SafeHtml(whitelistType=WhiteListType.SIMPLE_TEXT)</label></td>
				<td><form:input path="stringData2" type="text" placeholder="" /></td>
				<!-- field errors  -->
				<td><form:errors path="stringData2" /></td>
				<td>This whitelist allows only simple text formatting: b, em,
					i, strong, u. All other HTML (tags and attributes) will be removed.</td>
			</tr>
			<tr>
				<!-- stringData3 -->
				<td><label for="stringData3">@SafeHtml(whitelistType=WhiteListType.BASIC)</label></td>
				<td><form:input path="stringData3" type="text" placeholder="" /></td>
				<!-- field errors  -->
				<td><form:errors path="stringData3" /></td>
				<td>This whitelist allows a fuller range of text nodes: a, b,
					blockquote, br, cite, code, dd, dl, dt, em, i, li, ol, p, pre, q,
					small, strike, strong, sub, sup, u, ul , and appropriate
					attributes. Links (a elements) can point to http, https, ftp,
					mailto, and have an enforced rel=nofollow attribute. Does not allow
					images.</td>
			</tr>
			<tr>
				<!-- stringData4 -->
				<td><label for="stringData4">@SafeHtml(whitelistType=WhiteListType.BASIC_WITH_IMAGES)</label></td>
				<td><form:input path="stringData4" type="text" placeholder="" /></td>
				<!-- field errors  -->
				<td><form:errors path="stringData4" /></td>
				<td>This whitelist allows the same text tags as BASIC, and also
					allows img tags, with appropriate attributes, with src pointing to
					http or https.</td>
			</tr>
			<tr>
				<!-- stringData5 -->
				<td><label for="stringData5">@SafeHtml(whitelistType=WhiteListType.RELAXED)</label></td>
				<td><form:input path="stringData5" type="text" placeholder="" /></td>
				<!-- field errors  -->
				<td><form:errors path="stringData5" /></td>
				<td>This whitelist allows a full range of text and structural
					body HTML: a, b, blockquote, br, caption, cite, code, col,
					colgroup, dd, dl, dt, em, h1, h2, h3, h4, h5, h6, i, img, li, ol,
					p, pre, q, small, strike, strong, sub, sup, table, tbody, td,
					tfoot, th, thead, tr, u, ul Links do not have an enforced
					rel=nofollow attribute, but you can add that if desired.</td>
			</tr>
			<tr>
				<td colspan="3"><input id="submit" type="submit"
					value="<spring:message code="button.submit" />" /> <input
					type="reset" value="<spring:message code="button.reset" />" /></td>
			</tr>
		</table>
	</form:form>


	<%@ include file="/WEB-INF/jspf/footer.jspf"%>

</body>
</html>