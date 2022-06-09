package com.example.mybootapp.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

// DTO(Data Transfer Object): 모듈들 간에 데이터를 전달하기 위한 객체.
// VO(Value Object): 값을 저장하는 객체.

@RequiredArgsConstructor
// final로 선언된 멤버변수들을 초기화할 수 있는 argument를 갖는 생성자를 자동으로 생성.
// public ExampleDto(String name, int amount) {...}

@Getter
// private으로 선언된 멤버 변수들의 getter 메서드를 자동으로 생성.

@ToString
// toString 메서드를 자동으로 생성.
public class ExampleDto {
	private final String name;
	private final int amount;
}
