<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>All Smartphones</title>
</head>
<body>
<h1>All Smartphones</h1>
<p>
Here you can see a list of Smartphones: <br/>
<span style="color: #00ff0d">${msg}</span>
</p>

	<table>
	<thead>
	<tr>
	<th>Producer</th><th>Model</th><th>Price</th><th>Actions</th>
	</tr>
	</thead>
	<tbody>
	<c:forEach var="sPhone" items="${smartphones}">
	<tr>
	<td>${sPhone.producer}</td>
	<td>${sPhone.model}</td>
	<td>${sPhone.price}</td>
	<td>
	<a href="${pageContext.request.contextPath}/smartphones/edit/${sPhone.id}.html">Edit</a><br/>
	<a href="${pageContext.request.contextPath}/smartphones/delete/${sPhone.id}.html">Delete</a><br/>
	</td>
	</tr>
	</c:forEach>
	</tbody>
	</table>

<a href="${pageContext.request.contextPath}/index.html">Home page</a>
</body>
</html>