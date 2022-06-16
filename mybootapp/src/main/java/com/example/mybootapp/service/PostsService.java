package com.example.mybootapp.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.mybootapp.domain.Posts;
import com.example.mybootapp.domain.PostsRepository;
import com.example.mybootapp.dto.PostsSaveRequestDto;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor  // argument가 필요한 생성자를 자동으로 작성.
// final로 선언된 필드(멤버 변수)에 spring bean이 자동으로 주입됨.
@Service  // Spring 컨텍스트에서 Service 객체(bean)로 생성되고 관리됨. 
public class PostsService {
	
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

}
