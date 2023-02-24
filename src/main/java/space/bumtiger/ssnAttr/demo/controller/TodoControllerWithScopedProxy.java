package space.bumtiger.ssnAttr.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.Data;
import space.bumtiger.ssnAttr.demo.domain.TodoList;

@Controller
@RequestMapping("/scopedproxy")
@Data
public class TodoControllerWithScopedProxy {
	private TodoList todos;

}
