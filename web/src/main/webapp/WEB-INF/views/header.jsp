<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
	<body>
		<header>
			<div class="header-content">
				<div class="application-title"><spring:message code="label.apptitle"/></div>
				<div class="languages-content">
					<div class="language-element">
						<form action="language" method="post">
							<input type="hidden" name="language" value="en" />
							<button type="submit" class="button-link"><spring:message code="label.english" /></button>
						</form>
					</div>
					<div class="language-element">
						<form action="language" method="post">
							<input type="hidden" name="language" value="ru" />
							<button type="submit" class="button-link"><spring:message code="label.russian" /></button>
						</form>
					</div>
				</div>
			</div>
		</header>
	</body>
</html>