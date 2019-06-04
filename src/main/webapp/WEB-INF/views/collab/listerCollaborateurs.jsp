<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="dev.sgp.entite.Collaborateur" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>SGP - App</title>
	<link rel="stylesheet" href="<%=request.getContextPath() %>/bootstrap-4.3.1-dist/css/bootstrap.css">
</head>
<body>
	<h1>Les collaborateurs</h1>
	
	<form method="post" action="lister">
			<div class="form-group row">
				<label for="search" class="col-sm-4 col-form-label"> Rechercher un nom ou un prenom qui commence par : </label>
				<div class="col-sm-8">
					<input type="text" name="search" id="search" />
				</div>
			</div>
			
			<div class="form-group row">
				<label for="departFilter" class="col-sm-4 col-form-label"> Filtrer par département :</label>
				<div class="col-sm-8">
					<input type="text" name="departFilter" id="departFilter" />
				</div>
			</div>
	
	<ul>
		<% List<Collaborateur> listeNoms = (List<Collaborateur>)request.getAttribute("listeNoms");
		for(Collaborateur collaborateur : listeNoms) {
			%>
				<li><%=collaborateur.toString() %></li>
			<%
		}
		%>
		
	</ul>
</body>
</html>