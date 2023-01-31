<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page session="true"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add</title>
<style>
.error {
	color: #ff0000;
	font-style: italic;
	font-weight: bold;
}
</style>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<link href="resources/CSS/style.css" rel="stylesheet" />
<%-- <link rel="stylesheet" href="<c:url value="resources/css/Style.css"/>">
  --%>
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
	
	
</head>
<body>
	<jsp:include page="_menu.jsp" />
	
	<!-- <a href="nompersonne?mylocale=en">English </a>
	<img src="resources/img/anglais.png" width="18px" height="12px"/>
	<a href="nompersonne?mylocale=fr">Français </a>
	<img src="resources/img/france.png" width="18px" height="12px"/>
	 -->
	<br>
	
	<div class="container">
		<div class="corps px-4 px-lg-4">
			<div class="row gx-4 gx-lg-4 justify-content-center">
				<div class="col-md-10 col-lg-4 col-xl-7">
					<h2 align="center">Add employee</h2>

					<form:form action="add" method="post"
						modelAttribute="add">
						<div class="form-group">
							<div align="left">
								<form:label path="firstName">Firstname</form:label>
							</div>
							<form:input type="text" class="form-control" path="firstName" />
							<form:errors path="firstName" cssClass="error" />
						</div>
						<div class="form-group">
							<div align="left">
								<form:label path="lastName">Lastname</form:label>
							</div>
							<form:input type="text" class="form-control"
							 path="lastName" />
							<form:errors path="lastName" cssClass="error" />
						</div>

						<div class="form-group">
							<div align="left">
								<form:label path="title">Title</form:label>
							</div>
							<form:input type="text" class="form-control"
								path="title" />
							<form:errors path="title" cssClass="error" />
						</div>

						<div class="form-group">
							<div align="left">
								<form:label path="startDate">Start Date</form:label>
								<form:input type="date"
									min="1900-01-01" max="2100-12-31" path="startDate" />
								<form:errors path="startDate" cssClass="error" />
							</div>
						</div>

						<div align="left">
							<button type="submit" class="btn btn-primary">Add</button>
						</div>

					</form:form>
					<br>
					<form action="employee" method="get">
						<div align="left">

							<button type="submit" class="btn btn-primary">Cancel</button>
						</div>

					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>