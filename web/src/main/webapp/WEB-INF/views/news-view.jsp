<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="jstl" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
	<head>
		<title><spring:message code="label.newsviewname"/></title>
		<link href="${pageContext.request.contextPath}/resources/css/main.css" rel="stylesheet" />
		<script type="text/javascript">
            function confirmUpdateDelete() {
                if (confirm("Please, confirm the action.")) {
                    return true;
                } else {
                    return false;
                }
            }
		</script>
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
							<td>${newsView.newsEntity.contents.title}</td>
						</tr>
						<tr>
							<td><label id="date"><spring:message code="label.newsdate"/></label></td>
							<td>${newsView.stringDateOfPublication}</td>
						</tr>
						<tr>
							<td><label id="brief"><spring:message code="label.brief"/></label></td>
							<td>${newsView.newsEntity.contents.brief}</td>
						</tr>
						<tr>
							<td><label id="content"><spring:message code="label.content"/></label></td>
							<td>${newsView.newsEntity.contents.content}</td>
						</tr>
					</table>
					<div class="wrapper-button-elements">
						<div class="button-elem">
							<form action="delete-news" method="post">
								<input type="hidden" name="newsId" value="${newsView.newsEntity.id}" />
								<button type="submit" onclick="return confirmUpdateDelete()">
									<spring:message code="label.btndelete"/>
								</button>
							</form>
						</div>
						<div class="button-elem">
							<form action="edit-news" method="get">
								<input type="hidden" name="newsId" value="${newsView.newsEntity.id}" />
								<button type="submit" onclick="return confirmUpdateDelete()">
									<spring:message code="label.btnedit"/>
								</button>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
		<jsp:include page="footer.jsp"/>
	</body>
</html>