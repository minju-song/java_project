package co.yedam.variable;

import java.io.IOException;

public class VariableExe4 {
	
	public static void main(String [] args) {
		//이름은 홍길동, 나이는 20살 입니다.
		String name = "홍길동";
		int age = 20;
		double weight = 45.2;
		
		System.out.println("이름은 "+name+", 나이는 "+age+"입니다.");
		System.out.printf("이름은 %s, 나이는 %d살, 몸무게는 %.1fkg입니다.\n", name, age, weight);
		
		int i =0;
		try {
			System.out.print("값을 입력>>");
			while(true) {
			int result = System.in.read();
			if (result == 113) {break;}
			else if(result == 10 || result ==13) {continue;}
			else 
				System.out.println(result+" 출력 ");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("End of prog.");
	}
}
