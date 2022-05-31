package edu.java.review5;

// 인터페이스를 구현하는 클래스
// 인터페이스가 가지고 있는 추상 메서드(의 body)를 구현 - override
public class OracleDatabaseQuery implements DatabaseQuery {

	@Override
	public int insert(int id) {
		System.out.println("Oracle DB: id=" + id + ", insert 성공");
		
		return 0;
	}

}
