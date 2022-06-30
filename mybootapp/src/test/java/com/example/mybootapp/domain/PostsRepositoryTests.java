package com.example.mybootapp.domain;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class PostsRepositoryTests {
	@Autowired  // PostsRepository 타입 객체를 자동 주입 받음.
	private PostsRepository postsRepository;
	
	private void generateDummy() {
		// 가상의 테스트 데이터를 만듦.
		String[] titles = {"test 1", "TEst 2", "테스트 123", "테스트..."};
		String[] contents = {"test content 1", "테스트 컨텐트 2", 
				"test content 3...", "테스트 컨텐트 4..."};
		String[] authors = {"admin", "admin", "guest", "noname"};
		
		for (int i = 0; i < 4; i++) {
			Posts post = Posts.builder()
					.title(titles[i])
					.content(contents[i])
					.author(authors[i])
					.build();
			postsRepository.save(post);
		}
	}
	
	@AfterEach  // 각각의 @Test 메서드(JUnit test)를 끝났을 때 실행할 메서드.
	public void cleanUp() {
		// Posts 테이블의 기존의 모든 내용을 지움.
		postsRepository.deleteAll();
	}

//	@Test  // JUnit 테스트
	public void test() {
		generateDummy();  // 더미 데이터를 DB table에 insert
		
		List<Posts> list = postsRepository.findByOrderByIdDesc();
		log.info(list.toString());
		
		// list.size()가 4이면 테스트 pass, 그렇지 않으면 테스트 fail
		Assertions.assertEquals(4, list.size());
		
		// list.get(0)의 아이디가 list.get(1)의 아이디보다 큰 경우 테스트 pass, 그렇지 않으면 fail
		Assertions.assertTrue(list.get(0).getId() > list.get(1).getId());
		
	}
	
//	@Test
	public void test2() {
		generateDummy();
		
		List<Posts> list = postsRepository.findByTitle("TEst 2");
		log.info(list.toString());
		
		Assertions.assertEquals(1, list.size());
		Assertions.assertEquals("TEst 2", list.get(0).getTitle());
		
		// 영문자는 대/소문자를 구분하기 때문에 검색어의 대/소문자가 다르면 검색되지 않아야 함.
		List<Posts> list2 = postsRepository.findByTitle("test 2");
		Assertions.assertEquals(0, list2.size());
		
		// 단어가 완전히 일치하는 경우만 검색하기로 했기 때문에, 제목의 일부만으로는 검색되지 않아야 함.
		List<Posts> list3 = postsRepository.findByTitle("test");
		Assertions.assertEquals(0, list3.size());
	}
	
//	@Test
	public void test3() {
		generateDummy();
		
		List<Posts> list = postsRepository
				.findByTitleContainingIgnoringCase("tESt");
		log.info(list.toString());
		
	}
	
	@Test
	public void test4() {
		generateDummy();
		
		List<Posts> list = postsRepository
				.findByTitleContainingIgnoringCaseOrderByIdDesc("est");
		log.info(list.toString());
		
		Assertions.assertEquals(2, list.size());
		Assertions.assertTrue(list.get(0).getId() > list.get(1).getId());
	}
	
}
