<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jspf/taglib.jspf"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<!-- Registration Form -->
<title><spring:message
		code="title.example.validation.registration" /> <system:properties key="servlet.container.id" /></title>
<meta name="robots" content="noindex, nofollow" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta http-equiv="Content-Script-Type" content="text/javascript" />
<meta http-equiv="Content-Style-Type" content="text/css" />
<!-- 공통 -->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/common/jquery/jquery-1.10.2.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/common/common.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/common/jquery/jquery.placeholder.min.js"></script>

<!-- 달력 -->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/common/jquery/jquery.form.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/common/jquery/jquery-ui.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/common/jquery/jquery.ui.core.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/common/jquery/jquery.ui.position.min.js"></script>

<!-- validate -->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/common/jquery/jquery.validate.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/common/jquery/custom.jquery.plugin.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/common/jquery/jquery.metadata.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/common/jquery/messages_ko.js"></script>

<link href="${pageContext.request.contextPath}/css/common/jquery-ui.css"
	rel="stylesheet" type="text/css" />
<link
	href="${pageContext.request.contextPath}/css/common/jquery-ui-1.10.0.custom.min.css"
	rel="stylesheet" type="text/css" />
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/css/common/jquery.placeholder.css" />
<script type="text/javascript">



$(document).ready(function() {


	$("#formBtn").click(function(e) {
		$('#personDto').submit();
	});

	$("#personDto").validate( $.extend({}, validateDefaultOption, {
		ignore: "",
		// 예) "input[type='text']:hidden"
		rules: {
			username: { equalTo: "#tttt" }
		},
		messages: {
			username: { equalTo: "메세지" }
		},
		submitHandler: function(form) {
			// submit 전 개별 체크 및 비지니스 로직 설정

			// submit 전 개별 체크 및 비지니스 로직 설정
			form.submit();

		}
	}));

});




</script>
</head>
<body>
	${pageContext.request.contextPath}
	<!-- Registration Form -->
	<h1>
		<spring:message code="heading.example.validation.registration.form" />
	</h1>
	<hr />


	<div id="global.errors.area"></div>

	<form:form commandName="personDto">

		<form:errors path="*" />
		<codelaborForm:errors path="*" />

		<table>
			<tr>
				<!-- Username -->
				<td>필수입력</td>
				<td><input type="text" id="username" name="username"
					placeholder="아이디는 필수 입력 항목입니다." maxlength="12"></input></td>
				<td><form:errors path="username" /></td>
			</tr>
			<tr>
				<!-- Username -->
				<td>특수문자입력불가</td>
				<td><input type="text" id="tttt" name="tttt"
					placeholder="아이디는 필수 입력 항목입니다." maxlength="12"></input></td>
				<td><form:errors path="username" /></td>
			</tr>
			<tr>
				<!-- Password -->
				<td><spring:message code="label.password" /></td>
				<td><form:password path="password" /></td>
				<td><form:errors path="password" /></td>
			</tr>
			<tr>
				<!-- Password Confirmation -->
				<td><spring:message code="label.passwordConfirm" /></td>
				<td><form:password path="passwordConfirm" /></td>
				<td><form:errors path="passwordConfirm" /></td>
			</tr>
			<tr>
				<!-- First Name -->
				<td><spring:message code="label.firstName" /></td>
				<td><form:input path="firstName" /></td>
				<td><form:errors path="firstName" /></td>
			</tr>
			<tr>
				<!-- Last Name -->
				<td><spring:message code="label.lastName" /></td>
				<td><form:input path="lastName" /></td>
				<td><form:errors path="lastName" /></td>
			</tr>
			<tr>
				<!-- Mobile Phone -->
				<td><spring:message code="label.mobilePhone" /><span>0X-XXX-XXXX,
						01X-XXXX-XXXX</span></td>
				<td><form:input path="mobilePhone" /></td>
				<td><form:errors path="mobilePhone" /></td>
			</tr>
			<tr>
				<!-- Home Phone -->
				<td><spring:message code="label.homePhone" /><span>0X-XXX-XXXX,
						0X-XXXX-XXXX, 0XX-XXX-XXXX, 0XX-XXXX-XXXX</span></td>
				<td><form:input path="homePhone" /></td>
				<td><form:errors path="homePhone" /></td>
			</tr>
			<tr>
				<!-- Email -->
				<td><spring:message code="label.email" /></td>
				<td><form:input path="email" /></td>
				<td><form:errors path="email" /></td>
			</tr>
			<tr>
				<!-- Email Confirmation -->
				<td><spring:message code="label.emailConfirm" /></td>
				<td><form:input path="emailConfirm" /></td>
				<td><form:errors path="emailConfirm" /></td>
			</tr>
			<tr>
				<!-- Zip Code -->
				<td><spring:message code="label.zipCode" /></td>
				<td><form:input path="zipCode" /></td>
				<td><form:errors path="zipCode" /></td>
			</tr>
			<tr>
				<!-- Birth Date -->
				<td><spring:message code="label.birthDate" /> yyyy-MM-dd</td>
				<td><form:input path="birthDate" /></td>
				<td><form:errors path="birthDate" /></td>
			</tr>
			<tr>
				<td colspan="2"><input id="formBtn" type="button"
					value="<spring:message code="button.save" />" /> <input
					type="reset" value="<spring:message code="button.reset" />" /></td>
			</tr>
		</table>
	</form:form>


	<%@ include file="/WEB-INF/jspf/footer.jspf"%>

</body>
</html>