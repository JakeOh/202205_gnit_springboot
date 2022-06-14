package com.example.mybootapp.domain;

import java.time.LocalDateTime;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Getter;

// JPA(Java Persistence API) auditing 기능으로 생성/수정 시간 자동 저장:
//  (1) BaseTimeEntity 클래스 작성: @MappedSuperclass + @EntityListeners
//  (2) Posts 클래스가 BaseTimeEntity 클래스를 상속하도록 선언.
//  (3) JPA auditing이 활성화될 수 있도록, Application Main 클래스에 
// @EnableJpaAuditing 애너테이션을 추가.

@Getter  // getter 메서드 자동 작성.
@MappedSuperclass
// 이 클래스(BaseTimeEntity)를 상속(extends)하는 모든 하위 클래스에서
// 생성 시간(@CreatedDate), 마지막 수정 시간(@LastModifiedDate)을 컬럼으로 갖도록 함.
@EntityListeners(AuditingEntityListener.class)
// JPA Auditing 기능을 사용하도록 함. insert 또는 update될때 자동으로 시간이 기록.
public class BaseTimeEntity {
	
	@CreatedDate  // Entity가 생성되는 시점에 시간이 자동으로 기록.
	private LocalDateTime createDate;
	
	@LastModifiedDate  // Entity가 수정되는 시점에 시간이 자동으로 기록.
	private LocalDateTime modifiedDate;
	
}
