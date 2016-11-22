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
<title>Register</title>
</head>
<body>

	<div id="register-box">
          <a href="?lang=en_US" >English</a>|<a href="?lang=sp_SP" >Spanish</a>
		<h2><spring:message code="form.register.label"/></h2>

		<c:if test="${not empty error}">
			<div class="error">${error}</div>
		</c:if>
		<c:if test="${not empty msg}">
			<div class="msg">${msg}</div>
		</c:if>

		<form:form modelAttribute="customer" action="register" method="POST">
			<fieldset>
				<legend><spring:message code="form.newCustomer.label"/></legend>
				
				<div>
					<p>
						<label for="firstName"><spring:message code="form.firstName.label"/></label>
						<form:input id="firstName" path="firstName" type="text" />
					
						
						<form:errors path="firstName" cssStyle="color : red;" />
                    
					</p>
				</div>

				<div>
					<p>
						<label for="lastName"><spring:message code="form.lastName.label"/></label>
						<form:input id="lastName" path="lastName" type="text" />  
						
					
						<form:errors path="lastName" cssStyle="color : red;" />
                    
                   </p>
					
				</div>

				<div>
					<p>
						<label for="dateOfBirth"><spring:message code="form.dateOfBirth.label"/></label>
						<form:input id="dateOfBirth" path="dateOfBirth" type="text" />
						
						<form:errors path="dateOfBirth" cssStyle="color : red;" />
                    
					</p>
				</div>

				<div>
					<p>
						<label for="phone"><spring:message code="form.phone.label"/></label>
						<form:input id="phone" path="phone" type="text" />
						
						<form:errors path="phone" cssStyle="color : red;" />
                   
					</p>
				</div>
				<div>
					<p>
						<label for="email"><spring:message code="form.email.label"/></label>
						<form:input id="email" path="email" type="text" />
						
						<form:errors path="email" cssStyle="color : red;" />
                     
					</p>
				</div>



				<div>
					<p>
						<label for="street"><spring:message code="form.address.street.label"/></label>
						<form:input id="street" path="address.street" type="text" />
						
						<form:errors path="address.street" cssStyle="color : red;" />
                     
					</p>
				</div>

				<div>
					<p>
						<label for="city"><spring:message code="form.address.city.label"/></label>
						<form:input id="city" path="address.city" type="text" />
						
						<form:errors path="address.city" cssStyle="color : red;" />
                     
					</p>
				</div>

				<div>
					<p>
						<label for="state"><spring:message code="form.address.state.label"/></label>
						<form:input id="state" path="address.state" type="text" />
						
						<form:errors path="address.state" cssStyle="color : red;" />
                    
					</p>
				</div>

				<div>
					<p>
						<label for="zipCode"><spring:message code="form.address.zipCode.label"/></label>
						<form:input id="zipCode" path="address.zipCode" type="text" />
						
						<form:errors path="address.zipCode" cssStyle="color : red;" />
                     
					</p>
				</div>
				
				<div>
					<p>
						<label for="country"><spring:message code="form.address.country.label"/></label>
						<form:input id="country" path="address.country" type="text" />
						
						<form:errors path="address.country" cssStyle="color : red;" />
                    
					</p>
				</div>

				<div>
					<p>
						<label for="password"><spring:message code="form.password.label"/></label>
						<form:input id="password" path="password" type="text" />
						
						<form:errors path="password" cssStyle="color : red;" />
                    
					</p>
				</div>

				<div>
					<p>
						<input type="submit" value= "<spring:message code="form.submit.label"/>" id="btnAdd" />
						<a	href='<spring:url value="/"/>'><spring:message code="form.home.label"/></a>
					</p>
				</div>

			</fieldset>

		</form:form>



	</div>
</body>
</html>
