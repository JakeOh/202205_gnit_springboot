package com.example.mybootapp.dto;

import com.example.mybootapp.domain.Posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor  // argument를 갖지 않는 기본 생성자를 자동 작성.
@Getter
@ToString
public class PostsSaveRequestDto {
	// DTO: Data Transfer Object
	// 새 글 작성 요청에서 전달되는 데이터 저장을 위한 클래스.
	
	private String title;  // 글 제목
	private String content;  // 글 내용(본문)
	private String author;  // 글 작성자
	
	@Builder
	private PostsSaveRequestDto(String title, String content, String author) {
		this.title = title;
		this.content = content;
		this.author = author;
	}
	
	public Posts toEntity() {
		// PostsSaveRequestsDto 타입을 Posts 타입으로 변환해서 리턴.
		return Posts.builder()
				.title(title)
				.content(content)
				.author(author)
				.build();
	}

}
