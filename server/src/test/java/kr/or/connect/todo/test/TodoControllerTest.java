package kr.or.connect.todo.test;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import kr.or.connect.todo.TodoApplication;
import kr.or.connect.todo.domain.Todo;
import kr.or.connect.todo.persistence.TodoDao;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = TodoApplication.class)
//@SpringBootTest
@WebAppConfiguration
public class TodoControllerTest {

	SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	Calendar cal = Calendar.getInstance();
	String now = fm.format(cal.getTime());
	Timestamp date = Timestamp.valueOf(now);

	@Autowired
	private TodoDao dao;

	@Test
	public void shouldTodoCount() {
		int count = dao.countTodos();
	}

	@Test
	public void shouldTodoInsertAndSelect() {
		Todo todo = new Todo("할일 테스트", 0, date);
		Integer newId = dao.insert(todo);
	}

	@Test
	public void shouldTodoDelete() {

		Todo todo = new Todo("삭제 테스트", 0, date);
		Integer newId = dao.insert(todo);
		int affected = dao.deleteById(newId);
	}

	@Test
	public void shouldTodoUpdate() {
		Todo todo = new Todo("업데이트 테스트", 0, date);
		Integer newId = dao.insert(todo);

		todo.setId(newId);
		todo.setTodo("업데이트 테스트");
		int affected = dao.update(todo);
	}

}
