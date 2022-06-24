package com.example.mybootapp.dto;

import java.time.LocalDateTime;

import com.example.mybootapp.domain.Posts;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PostsReadResponseDto {
	private Long id;
	private String title;
	private String content;
	private String author;
	private LocalDateTime modifiedDate;

	// PostsRespository에서 findById로 검색된 entity 객체를 dto로 변환하는 생성자.
	public PostsReadResponseDto(Posts entity) {
		this.id = entity.getId();
		this.title = entity.getTitle();
		this.content = entity.getContent();
		this.author = entity.getAuthor();
		this.modifiedDate = entity.getModifiedDate();
	}
	
}
