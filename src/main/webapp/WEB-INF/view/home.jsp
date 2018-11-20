<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
	<body>
		<h2>Hello this is home - YOOHOO</h2>
	</body>
	
	<form:form action="${pageContext.request.contextPath}/logout" method="POST">
		<input type="submit" value="Logout">
	</form:form>
</html>