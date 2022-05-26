package edu.java.review2;

// 객체(Object): 프로그램에서 만들려고 대상. 데이터와 기능을 가질 수 있음.
// 클래스(Class): 객체를 만들기 위해서 프로그래밍 언어로 작성하는 코드. 
//     객체를 만들기 위한 설계도.
//     멤버 변수(프로퍼티, property) + 메서드(method)
//     클래스는 데이터 타입 - 변수를 선언할 때 변수 타입으로 클래스 이름을 사용.
// 인스턴스(Instance): 클래스를 사용해서 메모리에 생성된 객체.

public class Car {
	// 자동차가 가져야 하는 속성, 데이터 - 멤버 변수, property
	// 수식어 변수타입 변수이름 [= 값];
	private double fuel;  // 연료의 양
	private double speed; // 자동차의 속력
	
	// 생성자(Constructor): 객체를 메모리에 생성하는 역할.
	// 생성자는 리턴타입을 갖지 않음!
	// 생성자의 이름은 반드시 클래스 이름과 같아야 함!
	// 수식어 클래스이름(변수 선언, ...) { ... }
	
	// 1) argument를 갖지 않는 생성자(no-args constructor, default constructor)
	//    초기화 코드(변수의 값을 저장하는 코드)들이 없는 경우
	//    모든 멤버 변수들을 해당 타입의 기본값(0, false, null)으로 초기화를 수행함.
	public Car() {
//		this.fuel = 0;
//		this.speed = 0;
	}
	
	// 2) argument를 갖는 생성자(with-args constructor)
	public Car(double fuel, double speed) {
		this.fuel = fuel;  // 전달받은 argument fuel 값을 멤버변수 fuel에 저장.
		this.speed = speed;
	}
	
	// 자동차가 가져야 하는 기능 - 메서드
	// 수식어 리턴타입 메서드이름(변수 선언, ...) { ... }
	// 파라미터(parameter): 메서드 선언부(이름 옆 괄호 안)에서 선언하는 (지역) 변수.
	//   메서드를 호출하는 곳에서 전달한 값(argument)을 저장하기 위한 변수.
	public void drive(double speed) {
		this.speed = speed;
		System.out.println("현재 연료: " + this.fuel + ", 속력: " + this.speed);
	}
	
	// setter: private으로 감춰져 있는 멤버 변수의 값을 변경해주는 public 메서드.
	// 리턴타입 void: 메서드가 아무 값도 반환하지 않을 때(return 문장이 없을 
	public void setFuel(double fuel) {
		// 멤버 변수(field, property)의 값을 전달받은 argument로 변경
		this.fuel = fuel;
	}
	
	// getter: private으로 감춰져 있는 멤버 변수의 값을 반환하는 public 메서드.
	public double getFuel() {
		// 인스턴스가 가지고 있는 fuel 멤버 변수의 값을 메서드를 호출한 곳으로 반환.
		return this.fuel;
	}
	
	public double getSpeed() {
		return this.speed;
	}
	
	public String toString() {
		return "Car 계기판{speed=" + this.speed +
				", fuel=" + this.fuel + "}";
	}
	
}
