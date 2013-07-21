<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Edit Smartphone</title>
</head>
<body>
<h1>Edit Smartphone</h1>
<p>
Here you can edit Smartphone info:<br/>
</p>
<form:form method="PUT" commandName="sPhone" 
action="${pageContext.request.contextPath}/smartphones/edit/${sPhone.id}.html">
<table>
<tbody>
<tr>
<td>Producer:</td>
<td>
<form:select path="producer">
	<form:option value="NOKIA">Nokia</form:option>
	<form:option value="IPHONE">iPhone</form:option>
	<form:option value="HTC">HTC</form:option>
	<form:option value="SAMSUNG">Samsung</form:option>
</form:select>
</td>
</tr>
<tr>
<td>Model:</td>
<td><form:input path="model" /></td>
</tr>
<tr>
<td>Price:</td>
<td><form:input path="price" /></td>
</tr>
<tr>
<td><input type="submit" value="Edit" /></td>
<td></td>
</tr>
</tbody>
</table>
</form:form>
<a href="${pageContext.request.contextPath}/index.html">Home page</a>
</body>
</html>