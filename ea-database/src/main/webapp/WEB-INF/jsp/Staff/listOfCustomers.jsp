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
				<th>FirstName</th>
				<th>LastName</th>
				<th>DateOfBirth</th>
				<th>Phone</th>
				<th>Email</th>
				<th>Address</th>
				</tr>
		    
			<c:forEach items="${customers}" var="user">
				<tr>
					<td>${user.customerNumber} </td>
					<td>${user.firstName}</td>
					<td>${user.lastName}</td>
					<td>${user.dateOfBirth} </td>
					<td>${user.phone} </td>
					<td>${user.email} </td>
					<td> ${user.address.street}, ${user.address.city}, ${user.address.state} ${user.address.zipCode}</td>
					<td>
							<a href="<spring:url value="/customer/update?id=${user.userName}"/>" >
							<input type="button" id="btnCancel"  value ="<spring:message code="edit.customer.btn"></spring:message>"/></a>
					</td>
<%-- 					<td>
							<a href="<spring:url value="/customers/delete?id=${customer.id}"/>" >
							<input type="button" id="btnDelete"  value ="<spring:message code="delete.customer.btn"></spring:message>"/></a>
					</td> --%>
			 </tr>
			</c:forEach>
	</table>
	<hr>
	<p>
	  <a href="<c:url value="/customer/add" />" ><input type="button" id="btnAdd"  value ="<spring:message code="add.customer.btn"></spring:message>"/> </a>
	</p>
	</fieldset>
	</div>
</body>
</html>
