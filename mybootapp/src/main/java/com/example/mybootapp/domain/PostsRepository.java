package com.example.mybootapp.domain;

import org.springframework.data.jpa.repository.JpaRepository;

// JpaRepository<Entity 클래스 이름, PK 데이터 타입>
// PostsRepository 인터페이스는 CRUD(Create, Read, Update, Delete) 메서드들을 갖게됨.
// 아무런 애너테이션이 없어도 스프링 Bean 자동 생성, 관리.
// 추상 메서드들을 구현한 구현 클래스가 컴파일할 때 자동으로 생성됨. 
public interface PostsRepository 
	extends JpaRepository<Posts, Long> {

}
