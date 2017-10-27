<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="fr">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link href="static/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<title>${title }</title>
</head>
<body>
	<nav class="navbar navbar-light bg-light">
		<!--    <img src="/assets/brand/bootstrap-solid.svg" width="30" height="30" class="d-inline-block align-top" alt="">
 -->
		<a class="navbar-brand" href="logout"><button type="button" class="btn btn-secondary">
			Se déconnecter</button></a>
		
	</nav>
	<div class="container">
	<c:if test="${! empty erreur }">
		<div class="alert alert-danger" role="alert">${erreur}</div>
	</c:if>
		<div class="row">
			<h1>${model.title}</h1>
		</div>
		<div class="row">
			<table class="table table-striped">
				<thead>
					<tr>
						<th scope="col">Sujet</th>
						<th scope="col">Messages</th>
						<th scope="col">Créé par</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="entry" items="${model.listeTopics }">
						<tr>
							<td><a href="topic?topic=${entry.key.id }">${entry.key.title }</a></td>
							<td></td>
							<td>${entry.value.login }</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="row">
			<form action="topic" method="post">
				<input type="text" name="title" placeholder="Titre du sujet" size="50"/> <input
					type="hidden" name="creator" value="${user.id }" /> <input
					type="submit" value="Créer un nouveau sujet" />
			</form>
		</div>
		<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
			integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
			crossorigin="anonymous"></script>
		<script
			src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js"
			integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh"
			crossorigin="anonymous"></script>
		<script
			src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js"
			integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ"
			crossorigin="anonymous"></script>
	</div>
</body>
</html>