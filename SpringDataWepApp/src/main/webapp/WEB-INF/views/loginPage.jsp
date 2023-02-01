<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<style>
.error {
	color: #ff0000;
	font-style: italic;
	font-weight: bold;
}
</style>
</head>
<body>
	<jsp:include page="_menu.jsp" />


	<h1>
		<s:message code="login"></s:message>
	</h1>

	<!-- /login?error=true -->
	<c:if test="${param.error == 'true'}">
		<div style="color: red; margin: 10px 0px;">

			Login Failed!!!<br /> Reason :
			${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}

		</div>
	</c:if>

	<h3>
		<s:message code="nameandpassword"></s:message>
	</h3>

	<form name='f'
		action="${pageContext.request.contextPath}/j_spring_security_check"
		method='POST'>
		<table>
			<tr>
				<td><s:message code="mail"></s:message></td>
				<td><input type='text' name='username'></td>
			</tr>
			<tr>
				<td><s:message code="password"></s:message></td>
				<td><input type='password' name='password'></td>
			</tr>
			<tr>
				<td><input name="submit" type="submit" value="submit" /></td>

			</tr>
		</table>
	</form>


	
</body>
</html>