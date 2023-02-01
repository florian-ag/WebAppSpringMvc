<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${title}</title>
</head>
<body>
	<jsp:include page="_menu.jsp" />

	<h2><s:message code="adminpage"></s:message></h2>


	<h3><s:message code="welcome"></s:message> : ${pageContext.request.userPrincipal.name}</h3>

	<b><s:message code="protected"></s:message></b>
	
</body>
</html>