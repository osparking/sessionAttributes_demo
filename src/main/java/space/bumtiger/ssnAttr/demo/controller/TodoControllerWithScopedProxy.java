package space.bumtiger.ssnAttr.demo.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.Data;
import space.bumtiger.ssnAttr.demo.domain.TodoItem;
import space.bumtiger.ssnAttr.demo.domain.TodoList;

@Controller
@RequestMapping("/scopedproxy")
@Data
public class TodoControllerWithScopedProxy {
	@Autowired
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
	
	@PostMapping("/form") 
	public String showForm(TodoItem todoItem) {
		todoItem.setCreateDate(LocalDateTime.now());
		todos.add(todoItem);
		
		return "redirect:/scopedproxy/todos";
	}
}
