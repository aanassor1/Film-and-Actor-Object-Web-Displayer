<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>List of Films</title>
</head>
<body>
	<c:forEach items="${films}" var="film">
		<p>Name: ${film.title}, Setting:  ${film.setting} <a href="/actors?film=${film.id}">[Actor List]</a></p>
	</c:forEach>
</body>
</html>