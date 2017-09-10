<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
	<head>
		<title>News List Page</title>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<spring:url value="/resources/css/main.css" var="mainCss" />
		<link href="${mainCss}" rel="stylesheet" />
	</head>
	<body>
	<header>
		<div class="header-content">
			<div class="application-title"><spring:message code="label.apptitle"/></div>
			<div class="languages-content">
				<div class="language-element"><a href="?language=en">English</a></div>
				<div class="language-element"><a href="?language=ru">Russian</a></div>
			</div>
		</div>
	</header>
	<div class="wrapper-middle-context">
		<div class="wrapper-leftbar-content">
			<div class="leftbar-element"><a href="news-list/get-news-list"><spring:message code="label.newslist" /></a></div>
			<div class="leftbar-element"><a href="add-news/create-news"><spring:message code="label.addnews" /></a></div>
		</div>
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
	<footer>
		<div class="footer-content">
			<div class="application-footer-data">
				<spring:message code="label.copyright"/>
			</div>
		</div>
	</footer>
	</body>
</html>
