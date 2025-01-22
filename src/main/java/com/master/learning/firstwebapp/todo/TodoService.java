package com.master.learning.firstwebapp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TodoService {
	
	private static List<Todo> todos =new ArrayList<>();
	
	static {
		todos.add(new Todo(1,"in28minutes","learn AWS",LocalDate.now().plusYears(1),false));
	}
	
	
	public List<Todo> findallTodo(){
		return todos;
	}

}
