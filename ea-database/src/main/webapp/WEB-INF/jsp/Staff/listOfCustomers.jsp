<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style type="text/css">@import url("<spring:url value="/resource/css/main.css"/>");</style>
<title>List Of Customers</title>
</head>
<body>
	<div id="global">
					<fieldset>
				<legend>Customer list</legend>
			<table style="width:100%">
				<tr>
				<th>Username</th>
				<th>FirstName</th>
				<th>LastName</th>
				<th>DateOfBirth</th>
				<th>Phone</th>
				<th>Email</th>
				<th>Address</th>
				<th>Options</th>
				</tr>
		    
			<c:forEach items="${customers}" var="user">
				<tr>
					<td>${user.username} </td>
					<td>${user.firstName}</td>
					<td>${user.lastName}</td>
					<td>${user.dateOfBirth} </td>
					<td>${user.phone} </td>
					<td>${user.email} </td>
					<td> ${user.address.street}, ${user.address.city}, ${user.address.state} ${user.address.zipCode}</td>
					<td>
							<a href="<spring:url value="/staff/updateUser?id=${user.username}"/>" >Update</a>
					</td>
			 </tr>
			</c:forEach>
	</table>
	<hr>
	</fieldset>
	<div>
		<a href="/staff">Back</a>
	</div>
	<div>
		<a href="/logout">Logout</a>
	</div>
	</div>
</body>
</html>
