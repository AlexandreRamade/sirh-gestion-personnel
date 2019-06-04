<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored='false' %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Statistiques du site sgp</title>
	<link rel="stylesheet" href="<%=request.getContextPath() %>/bootstrap-4.3.1-dist/css/bootstrap.css">
</head>
<body>
	<h1>Statistiques</h1>
	<table class="table table-striped">
		<thead>
			<tr>
				<th scope="col">Chemin</th>
				<th scope="col">Nombre de visites</th>
				<th scope="col">Min (ms)</th>
				<th scope="col">Max (ms)</th>
				<th scope="col">Moyenne (ms)</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="stat" items="${ statistiques }">
				<tr>
					<td scope="row"><c:out value="${ stat.chemin }"></c:out>
					<td><c:out value="${ stat.nbVisites }"></c:out>
					<td><c:out value="${ stat.min }"></c:out>
					<td><c:out value="${ stat.max }"></c:out>
					<td><c:out value="${ stat.moyenne }"></c:out>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<script src="<%=request.getContextPath() %>/bootstrap-4.3.1-dist/js/bootstrap.bundle.js"></script>
</body>
</html>