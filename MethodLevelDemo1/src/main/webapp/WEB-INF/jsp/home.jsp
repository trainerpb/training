<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<body>
	<h1>Home Page</h1>
	<ul>
		<li><a href="pay">Pay</a> 
		<a href="doA">doA</a>
		<A href="email?user=rohit">Email of Rohit</A>
		<a href="<c:url value='/logout' />">Log out</a></li>
	</ul>
</body>
</html>