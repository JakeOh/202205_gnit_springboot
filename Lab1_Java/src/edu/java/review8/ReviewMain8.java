package edu.java.review8;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ReviewMain8 {

	public static void main(String[] args) {
		// 정수(Integer)를 저장할 수 있는 empty list를 생성
		List<Integer> numbers = new ArrayList<Integer>();
		
		// 난수(random number)를 생성하기 위한 클래스 객체 생성
		Random rand = new Random();
		rand.setSeed(1);  // 난수 생성 순서를 유지하기 위해서.
		// numbers 리스트에 100 미만의 정수 난수 10개를 저장.
		for (int i = 0; i < 10; i++) {
			numbers.add(rand.nextInt(100));
		}
		System.out.println(numbers);

		// numbers에서 홀수들만 출력
		for (int i = 0; i < numbers.size(); i++) { // 인덱스 0 ~ 9까지 반복
			int x = numbers.get(i);  // 리스트 numbers에서 인덱스 i번째 원소를 읽음.
			if (x % 2 == 1) {  // 원소가 홀수이면
				System.out.println(x);  // 출력
			}
		}
		
		System.out.println();
		// Java Stream 객체를 사용한 필터링
		numbers.stream()  // List를 Stream 객체로 변환
			.filter(x -> x % 2 == 1)  // Stream 객체에서 조건에 맞는 원소들을 필터링
			.forEach(x -> System.out.println(x));  // 각 원소를 출력
		
		System.out.println();
		// numbers의 모든 원소들을 x2
		for (int i = 0; i < numbers.size(); i++) { // 인덱스 0 ~ 9 반복
			int x = numbers.get(i);  // 해당 인덱스의 값을 읽음.
			System.out.print(2 * x + " ");  // 읽어온 값의 2배를 출력
		}
		
		System.out.println();
		numbers.stream()
			.map(x -> 2 * x)
			.forEach(x -> System.out.print(x + " "));
		
		System.out.println("\n\n");
		System.out.println(numbers);
		// numbers에서 홀수들을 필터링해서 그 값의 2배를 출력
		for (int i = 0; i < numbers.size(); i++) {
			int x = numbers.get(i);
			if (x % 2 == 1) {
				System.out.print(x * 2 + " ");
			}
		}
		System.out.println();
		
		numbers.stream()
			.filter(x -> x % 2 == 1)
			.map(x -> 2 * x)
			.forEach(x -> System.out.print(x + " "));
		System.out.println();
		
		System.out.println();
		// 리스트에서 홀수들만 필터링해서 그 값의 2배를 모두 더한 값을 계산.
		int sum = 0;
		for (int i = 0; i < numbers.size(); i++) {
			int x = numbers.get(i);
			if (x % 2 == 1) {
				sum += 2 * x;
			}
		}
		System.out.println(sum);
		
		int total = numbers.stream()
				.filter(x -> x % 2 == 1)
				.mapToInt(x -> 2 * x)
				.sum();
		System.out.println(total);
	}

}
