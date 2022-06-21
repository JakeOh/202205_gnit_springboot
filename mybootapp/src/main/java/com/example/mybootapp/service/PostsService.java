package com.example.mybootapp.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.mybootapp.domain.Posts;
import com.example.mybootapp.domain.PostsRepository;
import com.example.mybootapp.dto.PostsFindAllResponseDto;
import com.example.mybootapp.dto.PostsSaveRequestDto;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor  // argument가 필요한 생성자를 자동으로 작성.
// final로 선언된 필드(멤버 변수)에 spring bean이 자동으로 주입됨.
@Service  // Spring 컨텍스트에서 Service 객체(bean)로 생성되고 관리됨. 
public class PostsService {
	
	// final 멤버 변수: arg 있는 생성자에 의해서 의존성이 자동 주입.
	private final PostsRepository postsRepository;

	@Transactional
	public Long save(PostsSaveRequestDto dto) {
		// repository 객체를 사용해서 DB 테이블에 post를 저장(insert)하고,
		// 저장된 게시글의 글 번호(id)를 리턴.
		log.info("save(dto={})", dto);
		
		Posts saved = postsRepository.save(dto.toEntity());
		log.info("saved={}", saved);
		
		return saved.getId();
	}

	@Transactional(readOnly = true)
	public List<PostsFindAllResponseDto> findAll() {
		log.info("findAll() 호출");
		
		List<PostsFindAllResponseDto> list =
				postsRepository.findAll()  // List<Posts> 타입 리턴
				.stream()  // entity -> dto로 매핑을 쉽게 하기 위해서 스트림 생성
				.map(PostsFindAllResponseDto::new)  // entity -> dto 매핑
				.collect(Collectors.toList());  // 최종 결과를 List로 작성.
		log.info("list size = {}", list.size());
		
		return list;
	}
	
}
