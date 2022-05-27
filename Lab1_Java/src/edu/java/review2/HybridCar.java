package edu.java.review2;

// IS-A 관계: HybridCar IS A Car.
// HybridCar는 Car 객체가 가지고 있는 데이터(field)와 기능(method)을 그대로 갖고,
// Car에 없는 다른 데이터 또는 기능들을 확장해서 설계하는 클래스.
// 상속: HybridCar는 Car 클래스를 확장해서 만들어 지는 클래스.
// Car: 부모(parent), 상위(super), 기본(base) 클래스
// HybridCar: 자식(child), 하위(sub), 유도(derived) 클래스
public class HybridCar extends Car {

	private int battery;
	
	// setter: 멤버 변수의 값을 argument로 변경.
	public void setBattery(int battery) {
		this.battery = battery;
	}
	
	// getter: 멤버 변수의 값을 반환.
	public int getBattery() {
		return this.battery;
	}
	
	@Override  
	// super 클래스에서 상속받은 메서드를 sub 클래스에서 재정의(덮어쓰기).
	// override가 되려면, 메서드 리턴타입, 메서드 이름, 파라미터 모두 일치해야 함.
	public void drive(double speed) {
		System.out.println("현재 배터리 충전: " + this.battery);
		super.drive(speed);
	}
	
}
