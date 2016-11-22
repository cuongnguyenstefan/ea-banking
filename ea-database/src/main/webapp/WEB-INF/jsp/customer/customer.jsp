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
   <a href="?lang=en_US" >English</a>|<a href="?lang=sp_SP" >Spanish</a>
	<fieldset>
	
		<legend><spring:message code="form.customerDetail.label"/></legend>
		<p>
			<strong><spring:message code="form.firstName.label"/>:</strong> ${customer.firstName}
		</p>
		<p>
			<strong><spring:message code="form.lastName.label"/>:</strong> ${customer.lastName}
		</p>

		<p>
			<strong><spring:message code="form.dateOfBirth.label"/>:</strong> ${customer.dateOfBirth}
		</p>
		<p>
			<strong><spring:message code="form.address.label"/>:</strong> ${customer.address.street},
			${customer.address.city}, ${customer.address.state}
			${customer.address.zipCode}
		</p>

		<p><spring:message code="form.requestnewAccount.label"/>:</p>
		<a href="/customer/choose"><spring:message code="form.chooseanAccount.label"/></a>
	</fieldset>
	<fieldset>
		<legend><spring:message code="form.chooseanAccount.label"/></legend>
		<c:forEach items="${customer.account}" var="account">
			<div>
				<c:if
					test="${account['class'] == 'class edu.mum.ea.entity.AccountChecking'}">


					<a href='<spring:url value="/account?accountId=${account.id }"/>'>
					<spring:message code="form.checkingAccount.label"/>: ${account.id }</a>
				</c:if>
				<c:if
					test="${account['class'] == 'class edu.mum.ea.entity.AccountSaving'}">


					<a href='<spring:url value="/account?accountId=${account.id }"/>'>
					<spring:message code="form.savingAccount.label"/>: ${account.id }</a>
				</c:if>
			</div>
		</c:forEach>

	</fieldset>

	<a href="logout"><spring:message code="form.logout.label"/></a>

</body>
</html>
