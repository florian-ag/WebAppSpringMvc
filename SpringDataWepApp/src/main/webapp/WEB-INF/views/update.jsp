<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page session="true"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update</title>
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
	
	<br>
	<div class="container">
		<div class="corps px-4 px-lg-4">
			<div class="row gx-4 gx-lg-4 justify-content-center">
				<div class="col-md-10 col-lg-4 col-xl-7">
					<h2 align="center">Update employee</h2>

					<form:form action="update?id=${emp.empId}" method="post" modelAttribute="emp">
						<form:hidden path="empId" value="${emp.empId}" />
						<div class="form-group">
							<div align="left">
								<form:label path="firstName">Firstname</form:label>
							</div>
							<form:input type="text" class="form-control" value ="${emp.firstName}" path="firstName"/>
							<form:errors path="firstName" cssClass="error" />
						</div>
						<div class="form-group">
							<div align="left">
								<form:label path="lastName">Lastname</form:label>
							</div>
							<form:input type="text" class="form-control"  value ="${emp.lastName}" path="lastName"/>
							<form:errors path="lastName" cssClass="error" />
						</div>

						<div class="form-group">
							<div align="left">
								<form:label path="title">Title</form:label>
							</div>
							<form:input type="text" class="form-control"
								value ="${emp.title}" path="title"/> 
							<form:errors path="title" cssClass="error" />
						</div>
						
						<div class="form-group">
							<div align="left">
								<form:label path="startDate">Start Date</form:label> <form:input type="date"
									value="${emp.startDate}"
									min="1900-01-01" max="2100-12-31" path="startDate"/>
									<form:errors path="startDate" cssClass="error" />
							</div>
						</div>

						<div align="left">
							<button type="submit" class="btn btn-primary">Update</button>
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