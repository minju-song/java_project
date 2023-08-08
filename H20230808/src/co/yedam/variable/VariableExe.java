package co.yedam.variable;

public class VariableExe {

	public static void main(String[] args) {
		//변수선언 및 초기화
		byte num1 = 10;
		byte num2 = 20;
//		byte result = num1+num2; 
//		자바에서는 연산하는 순간 자료형이 int가 되어버림
		int result = num1+num2;
		
		System.out.println(result);
		
		int i1 = 100; byte b4 = 10;
		result = i1+b4;
		
		System.out.println(result);
		
		//실수 타입
		//float, double
		double dbl1 = 10.23332;
		double dbl2 = 20;
		System.out.println(dbl1+dbl2);
		
		float f1 = 10.1f;
		float f2 = 10.2f;
		
		System.out.println("실수 연산 : "+f1+f2);
	}

}
