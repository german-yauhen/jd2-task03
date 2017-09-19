<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
	<head>
		<title>Create News Context</title>
		<spring:url value="/resources/css/main.css" var="mainCss" />
		<link rel="stylesheet" href="${mainCss}" />
		<script>
            function resetForm() {
                document.getElementById("regform").reset();
            }
            function submitSave() {
                var query = confirm("Confirm the editing operation.");
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
				<form:form id="regform" modelAttribute="newsViewToEdit" action="process-news-edit-form" method="post">
					<table>
						<tr><form:hidden path="newsEntity.id" placeholder="${newsViewToEdit.newsEntity.id}"/></tr>
						<tr>
							<td><label for="title"><spring:message code="label.newstitle"/></label></td>
							<td><form:input id="title" type="text" path="newsEntity.contents.title" placeholder="${newsViewToEdit.newsEntity.contents.title}" /></td>
							<td><form:errors path="newsEntity.contents.title" cssClass="error"/></td>
						</tr>
						<tr>
							<td><label for="date"><spring:message code="label.newsdate"/></label></td>
							<td><form:input id="date" type="text" path="stringDateOfPublication" placeholder="${newsViewToEdit.stringDateOfPublication}" /></td>
							<td><form:errors path="stringDateOfPublication" cssClass="error"/></td>
						</tr>
						<tr>
							<td><label for="brief"><spring:message code="label.brief"/></label></td>
							<td><form:textarea id="brief" path="newsEntity.contents.brief" placeholder="${newsViewToEdit.newsEntity.contents.brief}" /></td>
							<td><form:errors path="newsEntity.contents.brief" cssClass="error"/></td>
						</tr>
						<tr>
							<td><label for="content"><spring:message code="label.content"/></label></td>
							<td><form:textarea id="content" path="newsEntity.contents.content" placeholder="${newsViewToEdit.newsEntity.contents.content}" /></td>
							<td><form:errors path="newsEntity.contents.content" cssClass="error"/></td>
						</tr>
					</table>
				</form:form>
				<button form="regform" type="submit" onclick="return submitSave()"><spring:message code="label.btnsave"/></button>
				<form:form action="news-list-context" method="get">
					<button type="submit" onclick="resetForm()"><spring:message code="label.btncancel"/></button>
				</form:form>
			</div>
		</div>
	</div>
	<jsp:include page="footer.jsp"/>
	</body>
</html>