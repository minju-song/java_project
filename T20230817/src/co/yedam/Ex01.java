package co.yedam;
import java.util.*;

public class Ex01 {
	
	public static void main(String[] args) {		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("두 수 입력>> ");
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		
		int max=num1;
		if(num1<num2) max = num2;
		
		System.out.println("큰 수는 "+max+"입니다.");
	}
	
	
}
