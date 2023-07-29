<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>New Actor Form</title>
</head>
<body>
<form:form action="/addActor?film=${filmid}" modelAttribute="actor">
	Name:
	<form:input path="name"/>
	<form:errors path="name"/><br/>
	
	Agent:
	<form:input path="agent"/>
	<form:errors path="agent"/><br/>
	
	Language:
	<form:input path="language"/>
	<form:errors path="language"/><br/>
	
	Age:
	<form:input path="age"/>
	<form:errors path="age"/><br/>
	
	<input type="submit"/>
</form:form>
</body>
</html>