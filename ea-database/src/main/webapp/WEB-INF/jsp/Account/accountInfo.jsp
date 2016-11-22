<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
#container .account-form {
	float: left;
	width: 50%;
}

.clear {
	clear: both;
}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
<script>
	$(function() {
		$('#info').on('click', function(){
			$('#info').prop('disabled', true);
			$.get("/customer/rest").done(function(data) {
				$.each(data, function(index, value) {
					$('#info-div').append(index + ': ' + value + ' <br />');
				});
			});
		});
	});
	
</script>
</head>
<body>
	<h1>Account Information</h1>
	<div id="container">


		Amount: ${ account.amount }<br> <br>
		
		<button id="info" class="show">Show Info</button>
		<div id="info-div"></div>
		<c:if test="${not empty error}">
			<div class="error">${error}</div>
		</c:if>
		<form action="account/withdraw" method="post">
			<input type="hidden" name="accountId" value="${ account.id }" />
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
			<input type="submit" value=" Withdraw" />
			<input type="text" name="amount" id="amount" />
		</form>

		<form action="account/deposit" method="post">

			<input type="hidden" name="accountId" value="${ account.id }" />
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
			<input type="submit" value="Deposit" id="amount" />
			<input type="text" name="amount" id="amount" />

		</form>
		<a href="/logout">Logout</a> <a href="/customer">Back</a>
		
	</div>
</body>
</html>