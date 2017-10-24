<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<nav>
	<ul>
		<li><a href="${pageContext.request.contextPath }/">Home</a></li>
		<c:if test="${!connected }">
			<li><a href="${pageContext.request.contextPath }/signup">Sign
					up</a></li>
			<li><a href="${pageContext.request.contextPath }/signin">Sign
					in</a></li>
		</c:if>
		<c:if test="${connected }">
			<li>
				<form action="${pageContext.request.contextPath }/signout"
					method="post">
					<input type="submit" value="Sign out">
				</form>
			</li>
		</c:if>
	</ul>
</nav>