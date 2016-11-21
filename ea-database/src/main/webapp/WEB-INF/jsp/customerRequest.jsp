<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<title>Customer Add</title>
</head>
<body>
		 	<form:form  modelAttribute="requestAccount" action="addRequest" method="POST">
			<fieldset>
				<legend>NEW CUSTOMER</legend>
				<!--  div><p>
				<form:errors path="*" id="errors"/>
				</p></div-->
				<div><p>
					<label for="firstName">First Name</label>
					<form:input id="firstName" path="customer.firstName" type="text" cssclassError ="form:input-large"/><br/>
					<form:errors path="customer.firstName" id="errors"/>
					</p></div>

				<div><p>
					<label for="lastName">Last Name</label>
					<form:input id="lastName" path="customer.lastName" type="text" /><br/>
					<form:errors path="customer.lastName" id="errors"/>
				</p></div>
			
			      <div><p>
			     		<label for="dateOfBirth">Date of Birth</label>
						  <form:input id="dateOfBirth" path="customer.dateOfBirth" type="text" /><br/>
							<form:errors path="customer.dateOfBirth" id="errors"/>
					</p></div>	
					
					 <div><p>
			     		<label for="phone">Phone Number</label>
						  <form:input  id="phone" path="customer.phone" type="text" /><br/>
							<form:errors path="customer.phone" id="errors"/>
					</p></div>
					 <div><p>
			     		<label for="email">Email</label>
						  <form:input id="email" path="customer.email" type="text"  /><br/>
							<form:errors path="customer.email" id="errors"/>
					</p></div>
					
					
							
				<div><p>
					  <label for="street">Street</label>
					  <form:input id="street" path="customer.address.street" type="text" /><br/>
					  <form:errors path="customer.address.street" id="errors"/>
				</p></div>
									
				 <div><p>
					<label for="city">City</label>
					<form:input id="city" path="customer.address.city" type="text" /><br/>
					<form:errors path="customer.address.city" id="errors"/>
				</p></div>
						
				<div><p>
					<label for="state">State</label>
					<form:input id="state" path="customer.address.state" type="text" /><br/>
					<form:errors path="customer.address.state" id="errors"/>
				</p></div>
					
				  <div>
				  <p>
					<label for="zipCode">Zip Code</label>
					<form:input id="zipCode" path="customer.address.zipCode" type="text" /><br/>
					<form:errors path="customer.address.zipCode" id="errors"/>
				   </p>
				  </div>
		
				 <div><p>
					<label for="username">UserName</label>
					<form:input id="username" path="customer.username" type="text" /><br/>
					<form:errors path="customer.username" id="errors"/>
				 </p></div>
					
				 <div><p>
					<label for="password">Password</label>
					<form:input id="password" path="customer.password" type="password" /><br/>
					<form:errors path="customer.password" id="errors"/>
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
		</body>
</html>