package edu.java.review7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReviewMain7 {

	public static void main(String[] args) {
		// 배열: int[] array = {1, 2, 3};  String[] strArr = {"a", "b"};
		// 배열의 단점: 배열은 생성될 때의 크기(원소의 개수)를 바꿀 수 없다.(추가/삭제 불가)
		// 리스트: 같은 타입의 값들을 인덱스를 사용해서 저장/삭제/수정할 수 있는 데이터 타입.
		
		// 정수들을 저장할 수 있는 리스트 객체를 생성.
		List<Integer> numbers = new ArrayList<Integer>();
		System.out.println(numbers);  // 빈 리스트(empty list)
		System.out.println(numbers.size());  // 리스트의 원소의 개수
		
		// 리스트에 새로운 원소 추가
		numbers.add(100);
		System.out.println(numbers);
		numbers.add(123);
		System.out.println(numbers);
		
		// 리스트에 저장된 원소 값 가져오기
		for (int i = 0; i < numbers.size(); i++) {
			System.out.println(numbers.get(i));
		}
		
		for (int x : numbers) {
			System.out.println(x);
		}
		
		System.out.println();
		// Map: key-value의 쌍으로 아이템(데이터)를 저장하는 데이터 타입.
		Map<String, Integer> menu = new HashMap<String, Integer>();
		System.out.println(menu);  // empty map
		System.out.println(menu.size());
		
		// map에 아이템 추가
		menu.put("짜장면", 5000);
		System.out.println(menu);
		menu.put("짬뽕", 6000);
		System.out.println(menu);
		
		System.out.println(menu.keySet());  // Map에서 key들의 집합
		for (String k : menu.keySet()) {
			// map.get(key): Map에서 key에 해당하는 value를 리턴.
			System.out.println(k + ":" + menu.get(k));
		}
		
	}

}
