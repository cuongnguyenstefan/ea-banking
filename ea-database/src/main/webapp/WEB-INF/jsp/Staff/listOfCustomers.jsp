<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style type="text/css">@import url("<spring:url value="/resource/css/main.css"/>");</style>
<title>List Of Customers</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
<script type="text/javascript">
	$(function(){
		$('button.show').on('click', function() {
			$(this).prop('disabled', true);
			var id = $(this).next().val();
			var button = $(this);
			$.get('/request/rest/' + id).done(function(data){
				$.each(data, function(i, v){
					button.parent().next().append("Request: <br/>");
					$.each(v, function(idx, val){
						button.parent().next().append("---" + idx + ": " + val + "<br/>");
					});
				});
			});
		})
	});
</script>
</head>
<body>
	<div id="global">
	<a href="?lang=en_US" >English</a>|<a href="?lang=sp_SP" >Spanish</a>
					<fieldset>
				<legend><spring:message code="form.Customerlist.label"/></legend>
			<table style="width:100%">
				<tr>
				<th><spring:message code="form.firstName.label"/></th>
				<th><spring:message code="form.lastName.label"/></th>
				<th><spring:message code="form.dateOfBirth.label"/></th>
				<th><spring:message code="form.phone.label"/></th>
				<th><spring:message code="form.email.label"/></th>
				<th><spring:message code="form.address.label"/></th>
				<th>Options</th>
				<th></th>
				</tr>
		    
			<c:forEach items="${customers}" var="user">
				<tr>
					<td>${user.username} </td>
					<td>${user.firstName}</td>
					<td>${user.lastName}</td>
					<td>${user.dateOfBirth} </td>
					<td>${user.phone} </td>
					<td>${user.email} </td>
					<td> ${user.address.street}, ${user.address.city}, ${user.address.state} ${user.address.zipCode}</td>
					<td>
							<a href="<spring:url value="/staff/updateUser?id=${user.username}"/>" >Update</a>
							<button class="show">Show Requests</button>
							<input type="hidden" value="${user.username}"/>
					</td>
					<td class="requests"></td>
					
			 </tr>
			</c:forEach>
	</table>
	<hr>
	</fieldset>
	<div>
		<a href="/staff">Back</a>
	</div>
	<div>
		<a href="/logout">Logout</a>
	</div>
	</div>
</body>
</html>
