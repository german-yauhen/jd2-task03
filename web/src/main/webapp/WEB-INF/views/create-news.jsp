<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
	<head>
		<title>Create News Context</title>
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
			<div class="leftbar-element"><a href="add-news/create-news-form"><spring:message code="label.addnews" /></a></div>
		</div>
		<div class="wrapper-main-content">
			<div class="main-content">
				<form:form modelAttribute="flashyNews" action="process-news-form">
					<table>
						<tr>
							<td><label for="title">News Title</label></td>
							<td><form:input id="title" type="text" path="contents.title"/></td>
							<td><form:errors path="contents.title" cssClass="error"/></td>
						</tr>
						<tr>
							<td><label for="date">News Date</label></td>
							<td><form:input id="date" type="text" path="dateOfPublication"/></td>
							<td><form:errors path="dateOfPublication" cssClass="error"/></td>
						</tr>
						<tr>
							<td><label for="brief">Brief</label></td>
							<td><form:textarea id="brief" path="contents.brief"/></td>
							<td><form:errors path="contents.brief" cssClass="error"/></td>
						</tr>
						<tr>
							<td><label for="content">Content</label></td>
							<td><form:textarea id="content" path="contents.content"/></td>
							<td><form:errors path="contents.content" cssClass="error"/></td>
						</tr>
					</table>
					<input type="reset" value="RESET" />
					<input type="submit" value="SAVE" />
				</form:form>
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