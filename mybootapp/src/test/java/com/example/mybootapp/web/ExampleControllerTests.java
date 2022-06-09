package com.example.mybootapp.web;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import lombok.extern.slf4j.Slf4j;

@Slf4j  // log를 사용하기 위해서.
// MVC 아키텍쳐의 Web 애플리케이션 단위 테스트
@WebMvcTest(controllers = ExampleController.class)
public class ExampleControllerTests {
	
	@Autowired  // 의존성 주입(dependency injection): 스프링 컨테이너에 의해서 자동으로 주입됨.
	private MockMvc mockMvc;  // 가상의 HTTP 요청(request)을 보낼 수 있는 객체.
	
	@Test  // JUnit (단위) 테스트에 의해서 실행되는 메서드.
	public void test1() throws Exception {
		log.info("JUnit test1() 호출...");
		
		mockMvc.perform(get("/test1"))  // (1)
			.andExpect(status().isOk())  // (2)
			.andExpect(content().string(containsString("My First Spring Boot App"))); // (3)
		// (1) mockMvc를 사용해서 "/test1" URL로 GET 방식의 요청(request)를 실행.
		// (2) 요청의 결과 상태(response status)가 OK(HTTP 200)라고 예상.
		// (3) 요청의 결과 컨텐트(response content)의 문자열이 
		// "My First Spring Boot App" 문자열을 포함하고 있다고 예상.
	}
	
	@Test
	public void test2() throws Exception {
		log.info("JUnit test2() 호출...");
		
		String name = "강남 아이티 아카데미";  // 요청 파라미터 값
		String expected = "Hello, 강남 아이티 아카데미!";  // 정상 결과
		
		mockMvc.perform(get("/test2").param("userName", name))
			.andExpect(status().isOk())
			.andExpect(content().string(containsString(expected)));
	}

}
