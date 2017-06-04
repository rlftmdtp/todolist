package kr.or.connect.todo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import kr.or.connect.todo.domain.Todo;
import kr.or.connect.todo.persistence.TodoDao;

@SpringBootApplication
public class TodoApplication extends WebMvcConfigurerAdapter {
	public static void main(String[] args) {
		SpringApplication.run(TodoApplication.class, args);
		
		/*
		// AppConfig 활용
		ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		TodoDao dao = context.getBean(TodoDao.class); // Bean이나 Repository으로 등록됨
		
		int count = dao.countBooks();
		System.out.println(count);
		
		Todo todo = dao.selectById(1);
		System.out.println(todo);
		
		
		추가 테스트
		Todo todo2 = new Todo("네이버 Java", "김강산", 512);
		Integer newId = dao.insert(todo2);
		System.out.println(newId);
		System.out.println(dao.selectById(newId));
		
		context.close();
		*/
	}
}
