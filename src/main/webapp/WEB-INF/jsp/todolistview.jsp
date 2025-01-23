
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
	<html>
	<head>
	    <title>Todos list</title>
	</head>
	<body>
	    <h1>Welcome To Todos list!</h1>
		<c:forEach items="${todos}" var="todo">
			<li>${todo}</li>
		</c:forEach>
	</body>
</html>
