<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style type="text/css">@import url("<spring:url value="/resource/css/main.css"/>");</style>
<title>Customer Edit</title>
</head>
<body>
	<div id="global">
	 	<form:form  modelAttribute="customer" method="POST">
			<fieldset>
				<legend><spring:message code="edit.customer.legend"></spring:message></legend>
				<div><p>
				<form:errors path="*" id="errors"/>
				</p></div>
				<div><p>
					<label for="customerNumber"><spring:message code="customer.customerNumber.label"></spring:message></label>  
					<form:input id="customerNumber" path="customerNumber" type="text" value="${customer.customerNumber}" />
					<form:errors path="customerNumber" id="errors"/>
				</p></div>
				
				<div><p>
					<label for="firstName"><spring:message code="customer.firstName.label"></spring:message></label>
					<form:input id="firstName" path="firstName" type="text" value="${customer.firstName}"/>
					<form:errors path="firstName" id="errors"/>
				</p></div>
				
				<div><p>
					<label for="lastName"><spring:message code="customer.lastName.label"></spring:message></label>
					<form:input id="lastName" path="lastName" type="text" value="${customer.lastName}" />
					<form:errors path="lastName" id="errors"/>
				</p></div>
			
		     	<div><p>
			     		<label for="dateOfBirth"><spring:message code="customer.dateOfBirth.label"></spring:message></label>
						  <form:input id="dateOfBirth" path="dateOfBirth" type="text" value="${customer.dateOfBirth}" />
							<form:errors path="dateOfBirth" id="errors"/>
				 </p></div>
			      <div><p>
			     		<label for="phone"><spring:message code="customer.phone.label"></spring:message></label>
						  <form:input id="phone" path="phone" type="text" value="${customer.phone}" />
							<form:errors path="phone" id="errors"/>
					</p></div>	
					<div><p>
			     		<label for="email"><spring:message code="customer.email.label"></spring:message></label>
						  <form:input id="email" path="email" type="text" value="${customer.email}" />
							<form:errors path="email" id="errors"/>
					</p></div>
					
					<div><p>
			     		<label for="productImage"><spring:message code="customer.image.label"></spring:message></label>
						  <form:input id="image" value = "/resource/images/${cutomer.firstName}${cutomer.Id}.png" path="customerImage" type="file" /><br/>
							<form:errors path="customerImage" id="errors"/>
					</p></div>						
				<div><p>
					  <label for="street"><spring:message code="address.street.label"></spring:message></label>
					  <form:input id="City" path="address.street" type="text" value="${customer.address.street}" />
					  <form:errors path="address.street" id="errors"/>
				</p></div>
									
				 <div><p>
					<label for="City"><spring:message code="address.city.label"></spring:message></label>
					<form:input id="City" path="address.city" type="text" value="${customer.address.city}" />
					<form:errors path="address.city" id="errors"/>
				</p></div>
						
				<div><p>
					<label for="State"><spring:message code="address.state.label"></spring:message></label>
					<form:input id="State" path="address.state" type="text" value="${customer.address.state}" />
					<form:errors path="address.state" id="errors"/>
				</p></div>
					
				  <div><p>
					<label for="zipCode"><spring:message code="address.zipCode.label"></spring:message></label>
					<form:input id="zipCode" path="address.zipCode" type="text" value="${customer.address.zipCode}"  />
					<form:errors path="address.zipCode" id="errors"/>
				  </p></div>
			  	
	<!-- 
				 <div><p>
					<label for="username"><spring:message code="user.username.label"></spring:message></label>
						<form:input id="username" path="user.username" type="text" />
						<form:errors path="user.username" id="errors"/>
				 </p></div>
					
				 <div><p>
					<label for="password"><spring:message code="user.password.label"></spring:message></label>
					<form:input id="password" path="user.password" type="password" />
					<form:errors path="user.password" id="errors"/>
				 </p></div>
			  </p></div>
			  -->
			 <div><p>
				<input type="submit" id="btnSave"  value ="<spring:message code="edit.save.btn"></spring:message>"/>
				
				<a href=" <c:url value="/customer/list" />">
				 <input type="button" id="btnCancel"  value ="<spring:message
					code="edit.cancel.btn"></spring:message>"/> </a>
			</p>
			</div>
				
			</fieldset>
		</form:form>
	</div>
</body>
</html>
