package com.master.learning.firstwebapp.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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

}
