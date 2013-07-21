<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Home page</title>
</head>
<body>
<h1>Home page</h1>
<p>
<span style="color: #00ff0d">${msg}</span><br/>
<a href="${pageContext.request.contextPath}/smartphones/create.html">Create new Smartphone</a><br/>
<a href="${pageContext.request.contextPath}/smartphones.html">All Smartphones</a><br/>
</p>
</body>
</html>