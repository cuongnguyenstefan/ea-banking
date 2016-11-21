<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<html>
<head>
<title>Staff History</title>
</head>
<body>
	<h1>Hello Staff ID: ${staff.username}</h1>
	<h3>Staff: ${staff.firstName} ${staff.lastName}</h3>
	<h3>List of your activities</h3>
	<table>
		<thead>
			<tr>
				<th>History ID</th>
				<th>Approved</th>
				<th>Request Type</th>
				<th>Customer ID</th>
				<th>Created On</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${histories}" var="h">
				<tr>
					<td>${h.historyId}</td>
					<td>${h.approved}</td>
					<td>${h.requestType}</td>
					<td>${h.customer.username}</td>
					<td>${h.createdOn}</td>
					<td>${h.action}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div>
		<a href="/staff">Back</a>
	</div>
	<div>
		<a href="/logout">Logout</a>
	</div>
</body>
</html>
