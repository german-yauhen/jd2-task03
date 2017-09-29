<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
		<title><spring:message code="label.newslistname"/></title>
		<link href="${pageContext.request.contextPath}/resources/css/main.css" rel="stylesheet" />
		<script>
			function submitDelete() {
				var checked = [];
				document.querySelectorAll(".checkedId").forEach(function(element) {
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
						<div class="news-element">
							<div class="wrapper-title-date">
								<div class="news-title-elem">${news.contents.title}</div>
								<div class="news-date-elem">${news.dateOfPublication}</div>
							</div>
							<div class="news-brief-elem">${news.contents.brief}</div>
							<div class="wrapper-action-elements">
								<div class="link-elem">
									<a href="view-news?newsId=${news.id}"><spring:message code="label.viewname"/></a>
								</div>
								<div class="link-elem">
									<a href="edit-news?newsId=${news.id}"><spring:message code="label.editname"/></a>
								</div>
								<div class="checkbox-elem">
									<form:checkbox path="taggedIds" value="${news.id}" cssClass="checkedId"/>
								</div>
							</div>
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