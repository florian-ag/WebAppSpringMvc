<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
	<%@page session="false"%>
	<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${title}</title>
</head>
<body>
	<jsp:include page="_menu.jsp" />

	<h2><s:message code="userpage"></s:message></h2>


	<h3><s:message code="welcome"></s:message> : ${pageContext.request.userPrincipal.name}</h3>
</body>
</html>