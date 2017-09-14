<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
		<title><spring:message code="label.newslistname"/></title>
		<spring:url value="/resources/css/main.css" var="mainCss" />
		<link href="${mainCss}" rel="stylesheet" />
	</head>
	<body>
	<jsp:include page="header.jsp"/>
	<div class="wrapper-middle-context">
		<jsp:include page="leftbar.jsp"/>
		<div class="wrapper-main-content">
			<div class="main-content">
				<jstl:forEach items="${newsView.getNewsList()}" var="news">
					<div class="news-title-elem">${news.getContents().getTitle()}</div>
					<div class="news-date-elem">${String.valueOf(news.getDateOfPublication())}</div>
					<div class="news-brief-elem">${news.getContents().getBrief()}</div>
					<div class="link-elem">
						<a href="view-news?newsId=${news.getId()}"><spring:message code="label.viewname"/></a>
					</div>
					<div class="link-elem">
						<a href="edit-news?newsId=${news.getId()}"><spring:message code="label.editname"/></a>
					</div>
					<input type="checkbox" value="news"/>
				</jstl:forEach>
			</div>
		</div>
	</div>
	<jsp:include page="footer.jsp"/>
	</body>
</html>