<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>JSP Spring CRUD</title>
</head>
<body>

	<div
		style="position: fixed; left: 2px; top: 2px; _position: absolute; background-color: white; height: 6%;">
		<a href="user/add"> <input type="button" name="add" value="ADD" class="button" /> </a> &nbsp; 
		<a href="user/view"> <input type="button" name="view" value="View" class="button" /> </a> <br> <br> <br>
	</div>


<div id="container">
		<c:if test="${userview==true}">
			
	<c:url var="addAction" value="/user/adduser"></c:url>
	<form id="sub" method="post" action="">

		<br> <br> <br> <br>
		<table align="left" class="CSSTable" border="1px">
			<tr>

				<th>User ID:</th>
				<th>Name:</th>
				<th>Email ID:</th>
				<th>Mobile:</th>
				<th>Address:</th>
				<!-- <th>VALID TILL</th> -->
			</tr>

			<c:forEach items="${userList}" var="user">
				<tr>
					<td>${user.uid}</td>
					<td>${user.name}</td>
					<td>${user.email}</td>
					<td>${user.mobile}</td>
					<td>${user.address}</td>
					
					<td><a href="<c:url value='user/edit/${user.uid}' />">Edit</a>
						<a href="<c:url value='user/remove/${user.uid}' />">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</form>
	
		</c:if>
	</div>
	
	
	
	
</body>
</html>