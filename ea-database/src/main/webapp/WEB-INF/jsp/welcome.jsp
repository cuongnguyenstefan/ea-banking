<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
	<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page session="true"%>
<html>
<head>
<title>Welcome</title>
</head>
<body>
	<a href="?lang=en_US" >English</a>|<a href="?lang=sp_SP" >Spanish</a>
	<h1 style="text-align: center"><spring:message code="form.welcome.label"/></h1>
	<div style="width:100%; text-align:center">
	<img src="/Bank.jpg" alt="Mountain View"
			style="width: 50%; height: 50%; position: relative; margin-right: auto; margin-left: auto;">
			</div>
	<sec:authorize access="isAnonymous()">
		
			
		
		<div style="text-align: center">
			<h3>
				<spring:message code="form.signIn.label"/> <a href="/login"><spring:message code="form.loginHere.label"/></a>
			</h3>
			<h3>
				<spring:message code="form.newClient.label"/><a href="/register"><spring:message code="form.registerHere.label"/></a>
			</h3>
		</div>
	</sec:authorize>
	<sec:authorize access="hasRole('ROLE_ADMIN')">
		<div style="text-align: center">
			<a href="/staff"><spring:message code="form.goTOStaffPage.label"/></a>
		</div>
	</sec:authorize>
	<sec:authorize access="hasRole('ROLE_USER')">
		<div style="text-align: center">
			<a href="/customer"><spring:message code="form.goTOCustomerPage.label"/></a>
		</div>
	</sec:authorize>
	<sec:authorize access="isAuthenticated()">
		<div style="text-align: center">
			<a href="<c:url value="/logout" />"><spring:message code="form.logout.label"/></a>
		</div>
	</sec:authorize>
</body>
</html>
