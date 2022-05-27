package edu.java.review4;

// 자바에서 Object 클래스는 모든 클래스의 최상위 클래스.
// extends Object는 생략 가능.
public class ReviewMain4 {

	public static void main(String[] args) {
		System.out.println("다형성(Polymorphism)");
		// 다형성: 한가지 객체를 두가지 이상의 타입으로 부를 수 있는 것.
		
		Person person1 = new Person();
		person1.test();
		
		// 회사원은 회사원이다.
		BusinessPerson person2 = new BusinessPerson();
		person2.test();
		
		// 회사원은 사람이다. (O)
		// Sub 타입으로 생성된 인스턴스는 Super 타입으로 선언된 변수에 할당할 수 있음.
		Person person3 = new BusinessPerson();
		person3.test();
		// 실제로 생성된 인스턴스는 BusinessPerson 객체이므로
		// BusinessPerson에서 override된 test() 메서드가 실행됨!
		
		// 사람은 회사원이다. (X)
		// Super 타입으로 생성된 인스턴스는 Sub 타입으로 선언된 변수에 할당할 수 없음!
//		BusinessPerson person4 = new Person();
	}

}
