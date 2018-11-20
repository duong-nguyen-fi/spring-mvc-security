<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>


<html>
	<body>
		<h2>Hello this is home - YOOHOO</h2>
	</body>
	
	<hr>
		<!-- Display User name and role -->
		
		<p>
			User: <security:authentication property="principal.username"/>
			<br><br>
			Roles: <security:authentication property="principal.authorities"/>
		</p>
	</hr>
	
	<security:authorize access="hasRole('MANAGER')">
		<hr>
			<!-- Link /leaders... for manager -->
			<p>
				<a href="${pageContext.request.contextPath}/leaders">Leadership Meeting</a> (for Managers)
			</p>
		</hr>
	</security:authorize>
	
	
	<security:authorize access="hasRole('ADMIN')">
		<hr>
			<!-- Link /systems... for admin -->
			<p>
				<a href="${pageContext.request.contextPath}/systems">ADMIN SYSTEM</a> (for admin)
			</p>
		</hr>
	</security:authorize>
	<hr>
		<form:form action="${pageContext.request.contextPath}/logout" method="POST">
			<input type="submit" value="Logout">
		</form:form>
	</hr>
</html>