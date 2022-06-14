package com.example.mybootapp.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
// 기본 생성자(public Posts() {};)를 자동으로 작성.

@Getter
// 클래스의 모든 필드들의 getter 메서드들을 자동으로 작성.

@ToString
// toString() 메서드를 자동으로 작성.

@Entity
// ORM(Object Relational Mapping)
// 데이터베이스 테이블과 매핑할 클래스임을 선언.
// 클래스의 모든 필드(멤버 변수)들은 테이블의 컬럼이 됨.
// Entity 클래스가 반드시 지켜야 하는 원칙:
//  (1) 기본 생성자(default constructor, no-args constructor)가 반드시 있어야 함.
//  (2) final class, interface, enum, inner 클래스는 Entity가 될 수 없음.
//  (3) 필드(멤버 변수)들을 final로 선언하면 안됨.
public class Posts extends BaseTimeEntity {
	
	@Id  // 테이블의 고유키(PK) 컬럼
	@GeneratedValue(strategy = GenerationType.AUTO)
	// PK 생성 규칙(전략): IDENTITY, SEQUENCE, TABLE, AUTO
	//  (1) IDENTITY: PK 생성을 데이터베이스에 위임. DB에 의존적(MySQL, ...)
	//  (2) SEQUENCE: DB의 sequence 객체를 사용해서 PK 생성. DB에 의존적(Oracle, ...)
	//  (3) TABLE: PK 생성/관리 담당 테이블 생성. DB에 의존적이지 않음.
	//  (4) AUTO: JPA에게 일임.
	private Long id;  // 글 번호(Primary Key, 고유키)
	
	
	@Column(length = 500, nullable = false)
	// @Column 애너테이션이 없어도 Entity 클래스의 멤버 변수는 테이블의 컬럼과 매핑됨.
	// @Column 애너테이션은 컬럼의 constraint 또는 데이터 타입 등을 변경할 필요가 있을 때 사용.
	private String title;  // 글 제목
	
	@Column(length = 5000, nullable = false)
	private String content; // 글 본문 내용
	
	private String author; // 글 작성자

	@Builder
	// Builder 디자인 패턴의 inner class와 static 메서드를 자동으로 작성.
	private Posts(String title, String content, String author) {
		this.title = title;
		this.content = content;
		this.author = author;
	}
	
}
