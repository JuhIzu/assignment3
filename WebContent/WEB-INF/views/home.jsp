<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
</head>
<body>
	<h1>Inventory Service App</h1>

	<h3>Get username</h3>
	<p>Enter user Id</p>
	<form action="user" method="post">
		<input type="text" name="userId"><br> <input
			type="submit" value="Login">
	</form>

	<h3>Get user inventory</h3>
	<p>Enter user Id</p>
	<form action="inventory" method="post">
		<input type="text" name="userId"><br> <input
			type="submit" value="Login">
	</form>
</body>
</html>