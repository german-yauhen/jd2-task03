<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
	<head>
		<title><spring:message code="label.newslistname"/></title>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<spring:url value="/resources/css/main.css" var="mainCss" />
		<link href="${mainCss}" rel="stylesheet" />
	</head>
	<body>
	<jsp:include page="header.jsp"/>
	<div class="wrapper-middle-context">
		<jsp:include page="leftbar.jsp"/>
		<div class="wrapper-main-content">
			<div class="link-sequence">News >> News List</div>
			<div class="main-content">
				<div class="news-element">
					<div class="news-title">News Title: title</div>
					<div class="news-brief">Brief</div>
					<div class="news-date">Date of Publication</div>
					<div class="view-link">View</div>
					<div class="edit-link">Edit</div>
					<div class="checkbox-element"><input type="checkbox" />id news</div>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="footer.jsp"/>
	</body>
</html>