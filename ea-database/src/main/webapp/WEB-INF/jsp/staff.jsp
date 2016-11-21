<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<html>
<head>
<title>Home</title>
</head>
<body>
	<h1>Hello Staff ID: ${staff.username}</h1>
	<h3>Staff: ${staff.firstName} ${staff.lastName}</h3>
	<h3>List of request new account</h3>
	<table>
		<thead>
			<tr>
				<th>Request ID</th>
				<th>Customer ID</th>
				<th>Status</th>
				<th>Created On</th>
				<th>Request Account Type</th>
				<th>Approve</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${accountRequests}" var="r">
				<tr>
					<td>${r.requestId}</td>
					<td>${r.customer.username}</td>
					<td>${r.requestStatus}</td>
					<td>${r.createdOn}</td>
					<td>${r.accountType}</td>
					<td><a href="/staff/approval?a=true&rId=${r.requestId}">Approve</a> <a href="/staff/approval?a=false&rId=${r.requestId}">Disapprove</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>
