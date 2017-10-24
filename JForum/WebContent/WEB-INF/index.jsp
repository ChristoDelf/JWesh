<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath }/static/css/style.css">
<title>JForum</title>
</head>
<body>
<c:import url="navigation.jsp" />
<h1>${model.title }</h1>
<h2>Recent topics</h2>
<table>
	<c:forEach var="topic" items="${model.topics }">
		<tr>
			<td><a href="${pageContext.request.contextPath }/topic?id=${topic.id }">${topic.title }</a></td>
			<td>${topic.creator }</td>
			<td>${topic.message }</td>
		</tr>	
	</c:forEach>
</table>
<c:if test="${connected }">
<h2>Create a new topic</h2>
	<form action="${pageContext.request.contextPath }/topic" method="post">
		<input type="text" name="title" placeholder="Title">
		<textarea name="message" placeholder="Text"></textarea>
		<input type="submit" value="Submit">
	</form>
</c:if>
</body>
</html>