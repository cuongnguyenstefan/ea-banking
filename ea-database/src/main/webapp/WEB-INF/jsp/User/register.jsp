<%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page session="true"%>
<html>
<head>
<title>Login</title>
</head>
<body>

	<div id="register-box">

		<h2>Register</h2>

		<c:if test="${not empty error}">
			<div class="error">${error}</div>
		</c:if>
		<c:if test="${not empty msg}">
			<div class="msg">${msg}</div>
		</c:if>

		<form name='registerForm'
		  action="<c:url value='/register' />" method='POST'>

		<table>
			<tr>
				<td>First name:</td>
				<td><input type='text' name='fistName'></td>
			</tr>
			<tr>
				<td>Last name:</td>
				<td><input type='text' name='lastName'></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type='password' name='password' /></td>
			</tr>
			<tr>
				<td>Country:</td>
				<td><input type='text' name='country'></td>
			</tr>
			<tr>
				<td>State:</td>
				<td><input type='text' name='state'></td>
			</tr>
			<tr>
				<td>Street:</td>
				<td><input type='text' name='street'></td>
			</tr>
			<tr>
				<td colspan='2'><input name="submit" type="submit"
				  value="submit" /></td>
			</tr>
		  </table>

		  <%-- <input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" /> --%>

		</form>
	</div>
</body>
</html>
