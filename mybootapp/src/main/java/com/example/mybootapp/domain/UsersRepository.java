package com.example.mybootapp.domain;

import org.springframework.data.jpa.repository.JpaRepository;

// JpaRepository를 상속받으면 @Repository 애너테이션이 없어도
// 스프링 컨텍스트에서 생성하고 관리하는 Bean이 됨.
public interface UsersRepository extends JpaRepository<Users, Long> {
	Users findByUsername(String username);
}
