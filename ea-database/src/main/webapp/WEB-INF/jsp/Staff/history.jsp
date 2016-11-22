<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page session="true"%>
<html>
<head>
<title>Staff History</title>
</head>
<body>
   <a href="?lang=en_US" >English</a>|<a href="?lang=sp_SP" >Spanish</a>
	<h1><spring:message code="form.helloStaffID.label"/>: ${staff.username}</h1>
	<h3><spring:message code="form.staff.label"/>: ${staff.firstName} ${staff.lastName}</h3>
	<fieldset>
				<legend><spring:message code="form.listofyouractivities.label"/></legend>
	<table>
		<thead>
			<tr>
				<th><spring:message code="form.historyID.label"/></th>
				<th><spring:message code="form.approved.label"/></th>
				<th><spring:message code="form.requestType.label"/></th>
				<th><spring:message code="form.customerID.label"/></th>
				<th><spring:message code="form.createdOn.label"/></th>
				<th><spring:message code="form.action.label"/></th>
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
	</fieldset>
	<div>
		<a href="/staff"><spring:message code="form.back.label"/></a>
	</div>
	<div>
		<a href="/logout"><spring:message code="form.logout.label"/></a>
	</div>
</body>
</html>
