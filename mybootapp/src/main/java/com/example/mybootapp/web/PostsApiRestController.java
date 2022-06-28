package com.example.mybootapp.web;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mybootapp.dto.PostsSaveRequestDto;
import com.example.mybootapp.dto.PostsUpdateRequestDto;
import com.example.mybootapp.service.PostsService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j  // 로그 사용.
@RequiredArgsConstructor  // argument가 필요한 생성자를 자동으로 작성.
@RestController  // Spring context에 REST 컨트롤러 객체로 등록.
@RequestMapping("/api")  // 컨트롤러 메서드의 URL 매핑이 "/api"로 시작함.
public class PostsApiRestController {
	
	private final PostsService postsService;
	// RequiredArgsConstructor 애너테이션이 있기 때문에 의존성 주입이 됨
	// -> 생성자에 의한 의존성 주입.

	@PostMapping("/posts")  // "/api/posts" 주소의 POST 방식 요청을 처리하는 메서드.
	public Long save(@RequestBody PostsSaveRequestDto dto) {
		// @RequestBody: 요청 패킷에 포함된 데이터(JSON 문자열)을 
		// 자바 객체로 변환해서 argument로 전달.
		log.info("save(dto={}) 호출", dto);
		
		return postsService.save(dto);
	}
	
	@DeleteMapping("/posts/{id}")
	public Long delete(@PathVariable(name = "id") Long id) {
		log.info("delete(id={})", id);
		
		Long result = postsService.deleteById(id);
		
		return result;
	}
	
	@PutMapping("/posts/{id}")
	public Long update(@PathVariable(name = "id") Long id,
			@RequestBody PostsUpdateRequestDto dto) {
		log.info("update(id={}, dto={})", id, dto);
		
		return postsService.update(id, dto);
	}
	
}
