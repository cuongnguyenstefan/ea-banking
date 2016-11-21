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
			<strong>First Name:</strong> ${customer.firstName}
		</p>
		<p>
			<strong>Last Name:</strong> ${customer.lastName}
		</p>

		<p>
			<strong>Date Of Birth:</strong> ${customer.dateOfBirth}
		</p>
		<p>
			<strong>Address:</strong> ${customer.address.street},
			${customer.address.city}, ${customer.address.state}
			${customer.address.zipCode}
		</p>

		<p>Request new Account:</p>
		<a href="/customer/choose">Choose an Account</a>
	</fieldset>
	<fieldset>
		<legend>Choose an account</legend>
		<c:forEach items="${customer.account}" var="account">
			<div>
				<c:if
					test="${account['class'] == 'class edu.mum.ea.entity.AccountChecking'}">


					<a href='<spring:url value="/account?accountId=${account.id }"/>'>Checking
						Account!</a>
				</c:if>
				<c:if
					test="${account['class'] == 'class edu.mum.ea.entity.AccountSaving'}">


					<a href='<spring:url value="/account?accountId=${account.id }"/>'>Saving
						Account!</a>
				</c:if>
			</div>
		</c:forEach>

	</fieldset>

	<a href="logout">logout</a>

</body>
</html>
