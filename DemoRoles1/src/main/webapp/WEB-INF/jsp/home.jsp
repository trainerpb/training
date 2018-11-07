<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>This is Home page</h1>
	<ul>
		<li><a href="admin/a1">Admin</a> <a href="emp/emp1">User</a> <a
			href="payment/pay1">Payment</a> <a href="page1">Page1</a> <a
			href="<c:url value="/logout" />">Logout</a></li>
	</ul>

</body>
</html>