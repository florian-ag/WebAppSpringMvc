<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
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

	<br>
		
		<div class="container">

		<div class="card-header mx-4 mx-md-5">
			<div class="row d-flex justify-content-center">
				<div style="background-color:LightGray; padding-bottom: 10px">

					<h2><s:message code="listemployee"></s:message></h2>
					<br>
					<a class="btn btn-primary" href="add"><s:message code="titleaddemployee"></s:message></a>
					<br>

				</div>
			</div>
		</div>

		<div class="card-body py-4">
			<div class="card mx-4 mx-md-5 shadow-5-strong">
				<div class="row d-flex justify-content-center">
					<div class="col">

						<table data-pagination="true" data-search="true"
							data-toggle="table" data-page-list="[5, 10, 25, 50, 100, all]"
							class="table table-striped table-hover">


							<thead>
								<tr>
									<th>EmpId</th>
									<th>FirstName</th>
									<th>LastName</th>
									<th>StartDate</th>
									<th>Title</th>
									<th>Action</th>

								</tr>
							</thead>
							<tbody>
								<c:forEach items="${list}" var="emp">
									<tr>
										<td>${emp.empId }</td>
										<td>${emp.firstName }</td>
										<td>${emp.lastName }</td>
										<td>${emp.startDate }</td>
										<td>${emp.title }</td>
										<td><a class="btn btn-primary"
											href="update?id=${emp.empId}"><s:message code="update"></s:message></a> <a
											href="delete?id=${emp.empId}"
											onclick="return confirm('Are you sure you want to delete this item?');">
												<button style="background-color:red; border-color:red" class="btn btn-primary" type="submit" name="id"
													value="${emp.empId}">
													<s:message code="delete"></s:message> <i class="bi bi-x-square-fill"></i>
												</button>
										</a></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>

		</div>
	</div>

	<%-- <c:forEach items="${employee}" var="emp">
		<tr>
			<td>${emp.empId }</td>
			<td>${emp.firstName }</td>
			<td>${emp.lastName }</td>
			<td>${emp.startDate }</td>
			<td>${emp.title }</td>
		</tr>
	</c:forEach> --%>

</body>
</html>