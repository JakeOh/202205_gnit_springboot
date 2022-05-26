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
		// System.out.println(myCar.toString()); 호출하는 것과 동일.
		
		// myCar.fuel = 100;  // Error 발생.
		// myCar 인스턴스의 멤버 변수 값을 변경하려고 할 때, 직접 변경할 수 없음.
		// fuel 멤버 변수(property, field)는 private으로 감춰져 있기 때문에.
		// public으로 공개된 메서드를 사용해서 간접적으로 멤버 변수 값을 변경.
		myCar.setFuel(50);
		
		myCar.drive(100);  // 메서드 호출
		// argument: 메서드를 호출할 때 전달하는 값. 여기서는 100.
		
		// 계기판: 현재 속력, 연료
		// System.out.println("myCar 계기판: " + myCar.speed);  // Error 발생
		// myCar 인스턴스에 저장된 멤버 변수의 값을 읽으려고 할 때 에러 발생.
		// 멤버 변수들이 private으로 감춰져 있기 때문에.
		// 멤버 변수에 저장된 값을 리턴(반환)해 주는 public으로 공개된 메서드를 사용.
		System.out.println(
				"myCar 계기판{속력=" + myCar.getSpeed() + 
				", 연료=" + myCar.getFuel() + "}");
		System.out.println(myCar.toString());
		
		// with-args constructor를 호출
		Car myCar2 = new Car(20, 0);
		System.out.println(myCar2);  // myCar2.toString() 자동 호출.
		myCar2.drive(50);
		
		// myCar2의 계기판
		System.out.println(
				"myCar 계기판{속력=" + myCar2.getSpeed() + 
				", 연료=" + myCar2.getFuel() + "}");
		System.out.println(myCar2.toString());
		
		System.out.println();
		System.out.println("상속(Inheritance)");
		
		// HybridCar 타입의 변수 선언 = HybridCar 인스턴스 생성;
		HybridCar hCar = new HybridCar();
		System.out.println(hCar);  // toString() 메서드 자동 호출
		
	}

}
