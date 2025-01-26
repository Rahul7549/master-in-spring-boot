<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>	

<div class="conatinr">

    <h1>Welcome to the Spring Boot Application!</h1>
    <p>your UserName: ${username}</p>
	<p>your password: ${password}</p>
	<a href="todo-list">Manage</a> your todos
</div>
	
<%@ include file="common/footer.jspf" %>
