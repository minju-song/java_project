package co.yedam.variable;
import java.util.Scanner;

public class VariableExe {

	public static void main(String[] args) {
		//변수선언 및 초기화
		Scanner sc = new Scanner(System.in);
		
		
		
		System.out.println("num1 입력");
		int num1 = sc.nextInt();
		System.out.println("num2 입력");
		int num2 = sc.nextInt();
		
		System.out.println("1:더하기, 2:빼기, 3:곱하기, 4:나누기");
		int sel = sc.nextInt();
		int result = 0;
		switch(sel) {
			case 1: result = num1 + num2; break;
			case 2: result = num1 - num2; break; 
			case 3: result = num1 * num2; break;
			case 4: result = num1 / num2; break;
			default : System.out.println("잘못입력함");
		}
		
		
		System.out.print("결과 : ");
		System.out.println(result);
		
	}

}
