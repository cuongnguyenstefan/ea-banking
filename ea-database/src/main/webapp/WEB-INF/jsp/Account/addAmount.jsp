<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add New Amount</title>
</head>
<body>

<div>
		<form:form action="accountAdd" method="POST" commandname = "accountAdd">

			
				Amount:  
				
				
				
				<label for="amount">Deposit:<input type="text" name="amount" id="amount" /></label>
				<label for="amount">Withdraw: <input type="text" name="interest" id="interest" /></label>
				
			<input type="submit" name="/accountInfo" value="Deposit" />
			<input type="submit" name="/accountInfo" value="Withdraw" />
			
		</form:form>
	</div>


</body>
</html>