package com.example.mybootapp.web;

//static 메서드 이름을 import
import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

// 클래스 이름을 import
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@WebMvcTest(controllers = ExampleRestController.class)
public class ExampleRestControllerTests {
	@Autowired  // 의존성 주입
	private MockMvc mockMvc;
	
	@Test
	public void test3() throws Exception {
		log.info("test3() 호출...");
		
		String expected = "안녕하세요, 여러분~~!!";
		mockMvc.perform(get("/test3"))
			.andExpect(status().isOk())
			.andExpect(content().string(expected));
	}

	@Test
	public void test4() throws Exception {
		// path variable로 사용할 문자열
		String userName = "ZXCV";
		// RestController가 리턴하는 문자열
		String expected = String.format("안녕하세요, %s님!", userName);
		
		mockMvc.perform(get("/test4/" + userName))
			.andExpect(status().isOk())
			.andExpect(content().string(expected));
	}
	
	@Test
	public void test5() throws Exception {
		// 요청 파라미터 name과 amount를 포함하지 않고 요청을 보내는 경우
		mockMvc.perform(get("/test5"))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.name", is("Unknown")))
			.andExpect(jsonPath("$.amount", is(0)));
		
		// 요청 파라미터 name과 amount를 포함하고 요청을 보내는 경우
		String paramName = "강남 아이티 아카데미";
		int paramAmount = 123_000;
		mockMvc.perform(get("/test5")
						.param("name", paramName)
						.param("amount", String.valueOf(paramAmount)))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.name", is(paramName)))
			.andExpect(jsonPath("$.amount", is(paramAmount)));
	}
}
