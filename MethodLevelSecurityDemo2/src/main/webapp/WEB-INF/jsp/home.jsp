<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<body>
<h1>This is Home.jsp</h1>
<ul>
 <a href="admin/a1">Toya</a>
 <a href="emp/e1">Soham</a>
 <a href="nov/n1">Ifan</a>
<a href='<c:url value="/logout" />'>Logout</a>	
</ul>
</body>
</html>