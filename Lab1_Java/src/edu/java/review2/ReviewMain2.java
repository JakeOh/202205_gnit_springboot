package edu.java.review2;

public class ReviewMain2 {

	public static void main(String[] args) {
		// Car 클래스 타입으로 변수 myCar를 선언.
		// 클래스 Car의 인스턴스를 생성.(생성자 호출)
		// -> 생성자 호출하면, 클래스의 멤버 변수들은 초기화가 됨(값을 가지게 됨).
		// 생성된 인스턴스를 변수 myCar에 할당.
		Car myCar = new Car();
		// 지역 변수(local variable): 메서드가 실행되는 동안에만 사용되는 변수.
		System.out.println(myCar);
		
		myCar.drive(100);  // 메서드 호출
		// argument: 메서드를 호출할 때 전달하는 값. 여기서는 100.
		
		// with-args constructor를 호출
		Car myCar2 = new Car(20, 0);
		myCar2.drive(50);
	}

}
