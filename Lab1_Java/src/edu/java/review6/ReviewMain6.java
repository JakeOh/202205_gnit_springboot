package edu.java.review6;

public class ReviewMain6 {

	public static void main(String[] args) {
		// 지역 내부 클래스(local inner class)
		class Adder implements Calculable {
			@Override
			public double calculate(double x, double y) {
				return x + y;
			}
		}
		Calculable adder = new Adder();
		double result = calculate(1.0, 2.0, adder);
		System.out.println(result);
		
		// 익명 내부 클래스
		result = calculate(1.0, 2.0, new Calculable() {
			@Override
			public double calculate(double x, double y) {
				return x - y;
			}
		});
		System.out.println(result);
		
		// 람다 표현식
		result = calculate(1.0, 2.0, (x, y) -> x / y);
		System.out.println(result);
	}

	public static double calculate(double x, double y, 
			Calculable calculator) {
		return calculator.calculate(x, y);
	}
	
}
