package kr.or.connect.todo.persistence;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import kr.or.connect.todo.AppConfig;
import kr.or.connect.todo.domain.Todo;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = AppConfig.class)
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

}
