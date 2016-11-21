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
		
		<p>Request new Account:</p>
		<a href="/customer/request?type=saving">Saving Account</a>
		<a href="/customer/request?type=checking">Checking Account</a>
	</fieldset>
	<a href="logout">logout</a>

</body>
</html>
