package com.master.learning.firstwebapp.todo;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;


@Controller
//@SessionAttributes("username")
public class TodoController {
	
	@Autowired
	TodoService todoService;
	@Autowired
	TodoRepository todoRepository;
	
	@RequestMapping("/todo-list")
	public String goToTodoListPage(ModelMap model) {
		//var todos= todoService.findallTodo(getLoggedInUsername());
		var todos=todoRepository.findByUsername(getLoggedInUsername());
		model.addAttribute("todos",todos);
		return "todolistview";
		
	}
	
	@RequestMapping("/add-todo")
	public String goToAddTodoPage(ModelMap model) {
        //String username=(String) model.get("username");
		Todo todo= new Todo(0,getLoggedInUsername(),"",LocalDate.now().plusYears(1),false);
        model.addAttribute("todo",todo);
		return "addnewTodo";
		
	}
	
	@PostMapping("/add-todo")
	public String addTodo(ModelMap model,@Valid Todo todo, BindingResult result) {
		if(result.hasErrors()) {
			return "addnewTodo";
		}
		//todo.setDone(false);
		//todo.setTargetDate(LocalDate.now().plusYears(1));
		//todo.setUsername(getLoggedInUsername());
		
		todo.setUsername(getLoggedInUsername());
		//todoService.addNewTodo(todo);
		//System.out.println(todo);
		todoRepository.save(todo);
		//System.out.println(todo);
		return "redirect:todo-list";
		
	}
	
	
	@GetMapping("/delete-todo")
	public String deleteTodo(@RequestParam long id) {
		//todoService.deleteTodo(id);
		todoRepository.deleteById(id);
		return "redirect:todo-list"; 
	}
	
	
	@GetMapping("/update-todo")
	public String goTOUpdateTodoPage(ModelMap model,@RequestParam Long id) {
		//Todo todo=todoService.findTodoById(id);
	    Todo todo=todoRepository.findById(id).get();
        model.addAttribute("todo",todo);
		return "addnewTodo"; 
	}
	
	@PostMapping("/update-todo")
	public String updateTodo(ModelMap model,@Valid Todo todo, BindingResult result) {
		if(result.hasErrors()) {
			return "addnewTodo";
		}
		todo.setUsername(getLoggedInUsername());
		//todoService.updateTodo(todo);
		todoRepository.save(todo);
		return "redirect:todo-list";
	}
	
	private String getLoggedInUsername() {
		Authentication authentication = 
				SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
	}
	


}
