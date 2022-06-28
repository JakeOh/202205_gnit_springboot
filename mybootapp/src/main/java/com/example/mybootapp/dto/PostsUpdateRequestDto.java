package com.example.mybootapp.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

// 포스트를 수정할 정보들만 저장하는 클래스
@NoArgsConstructor  // argument를 갖지 않는 기본 생성자를 자동으로 작성.
@Getter  // getter 메서드들을 자동으로 작성.
@ToString  // toString 메서드 자동 작성.
public class PostsUpdateRequestDto {
	private String title;
	private String content;
	
	@Builder
	private PostsUpdateRequestDto(String title, String content) {
		this.title = title;
		this.content = content;
	}
}
