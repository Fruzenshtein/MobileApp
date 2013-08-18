<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Create new Smartphone</title>
<link href="../resources/css/main.css" rel="stylesheet" type="text/css"/>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript">
   
    $(document).ready(function() {
      
      $('#newSmartphoneForm').submit(function(event) {
    	  
    	  var producer = $('#producer').val();
    	  var model = $('#model').val();
    	  var price = $('#price').val();
    	  var json = { "producer" : producer, "model" : model, "price": price};
    	  
        $.ajax({
        	url: $("#newSmartphoneForm").attr( "action"),
        	data: JSON.stringify(json),
        	type: "POST",
        	
        	beforeSend: function(xhr) {
        		xhr.setRequestHeader("Accept", "application/json");
        		xhr.setRequestHeader("Content-Type", "application/json");
        	},
        	success: function(smartphone) {
        		var respContent = "";
        		
		  		respContent += "<span class='success'>Smartphone was created: [";
		  		respContent += smartphone.producer + " : ";
		  		respContent += smartphone.model + " : " ;
		  		respContent += smartphone.price + "]</span>";
        		
        		$("#sPhoneFromResponse").html(respContent);   		
        	}
        });
         
        event.preventDefault();
      });
       
    });   
  </script>
</head>
<body>
<div id="container">
<h1>Create new Smartphone</h1>
<div>
<p>Here you can create new Smartphone:</p>
<div id="sPhoneFromResponse"></div>
</div>
<form:form id="newSmartphoneForm" action="${pageContext.request.contextPath}/smartphones/create.json" commandName="sPhone">
<table>
<tbody>
<tr>
<td>Producer:</td>
<td>
<form:select path="producer">
	<form:option value="NOKIA">Nokia</form:option>
	<form:option selected="selected" value="IPHONE">iPhone</form:option>
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
<td><input type="submit" value="Create" /></td>
<td></td>
</tr>
</tbody>
</table>
</form:form>
<a href="${pageContext.request.contextPath}/index.html">Home page</a>
</div>
</body>
</html>