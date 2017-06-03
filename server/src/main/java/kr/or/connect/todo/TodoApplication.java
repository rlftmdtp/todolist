package kr.or.connect.todo;

import java.util.Collections;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import kr.or.connect.todo.persistence.TodoDao;

@SpringBootApplication
public class TodoApplication extends WebMvcConfigurerAdapter {
	public static void main(String[] args) {
		SpringApplication.run(TodoApplication.class, args);
		
		ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		DataSource dataSource = context.getBean(DataSource.class);
		TodoDao dao = new TodoDao(dataSource);
		int count = dao.countBooks();
		System.out.println(count);
		context.close();
	}
}
