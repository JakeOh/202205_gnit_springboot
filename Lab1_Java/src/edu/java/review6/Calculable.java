package edu.java.review6;

@FunctionalInterface  // 추상 메서드가 오직 1개인 인터페이스임을 선언.
public interface Calculable {

	// public abstract 생략 가능
	double calculate(double x, double y);
	
}
