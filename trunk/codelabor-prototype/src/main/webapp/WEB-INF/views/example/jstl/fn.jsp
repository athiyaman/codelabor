<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jspf/taglib.jspf" %>
<!DOCTYPE html>
<%--
Author Shin Sang-Jae
--%>
<html>
<head>
<meta charset="UTF-8">
<title>Function Example <system:properties key="con.name" /></title>
</head>
<body>
<h1>Function Example</h1>

<%
pageContext.setAttribute("muliLineTextLF", "1234\nqwer\n가나다라\n");
pageContext.setAttribute("muliLineTextCR", "1234\rqwer\r가나다라\r");
pageContext.setAttribute("muliLineTextCRLF", "1234\r\nqwer\r\n가나다라\r\n");
pageContext.setAttribute("muliLineTextLFCR", "1234\n\rqwer\n\r가나다라\n\r");
pageContext.setAttribute("muliLineTextLLFCRCRLFFCR", "1234\nqwer\n가나다라\n1234\rqwer\r가나다라\r1234\r\nqwer\r\n가나다라\r\n1234\n\rqwer\n\r가나다라\n\r");

pageContext.setAttribute("LF", "\n");
pageContext.setAttribute("CR", "\r");
pageContext.setAttribute("CRLF", "\r\n");
pageContext.setAttribute("LFCR", "\n\r");
pageContext.setAttribute("LFCRCRLFLFCR", "(\n|\r|\r\n|\n\r)");
pageContext.setAttribute("BR", "<br />");

%>

<hr />
<h3>EL</h3>
${muliLineText}

<h3>Spring Taglib</h3>

<h4>escapeBody: LF</h4>
<spring:escapeBody javaScriptEscape="true">${muliLineTextLF}</spring:escapeBody>

<h4>escapeBody: CR</h4>
<spring:escapeBody javaScriptEscape="true">${muliLineTextCR}</spring:escapeBody>

<h4>escapeBody: CRLF</h4>
<spring:escapeBody javaScriptEscape="true">${muliLineTextCRLF}</spring:escapeBody>

<h4>escapeBody: LFCR</h4>
<spring:escapeBody javaScriptEscape="true">${muliLineTextLFCR}</spring:escapeBody>

<h3>JSTL Function</h3>

<h4>LF (Unix)</h4>
${fn:replace(muliLineTextLF, LF, BR)}

<h4>CR (Mac OS)</h4>
${fn:replace(muliLineTextCR, CR, BR)}

<h4>CR+LF (Windows)</h4>
${fn:replace(muliLineTextCRLF, CRLF, BR)}

<h4>LF+CR (RISC OS)</h4>
${fn:replace(muliLineTextLFCR, LFCR, BR)}

<h3>JSTL Function 2</h3>

<h4>LF (Unix)</h4>
${fn:replace(muliLineTextLFCR, LF, BR)}

<h4>CR (Mac OS)</h4>
${fn:replace(muliLineTextLFCR, CR, BR)}

<h4>CR+LF (Windows)</h4>
${fn:replace(muliLineTextLFCR, CRLF, BR)}

<h4>LF+CR (RISC OS)</h4>
${fn:replace(muliLineTextLFCR, LFCR, BR)}

<h4>LF, CR, CR+LF, LF+CR</h4>
${fn:replace(muliLineTextLLFCRCRLFFCR, LFCRCRLFLFCR, BR)}



</body>
</html>