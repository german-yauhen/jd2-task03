<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
	<body>
		<header>
			<div class="header-content">
				<div class="application-title"><spring:message code="label.apptitle"/></div>
				<div class="languages-content">
					<div class="language-element"><a href="?language=en"><spring:message code="label.english" /></a></div>
					<div class="language-element"><a href="?language=ru"><spring:message code="label.russian" /></a></div>
				</div>
			</div>
		</header>
	</body>
</html>