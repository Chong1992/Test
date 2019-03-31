<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>

<title>Main</title>
</head>
<body>

	<div class="container">


			<div class="page-heading">
				<h1>Upload filepath</h1>
			</div>
			<form action="linkUpload">
				<input class="btn btn-default btn-lg btn-block" type="submit" value="link" />
			</form>
		
	</div>
	
	<table>
	<tr>
		<th>Here is a list of companies successfully uploaded</th>
	</tr>
	<tr>
		<c:forEach var="company" items="${List}">
			<tr>
			<td>Name : ${company}</td>			
			</tr>
		</c:forEach>
	</tr>
	</table>
	
	
	<div class="container">
	<h1>Search</h1>
	<form action="storeSearch" method="post">
	<div class="form-group">
		<div class="form-group">
      <input type="text" class="form-control" placeholder="Enter date" name="date" required>
    </div>
    </div>
    
    <table>
	<tr>
		<th>Here is a list of companies searched for</th>
	</tr>
	<tr>
		<c:forEach var="company" items="${List}">
			<tr>
			<td>Name : ${company}</td>			
			</tr>
		</c:forEach>
	</tr>
	</table>

</body>
</html>