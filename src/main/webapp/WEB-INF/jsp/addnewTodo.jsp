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
		<form method="post">
			Description:
			<div class="input-group">
			  <input type="text" name="description" class="form-control" placeholder="Description" 
			  aria-label="User need to inter description" aria-describedby="button-addon4">
			  <div class="input-group-append" id="button-addon4">
			    <button class="btn btn-outline-success" type="submit">Button</button>
			  </div>
			  </input>
			</div>
		</form>
		
		
	</div>
	<script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
	<script src="webjars/jquery/3.6.0/jquery.min.js"></script>
</body>
</html>
