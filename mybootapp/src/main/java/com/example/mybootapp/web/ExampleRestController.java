package com.example.mybootapp.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.mybootapp.dto.ExampleDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j  // log를 사용하기 위해서.
@RestController  // 스프링 컨테이너에 RestController 컴포넌트로 관리되는 Bean.
// REST(Representational State Transfer):
// 하나의 URI가 하나의 고유한 resource를 대표하도록 설계하는 서비스.
public class ExampleRestController {

	@GetMapping("/test3")
	public String test3() {
		log.info("test3() 호출...");
		
		// RestController의 메서드가 리턴하는 값은 view(HTML)의 이름이 아니고(!),
		// 클라이언트(웹 브라우저)로 직접 전송되는 데이터.
		return "안녕하세요, 여러분~~!!";
	}
	
	@GetMapping("/test4/{userName}")
	public String test4(@PathVariable(name = "userName") String name) {
		// @PathVariable: URL 경로에 포함된 변수(path variable)을 변수에 전달.
		
		log.info("test4(userName={})", name);
		return String.format("안녕하세요, %s님!", name);  // 클라이언트로 전달되는 문자열.
	}
	
	@GetMapping("/test5")
	public ExampleDto test5(
			@RequestParam(name = "name", defaultValue = "Unknown") String name,
			@RequestParam(name = "amount", defaultValue = "0") int amount) {
		
		log.info("test5(name={}, amount={})", name, amount);
		
		ExampleDto dto = new ExampleDto(name, amount);
		log.info("dto={}", dto);
		
		return dto;
	}
	
}
