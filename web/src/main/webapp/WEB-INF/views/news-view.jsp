<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="jstl" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
	<head>
		<title><spring:message code="label.newsviewname"/></title>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<spring:url value="/resources/css/main.css" var="mainCss" />
		<link href="${mainCss}" rel="stylesheet" />
	</head>
	<body>
		<jsp:include page="header.jsp"/>
		<div class="wrapper-middle-context">
			<jsp:include page="leftbar.jsp"/>
			<div class="wrapper-main-content">
				<div class="main-content">
					<table>
						<tr>
							<td><label id="title"><spring:message code="label.newstitle"/></label></td>
							<td>${newsView.getNewsMessage().getContents().getTitle()}</td>
						</tr>
						<tr>
							<td><label id="date"><spring:message code="label.newsdate"/></label></td>
							<td>${String.valueOf(newsView.getNewsMessage().getDateOfPublication())}</td>
						</tr>
						<tr>
							<td><label id="brief"><spring:message code="label.brief"/></label></td>
							<td>${newsView.getNewsMessage().getContents().getBrief()}</td>
						</tr>
						<tr>
							<td><label id="content"><spring:message code="label.content"/></label></td>
							<td>${newsView.getNewsMessage().getContents().getContent()}</td>
						</tr>
					</table>
				</div>
			</div>
		</div>
		<jsp:include page="footer.jsp"/>
	</body>
</html>