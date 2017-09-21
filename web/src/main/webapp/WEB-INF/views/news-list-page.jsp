<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
		<title><spring:message code="label.newslistname"/></title>
		<spring:url value="/resources/css/main.css" var="mainCss"/>
		<link href="${mainCss}" rel="stylesheet"/>
		<script>
			function submitDelete() {
				var checked = [];
				document.querySelectorAll(".check-me").forEach(function(element) {
						if (element.checked) checked.push(element);
					});
				if(checked.length === 0) {
                    alert("There no selected news to provide delete operation. At least one news must be selected.")
				    return false;
                }
				return confirm("Confirm the delete operation.");
			}
		</script>
	</head>
	<body>
	<jsp:include page="header.jsp"/>
	<div class="wrapper-middle-context">
		<jsp:include page="leftbar.jsp"/>
		<div class="wrapper-main-content">
			<div class="main-content">
				<form:form id="newsListForm" modelAttribute="newsView" action="delete-news-list" method="POST">
					<jstl:forEach items="${newsView.newsList}" var="news">
						<div class="news-title-elem">${news.contents.title}</div>
						<div class="news-date-elem">${news.dateOfPublication}</div>
						<div class="news-brief-elem">${news.contents.brief}</div>
						<div class="link-elem">
							<a href="view-news?newsId=${news.id}"><spring:message code="label.viewname"/></a>
						</div>
						<div class="link-elem">
							<a href="edit-news?newsId=${news.id}"><spring:message code="label.editname"/></a>
						</div>
						<div class="checkbox-elem">
							<form:checkbox path="taggedIds" value="${news.id}" cssClass="check-me"/>
						</div>
					</jstl:forEach>
				</form:form>
				<div class="button-delete-elem">
					<button form="newsListForm" type="submit" onclick="return submitDelete()">
						<spring:message code="label.btndelete"/>
					</button>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="footer.jsp"/>
	</body>
</html>