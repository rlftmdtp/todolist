package kr.or.connect.todo.service;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.stereotype.Service;

import kr.or.connect.todo.domain.Todo;

@Service
public class TodoService {
	
	public Todo findById(Integer id) {
		return new Todo(1, "Java 이렇게 공부하자", "김자바", 300);
	}

	public Collection<Todo> findAll() {
		return Arrays.asList(
			new Todo(1, "네이버 네비 좋아요", "김광근", 300),
			new Todo(2, "HTTP 완벽 이해하기", "김명호", 300)
		);
	}

}
