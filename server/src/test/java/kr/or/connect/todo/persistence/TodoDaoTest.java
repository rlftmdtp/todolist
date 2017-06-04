package kr.or.connect.todo.persistence;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import kr.or.connect.todo.AppConfig;
import kr.or.connect.todo.domain.Todo;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class TodoDaoTest {
	
	@Autowired
	private TodoDao dao;
	
	@Test
	public void shouldInsertAndSelect() {
		// given
		Todo todo = new Todo("Java 웹개발", "네이버", 342);

		// when
		Integer id = dao.insert(todo);

		// then
		Todo selected = dao.selectById(id);
		System.out.println(selected);
		assertThat(selected.getTitle(), is("Java 웹개발"));
	}
	
	@Test
	public void shouldDelete() {
		// given
		Todo todo = new Todo("네이버 자바", "네이버", 142);
		Integer id = dao.insert(todo);

		// when
		int affected = dao.deleteById(id);

		// Then
		assertThat(affected, is(1));
	}
	
	@Test
	public void shouldUpdate() {
		// Given
		Todo todo = new Todo("네이버 자바", "네이버", 142);
		Integer id = dao.insert(todo);

		// When
		todo.setId(id);
		todo.setTitle("네이버 자바2");
		int affected = dao.update(todo);

		// Then
		assertThat(affected, is(1));
		Todo updated = dao.selectById(id);
		assertThat(updated.getTitle(), is("네이버 자바2"));
	}

}
