<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
	<head>
		<title>Create News Context</title>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<spring:url value="/resources/css/main.css" var="mainCss" />
		<link href="${mainCss}" rel="stylesheet" />
		<script>
			function resetForm() {
				document.getElementById("regform").reset();
            }
            function submitSave() {
			    var query = confirm("Confirm the saving operation.");
			    if (query) return true;
			    else return false;
            }
		</script>
	</head>
	<body>
	<jsp:include page="header.jsp"/>
	<div class="wrapper-middle-context">
		<jsp:include page="leftbar.jsp"/>
		<div class="wrapper-main-content">
			<div class="main-content">
				<form:form id="regform" modelAttribute="flashyNews" action="process-news-form" method="post">
					<table>
						<tr>
							<td><label for="title"><spring:message code="label.newstitle"/></label></td>
							<td><form:input id="title" type="text" path="contents.title"/></td>
							<td><form:errors path="contents.title" cssClass="error"/></td>
						</tr>
						<tr>
							<td><label for="date"><spring:message code="label.newsdate"/></label></td>
							<td><form:input id="date" type="text" path="dateOfPublication"/></td>
							<td><form:errors path="dateOfPublication" cssClass="error"/></td>
						</tr>
						<tr>
							<td><label for="brief"><spring:message code="label.brief"/></label></td>
							<td><form:textarea id="brief" path="contents.brief"/></td>
							<td><form:errors path="contents.brief" cssClass="error"/></td>
						</tr>
						<tr>
							<td><label for="content"><spring:message code="label.content"/></label></td>
							<td><form:textarea id="content" path="contents.content"/></td>
							<td><form:errors path="contents.content" cssClass="error"/></td>
						</tr>
					</table>
					<button type="submit" onclick="submitSave()"><spring:message code="label.btnsave"/></button>
				</form:form>
				<form:form action="news-list-context" method="get">
					<button type="submit" onclick="resetForm()"><spring:message code="label.btncancel"/></button>
				</form:form>
			</div>
		</div>
	</div>
	<jsp:include page="footer.jsp"/>
	</body>
</html>