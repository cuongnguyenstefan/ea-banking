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

		<p>
			<input type="button" id="btnAdd"
				<a href="<c:url value="/addRequest" />"> 
					Add Another Customer </a> />
		</p>
	</fieldset>
	<fieldset>
		<legend>Choose an account</legend>
		<c:forEach items="${customer.account}" var="account.id">
			<div>
				<c:if test="account.class.name == 'AccountChecking'">

					<input
						<a href='<spring:url value="/account?accountId=${account. }"/>'>Checking Account!</a> />
				</c:if>
				<c:if test="account.class.name == 'AccountSaving'">

					<input
						<a href='<spring:url value="/account?accountId=${account. }"/>'>Saving Account!</a> />
				</c:if>
			</div>
		</c:forEach>

	</fieldset>

	<a href="logout">logout</a>

</body>
</html>
