package com.example.mybootapp.domain;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

// JpaRepository<Entity 클래스 이름, PK 데이터 타입>
// PostsRepository 인터페이스는 CRUD(Create, Read, Update, Delete) 메서드들을 갖게됨.
// 아무런 애너테이션이 없어도 스프링 Bean 자동 생성, 관리.
// 추상 메서드들을 구현한 구현 클래스가 컴파일할 때 자동으로 생성됨.
// Method Signature에서 사용하는 상용구
//   Equals, Between
//   Contains, Containing
//   IgnoreCase, IgnoringCase
//   IsNull, Null, IsNotNull, NotNull
//	 And, Or
//   OrderBy
//   ...
public interface PostsRepository 
	extends JpaRepository<Posts, Long> {

	// Spring Data method signature - 메서드 리턴타입, 이름, 파라미터 선언.
	
	// Posts 테이블에서 전체 검색 결과를 id의 내림차순으로 정렬
	// SELECT * FROM posts ORDER BY id DESC;
	List<Posts> findByOrderByIdDesc();
	
	// 글 제목으로 검색하기
	// 글 제목(title)이 완전히 일치하는 posts들을 검색
	// SELECT * FROM posts WHERE title = ?
	List<Posts> findByTitle(String title);
	
	// 글 제목(title)의 일부만으로도 검색 가능, 대/소문자 구분 없이 검색 가능.
	// SELECT * 
	// FROM posts
	// WHERE upper(title) LIKE upper(?)
	List<Posts> findByTitleContainingIgnoringCase(String title);
	
	// 글 제목(title)의 일부로 대/소문자 구분없이 글 번호(id)의 내림차순 정렬로 검색.
	// SELECT *
	// FROM posts
	// WHERE upper(title) like upper(?)
	// ORDER BY id DESC;
	List<Posts> findByTitleContainingIgnoringCaseOrderByIdDesc(String title);
	
	// 글 내용(content)로 검색
	// SELECT *
	// FROM posts
	// WHERE upper(content) LIKE upper(?)
	// ORDER BY id DESC;
	List<Posts> findByContentContainsIgnoreCaseOrderByIdDesc(String content);
	
	// 글 제목(title) 또는 글 내용(content)로 검색
	// SELECT *
	// FROM posts
	// WHERE upper(title) LIKE upper(?) 
	//		OR upper(content) LIKE upper(?)
	// ORDER BY id DESC;
	List<Posts> findByTitleContainsIgnoreCaseOrContentContainsIgnoreCaseOrderByIdDesc(String title, String content);
	
	// 글 작성자(author)로 검색
	// SELECT *
	// FROM posts
	// WHERE upper(author) LIKE upper(?)
	// ORDER BY id DESC;
	List<Posts> findByAuthorContainsIgnoreCaseOrderByIdDesc(String author);
	
}
