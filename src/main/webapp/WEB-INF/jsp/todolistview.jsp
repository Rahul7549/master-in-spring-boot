
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
	<html>
	<head>
		<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet" >
	    <title>Todos list</title>
	</head>
	<body>
		<div class="container">
			<h3>Welcome To Todos list ${username}!</h3>
			<table class="table">
				<thead>
					<tr>
						<td>Si No.</td>
						<td>Description</td>
						<td>Target Date</td>
						<td>Done</td>
					</tr>
				</thead>
				<tbody>
						<c:forEach items="${todos}" var="todo">
							<tr>
									<td>${todo.id}</td>
									<td>${todo.description}</td>
									<td>${todo.targetDate}</td>
									<td>${todo.done}</td>
						    </tr>
						</c:forEach>
				</tbody>
			</table>
			<a  class="btn btn-success" href="add-todo">Add new</a>
		</div>
		
		
		<script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
		<script src="webjars/jquery/3.6.0/jquery.min.js"></script>
	</body>
</html>
