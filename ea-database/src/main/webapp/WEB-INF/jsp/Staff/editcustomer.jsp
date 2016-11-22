<%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page session="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<title>Edit</title>
</head>
<body>

	<div id="register-box">

		<h2>Edit</h2>

		<c:if test="${not empty error}">
			<div class="error">${error}</div>
		</c:if>
		<c:if test="${not empty msg}">
			<div class="msg">${msg}</div>
		</c:if>

		<form:form modelAttribute="customer" action="updateUser" method="POST">
			<fieldset>
				<legend>EDIT CUSTOMER ID: <form:input id="username" path="username" type="text" /></legend>
				<div>
					<p>
						<label for="firstName">First Name</label>
						<form:input id="firstName" path="firstName" type="text" />
					
						
						<form:errors path="firstName" cssStyle="color : red;" />
                    
					</p>
				</div>

				<div>
					<p>
						<label for="lastName">Last Name</label>
						<form:input id="lastName" path="lastName" type="text" />  
						
					
						<form:errors path="lastName" cssStyle="color : red;" />
                    
                   </p>
					
				</div>

				<div>
					<p>
						<label for="dateOfBirth">Date of Birth</label>
						<form:input id="dateOfBirth" path="dateOfBirth" type="text" />
						
						<form:errors path="dateOfBirth" cssStyle="color : red;" />
                    
					</p>
				</div>

				<div>
					<p>
						<label for="phone">Phone Number</label>
						<form:input id="phone" path="phone" type="text" />
						
						<form:errors path="phone" cssStyle="color : red;" />
                   
					</p>
				</div>
				<div>
					<p>
						<label for="email">Email</label>
						<form:input id="email" path="email" type="text" />
						
						<form:errors path="email" cssStyle="color : red;" />
                     
					</p>
				</div>



				<div>
					<p>
						<label for="street">Street</label>
						<form:input id="street" path="address.street" type="text" />
						
						<form:errors path="address.street" cssStyle="color : red;" />
                     
					</p>
				</div>

				<div>
					<p>
						<label for="city">City</label>
						<form:input id="city" path="address.city" type="text" />
						
						<form:errors path="address.city" cssStyle="color : red;" />
                     
					</p>
				</div>

				<div>
					<p>
						<label for="state">State</label>
						<form:input id="state" path="address.state" type="text" />
						
						<form:errors path="address.state" cssStyle="color : red;" />
                    
					</p>
				</div>

				<div>
					<p>
						<label for="zipCode">Zip Code</label>
						<form:input id="zipCode" path="address.zipCode" type="text" />
						
						<form:errors path="address.zipCode" cssStyle="color : red;" />
                     
					</p>
				</div>
				
				<div>
					<p>
						<label for="country">Country</label>
						<form:input id="country" path="address.country" type="text" />
						
						<form:errors path="address.country" cssStyle="color : red;" />
                    
					</p>
				</div>

				<div>
					<p>
						<label for="password">Password</label>
						<form:input id="password" path="password" type="password" />
						
						<form:errors path="password" cssStyle="color : red;" />
                    
					</p>
				</div>

				<div>
					<p>
						<input type="submit" value="Update" id="btnAdd" /> <a
							href='<spring:url value="/staff/list"/>'>Back</a>
					</p>
				</div>

			</fieldset>

		</form:form>



	</div>
</body>
</html>
