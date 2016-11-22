<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
body {
	margin: 0px;
	padding: 0px;
}

body>h1 {
	text-align: center;
}

#container {
	text-align: center;
	border: 1px dotted #DDD;
	padding: 20px;
	width: 50%;
	margin: auto;
}

#container p {
	margin: 0px;
	padding: 0px 0px 15px 0px;
}

#container #info {
	padding: 7px;
	margin-bottom: 10px;
}

#container .account-form {
	float: left;
	width: 50%;
}

#container .form {
	padding: 10px;
}

.btn {
	padding: 5px 15px;
	background: #ccc;
	border: 0 none;
	cursor: pointer;
	-webkit-border-radius: 5px;
	border-radius: 5px;
	width: 100px;
}
.link{
	padding: 10px;
    color: #444;
}
input[type="text"]{
	padding: 5px;
}
#info-div{
	text-align: left;
}
tr.result span{
	text-transform: capitalize;
}
.clear {
	clear: both;
}
</style>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
<script>
	$(function() {
		$('#info').on('click', function() {
			$('#info').prop('disabled', true);
			$.get("/customer/rest").done(function(data) {
			    var res = "";
			    $.each(data, function(index, value) {
					res += '<tr class="result"><td><span>' + index + '</span></td><td>:</td><td>' + value + '</td></tr>';
				});
			    $('#info-div').append('<table>'+res+'</table>');
			});
		});
	});
</script>
</head>
<body>
	<h1>Account Information</h1>
	<div id="container">

		<p>Amount: ${ account.amount }</p>

		<button id="info" class="show btn">Show Info</button>
		<div id="info-div"></div>
		<c:if test="${not empty error}">
			<div class="error">${error}</div>
		</c:if>
		<form action="account/withdraw" method="post" class="form">
			<input type="hidden" name="accountId" value="${ account.id }" /> <input
				type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
			<input type="text" name="amount" id="amount" placeholder="Enter amount" /> <input type="submit"
				value=" Withdraw" class="btn" />

		</form>

		<form action="account/deposit" method="post" class="form">

			<input type="hidden" name="accountId" value="${ account.id }" /> <input
				type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
			<input type="text" name="amount" id="amount" placeholder="Enter amount" /> <input type="submit"
				value="Deposit" id="amount" class="btn" />


		</form>
		<a href="/logout" class="link">Logout</a>
		<a href="/customer" class="link">Back</a>

	</div>
</body>
</html>