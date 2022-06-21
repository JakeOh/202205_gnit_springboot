package com.example.mybootapp.dto;

import java.time.LocalDateTime;

import com.example.mybootapp.domain.Posts;

import lombok.Getter;
import lombok.ToString;

// 메인 페이지(index.html)에서 테이블로 포스트 목록을 보여주기 위해서 필요한 정보들을 정의.
@Getter
@ToString
public class PostsFindAllResponseDto {
	private Long id;
	private String title;
	private String author;
	private LocalDateTime modifiedDate;
	
	public PostsFindAllResponseDto(Posts entity) {
		this.id = entity.getId();
		this.title = entity.getTitle();
		this.author = entity.getAuthor();
		this.modifiedDate = entity.getModifiedDate();
	}

}
