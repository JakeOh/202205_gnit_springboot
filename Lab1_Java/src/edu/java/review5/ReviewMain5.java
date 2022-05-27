package edu.java.review5;

public class ReviewMain5 {

	public static void main(String[] args) {
		System.out.println("인터페이스(Interface)");
		
		A a = new A();  // 인스턴스 생성
		a.number = 100;  // 생성된 인스턴스를 참조해서 사용하는 변수.
		
		// 클래스 이름으로 참조(접근)해서 사용하는 변수.
		B.staticNumber = 10;
		
		System.out.println(DatabaseQuery.version);  // static
//		DatabaseQuery.version = 2;  // final이기 때문에 변경 불가능.
		
//		DatabaseQuery query = new DatabaseQuery();
		// 인터페이스는 객체 생성을 할 수 없음.
		
		OracleDatabaseQuery query = new OracleDatabaseQuery();
		query.insert(10);
		
		// 다형성
		DatabaseQuery query2 = new OracleDatabaseQuery();
	}

}

class A {
	public int number;  
	// 인스턴스 (멤버) 변수 - 객체 생성 후에만 사용할 수 있는 멤버.
}

class B {
	public static int staticNumber;
	// 클래스(static) (멤버) 변수 - 객체 생성 여부와 상관 없이 사용할 수 있는 멤버.
}
