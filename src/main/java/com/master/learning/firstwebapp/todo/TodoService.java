package com.master.learning.firstwebapp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;


@Service
public class TodoService {
	
	private static List<Todo> todos =new ArrayList<>();
	public static int countTodo=0;
	
	
	static {
		todos.add(new Todo(++countTodo,"in28minutes","learn AWS",LocalDate.now().plusYears(1),false));
		todos.add(new Todo(++countTodo,"in28minutes","learn AWS",LocalDate.now().plusYears(1),false));
		todos.add(new Todo(++countTodo,"in28minutes","learn AWS",LocalDate.now().plusYears(1),false));
	}
	
	
	public List<Todo> findallTodo(){
		return todos;
	}
	
	public void addNewTodo(Todo todo) {
		todos.add(new Todo(++countTodo, todo.getUsername(),todo.getDescription(), todo.getTargetDate(), todo.isDone()));
		
	}
	
	public void deleteTodo(long id) {
		todos.removeIf(todo -> todo.getId() == id);
	}
	
	public void updateTodo(Todo todo) {
		todos.removeIf(t -> t.getId() == todo.getId());
		todos.add(new Todo(++countTodo, todo.getUsername(),todo.getDescription(), todo.getTargetDate(), todo.isDone()));
	}

	public Todo findTodoById(long id) {
	    return todos.stream()
	                .filter(todo -> todo.getId() == id)
	                .findFirst()
	                .orElse(null);
	}
}
