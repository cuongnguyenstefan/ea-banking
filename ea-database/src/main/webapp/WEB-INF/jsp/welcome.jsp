<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ page session="true"%>
<html>
<head>
<title>Welcome</title>
</head>
<body>
	<h1 style="text-align: center" >Welcome to our Bank Account Management System</h1>
	<img src="resources/Bank.jpg" alt="Mountain View" style="width:304px;height:228px;">
	<sec:authorize access="isAnonymous()">
		<div style="text-align: center">
		<h3>
			Already user? <a href="/login">Login Here</a>
		</h3>
		<h3>
		   New Client? 
			<a href="/register">Register Here</a>
		</h3>
		</div>
	</sec:authorize>
	<sec:authorize access="hasRole('ROLE_ADMIN')">
		<div style="text-align: center">
			<a href="/staff">Go to Staff Page</a><br />
		</div>
	</sec:authorize>
	<sec:authorize access="hasRole('ROLE_USER')">
		<div style="text-align: center">
			<a href="/customer">Go to Customer Page</a><br />
		</div>
	</sec:authorize>
	<sec:authorize access="isAuthenticated()">
		<div style="text-align: center">
	    	<a href="<c:url value="/logout" />">Logout</a>
	    </div>
	</sec:authorize>
</body>
</html>
