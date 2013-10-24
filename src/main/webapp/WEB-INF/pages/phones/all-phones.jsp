<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>All Smartphones</title>
<link href="resources/css/main.css" rel="stylesheet" type="text/css"/>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript">
   
    $(document).ready(function() {
    	
		var deleteLink = $("a:contains('Delete')");
      
		$(deleteLink).click(function(event) {
    	  
			$.ajax({
				url: $(event.target).attr("href"),
			  	type: "DELETE",
			  	
			  	beforeSend: function(xhr) {
			  		xhr.setRequestHeader("Accept", "application/json");
			  		xhr.setRequestHeader("Content-Type", "application/json");
			  	},
			  	
			  	success: function(smartphone) {
			  		var respContent = "";
			  		var rowToDelete = $(event.target).closest("tr");
			  		
			  		rowToDelete.remove();
			  		
			  		respContent += "<span class='success'>Smartphone was deleted: [";
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
<h1>All Smartphones</h1>
<div>
<p>Here you can see a list of Smartphones:</p>
<div id="sPhoneFromResponse"></div>
</div>
	<table border="1px" cellpadding="0" cellspacing="0">
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
	<a href="${pageContext.request.contextPath}/smartphones/delete/${sPhone.id}.json">Delete</a><br/>
	</td>
	</tr>
	</c:forEach>
	</tbody>
	</table>

<a href="${pageContext.request.contextPath}/index.html">Home page</a>
</div>
</body>
</html>