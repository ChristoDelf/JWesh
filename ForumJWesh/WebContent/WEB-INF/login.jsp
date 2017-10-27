<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- Bootstrap core CSS -->
<link href="static/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="static/bootstrap/css/signin.css" rel="stylesheet">
<title>${title }</title>
</head>
<body>
	<c:if test="${! empty erreur }">
		<div class="alert alert-danger" role="alert">${erreur}</div>
	</c:if>
	<c:if test="${! empty message }">
		<div class="alert alert-success" role="alert">${message }</div>
	</c:if>


	<div class="container">
	<h1 class="text-center">Vous devez être inscrit et connecté pour participer au Forum</h1>
		<form class="form-signin" action="login" method="post">
			<h2 class="form-signin-heading">Se connecter</h2>
			<!--          <label for="inputEmail" class="sr-only">login</label>-->
			<input type="text" name="login" id="inputEmail" class="form-control"
				placeholder="Login" required autofocus>
			<!--         <label for="inputPassword" class="sr-only">Password</label>  -->
			<input type="password" name="password" id="inputPassword"
				class="form-control" placeholder="Mot de passe" required>
			<!--         <div class="checkbox">
          <label>
            <input type="checkbox" value="remember-me"> Remember me
          </label>
        </div>
 -->
			<button class="btn btn-lg btn-primary btn-block" type="submit">Se
				connecter</button>
		</form>
<p class="text-center">ou</p>
		<form class="form-signin" action="signup" method="post">
			<h2 class="form-signin-heading">S'inscrire</h2>
			<!--          <label for="inputEmail" class="sr-only">login</label>-->
			<input type="text" name="login" id="inputEmail" class="form-control"
				placeholder="Login" required autofocus>
			<!--         <label for="inputPassword" class="sr-only">Password</label>  -->
			<input type="password" name="password" id="inputPassword"
				class="form-control" placeholder="Mot de passe" required>
			<!--         <div class="checkbox">
          <label>
            <input type="checkbox" value="remember-me"> Remember me
          </label>
        </div>
 -->
			<button class="btn btn-lg btn-primary btn-block" type="submit">S'inscrire</button>
		</form>

	</div>
	<!-- /container -->


</body>
</html>