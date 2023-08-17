package co.yedam;
import java.util.*;

public class Ex02 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("두 수 입력>> ");
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		
		int sum2=0; 
		int sum3=0;

		int start=num1; int end=num2;
		if(num2<num1) {
			start = num2; 
			end = num1;
		}
		
		for(int i=start+1; i<end; i++) {
			if(i%2==0) sum2 += i;
			if(i%3==0) sum3 += i;
		}
		
		System.out.println("2의 배수의 합 : "+sum2);
		System.out.println("3의 배수의 합 : "+sum3);
	}

}
