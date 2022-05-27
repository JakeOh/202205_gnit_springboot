package edu.java.review5;

// 인터페이스를 구현하는 클래스
public class OracleDatabaseQuery implements DatabaseQuery {

	@Override
	public int insert(int id) {
		System.out.println("Oracle DB: id=" + id + ", insert 성공");
		
		return 0;
	}

}
