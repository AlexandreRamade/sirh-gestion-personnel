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
	<div class="container mx-auto" style="width: 800px">
		<h1>Nouveau Collaborateur</h1>
		<form method="post" action="editer">
			<div class="form-group row">
				<label for="nom" class="col-sm-4 col-form-label"> Nom</label>
				<div class="col-sm-8">
					<input type="text" name="nom" id="nom" required />
				</div>
			</div>
			
			<div class="form-group row">
				<label for="prenom" class="col-sm-4 col-form-label"> Prenom</label>
				<div class="col-sm-8">
					<input type="text" name="prenom" id="prenom" required />
				</div>
			</div>
			
			<div class="form-group row">
				<label for="dateNaissance" class="col-sm-4 col-form-label"> Date de naissance</label>
				<div class="col-sm-8">
					<input type="date" name="dateNaissance" id="dateNaissance" required />
				</div>
			</div>
			
			<div class="form-group row">
				<label for="adresse" class="col-sm-4 col-form-label"> Adresse</label>
				<div class="col-sm-8">
					<input type="text" name="adresse" id="adresse" required />
				</div>
			</div>
			
			<div class="form-group row">
				<label for="numeroSecu" class="col-sm-4 col-form-label"> Numero de sécurité sociale</label>
				<div class="col-sm-8">
					<input type="text" name="numeroSecu" id="numeroSecu" required />
				</div>
			</div>
	
			<div class="form-group row">
				<div class="col-sm-10">
					<input type="submit" value="Créer" class="btn btn-primary"/>	
				</div>
			</div>
		</form>
	</div>
	<script src="<%=request.getContextPath() %>/bootstrap-4.3.1-dist/js/bootstrap.bundle.js"></script>
	
</body>
</html>