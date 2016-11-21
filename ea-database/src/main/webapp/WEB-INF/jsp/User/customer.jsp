<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<title>Customer Page</title>
</head>
<body>
	<fieldset>
				<legend>Customer Detail</legend>
<p> 
				<strong>First Name:</strong> 
				${customer.firstName}
			</p>
			<p>
				<strong>Last Name:</strong> 
				${customer.lastName}
			</p>
			
			<p>
				<strong>Date Of Birth:</strong> 
				${customer.dateOfBirth}
			</p>
			<p>
				<strong>Address:</strong> 
				${user.address.street}, ${user.address.city},
				${user.address.state} ${user.address.zipCode}
			</p>
		
		   <p>
		    <input type="button" id="btnAdd" <a href="<c:url value="/addRequest" />"> 
					Add Another Customer </a> />
		  </p>
	 </fieldset>
	 <a href="logout">logout</a>
	
</body>
</html>
