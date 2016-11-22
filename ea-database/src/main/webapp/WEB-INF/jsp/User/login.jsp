<%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page session="true"%>
<html>
<head>
<title>Login</title>
</head>
<body>

	<div id="login-box">
   <a href="?lang=en_US" >English</a>|<a href="?lang=sp_SP" >Spanish</a>
		<h2><spring:message code="form.loginwithUsernameandPassword.label"/></h2>

		<c:if test="${not empty error}">
			<div class="error">${error}</div>
		</c:if>
		
		<c:if test="${not empty msg}">
			<div class="msg">${msg}</div>
		</c:if>

		<form name='loginForm'
		  action="<c:url value='/login' />" method='POST'>

		<table>
			<tr>
				<td><spring:message code="form.userID.label"/></td>
				<td><input type='text' name='username'></td>
			</tr>
			<tr>
				<td><spring:message code="form.password.label"/></td>
				<td><input type='password' name='password' /></td>
			</tr>
			<tr>
				<td colspan='2'><input name="submit" type="submit"
				  value="<spring:message code="form.submit.label"/>" /></td>
			</tr>
		  </table>

		  <input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />

		</form>
	</div>
</body>
</html>
