package com.master.learning.firstwebapp.todo;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes("username")
public class TodoController {
	
	@Autowired
	TodoService todoService;
	
	@RequestMapping("/todo-list")
	public String goToTodoListPage(ModelMap model) {
		var todos= todoService.findallTodo();
		model.addAttribute("todos",todos);
		return "todolistview";
		
	}
	
	@RequestMapping("/add-todo")
	public String goToAddTodoPage(ModelMap model) {
		String username=(String) model.get("username");
		Todo todo= new Todo(1,username,"",LocalDate.now().plusYears(1),false);
        model.put("todo",todo);
		return "addnewTodo";
		
	}
	
	@PostMapping("/add-todo")
	public String addTodo(ModelMap model,Todo todo) {
		todo.setDone(false);
		todo.setTargetDate(LocalDate.now().plusYears(1));
		todo.setUsername((String) model.get("username"));
		todoService.addNewTodo(todo);
		return "redirect:todo-list";
		
	}


}
