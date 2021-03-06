<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
	<head>
		<title><spring:message code="label.mainpagename" /></title>
		<link href="${pageContext.request.contextPath}/resources/css/main.css" rel="stylesheet" />
	</head>
	<body>
	<jsp:include page="header.jsp"/>
	<div class="wrapper-middle-context">
		<jsp:include page="leftbar.jsp"/>
		<div class="wrapper-main-content">
			<div class="main-content">
				<spring:message code="label.welcome"/>
			</div>
		</div>
	</div>
	<jsp:include page="footer.jsp"/>
	</body>
</html>