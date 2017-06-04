package kr.or.connect.todo.api;

import java.util.Collection;

import org.springframework.http.HttpStatus; // ...
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import kr.or.connect.todo.domain.Todo;
import kr.or.connect.todo.service.TodoService;

@RestController
@RequestMapping("/api/books") // 공퉁 부분 선언  추후 books 부분 변경해야함
public class TodoController {

	private final TodoService service;

	@Autowired
	public TodoController(TodoService service) {
		this.service = service;
	}
	
	@GetMapping
	Collection<Todo> readList() {
		return service.findAll();
	}

	@GetMapping("/{id}")
	Todo read(@PathVariable  Integer id) {
		return service.findById(id);
	}
	
}
