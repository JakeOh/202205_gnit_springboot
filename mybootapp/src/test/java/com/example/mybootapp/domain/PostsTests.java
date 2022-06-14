package com.example.mybootapp.domain;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

@Slf4j  // log 객체 사용
@SpringBootTest  // 스프링 부트 설정, Bean 테스트
public class PostsTests {

	@Test
	public void postsConstructTest() {
		// Posts 클래스 객체 생성 방법과 getter 메서드들 테스트.
		
		// 1. 기본 생성자 테스트
		Posts post1 = new Posts();
		log.info("post1={}", post1);
		log.info("createDate={}", post1.getCreateDate());
		log.info("modifiedDate={}", post1.getModifiedDate());
		
		// 2. Builder 패턴 객체 생성 테스트
		// new Posts("test", "test", "test"); 생성자 대신 사용 패턴.
		Posts post2 = Posts.builder()
						.title("test title")
						.content("테스트 컨텐트")
						.author("admin")
						.build();
		log.info("post2={}", post2);
		log.info("createDate={}", post2.getCreateDate());
		
	}
	
}
