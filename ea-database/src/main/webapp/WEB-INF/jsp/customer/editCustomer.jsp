<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page session="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
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

 <form:form  modelAttribute="customer" action="register" method="POST">
			<fieldset>
				<legend>NEW CUSTOMER</legend>
				<!--  div><p>
				<form:errors path="*" id="errors"/>
				</p></div-->
				<div><p>
					<label for="firstName">First Name</label>
					<form:input id="firstName" path="firstName" type="text" cssclassError ="form:input-large"/><br/>
					<form:errors path="firstName" id="errors"/>
					</p></div>

				<div><p>
					<label for="lastName">Last Name</label>
					<form:input id="lastName" path="lastName" type="text" /><br/>
					<form:errors path="lastName" id="errors"/>
				</p></div>
			
			      <div><p>
			     		<label for="dateOfBirth">Date of Birth</label>
						  <form:input id="dateOfBirth" path="dateOfBirth" type="text" /><br/>
							<form:errors path="dateOfBirth" id="errors"/>
					</p></div>	
					
					 <div><p>
			     		<label for="phone">Phone Number</label>
						  <form:input  id="phone" path="phone" type="text" /><br/>
							<form:errors path="phone" id="errors"/>
					</p></div>
					 <div><p>
			     		<label for="email">Email</label>
						  <form:input id="email" path="email" type="text"  /><br/>
							<form:errors path="email" id="errors"/>
					</p></div>
					
					
							
				<div><p>
					  <label for="street">Street</label>
					  <form:input id="street" path="customer.address.street" type="text" /><br/>
					  <form:errors path="customer.address.street" id="errors"/>
				</p></div>
									
				 <div><p>
					<label for="city">City</label>
					<form:input id="city" path="address.city" type="text" /><br/>
					<form:errors path="address.city" id="errors"/>
				</p></div>
						
				<div><p>
					<label for="state">State</label>
					<form:input id="state" path="address.state" type="text" /><br/>
					<form:errors path="address.state" id="errors"/>
				</p></div>
					
				  <div>
				  <p>
					<label for="zipCode">Zip Code</label>
					<form:input id="zipCode" path="address.zipCode" type="text" /><br/>
					<form:errors path="address.zipCode" id="errors"/>
				   </p>
				  </div>
		
				 <div><p>
					<label for="username">UserName</label>
					<form:input id="username" path="username" type="text" /><br/>
					<form:errors path="username" id="errors"/>
				 </p></div>
					
				 <div><p>
					<label for="password">Password</label>
					<form:input id="password" path="password" type="password" /><br/>
					<form:errors path="password" id="errors"/>
				 </p></div>
				 
			 <div>
			 <p>
				<input type="submit" id="btnAdd"  />
				<a href='<spring:url value="/"/>'>Home</a>
			 </p>
			</div>
				
			</fieldset>
			 <fieldset>
			<legend>Choose an account</legend>
			
				 <div>
				 <input<a href='<spring:url value="/"/>'>Checking Account!</a>/>
				 <input<a href='<spring:url value="/"/>'>Saving Account!</a>/>
				 </div>
			 
			</fieldset> 
			
		</form:form>
 
 
 
 	</div>
</body>
</html>
