package com.example.mybootapp.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.mybootapp.domain.Posts;
import com.example.mybootapp.domain.PostsRepository;
import com.example.mybootapp.dto.PostsFindAllResponseDto;
import com.example.mybootapp.dto.PostsReadResponseDto;
import com.example.mybootapp.dto.PostsSaveRequestDto;
import com.example.mybootapp.dto.PostsUpdateRequestDto;

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

	@Transactional(readOnly = true)
	public PostsReadResponseDto findById(Long id) {
		log.info("findById(id={})", id);
		
		// repository를 사용해서 DB에서 id로 검색
		Posts entity = postsRepository.findById(id).orElseThrow();
		log.info("entity={}", entity);
		
		// 검색된 결과(Posts 타입)을 DTO 타입으로 변환
		PostsReadResponseDto dto = new PostsReadResponseDto(entity);
		log.info("dto={}", dto);
		
		return dto;  // controller에게 리턴.
	}

	@Transactional
	public Long deleteById(Long id) {
		log.info("deleteById(id={})", id);
		
		// repository의 메서드를 사용해서 delete SQL을 실행.
		postsRepository.deleteById(id); // 리턴 타입: void
		
		return id;  // controller에게 삭제한 포스트의 PK(id)를 리턴.
	}

	@Transactional
	public Long update(Long id, PostsUpdateRequestDto dto) {
		log.info("update(id={}, dto={})", id, dto);
		
		// 1. id로 검색
		// 2. 검색된 entity를 수정.
		// -> 트랜잭션이 끝나는 시점에 Database UPDATE가 수행됨.
		// JPA(Java Persistence API) 영속성 컨텍스트(persistence context): entity를 영구적으로 저장하는 환경.
		// 트랜잭션 안에서 데이터베이스의 데이터(엔터티)를 읽어오면, 이 데이터는 영속성 컨텍스트가 유지된 상태.
		// 이 상태에서 엔터티의 변경이 생기면, 트랜잭션이 끝나는 시점에 해당 테이블에 변경 내용이 반영.
		// 즉, entity 객체를 수정하면 update 쿼리 없이 데이터베이스 수정이 가능.
		
		Posts entity = postsRepository.findById(id).orElseThrow();
		log.info("수정 전 entity={}", entity);
		
		entity.update(dto.getTitle(), dto.getContent());
		log.info("수정 후 entity={}", entity);
		
		return id;
	}
	
}
