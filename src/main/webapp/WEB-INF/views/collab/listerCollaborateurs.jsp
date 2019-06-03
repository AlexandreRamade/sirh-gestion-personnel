<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
    import="java.util.List"
    import="dev.sgp.entite.Collaborateur"
    %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>SGP - App</title>
	<link rel="stylesheet" href="<%=request.getContextPath() %>/bootstrap-4.3.1-dist/css/bootstrap.css">
</head>
<body>
	<h1>Les collaborateurs</h1>
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