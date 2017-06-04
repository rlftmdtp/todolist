package kr.or.connect.todo.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import kr.or.connect.todo.AppConfig;
import kr.or.connect.todo.TodoApplication;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = TodoApplication.class)
@WebAppConfiguration
public class TodoControllerTest {
	
	/*
	@Autowired
	private TodoDao dao;
	
	@Test
	public void shouldTodoCount(){
		int count = dao.countBooks();
		System.out.println(count);
	}
	*/
	@Autowired
	WebApplicationContext wac;
	MockMvc mvc;
	
	@Before
	public void setUp() {
		this.mvc = webAppContextSetup(this.wac)
			.alwaysDo(print(System.out))
			.build();
	}

	@Test
	public void shouldCreate() throws Exception {
		String requestBody = "{\"title\":\"사피엔스\", \"author\":\"유발하라리\"}";

		mvc.perform(
			post("/api/books/")   // 추후 변경해야함
				.contentType(MediaType.APPLICATION_JSON)
				.content(requestBody)
			)
			.andExpect(status().isCreated())
			.andExpect(jsonPath("$.id").exists())
			.andExpect(jsonPath("$.title").value("사피엔스"))
			.andExpect(jsonPath("$.author").value("유발하라리"));
	}
}
