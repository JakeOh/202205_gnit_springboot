package edu.java.review5;

// 클래스 선언되는 위치:
// 1. 외부 클래스
// 2. 내부 클래스
//    (1) 멤버 내부 클래스(member inner class)
//        클래스 내부 중에서 멤버 선언 위치에서 정의하는 클래스
//    (2) 지역 내부 클래스(local inner class)
//        메서드 내부에서 정의하는, 이름을 갖는 클래스.
//        지역 클래스는 다른 외부 클래스나 다른 메서드에서 객체를 생성할 수 없음!
//        선언된 메서드 안에서만 객체를 생성하는 용도로 사용할 수 있음.
//    (3) (지역) 익명 클래스(anonymous inner class)
//        메서드 내부에서 정의하는, 이름을 갖지 않는 클래스.
//        클래스를 선언(정의)하면서 객체의 생성까지 하기 위한 클래스.
// 클래스 멤버: 멤버 변수(프로퍼티), 메서드, 생성자

public class ReviewMain5 {
	
	// 멤버 내부 클래스
	public static class MariaDbQuery implements DatabaseQuery {
		@Override
		public int insert(int id) {
			System.out.println("MariaDb insert(id=" + id + ")");
			return 1;
		}
	}

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
		
		// 다형성: SuperType var = new SubType();
		DatabaseQuery query2 = new OracleDatabaseQuery();
		int result = query2.insert(20);
		System.out.println("result=" + result);
		
		System.out.println();
		// 멤버 내부 클래스의 객체 생성
		DatabaseQuery mariaDb = new MariaDbQuery();
		result = mariaDb.insert(30);
		System.out.println("result=" + result);
		
		// 지역 내부 클래스 선언(정의)
		class MongoDbQuery implements DatabaseQuery {
			@Override
			public int insert(int id) {
				System.out.println("MongoDb Insert 성공");
				return 1;
			}
		} // 지역 내부 클래스 MongoDbQuery 끝
		
		System.out.println();
		DatabaseQuery mongoDb = new MongoDbQuery();
		result = mongoDb.insert(0);
		System.out.println("result=" + result);
		
		// (지역) 익명 클래스 선언(정의)
		DatabaseQuery msSQL = new DatabaseQuery() {
			@Override
			public int insert(int id) {
				System.out.println("MS SQL...");
				return 0;
			}
		};
		
		System.out.println();
		result = msSQL.insert(123);
		System.out.println("result=" + result);
		
		// Lambda Expression(람다 표현식):
		// 구현해야할 메서드를 오직 하나만 갖는 인터페이스를 구현하는
		// 익명 클래스를 간단하게 표현하는 방법.
		// (param, ...) -> {}
		DatabaseQuery mySQL = (id) -> {
			System.out.println("MySQL insert...id=" + id);
			return 1;
		};
		
		System.out.println();
		result = mySQL.insert(1020);
		System.out.println("result=" + result);
		
	} // main() 메서드 끝

} // class ReviewMain5 끝

class A {
	public int number;  
	// 인스턴스 (멤버) 변수 - 객체 생성 후에만 사용할 수 있는 멤버.
}

class B {
	public static int staticNumber;
	// 클래스(static) (멤버) 변수 - 객체 생성 여부와 상관 없이 사용할 수 있는 멤버.
}
