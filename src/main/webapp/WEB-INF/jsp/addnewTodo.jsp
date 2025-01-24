<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
	<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet" >
    <title>Welcome</title>
</head>
<body>
	<div class='container'>
    	<h1>Add new Todo</h1>
		<hr>
		<form:form method="post" modelAttribute="todo">
			Description:
			<div class="input-group">
				<form:input type="hidden" path="done" class="form-control" />
				<form:input type="hidden" path="id" class="form-control" />
				<form:input type="hidden" path="done" class="form-control" />
			  <form:input type="text" path="description" class="form-control" required="required"/>
			  <div class="input-group-append" id="button-addon4">
			    <button class="btn btn-outline-success" type="submit">Button</button>
			  </div>
			 
			</div>
		</form:form>
		
		
	</div>
	<script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
	<script src="webjars/jquery/3.6.0/jquery.min.js"></script>
</body>
</html>
