package space.bumtiger.ssnAttr.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.Data;
import space.bumtiger.ssnAttr.demo.domain.TodoItem;
import space.bumtiger.ssnAttr.demo.domain.TodoList;

@Controller
@RequestMapping("/scopedproxy")
@Data
public class TodoControllerWithScopedProxy {
	private TodoList todos;
	
	@GetMapping("/form") 
	public String showForm(Model model) {
		if (!todos.isEmpty()) {
			model.addAttribute("todo", todos.peekLast());
		} else {
			model.addAttribute("todo", new TodoItem());
		}
		return "scopedproxyform";
	}
}
