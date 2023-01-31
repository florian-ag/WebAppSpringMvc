<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Menu</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<link href="CSS.css" rel="stylesheet" />

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
	crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/jquery/dist/jquery.min.js"></script>
<script
	src="https://unpkg.com/bootstrap-table@1.21.2/dist/bootstrap-table.min.js"></script>
<link rel="stylesheet"
	href="https://unpkg.com/bootstrap-table@1.21.2/dist/bootstrap-table.min.css">


<style>

ul {
	list-style-type: none;
	margin: 0;
	padding: 0;
	overflow: hidden;
	background-color: #333;
}

li {
	float: left;
}

li a {
	display: block;
	color: white;
	text-align: center;
	padding: 14px 16px;
	text-decoration: none;
}

li a:hover:not(.active) {
	background-color: #111;
}

.active {
	background-color: #04AA6D;
}
</style>

</head>
<body>

	<ul>
		<li><a href="${pageContext.request.contextPath}/welcome">Home</a></li>
		<li><a href="${pageContext.request.contextPath}/userInfo">UserInfo</a></li>
		<li><a href="${pageContext.request.contextPath}/admin">Admin</a></li>
		<li><sec:authorize access="hasRole('ADMIN')">
				<a href="${pageContext.request.contextPath}/employee">Employee</a>
			</sec:authorize></li>

		<li style="float: right"><c:if
				test="${pageContext.request.userPrincipal.name != null}">
				<a class="active" href="${pageContext.request.contextPath}/logout">Logout</a>

			</c:if></li>
	</ul>

	<%-- <a href="${pageContext.request.contextPath}/welcome">Home</a> | &nbsp;

	<a href="${pageContext.request.contextPath}/userInfo">User Info</a> |
	&nbsp;

	<a href="${pageContext.request.contextPath}/admin">Admin</a>

	<sec:authorize access="hasRole('ADMIN')">
   | &nbsp; <a href="${pageContext.request.contextPath}/employee">Employee</a>
	</sec:authorize>

	<c:if test="${pageContext.request.userPrincipal.name != null}">
 
     | &nbsp;
     <a href="${pageContext.request.contextPath}/logout">Logout</a>

	</c:if>
 --%>
	<!-- </div> -->

</body>
</html>