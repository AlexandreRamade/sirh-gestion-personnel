<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>Nouveau Collaborateur</title>
	<link rel="stylesheet" href="<%=request.getContextPath() %>/bootstrap-4.3.1-dist/css/bootstrap.css">
</head>
<body>
	<h1>Nouveau Collaborateur</h1>
	<form method="post" action="/editer">
		<label for="nom"> Nom</label>
		<input type="text" name="nom" id="nom" required />
		<label for="prenom"> Prenom</label>
		<input type="text" name="prenom" id="prenom" required />
		<label for="dateNaissance"> Date de naissance</label>
		<input type="text" name="dateNaissance" id="dateNaissance" required />
		<label for="adresse"> Adresse</label>
		<input type="text" name="adresse" id="adresse" required />
		<label for="numeroSecu"> Numero de sécurité sociale</label>
		<input type="text" name="numeroSecu" id="numeroSecu" required />

		<input type="submit" value="Créer" />	
		
	
	</form>
	
	<script src="<%=request.getContextPath() %>/bootstrap-4.3.1-dist/js/bootstrap.bundle.js"></script>
	
</body>
</html>