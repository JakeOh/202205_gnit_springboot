package edu.java.review5;

// 인터페이스(interface):
// 1. 모든 메서드는 public abstract로 선언되고,
// 2. 모든 멤버 변수는 public static final로 선언된
// 특별한 종류의 클래스.
// -> 메서드를 선언할 때 public abstract를 생략 가능.
// -> 멤버 변수를 선언할 public static final을 생략 가능.

// public: 외부에 공개된
// abstract: 구현되지 않은
// static: 객체 생성 없이도 클래스 이름이나 인터페이스 이름으로 직접 참조 가능한
// final: 최종적인. 변경할 수 없는

public interface DatabaseQuery {

	// public static final int version = 1;
	int version = 1;
	
	// 추상 메서드(abstract method): 메서드의 본체(body)가 없는 메서드
	// public abstract int insert(int id);
	int insert(int id);
	
}
