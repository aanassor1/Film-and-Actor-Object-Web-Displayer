<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>List of Actors</title>
</head>
<body>
	<c:forEach items="${actors}" var="actor">
		<p>Name: ${actor.name}, Agent:  ${actor.agent}, Language:  ${actor.language}</p>
	</c:forEach>
	<p><a href="/newActor?film=${filmid}">New actor form</a></p>
</body>
</html>