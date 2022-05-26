package edu.java.review1;

public class ReviewMain1 {

	// main 메서드(method): Java 프로그램의 시작점
	public static void main(String[] args) {
		System.out.println("Hello, Java!");
		System.out.println("안녕하세요.");
		
		// 변수: 데이터를 저장하는 공간
		// 타입 변수이름 = 값;
		int num = 1;
		System.out.println(num);
		// 변수 타입:
		// 정수 타입: int, long
		// 실수 타입: float, double
		// 논리값(true, false): boolean
		// 문자열: String
		
		num = 19;
		System.out.println(num);
		
		String name = "강남아이티학원";
		System.out.println(name);
		
		// 조건문
		if (num % 2 == 0) {
			System.out.println(num + ": 짝수");
		} else {
			System.out.println(num + ": 홀수");
		}
		
		num = 0;
		if (num > 0) {
			System.out.println("양수");
		} else if (num < 0) {
			System.out.println("음수");
		} else {
			System.out.println("영");
		}
		
		// 반복문
		for (int i = 0; i < 5; i++) {
			System.out.println(i);
		}
		
		// 배열: 하나의 변수 이름에 같은 타입의 값 여러개를 저장하는 데이터 타입.
		String[] names = {"Scott", "Tiger", "King"};
		System.out.println(names);
		// 배열의 인덱스는 0부터 시작. 배열의 마지막 인덱스 (원소 개수 - 1).
		System.out.println(names[0]);
		for (int i = 0; i < 3; i++) {
			System.out.println(names[i]);
		}
		
		// for-each 구문(향상된 for 구문)
		for (String n : names) {
			System.out.println(n);
		}
		
	} // main 메서드 끝 --> 프로그램 종료

}
