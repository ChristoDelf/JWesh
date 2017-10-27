<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link href="static/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<title>${model.title }</title>
</head>
<body>
	<nav class="navbar navbar-light bg-light">
		<!--    <img src="/assets/brand/bootstrap-solid.svg" width="30" height="30" class="d-inline-block align-top" alt="">
 -->
		<a class="navbar-brand" href="logout"><button type="button"
				class="btn btn-secondary">Se déconnecter</button></a>
	</nav>
	<div class="container">
		<c:if test="${! empty erreur }">
			<div class="alert alert-danger" role="alert">${erreur}</div>
		</c:if>
		<div class="row" ></div>
		<div class="row">
			<ol class="breadcrumb">
				<li class="breadcrumb-item"><a href="index">Accueil</a></li>
				<li class="breadcrumb-item active" aria-current="page">${model.title }</li>
			</ol>
		</div>
		<div class="row">
			<h1>${model.title}</h1>
		</div>
		<div class="row">
			<table class="table table-striped">
				<thead>
					<tr>
						<th scope="col">Auteur</th>
						<th scope="col">Message</th>
						<th scope="col">Date</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="entry" items="${model.listeMessages }">
						<tr>
							<td>${entry.value.login }</td>
							<td>${entry.key.text }</td>
							<td>${entry.key.date }</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="row">
			<form action="message" method="post">
				<div class="form-group">
					<label for="exampleFormControlTextarea1">Votre message:</label>
					<textarea class="form-control" name="text"
						id="exampleFormControlTextarea1" rows="3" cols="50"></textarea>
				</div>


				<br> <input type="hidden" name="author" value="${user.id }" />
				<input type="hidden" name="topic" value="${model.topicId }" />
				<button type="submit">Ajouter un message</button>
			</form>
		</div>
	</div>
</body>
</html>