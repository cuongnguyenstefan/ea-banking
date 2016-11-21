<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	<style>
		#container .account-form{float: left; width:50%;}
		.clear{clear:both;}
	</style>
</head>
<body>
	<h1>Account Information</h1>
	<div id = "container">
	
		<form action="accountInfo" method="post">
			<label for="amount">Amount: <input type="text" name="amount" id="amount" /></label><br><br>
			<label for="amount">Interest: <input type="text" name="interest" id="interest" /></label><br><br>
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
			<input type="submit"  value="Deposit" />
			<!--<input type="submit" name="/accountInfo" value="Withdraw" />-->
		</form>
		
		<!-- <div class="clear"></div>
		<div class="account-form">
			<form action="depositAmount" method="post">

				<input type="submit" name="deposit" value=" Deposit" />

			</form>
		</div>
		<div class="account-form">
			<form action="depositAmount" method="post">
			
				<input type="submit" name="withdraw" value=" Withdraw" />

			</form>
		</div> -->
	</div>
</body>
</html>