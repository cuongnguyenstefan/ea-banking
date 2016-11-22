<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<title>Home</title>
</head>
<body>
<a href="?lang=en_US" >English</a>|<a href="?lang=sp_SP" >Spanish</a>
	<h1><spring:message code="form.helloStaffID.label"/>: ${staff.username}</h1>
	<h3><spring:message code="form.staff.label"/>: ${staff.firstName} ${staff.lastName}</h3>
	<h3><spring:message code="form.Listofrequestnewaccount.label"/>List of request new account</h3>
	<table>
		<thead>
			<tr>
				<th><spring:message code="form.requestID.label"/></th>
				<th><spring:message code="form.customerID.label"/></th>
				<th><spring:message code="form.Status.label"/></th>
				<th><spring:message code="form.createdOn.label"/></th>
				<th><spring:message code="form.requestAccountType.label"/></th>
				<th><spring:message code="form.approve.label"/></th>
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
					<td><a href="/staff/approval?a=true&rId=${r.requestId}">
					<spring:message code="form.approve.label"/></a> 
					<a href="/staff/approval?a=false&rId=${r.requestId}">
					<spring:message code="form.disapprove.label"/></a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<h3>Other Options</h3>
	<div>
		<div><a href="/staff/list"><spring:message code="form.listCustomers.label"/></a></div>
		<div><a href="/staff/history"><spring:message code="form.getMyActivities.label"/></a></div>
		<div><a href="/"><spring:message code="form.Home.label"/></a></div>
		<div><a href="/logout"><spring:message code="form.Logout.label"/></a></div>
	</div>
</body>
</html>
