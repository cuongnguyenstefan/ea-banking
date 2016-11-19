<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="addAccount" method="post">
		<table>
			<tr>
				<td>Customer id</td>
				<!-- <td><input type="text" name="customer.id" /></td> -->
			</tr>
			<tr>
				<td>DEPOSIT</td>
				<td><input type="text" name="amount" /></td>
			</tr>
			<tr>
				<td>WITHDRAW</td>
				<td><input type="text" name="interest" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="CHECK"/></td>
			</tr>
		</table>
	</form>
</body>
</html>