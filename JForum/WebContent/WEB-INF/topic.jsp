<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath }/static/css/style.css">
<title>JForum</title>
</head>
<body>
	<c:import url="navigation.jsp" />
	<h2>${model.title }</h2>
	<p>posted by ${model.creator }</p>
	<table>
		<c:forEach var="post" items="${model.posts }">
			<tr>
				<td>${post.creator }</td>
				<td>${post.content }</td>
			</tr>
		</c:forEach>
	</table>
<h3>Post a message :</h3>
	<form action="${pageContext.request.contextPath }/post" method="post">
		<input type="hidden" name="topicId" value="${model.id }">
		<textarea name="message" placeholder="Text"></textarea>
		<input type="submit" value="Submit">
	</form>
</body>
</html>