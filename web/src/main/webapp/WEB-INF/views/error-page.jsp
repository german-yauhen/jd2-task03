<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
	<title><spring:message code="label.errorpagename"/></title>
	<link href="${pageContext.request.contextPath}/resources/css/main.css" rel="stylesheet" />
</head>
	<body>
		<jsp:include page="header.jsp"/>
		<div class="wrapper-middle-context">
			<jsp:include page="leftbar.jsp"/>
			<div class="wrapper-main-content">
				<spring:message code="label.warningmessage"/>
			</div>
		</div>
		<jsp:include page="footer.jsp"/>
	</body>
</html>