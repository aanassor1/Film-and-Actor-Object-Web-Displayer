<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>New Film Form</title>
</head>
<body>
<form:form action="/addFilm" modelAttribute="film">
	ID:
	<form:input path="id"/>
	<form:errors path="id"/><br/>

	Title:
	<form:input path="title"/>
	<form:errors path="title"/><br/>
	
	Setting:
	<form:input path="setting"/>
	<form:errors path="setting"/><br/>

	<input type="submit"/>
</form:form>
</body>
</html>